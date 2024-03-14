package cn.iocoder.yudao.module.store.service;

import cn.iocoder.yudao.module.store.controller.admin.vo.*;

import java.util.List;

public interface JshStroeClerkService {


    JshStroeClerkReSVO add(AddJshStroeClerkReqVO addJshStroeClerkReqVO);

    JshStroeClerkReSVO updateById(UpdateJshStroeClerkReqVO updateJshStroeClerkReqVO);

    List<JshStroeClerkReSVO> selectByStoreNumber(String storeNumber);
}
