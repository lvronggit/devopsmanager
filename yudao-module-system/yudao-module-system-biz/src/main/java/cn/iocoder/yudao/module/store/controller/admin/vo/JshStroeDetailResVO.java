package cn.iocoder.yudao.module.store.controller.admin.vo;

import lombok.Data;

/**
 * 门店信息表
 */
@Data
public class JshStroeDetailResVO {
    public static final Long PARENT_ID_ROOT = 0L;
    private Integer id;
    /**
     * 门店编号
     */
    private String number;
    /**
     * 门店名
     *
     */
    private String name;


    /**
     * 门店地址
     */
    private String address;

    /**
     * 门店法人
     */
    private String legalPerson;

    /**
     * 投入资金
     */
    private String initialAmount;

    /**
     * 描述
     */
    private String remark;


}
