package io.terminus.trantor.example.dataaction;


import io.terminus.common.model.Paging;
import io.terminus.trantor.example.dao.StudentLowLevelSqlDAO;
import io.terminus.trantor.example.dao.StudentSqlDao;
import io.terminus.trantor.example.model.Student;
import io.terminus.trantor.sdk.datasource.MultiDataAction;
import io.terminus.trantor.sdk.datasource.MultiDataParams;
import io.terminus.trantor.sdk.datasource.MultiDataResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 使用TrantorLowLevelSqlDAO
 *
 * @author chengong
 * @date 2021/1/19 8:34 下午
 */
@Component
public class StudentMultiDataAction implements MultiDataAction<Student> {

    @Autowired
    private StudentLowLevelSqlDAO studentLowLevelSqlDAO;

    @Override
    public MultiDataResult<Student> load(MultiDataParams multiDataParams) {

        Paging<Student> studentPaging = studentLowLevelSqlDAO.pageWithTotal(multiDataParams);

        return new MultiDataResult<>(studentPaging.getData(), studentPaging.getTotal());
    }
}
