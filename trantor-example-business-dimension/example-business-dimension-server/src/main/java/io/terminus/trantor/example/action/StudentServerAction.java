package io.terminus.trantor.example.action;


import io.terminus.trantor.api.TContext;
import io.terminus.trantor.api.annotation.TAction;
import io.terminus.trantor.api.annotation.params.TParam;
import io.terminus.trantor.example.dao.StudentDao;
import io.terminus.trantor.example.model.Classes;
import io.terminus.trantor.example.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author chengong
 * @date 2021/1/19 8:48 下午
 */
@Component
public class StudentServerAction {

    @Autowired
    private StudentDao studentDao;

    @TAction(modelClass = Student.class)
    public void save(@TParam Student student) {
        Integer id = TContext.getFrontendContext().getCurrentBusinessDimensionId();
        Classes classes = new Classes();
        classes.setId(Long.valueOf(id));
        student.setClasses(classes);
        studentDao.saveWithRelationSkipNull(student);
    }

}
