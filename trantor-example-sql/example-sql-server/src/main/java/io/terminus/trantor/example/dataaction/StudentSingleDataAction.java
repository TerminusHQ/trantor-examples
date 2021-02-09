package io.terminus.trantor.example.dataaction;

import io.terminus.trantor.example.dao.StudentSqlDao;
import io.terminus.trantor.example.model.Student;
import io.terminus.trantor.sdk.autumn.dao.sql.TrantorLowLevelSqlDAO;
import io.terminus.trantor.sdk.datasource.SingleDataAction;
import io.terminus.trantor.sdk.datasource.SingleDataParams;
import io.terminus.trantor.sdk.datasource.SingleDataResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author chengong
 * @date 8:50 下午
 * @desc 这里演示dataAction 返回单条数据的场景
 */
@Component
public class StudentSingleDataAction implements SingleDataAction<Student> {
    @Autowired
    private StudentSqlDao studentSqlDao;

    @Override
    public SingleDataResult<Student> load(SingleDataParams singleDataParams) {
        Integer id = singleDataParams.getQueryValues().getOneValue("id");
        Student student = studentSqlDao.readOne(id.longValue());

        SingleDataResult<Student> result = new SingleDataResult<>();
        result.setData(student);
        return result;
    }
}
