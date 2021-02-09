package io.terminus.trantor.example.dao;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import io.seata.common.util.NumberUtils;
import io.seata.common.util.StringUtils;
import io.terminus.common.model.PageInfo;
import io.terminus.common.model.Paging;
import io.terminus.trantor.example.model.Student;
import io.terminus.trantor.sdk.autumn.dao.sql.TrantorLowLevelSqlDAO;
import io.terminus.trantor.sdk.autumn.dao.sql.TrantorSqlDAO;
import io.terminus.trantor.sdk.datasource.MultiDataParams;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 不绑定业务模型示例
 * 涉及多模型联表查询时， 使用该Dao
 *
 * @author chengong
 * @date 2021/2/2 10:58 上午
 */
@Component
@NoArgsConstructor
public class StudentLowLevelSqlDAO {

    @Autowired
    private TrantorLowLevelSqlDAO trantorLowLevelSqlDAO;

    private final static String querySQL = "select student.id,student.stuNo,student.age, student.name, studentCard.studentCardId from " +
            "example_sql_Student student left join example_sql_StudentCard studentCard on student.studentCard = studentCard.id";
    private final static String countSQL = "select count(1) as count from " +
            "example_sql_Student student left join example_sql_StudentCard studentCard on student.studentCard = studentCard.id";


    public Paging<Student> pageWithTotal(MultiDataParams multiDataParams) {
        Map<String, Object> params = new HashMap<>(16);
        // count
        String countSqlStr = buildSqlAndParam(countSQL, multiDataParams, params);
        List<Map<String, Object>> countMaps = trantorLowLevelSqlDAO.readManyListMap(countSqlStr, params);
        long total = NumberUtils.toLong(String.valueOf(countMaps.get(0).get("count")));
        // query
        String querySqlWithoutLimit = buildSqlAndParam(querySQL, multiDataParams, params);
        String querySqlStr = buildPageAndOrder(querySqlWithoutLimit, multiDataParams, params);
        List<Map<String, Object>> dataList = trantorLowLevelSqlDAO.readManyListMap(querySqlStr, params);
        // deal data
        List<Student> studentList = new ArrayList<>();
        for (Map<String, Object> map : dataList) {
            JSONObject json = JSON.parseObject(JSON.toJSONString(map));
            Student student = JSON.toJavaObject(json, Student.class);
            studentList.add(student);
        }
        // return data
        Paging<Student> paging = new Paging<>();
        paging.setTotal(total);
        paging.setData(studentList);
        return paging;
    }

    /**
     * 还支持 ><= 和 is null&is not null
     * <p>
     * builder.append(" and ( student.createdAt > :getAtStart and b.createdAt < :getAtEnd ) ");
     * params.put(":getAtStart", createAt);
     * params.put(":getAtEnd", updateAt;
     * <p>
     * builder.append(" and student.id is null");
     * builder.append(" and student.name is null and student.id is not null ");
     * builder.append(" and student.id is not null ");
     *
     * @param sql
     * @param multiDataParams
     * @param params
     * @return
     */
    private String buildSqlAndParam(String sql, MultiDataParams multiDataParams, Map<String, Object> params) {
        StringBuilder builder = new StringBuilder(sql);
        String name = multiDataParams.getQueryValues().getOneValue(Student.name_field);
        String stuNo = multiDataParams.getQueryValues().getOneValue(Student.stuNo_field);

        if (StringUtils.isNotBlank(name)) {
            builder.append(" and student.name = :name ");
            params.put(":name", name);
        }
        if (StringUtils.isNotBlank(stuNo)) {
            builder.append(" and student.stuNo = :stuNo ");
            params.put(":stuNo", stuNo);
        }
        return builder.toString();
    }

    private String buildPageAndOrder(String sql, MultiDataParams multiDataParams, Map<String, Object> params) {
        StringBuilder builder = new StringBuilder(sql);
        Integer pageNo = multiDataParams.getPaging().getNo();
        Integer pageSize = multiDataParams.getPaging().getSize();
        PageInfo pageInfo = new PageInfo(pageNo, pageSize);
        builder.append(" order by student.createdAt desc ");
        builder.append(" limit :offset,:limit");
        params.put(":offset", pageInfo.getOffset());
        params.put(":limit", pageInfo.getLimit());
        return builder.toString();
    }
}
