package cn.iocoder.yudao.module.store.dal.mysql;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.module.store.controller.admin.vo.JshStorePageReqVO;
import cn.iocoder.yudao.module.store.controller.admin.vo.JshStroeShareholderReqVO;
import cn.iocoder.yudao.module.store.dal.dataobject.JshStroeDO;
import cn.iocoder.yudao.module.store.dal.dataobject.JshStroeShareholderDO;
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


    default PageResult<JshStroeDO> selectPage(JshStorePageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<JshStroeDO>()
                .eqIfPresent(JshStroeDO::getNumber, reqVO.getNumber())
                .likeIfPresent(JshStroeDO::getName, reqVO.getName())
                .orderByDesc(JshStroeDO::getId));
    }

}
