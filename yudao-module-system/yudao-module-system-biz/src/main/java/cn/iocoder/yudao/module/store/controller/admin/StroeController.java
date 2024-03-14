package cn.iocoder.yudao.module.store.controller.admin;

import cn.iocoder.yudao.framework.common.enums.UserTypeEnum;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.web.core.util.WebFrameworkUtils;
import cn.iocoder.yudao.module.store.controller.admin.vo.*;
import cn.iocoder.yudao.module.store.service.JshStroeClerkService;
import cn.iocoder.yudao.module.store.service.JshStroeService;
import cn.iocoder.yudao.module.store.service.JshStroeShareHolderService;
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

@Tag(name = "门店管理 - 门店信息")
@RestController
@RequestMapping("/store/manager")
@Validated
@Slf4j
public class StroeController {
    @Autowired
    private JshStroeService jshStroeService;
    @Autowired
    private JshStroeShareHolderService jshStroeShareHolderService;
    @Autowired
    private JshStroeClerkService jshStroeClerkService;

    @PostMapping("/create")
    @Operation(summary = "创建门店")
    // @PreAuthorize("@ss.hasPermission('system:post:create')")
    public CommonResult<JshStroeReSVO> createPost(@Valid @RequestBody JshStroeReqVO createReqVO) {
        JshStroeReSVO jshStroeReSVO = jshStroeService.create(createReqVO);
        return success(jshStroeReSVO);
    }


    @GetMapping("/page")
    @Operation(summary = "查询门店列表")
    // @PreAuthorize("@ss.hasPermission('system:post:create')")
    public CommonResult<PageResult<JshStroeDetailResVO>> listStorePage(@Valid  JshStorePageReqVO jshStorePageReqVO) {
        Long loginUserId = WebFrameworkUtils.getLoginUserId();
        // 管理员可以查出所有的门店
        Integer loginUserType = WebFrameworkUtils.getLoginUserType();
        if (UserTypeEnum.ADMIN.getValue().equals(loginUserType)) {
            loginUserId = null;
        }
        PageResult<JshStroeDetailResVO> jshStroeReSVO = jshStroeService.selectStore(jshStorePageReqVO, loginUserId);
        return success(jshStroeReSVO);
    }



    @PostMapping("/addstroeclerk")
    @Operation(summary = "新增店员信息")
    // @PreAuthorize("@ss.hasPermission('system:post:create')")
    public CommonResult<JshStroeClerkReSVO> addStroeClerk(@Valid @RequestBody AddJshStroeClerkReqVO addJshStroeClerkReqVO) {
        JshStroeClerkReSVO jshStroeClerkReSVO = jshStroeClerkService.add(addJshStroeClerkReqVO);
        return success(jshStroeClerkReSVO);
    }


    @PostMapping("/updatestroeclerk")
    @Operation(summary = "新增店员信息")
    // @PreAuthorize("@ss.hasPermission('system:post:create')")
    public CommonResult<JshStroeClerkReSVO> updateStroeClerk(@Valid @RequestBody UpdateJshStroeClerkReqVO updateJshStroeClerkReqVO) {
        JshStroeClerkReSVO jshStroeClerkReSVO = jshStroeClerkService.updateById(updateJshStroeClerkReqVO);
        return success(jshStroeClerkReSVO);
    }





    @PostMapping("/addStoreShareholder")
    @Operation(summary = "新增股东信息")
    // @PreAuthorize("@ss.hasPermission('system:post:create')")
    public CommonResult<JshStroeShareholderReSVO> addStoreShareholder(@Valid @RequestBody AddJshStroeShareholderReqVO addJshStroeShareholderReqVO) {
        JshStroeShareholderReSVO jshStroeReSVO = jshStroeShareHolderService.add(addJshStroeShareholderReqVO);
        return success(jshStroeReSVO);
    }


    @PostMapping("/updateStoreShareholder")
    @Operation(summary = "新增股东信息")
    // @PreAuthorize("@ss.hasPermission('system:post:create')")
    public CommonResult<JshStroeShareholderReSVO> updateStoreShareholder(@Valid @RequestBody AddJshStroeShareholderReqVO addJshStroeShareholderReqVO) {
        JshStroeShareholderReSVO jshStroeReSVO = jshStroeShareHolderService.updateById(addJshStroeShareholderReqVO);
        return success(jshStroeReSVO);
    }




}
