package cn.niit.shop_online.controller;

import cn.niit.shop_online.common.result.Result;
import cn.niit.shop_online.entity.IndexCarousel;
import cn.niit.shop_online.service.IndexCarouselService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;


/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 200613
 * @since 2023-11-07
 */
@Tag(name = "首页管理")
@RestController
@RequestMapping("home")
@AllArgsConstructor
public class IndexCarouselController {
    private final IndexCarouselService indexCarouselService;

    @Operation(summary = "首页/商品分类页-推荐轮播图")
    @GetMapping("banner")
    public Result<List<IndexCarousel>> getList(@RequestParam Integer distributionSite) {

        List<IndexCarousel> list = indexCarouselService.getList(distributionSite);
        return Result.ok(list);

    }

}

