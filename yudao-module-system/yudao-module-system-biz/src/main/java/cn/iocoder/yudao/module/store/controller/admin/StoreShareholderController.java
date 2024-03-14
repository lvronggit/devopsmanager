package cn.iocoder.yudao.module.store.controller.admin;

import cn.iocoder.yudao.framework.common.enums.UserTypeEnum;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.web.core.util.WebFrameworkUtils;
import cn.iocoder.yudao.module.store.controller.admin.vo.JshStorePageReqVO;
import cn.iocoder.yudao.module.store.controller.admin.vo.JshStroeDetailResVO;
import cn.iocoder.yudao.module.store.controller.admin.vo.JshStroeReSVO;
import cn.iocoder.yudao.module.store.controller.admin.vo.JshStroeReqVO;
import cn.iocoder.yudao.module.store.service.JshStroeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

@Tag(name = "门店管理 - ")
@RestController
@RequestMapping("/store/manager")
@Validated
@Slf4j
public class StoreShareholderController {
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


    @PostMapping("/addStoreShareholder")
    @Operation(summary = "新增股东信息")
    // @PreAuthorize("@ss.hasPermission('system:post:create')")
    public CommonResult<JshStroeReSVO> addStoreShareholder(@Valid @RequestBody JshStroeReqVO createReqVO) {
        JshStroeReSVO jshStroeReSVO = jshStroeService.create(createReqVO);
        return success(jshStroeReSVO);
    }


}
