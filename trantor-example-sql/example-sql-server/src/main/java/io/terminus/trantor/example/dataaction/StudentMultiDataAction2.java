package io.terminus.trantor.example.dataaction;


import io.terminus.trantor.example.dao.StudentSqlDao;
import io.terminus.trantor.example.model.Student;
import io.terminus.trantor.sdk.datasource.DataSourceInput;
import io.terminus.trantor.sdk.datasource.MultiDataAction;
import io.terminus.trantor.sdk.datasource.MultiDataParams;
import io.terminus.trantor.sdk.datasource.MultiDataResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

/**
 * 使用TrantorSqlDAO
 * @author chengong
 * @date 2021/1/19 8:34 下午
 */
@Component
public class StudentMultiDataAction2 implements MultiDataAction<Student> {

    @Autowired
    private StudentSqlDao studentSqlDao;

    @Override
    public MultiDataResult<Student> load(MultiDataParams multiDataParams) {
        Long count = studentSqlDao.countAll();
        DataSourceInput.PagingParam paging = multiDataParams.getPaging();
        List<Student> studentList = studentSqlDao.page(paging.getNo(), paging.getSize(), Collections.emptyList(), null);

        MultiDataResult<Student> multiDataResult = new MultiDataResult<>();
        multiDataResult.setData(studentList);
        multiDataResult.setCount(count);
        return multiDataResult;
    }
}
