package cn.iocoder.yudao.module.store.service.impl;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.collection.CollectionUtils;
import cn.iocoder.yudao.module.store.controller.admin.vo.*;
import cn.iocoder.yudao.module.store.dal.dataobject.JshStroeDO;
import cn.iocoder.yudao.module.store.dal.dataobject.JshStroeShareholderDO;
import cn.iocoder.yudao.module.store.dal.mysql.JshStoreMapper;
import cn.iocoder.yudao.module.store.dal.mysql.JshStroeShareholderMapper;
import cn.iocoder.yudao.module.store.service.JshStroeClerkService;
import cn.iocoder.yudao.module.store.service.JshStroeService;
import cn.iocoder.yudao.module.store.service.JshStroeShareHolderService;
import cn.iocoder.yudao.module.util.AutoOrder;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class JshStroeServiceImpl implements JshStroeService {
    @Autowired
    private JshStoreMapper jshStoreMapper;
    @Autowired
    private JshStroeShareholderMapper jshStroeShareholderMapper;

    @Autowired
    private JshStroeShareHolderService jshStroeShareHolderService;
    @Autowired
    private JshStroeClerkService jshStroeClerkService;

    @Override
    public JshStroeReSVO create(JshStroeReqVO jshStroeReqVO) {
        JshStroeDO jshStroeDO = new JshStroeDO();
        BeanUtils.copyProperties(jshStroeReqVO, jshStroeDO);
        jshStroeDO.setInitialAmount(new BigDecimal(jshStroeReqVO.getInitialAmount()));
        // 生成编号
        jshStroeDO.setNumber(AutoOrder.GetSystemserialnumber());
        jshStoreMapper.insert(jshStroeDO);

        JshStroeDO retrunJshStroeDO = jshStoreMapper.selectByNumber(jshStroeDO.getNumber());
        JshStroeReSVO jshStroeReSVO = new JshStroeReSVO();
        BeanUtils.copyProperties(jshStroeReqVO, jshStroeReSVO);
        jshStroeReSVO.setNumber(jshStroeDO.getNumber());
        jshStroeReSVO.setId(retrunJshStroeDO.getId());
        return jshStroeReSVO;
    }


    /**
     * 查询门店
     *
     * @param jshStorePageReqVO
     * @return
     */
    @Override
    public PageResult<JshStroeDetailResVO> selectStore(JshStorePageReqVO jshStorePageReqVO, Long userId) {
        // 查出股东对应的门店号
        List<JshStroeDO> jshStroeDOS;
        PageResult<JshStroeDetailResVO> jshStroeDetailResVO = new PageResult<>();
        // 管理员查询
        if (userId != null) {
            JshStroeShareholderReqVO jshStroeShareholderReqVO = new JshStroeShareholderReqVO();
            jshStroeShareholderReqVO.setShareholderIds(Lists.newArrayList(userId));
            if (StringUtils.isNotBlank(jshStorePageReqVO.getNumber())) {
                jshStroeShareholderReqVO.setStoreNumbers(Lists.newArrayList(jshStorePageReqVO.getNumber()));
            }

            jshStroeShareholderReqVO.setPageNo(jshStorePageReqVO.getPageNo());
            jshStroeShareholderReqVO.setPageSize(jshStorePageReqVO.getPageSize());
            PageResult<JshStroeShareholderDO> jshStroeShareholderDOPageResult = jshStroeShareholderMapper.selectPage(jshStroeShareholderReqVO);
            if (CollectionUtils.isAnyEmpty(jshStroeShareholderDOPageResult.getList())) {
                jshStroeDetailResVO.setList(new ArrayList<>());
                jshStroeDetailResVO.setTotal(0L);
                return jshStroeDetailResVO;
            }
            jshStroeDetailResVO.setTotal(jshStroeShareholderDOPageResult.getTotal());
            Map<String, JshStroeShareholderDO> storeMap = jshStroeShareholderDOPageResult.getList().stream().collect(Collectors.toMap(JshStroeShareholderDO::getStoreNumber, store -> store));
            // 所有的门店信息
            jshStroeDOS = jshStoreMapper.selectList(new ArrayList<>(storeMap.keySet()));
        } else {
            PageResult<JshStroeDO> jshStroeDOPageResult = jshStoreMapper.selectPage(jshStorePageReqVO);
            if (CollectionUtils.isAnyEmpty(jshStroeDOPageResult.getList())) {
                jshStroeDetailResVO.setList(new ArrayList<>());
                jshStroeDetailResVO.setTotal(0L);
                return jshStroeDetailResVO;
            }
            jshStroeDetailResVO.setTotal(jshStroeDOPageResult.getTotal());
            jshStroeDOS = jshStroeDOPageResult.getList();
        }
        List<JshStroeDetailResVO> jshStroeDetailResVOS = new ArrayList<>();
        for (JshStroeDO jshStroeDO : jshStroeDOS) {
            jshStroeDetailResVOS.add(storeDetail(jshStroeDO.getNumber()));
        }
        jshStroeDetailResVO.setList(jshStroeDetailResVOS);

        return jshStroeDetailResVO;
    }


    private JshStroeDetailResVO storeDetail(String number) {
        // 门店信息
        JshStroeDO jshStroeDO = jshStoreMapper.selectByNumber(number);
        JshStroeDetailResVO jshStroeDetailResVO = new JshStroeDetailResVO();
        BeanUtils.copyProperties(jshStroeDO, jshStroeDetailResVO);
        // 查询门店信息
        jshStroeDetailResVO.setInitialAmount(jshStroeDO.getInitialAmount().toString());
        // 股东信息
        List<JshStroeShareholderReSVO> jshStroeShareholderReSVOS = jshStroeShareHolderService.selectByStorenumber(number);
        jshStroeDetailResVO.setJshStroeShareholderReSVOS(jshStroeShareholderReSVOS);
        // 店员
        List<JshStroeClerkReSVO> jshStroeClerkReSVOS = jshStroeClerkService.selectByStoreNumber(number);
        jshStroeDetailResVO.setJshStroeClerkReSVOS(jshStroeClerkReSVOS);
        return jshStroeDetailResVO;
    }

}
