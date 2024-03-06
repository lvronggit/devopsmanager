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
@TableName("jsh_store")
@Data
@EqualsAndHashCode(callSuper = true)
public class JshStroeDO extends BaseDO {
    public static final Long PARENT_ID_ROOT = 0L;

    /**
     * 部门ID
     */
    @TableId
    private Integer id;
    /**
     * 门店编号
     */
    private String number;
    /**
     * 门店名
     *
     * 关联 {@link #id}
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
    private BigDecimal initialAmount;

    /**
     * 描述
     */
    private String remark;


}
