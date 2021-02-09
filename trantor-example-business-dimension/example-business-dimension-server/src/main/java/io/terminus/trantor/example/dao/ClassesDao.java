package io.terminus.trantor.example.dao;

import io.terminus.trantor.example.model.Classes;
import io.terminus.trantor.sdk.autumn.dao.TrantorDAO;
import org.springframework.stereotype.Repository;

/**
 * @author ymf
 * @date 2021/1/20 10:49 上午
 */
@Repository
public class ClassesDao extends TrantorDAO<Classes, Long> {
}
