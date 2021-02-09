package io.terminus.trantor.example.dao;


import io.terminus.trantor.example.model.Student;
import io.terminus.trantor.sdk.autumn.dao.sql.TrantorSqlDAO;
import org.springframework.stereotype.Repository;

/**
 * 适用于单个模型CURD，涉及多模型联表查询时， 请使用TrantorLowLevelSqlDAO
 * @author chengong
 * @date 2021/1/19 8:55 下午
 */
@Repository
public class StudentSqlDao extends TrantorSqlDAO<Student, Long> {

}


