package io.terminus.trantor.example.dao;


import io.terminus.trantor.example.model.Student;
import io.terminus.trantor.sdk.autumn.dao.TrantorDAO;
import org.springframework.stereotype.Repository;


/**
 * @author ymf
 * 学生相关 dao, 须继承 TrantorDAO，默认已包含 CRUD 操作
 */
@Repository
public class StudentRepository extends TrantorDAO<Student, Long> {

}


