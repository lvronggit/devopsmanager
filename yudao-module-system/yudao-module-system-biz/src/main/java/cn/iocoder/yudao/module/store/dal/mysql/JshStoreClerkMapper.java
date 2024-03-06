package cn.iocoder.yudao.module.store.dal.mysql;

import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.store.dal.dataobject.JshStoreClerkDO;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface JshStoreClerkMapper extends BaseMapperX<JshStoreClerkDO> {

    default List<JshStoreClerkDO> selecByStoreNumber(String storeNumber) {
        return selectList(new LambdaQueryWrapper<JshStoreClerkDO>()
                .eq(JshStoreClerkDO::getStoreNumber, storeNumber)
                .eq(JshStoreClerkDO::getEmployed, "是"));
    }


}
