package cn.iocoder.yudao.module.store.service.impl;

import cn.iocoder.yudao.module.store.controller.admin.vo.JshStorePageReqVO;
import cn.iocoder.yudao.module.store.controller.admin.vo.JshStroeDetailResVO;
import cn.iocoder.yudao.module.store.controller.admin.vo.JshStroeReSVO;
import cn.iocoder.yudao.module.store.controller.admin.vo.JshStroeReqVO;
import cn.iocoder.yudao.module.store.dal.dataobject.JshStroeDO;
import cn.iocoder.yudao.module.store.dal.mysql.JshStoreMapper;
import cn.iocoder.yudao.module.store.service.JshStroeService;
import cn.iocoder.yudao.module.util.AutoOrder;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class JshStroeServiceImpl implements JshStroeService {
    @Autowired
    private JshStoreMapper jshStoreMapper;

    @Override
    public JshStroeReSVO create(JshStroeReqVO jshStroeReqVO){
        JshStroeDO jshStroeDO = new JshStroeDO();
        BeanUtils.copyProperties(jshStroeReqVO,jshStroeDO);
        jshStroeDO.setInitialAmount(new BigDecimal(jshStroeReqVO.getInitialAmount()));
        // 生成编号
        jshStroeDO.setNumber(AutoOrder.GetSystemserialnumber());
        jshStoreMapper.insert(jshStroeDO);

        JshStroeDO retrunJshStroeDO = jshStoreMapper.selectByNumber(jshStroeDO.getNumber());
        JshStroeReSVO jshStroeReSVO = new JshStroeReSVO();
        BeanUtils.copyProperties(jshStroeReqVO,jshStroeReSVO);
        jshStroeReSVO.setNumber(jshStroeDO.getNumber());
        jshStroeReSVO.setId(retrunJshStroeDO.getId());
        return jshStroeReSVO;
    }


    /**
     * 查询门店
     * @param jshStroeReqVO
     * @return
     */
    @Override
    public List<JshStroeDetailResVO> selectStore(JshStorePageReqVO jshStorePageReqVO, Long storeId){

    }

}
