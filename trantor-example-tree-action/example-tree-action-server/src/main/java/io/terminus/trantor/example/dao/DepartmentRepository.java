package io.terminus.trantor.example.dao;

import io.terminus.trantor.example.model.Department;
import io.terminus.trantor.sdk.autumn.dao.TrantorDAO;
import org.springframework.stereotype.Repository;


/**
 * @author yaomingfeng
 */
@Repository
public class DepartmentRepository extends TrantorDAO<Department, Long> {
}
