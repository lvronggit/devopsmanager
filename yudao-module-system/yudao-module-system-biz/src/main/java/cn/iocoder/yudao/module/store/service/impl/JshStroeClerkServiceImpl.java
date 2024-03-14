package cn.iocoder.yudao.module.store.service.impl;

import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.store.controller.admin.vo.AddJshStroeClerkReqVO;
import cn.iocoder.yudao.module.store.controller.admin.vo.JshStroeClerkReSVO;
import cn.iocoder.yudao.module.store.controller.admin.vo.UpdateJshStroeClerkReqVO;
import cn.iocoder.yudao.module.store.dal.dataobject.JshStoreClerkDO;
import cn.iocoder.yudao.module.store.dal.mysql.JshStoreClerkMapper;
import cn.iocoder.yudao.module.store.service.JshStroeClerkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JshStroeClerkServiceImpl implements JshStroeClerkService {
    @Autowired
    private JshStoreClerkMapper jshStoreClerkMapper;

    @Override
    public JshStroeClerkReSVO add(AddJshStroeClerkReqVO addJshStroeClerkReqVO) {
        JshStoreClerkDO jshStoreClerkDO = BeanUtils.toBean(addJshStroeClerkReqVO, JshStoreClerkDO.class);
        jshStoreClerkMapper.insert(jshStoreClerkDO);
        return BeanUtils.toBean(jshStoreClerkDO, JshStroeClerkReSVO.class);
    }

    @Override
    public JshStroeClerkReSVO updateById(UpdateJshStroeClerkReqVO updateJshStroeClerkReqVO) {
        JshStoreClerkDO jshStoreClerkDO = BeanUtils.toBean(updateJshStroeClerkReqVO, JshStoreClerkDO.class);
        jshStoreClerkMapper.updateById(jshStoreClerkDO);
        return BeanUtils.toBean(jshStoreClerkDO, JshStroeClerkReSVO.class);
    }
}



