package io.terminus.trantor.example.tree;

import io.terminus.datastore.dsl.Query;
import io.terminus.datastore.dsl.impl.TSQL;
import io.terminus.trantor.example.tree.query.QCategory;
import io.terminus.trantorframework.api.annotation.TreeDataSource;
import io.terminus.trantorframework.sdk.datasource.tree.TreeDataProvider;
import io.terminus.trantorframework.sdk.datasource.tree.TreeItem;
import io.terminus.trantorframework.sdk.datasource.tree.TreeSearchParams;
import io.terminus.trantorframework.sdk.sql.DS;

import javax.annotation.Nullable;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: Chen Gong
 * @date：2021/8/24 8:06 下午
 */
@TreeDataSource
public class CategoryTreeDataProvider extends TreeDataProvider<Category, QCategory, Long> {
    @Override
    public List<Category> loadChildren(@Nullable Long parentId, TreeSearchParams<Category, QCategory> params) {
        return DS.findAll(Category.class, "*", "1==1");
    }

    @Override
    public List<TreeItem<Long>> search(TreeSearchParams<Category, QCategory> params) {
        String fuzzyValue = params.getSearch().getQueryParams().getFuzzyValue();
        List<Category> categoryList = DS.findAll(Category.class, "*", "name like ?", "%" + fuzzyValue + "%");
        return categoryList.stream().map(category -> {
            TreeItem<Long> treeItem = new TreeItem<>();
            treeItem.setDisplayName(category.getName());
            treeItem.setId(category.getId());
            return treeItem;
        }).collect(Collectors.toList());
    }

    @Override
    public List<Category> reverseBuild(@Nullable Long parentId, TreeSearchParams<Category, QCategory> params) {
        return DS.findAll(Category.class, "*", "parent.id = ?", parentId);
    }

    @Override
    public List<Category> loadByIds(List<Long> ids, TreeSearchParams<Category, QCategory> params) {
        Query query = TSQL.select(TSQL.field("*")).from(Category.class).where(TSQL.field(Category.id_field).in(ids));
        return DS.findAll(query);
    }
}

