package io.terminus.trantor.example.action;

import io.terminus.trantor.api.TContext;
import io.terminus.trantor.example.dao.StudentDao;
import io.terminus.trantor.example.model.Classes;
import io.terminus.trantor.example.model.Student;
import io.terminus.trantor.sdk.datasource.*;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author ymf
 * @date 2021/1/20 10:49 上午
 */
@Component
public class StudentDataAction implements MultiDataAction<Student> {


    @Resource
    StudentDao studentDao;

    @Override
    public MultiDataResult<Student> load(MultiDataParams multiDataParams) {

        // 获取业务维度id，对应班级的id
        Integer id = TContext.getFrontendContext().getCurrentBusinessDimensionId();

        List<Student> response = studentDao.find(query -> {
            query.where(conditionSet -> {
                conditionSet.condition(Student.classes_field, classes -> {
                    classes.eq(Classes.id_field, id);
                });
            });
            query.selectAll();
            query.orderBy(Student.createdAt_field, false);
        });

        return new MultiDataResult(response, (long) response.size());
    }
}
