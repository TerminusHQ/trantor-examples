package io.terminus.trantor.example.serveraction;


import io.terminus.platform.sdk.transaction.DSTransaction;
import io.terminus.trantor.api.TContext;
import io.terminus.trantor.api.annotation.TAction;
import io.terminus.trantor.api.annotation.params.TCollectionParam;
import io.terminus.trantor.api.annotation.params.TParam;
import io.terminus.trantor.example.dao.StudentSqlDao;
import io.terminus.trantor.example.model.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author chengong
 * @date 2021/1/19 8:48 下午
 * @desc 通过@TAction 在方法上注解声明，此外 Action 方法所在类必须是一个 Spring bean
 */
@Slf4j
@Component
public class StudentServerAction {

    @Autowired
    private StudentSqlDao studentSqlDao;


    @TAction(modelClass = Student.class)
    public void create(@TParam Student student) {
        Long id = studentSqlDao.createOne(student);
        log.debug("created id:{}", id);
    }

    @TAction(modelClass = Student.class)
    public void update(@TParam Student student) {
        Boolean updated = studentSqlDao.updateOne(student, true);
        log.debug("model:{}, updated:{}", student, updated);
    }

    @TAction(modelClass = Student.class)
    @DSTransaction
    public void updateByIds(@TCollectionParam(Long.class) List<Long> id) {
        /**
         *  还可以表示字段的加减乘除
         *  String sql = "update %s set %s=%s-100, updatedBy=%s where id in (%s)";
         *  String sql = "update %s set %s=%s*100, updatedBy=%s where id in (%s)";
         *  String sql = "update %s set %s=%s/100, updatedBy=%s where id in (%s)";
         */
        String sql = "update %s set %s=%s+100, updatedBy=%s where id in (%s)";
        sql = String.format(sql, studentSqlDao.getModelKey(),
                Student.age_field,
                Student.age_field,
                TContext.getCurrentUserIdSafe().get(),
                id.stream().map(String::valueOf).collect(Collectors.joining(","))
        );
        Long updated = studentSqlDao.updateMany(sql);
        log.debug("model:{}, updated:{}", id, updated);
    }

    @TAction(modelClass = Student.class)
    @DSTransaction
    public void updateByIdsAndField(@TCollectionParam(Long.class) List<Long> id, @TParam("name") String name) {
        List<Student> models = id.stream()
                .map(oneId -> {
                    Student model = new Student();
                    model.setId(oneId);
                    model.setName(name);
                    return model;
                })
                .collect(Collectors.toList());
        Long updated = studentSqlDao.updateMany(models, true);
        log.debug("ids:{}, updated:{}", id, updated);
    }

    @TAction(modelClass = Student.class)
    @DSTransaction
    public void deleteById(@TParam("id") Long id) {
        Boolean deleted = studentSqlDao.deleteOne(id);
        log.debug("id:{}, deleted:{}", id, deleted);
    }

}
