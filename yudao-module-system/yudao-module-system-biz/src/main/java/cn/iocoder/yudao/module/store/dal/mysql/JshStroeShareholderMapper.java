package cn.iocoder.yudao.module.store.dal.mysql;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.module.store.controller.admin.vo.JshStroeShareholderReqVO;
import cn.iocoder.yudao.module.store.dal.dataobject.JshStroeShareholderDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface JshStroeShareholderMapper extends BaseMapperX<JshStroeShareholderDO> {

    default List<JshStroeShareholderDO> selectByShareholderIds(List<String> shareholderIds) {
        return selectList(JshStroeShareholderDO::getShareholderId, shareholderIds);
    }

    default List<JshStroeShareholderDO> selectByStoreNumbers(List<String> storeNumbers) {
        return selectList(JshStroeShareholderDO::getStoreNumber, storeNumbers);
    }


    default PageResult<JshStroeShareholderDO> selectPage(JshStroeShareholderReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<JshStroeShareholderDO>()
                .inIfPresent(JshStroeShareholderDO::getShareholderId, reqVO.getShareholderIds())
                .inIfPresent(JshStroeShareholderDO::getStoreNumber, reqVO.getStoreNumbers())
                .orderByDesc(JshStroeShareholderDO::getId));
    }
}
