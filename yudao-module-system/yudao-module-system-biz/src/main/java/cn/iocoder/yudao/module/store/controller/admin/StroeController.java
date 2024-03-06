package cn.iocoder.yudao.module.store.controller.admin;

import cn.hutool.core.collection.CollUtil;
import cn.iocoder.yudao.framework.common.enums.UserTypeEnum;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.web.core.util.WebFrameworkUtils;
import cn.iocoder.yudao.module.store.controller.admin.vo.JshStorePageReqVO;
import cn.iocoder.yudao.module.store.controller.admin.vo.JshStroeDetailResVO;
import cn.iocoder.yudao.module.store.controller.admin.vo.JshStroeReSVO;
import cn.iocoder.yudao.module.store.controller.admin.vo.JshStroeReqVO;
import cn.iocoder.yudao.module.store.service.JshStroeService;
import cn.iocoder.yudao.module.system.controller.admin.user.vo.user.UserPageReqVO;
import cn.iocoder.yudao.module.system.controller.admin.user.vo.user.UserRespVO;
import cn.iocoder.yudao.module.system.convert.user.UserConvert;
import cn.iocoder.yudao.module.system.dal.dataobject.dept.DeptDO;
import cn.iocoder.yudao.module.system.dal.dataobject.user.AdminUserDO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;
import java.util.Map;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;
import static cn.iocoder.yudao.framework.common.util.collection.CollectionUtils.convertList;

@Tag(name = "门店管理 - 门店信息")
@RestController
@RequestMapping("/store/manager")
@Validated
@Slf4j
public class StroeController {
    @Autowired
    private JshStroeService jshStroeService;

    @PostMapping("/create")
    @Operation(summary = "创建门店")
    // @PreAuthorize("@ss.hasPermission('system:post:create')")
    public CommonResult<JshStroeReSVO> createPost(@Valid @RequestBody JshStroeReqVO createReqVO) {
        JshStroeReSVO jshStroeReSVO = jshStroeService.create(createReqVO);
        return success(jshStroeReSVO);
    }


    @PostMapping("/page")
    @Operation(summary = "查询门店列表")
    // @PreAuthorize("@ss.hasPermission('system:post:create')")
    public CommonResult<PageResult<JshStroeDetailResVO>> listStorePage(@Valid @RequestBody JshStorePageReqVO jshStorePageReqVO) {
        Long loginUserId = WebFrameworkUtils.getLoginUserId();
        // 管理员可以查出所有的门店
        Integer loginUserType = WebFrameworkUtils.getLoginUserType();
        if (!UserTypeEnum.ADMIN.getValue().equals(loginUserType)) {
            loginUserId = null;
        }
        PageResult<JshStroeDetailResVO> jshStroeReSVO = jshStroeService.selectStore(jshStorePageReqVO, loginUserId);
        return success(jshStroeReSVO);
    }


}
