package cn.iocoder.yudao.module.store.controller.admin.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 新增股东信息
 */
@Schema(description = "新增股东信息")
@Data
public class AddJshStroeShareholderReqVO {
    private Integer id;


    @Schema(description = "门店编号", example = "0000000012")
    private String storeNumber;

    @Schema(description = "股东id", example = "1")
    private Long shareholderId;


    @Schema(description = "股东名", example = "yunai")
    private String shareholderName;

    /**
     * 股份比例
     */
    @Schema(description = "股份比例", example = "10")
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
