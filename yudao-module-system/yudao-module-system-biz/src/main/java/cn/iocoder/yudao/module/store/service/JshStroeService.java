package cn.iocoder.yudao.module.store.service;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.store.controller.admin.vo.JshStorePageReqVO;
import cn.iocoder.yudao.module.store.controller.admin.vo.JshStroeDetailResVO;
import cn.iocoder.yudao.module.store.controller.admin.vo.JshStroeReSVO;
import cn.iocoder.yudao.module.store.controller.admin.vo.JshStroeReqVO;

import java.util.List;

public interface JshStroeService {
    JshStroeReSVO create(JshStroeReqVO jshStroeReqVO);

    PageResult<JshStroeDetailResVO> selectStore(JshStorePageReqVO jshStorePageReqVO, Long storeId);
}
