package cn.iocoder.yudao.module.store.controller.admin.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.List;

/**
 * 门店信息表
 */
@Schema(description = "管理后台 - 通知公告分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
public class JshStroeShareholderReqVO extends PageParam {
    public static final Long PARENT_ID_ROOT = 0L;

    @Schema(description = "门店编号集合", example = "[1,2]")
    private List<String> storeNumbers;

    @Schema(description = "股东id集合", example = "[1,2]")
    private List<Long> shareholderIds;


}


