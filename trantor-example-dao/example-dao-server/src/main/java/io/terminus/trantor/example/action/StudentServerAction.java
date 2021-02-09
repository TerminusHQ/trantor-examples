package io.terminus.trantor.example.action;


import io.terminus.trantor.api.annotation.TAction;
import io.terminus.trantor.api.annotation.params.TParam;
import io.terminus.trantor.example.dao.StudentRepository;
import io.terminus.trantor.example.model.Student;
import io.terminus.trantor.sdk.autumn.param.Operators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 * @author ymf
 * @date 2021/1/21 8:34 下午
 */
@Component
public class StudentServerAction {

    @Autowired
    private StudentRepository studentRepository;

//Create
    /**
     * 保存一条记录
     * 若不存在则创建 存在则更新
     * 会忽略关联模型, 仅生效与模型自身
     * @param student
     */
    @TAction(modelClass = Student.class)
    public void saveIgnoreRelation(@TParam Student student) {
        studentRepository.saveIgnoreRelation(student);
    }

    /**
     * 保存一条记录
     * 若不存在则创建 存在则更新
     * 会同步关联、创建或者更新关联模型，规则同样适用于子对象
     * @param student
     */
    @TAction(modelClass = Student.class)
    public void saveWithRelation(@TParam Student student) {
        studentRepository.saveWithRelation(student);
    }

    /**
     * 保存一条记录
     * 若不存在则创建 存在则更新
     * 仅会建立关联模型关系, 不会创建或更新关联模型
     * @param student
     */
    @TAction(modelClass = Student.class)
    public void saveConnectRelation(@TParam Student student) {
        studentRepository.saveConnectRelation(student);
    }


//Update

    /**
     * 会忽略关联模型, 仅更新模型自身
     * @param student
     */
    @TAction(modelClass = Student.class)
    public void updateIgnoreRelation(@TParam Student student) {
        studentRepository.updateIgnoreRelation(student);
    }

    /**
     * 仅会建立关联模型关系, 不会创建或更新关联模型会忽略关联模型, 仅更新模型自身
     * @param student
     */
    @TAction(modelClass = Student.class)
    public void updateConnectRelation(@TParam Student student) {
        studentRepository.updateConnectRelation(student);
    }

    /**
     * 会同步关联、创建或者更新关联模型
     * 关联或创建时需要全量关联记录，没有的则视为解除关联
     * * @param student
     */
    @TAction(modelClass = Student.class)
    public void updateWithRelation(@TParam Student student) {
        studentRepository.updateWithRelation(student);
    }


    /**
     * 按 id 更新一条记录，id 在记录内
     * 会忽略关联模型, 仅更新模型自身
     * * @param student
     */
    @TAction(modelClass = Student.class)
    public void updateIgnoreRelationSkipNull(@TParam Student student) {
        studentRepository.updateIgnoreRelationSkipNull(student);
    }

    /**
     * 按 id 更新一条记录，id 在记录内
     * 仅会同步关联关联模型, 不会创建或更新
     * * @param student
     */
    @TAction(modelClass = Student.class)
    public void updateConnectRelationSkipNull(@TParam Student student) {
        studentRepository.updateConnectRelationSkipNull(student);
    }


    /**
     * 按 id 更新一条记录，id 在记录内
     * 会更同步关联、创建或者更新关联模型
     * 关联或创建时需要全量关联记录，没有的则视为解除关联
     * * @param student
     */
    @TAction(modelClass = Student.class)
    public void updateWithRelationSkipNull(@TParam Student student) {
        studentRepository.updateWithRelationSkipNull(student);
    }


//Query

    /**
     * 查询单条数据
     */
    @TAction(modelClass = Student.class)
    public Student findById(@TParam Student student) {
        Optional<Student> response = studentRepository.findById(student.getId());
        return response.get();
    }

    /**
     * 查询单条数据
     */
    @TAction(modelClass = Student.class)
    public Student findOne(@TParam Student student) {
        Optional<Student> response = studentRepository.findOne(query ->{
            query.where(conditionSet -> conditionSet.condition(Student.subjects_field, Operators.EQ, null));
            query.where(conditionSet -> conditionSet.condition(Student.id_field, Operators.EQ, student.getId()));

            query.selectAll();
            query.orderBy(Student.createdAt_field, false);
        });
        return response.get();
    }

    /**
     * 查询多条数据
     */
    @TAction(modelClass = Student.class)
    public List<Student> batchQuery(List<Long> ids) {
        List<Student> response = studentRepository.findByIds(ids);
        return response;
    }

    /**
     * 按照条件查询;查询学生所学课程中包含音乐的学生
     */
    @TAction(modelClass = Student.class)
    public List<Student> findByCondition(@TParam Student student) {
        return studentRepository.find(query -> {
            query.where(conditionSet -> conditionSet.condition(Student.subjects_field, subject->{
                subject.eq(Student.name_field,"music");
            }));
            query.selectAll();
        query.orderBy(Student.createdAt_field, false);

        });


    }

//Delete

    /**
     * @desc 删除单条数据
     * @param student
     */
    @TAction(modelClass = Student.class)
    public void delete(@TParam Student student) {
        studentRepository.delete(student.getId());
    }

    /**
     * @desc 删除多条数据
     * @param studentIds
     */
    @TAction(modelClass = Student.class)
    public void batchdelete(List<Long> studentIds) {
        studentRepository.delete(studentIds);
    }


    /**
     * @desc 按给定条件批量删除记录
     * @param student
     */
    @TAction(modelClass = Student.class)
    public void ConditionDelete(@TParam Student student) {
        studentRepository.delete(s ->{
           s.condition("name",Operators.CONTAINS,student.getName());
        });
    }



}
