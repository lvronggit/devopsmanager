package cn.iocoder.yudao.module.store.service;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.store.controller.admin.vo.*;

import java.util.List;

public interface JshStroeShareHolderService {


    List<JshStroeShareholderReSVO> selectByStorenumber(String storeNumber);

    JshStroeShareholderReSVO add(AddJshStroeShareholderReqVO addJshStroeShareholderReqVO);

    JshStroeShareholderReSVO updateById(AddJshStroeShareholderReqVO addJshStroeShareholderReqVO);
}
