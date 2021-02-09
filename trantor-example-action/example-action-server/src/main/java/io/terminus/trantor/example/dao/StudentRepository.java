package io.terminus.trantor.example.dao;


import io.terminus.trantor.example.model.Student;
import io.terminus.trantor.sdk.autumn.dao.TrantorDAO;
import org.springframework.stereotype.Repository;

/**
 * @author chengong
 * @date 2021/1/19 8:55 下午
 */
@Repository
public class StudentRepository extends TrantorDAO<Student, Long> {

}


