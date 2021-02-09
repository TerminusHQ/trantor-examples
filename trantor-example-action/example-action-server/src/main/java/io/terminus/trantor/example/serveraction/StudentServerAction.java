package io.terminus.trantor.example.serveraction;


import io.terminus.trantor.api.annotation.TAction;
import io.terminus.trantor.api.annotation.params.TParam;
import io.terminus.trantor.example.dao.StudentRepository;
import io.terminus.trantor.example.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author chengong
 * @date 2021/1/19 8:48 下午
 * @desc 通过@TAction 在方法上注解声明，此外 Action 方法所在类必须是一个 Spring bean
 */
@Component
public class StudentServerAction {

    @Autowired
    private StudentRepository studentRepo;

    @TAction(modelClass = Student.class)
    public void delete(@TParam Student student) {
        studentRepo.delete(student.getId());
    }

    @TAction(modelClass = Student.class)
    public void save(@TParam Student student) {
        studentRepo.saveWithRelationSkipNull(student);
    }

}
