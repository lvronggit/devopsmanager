package cn.iocoder.yudao.module.store.controller.admin.vo;

import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 新增股东信息
 */
@Schema(description = "新增店员信息")
@Data
public class AddJshStroeClerkReqVO {

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
