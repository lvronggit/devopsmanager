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
@TableName("jsh_store_shareholder")
@Data
@EqualsAndHashCode(callSuper = true)
public class JshStroeShareholderDO extends BaseDO {
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
     * 股东id
     */
    private Long shareholderId;


    /**
     * 股东名
     */
    private String shareholderName;

    /**
     * 股份比例
     */
    private String percentage;
    /**
     * 股东电话
     */
    private String phone;

    /**
     * 投入资金
     */
    private BigDecimal investment;


}
