package cn.iocoder.yudao.module.store.service.impl;

import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.store.controller.admin.vo.AddJshStroeShareholderReqVO;
import cn.iocoder.yudao.module.store.controller.admin.vo.JshStroeShareholderReSVO;
import cn.iocoder.yudao.module.store.dal.dataobject.JshStroeShareholderDO;
import cn.iocoder.yudao.module.store.dal.mysql.JshStroeShareholderMapper;
import cn.iocoder.yudao.module.store.service.JshStroeShareHolderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
@Service
public class JshStroeShareHolderServiceImpl implements JshStroeShareHolderService {
    @Autowired
    private JshStroeShareholderMapper jshStroeShareholderMapper;

    @Override
    public List<JshStroeShareholderReSVO> selectByStorenumber(String storeNumber) {
        List<JshStroeShareholderDO> jshStroeShareholderDOS = jshStroeShareholderMapper.selectByStoreNumbers(Arrays.asList(storeNumber));
        List<JshStroeShareholderReSVO> jshStroeShareholderReSVOS = new ArrayList<>();
        for (JshStroeShareholderDO jshStroeShareholderDO: jshStroeShareholderDOS) {
            JshStroeShareholderReSVO jshStroeShareholderReSVO = BeanUtils.toBean(jshStroeShareholderDO, JshStroeShareholderReSVO.class);
            jshStroeShareholderReSVOS.add(jshStroeShareholderReSVO);
        }
        return jshStroeShareholderReSVOS;
    }


    /**
     * 新增股东信息
     *
     * @param addJshStroeShareholderReqVO
     * @return
     */
    @Override
    public JshStroeShareholderReSVO add(AddJshStroeShareholderReqVO addJshStroeShareholderReqVO) {
        JshStroeShareholderDO jshStroeShareholderDO = BeanUtils.toBean(addJshStroeShareholderReqVO, JshStroeShareholderDO.class);
        jshStroeShareholderMapper.insert(jshStroeShareholderDO);
        return BeanUtils.toBean(jshStroeShareholderDO, JshStroeShareholderReSVO.class);
    }

    /**
     * 根据id更新股东信息
     *
     * @param addJshStroeShareholderReqVO
     * @return
     */
    @Override
    public JshStroeShareholderReSVO updateById(AddJshStroeShareholderReqVO addJshStroeShareholderReqVO) {
        JshStroeShareholderDO jshStroeShareholderDO = BeanUtils.toBean(addJshStroeShareholderReqVO, JshStroeShareholderDO.class);
        jshStroeShareholderMapper.updateById(jshStroeShareholderDO);
        return BeanUtils.toBean(jshStroeShareholderDO, JshStroeShareholderReSVO.class);
    }

}
