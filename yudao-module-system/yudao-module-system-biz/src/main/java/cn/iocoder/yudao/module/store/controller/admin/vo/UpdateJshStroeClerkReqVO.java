package cn.iocoder.yudao.module.store.controller.admin.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 新增股东信息
 */
@Schema(description = "新增店员信息")
@Data
public class UpdateJshStroeClerkReqVO extends AddJshStroeClerkReqVO {

    private Integer id;

}
