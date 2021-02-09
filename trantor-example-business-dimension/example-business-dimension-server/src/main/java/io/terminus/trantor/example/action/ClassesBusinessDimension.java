package io.terminus.trantor.example.action;

import io.terminus.trantor.api.annotation.TBusinessDimension;
import io.terminus.trantor.api.dimension.BusinessDimensionAction;
import io.terminus.trantor.api.dimension.BusinessDimensionData;
import io.terminus.trantor.example.dao.ClassesDao;
import io.terminus.trantor.example.model.Classes;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ymf
 * @date 2021/1/20 10:49 上午
 */
@TBusinessDimension("以班级区分")
public class ClassesBusinessDimension implements BusinessDimensionAction {

    @Autowired
    private ClassesDao classesDao;

    @Override
    public List<BusinessDimensionData> load() {

        List<Classes> product = classesDao.find(query -> {
        });

        // 按课程编码排序
        return product.stream().sorted(Comparator.comparing(Classes::getClassesNo).reversed()).collect(Collectors.toList());
    }

}