package cn.iocoder.yudao.module.store.dal.mysql;

import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.store.dal.dataobject.JshStroeDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface JshStoreMapper extends BaseMapperX<JshStroeDO> {

    default List<JshStroeDO> selectList(List<String> numbers) {
        return selectList("number",numbers);
    }

    default JshStroeDO selectByNumber(String number) {
        return selectOne(JshStroeDO::getNumber,number);
    }


}
