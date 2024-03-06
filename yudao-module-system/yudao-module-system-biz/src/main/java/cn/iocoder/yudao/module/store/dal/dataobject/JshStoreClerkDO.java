package cn.iocoder.yudao.module.store.dal.dataobject;

import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

/**
 * 门店信息表
 */
@TableName("jsh_store_clerk")
@Data
@EqualsAndHashCode(callSuper = true)
public class JshStoreClerkDO extends BaseDO {
    public static final Long PARENT_ID_ROOT = 0L;
    /**
     * 部门ID
     */
    @TableId
    private Integer id;
    /**
     * 门店编号
     */
    private String storeNumber;
    /**
     * 店员id
     */
    private Long clerkId;

    /**
     * 部门id
     */
    private Long depId;
    /**
     * '店员名称'
     */
    private String name;

    /**
     * '每月工资（元）'
     */
    private BigDecimal monthlySalary;
    /**
     * 股东电话
     */
    private String phone;

    /**
     * 投入资金
     */
    private BigDecimal investment;
    /**
     * '身份证
     */
    private String idCard;
    /**
     * 男/女
     */
    private String gender;

    private String joinedDate;

    private String departDate;
    /**
     * 是否在职（是/否）
     */
    private String employed;

    /**
     * '住址'
     */
    private String address;

}
