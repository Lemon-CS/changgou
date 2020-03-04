package com.changgou.goods.controller;

import com.changgou.goods.pojo.Brand;
import com.changgou.goods.service.BrandService;
import com.github.pagehelper.PageInfo;
import com.changgou.entity.Result;
import com.changgou.entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * description: BrandController <br>
 * date: 2020/3/3 8:46 下午 <br>
 * author: fangpeng <br>
 * version: 1.0 <br>
 */
@RestController
@RequestMapping(value = "/brand")
@CrossOrigin // 跨域：A域名访问B域名的数据（域名、请求端口或者协议不一致，就存在跨域）
public class BrandController {

    @Autowired
    private BrandService brandService;

    @GetMapping(value = "/{id}")
    public Result<Brand> findById(@PathVariable(value = "id")Integer id) {
        Brand brand = brandService.findById(id);
        return new Result<Brand>(true, StatusCode.OK, "根据ID查询Brand成功！", brand);
    }

    /**
     * 查询所有品牌
     */
    @GetMapping
    public Result<List<Brand>> findAll() {
        // 查询所有品牌
        List<Brand> brands = brandService.findAll();
        // 响应结果封装
        return new Result<List<Brand>>(true, StatusCode.OK, "查询品牌集合成功！", brands);
    }

    /**
     * 增加品牌
     * @param brand
     * @return
     */
    @PostMapping
    public Result add(@RequestBody Brand brand) {
        brandService.add(brand);
        return new Result(true, StatusCode.OK, "增加品牌成功！");
    }

    /**
     * 修改品牌
     * @return
     */
    @PutMapping(value = "/{id}")
    public Result update(@PathVariable(value = "id") Integer id, @RequestBody Brand brand) {
        // 将ID给到brand
        brand.setId(id);
        brandService.update(brand);
        return new Result(true, StatusCode.OK, "修改品牌成功！");
    }

    /**
     * 根据ID删除品牌
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}")
    public Result delete(@PathVariable(value = "id") Integer id) {
        brandService.delete(id);
        return new Result(true, StatusCode.OK, "删除品牌成功！");
    }

    /**
     * 条件查询
     * @param brand
     * @return
     */
    @PostMapping(value = "/search")
    public Result<List<Brand>> findList(@RequestBody Brand brand) {
        List<Brand> brands = brandService.findList(brand);
        return new Result<List<Brand>>(true, StatusCode.OK, "条件搜索查询品牌集合成功！", brands);
    }

    /**
     * 分页查询实现
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}")
    public Result<PageInfo<Brand>> findPage(@PathVariable(value = "page") Integer page,
                                    @PathVariable(value = "size") Integer size) {
        PageInfo<Brand> pageInfo = brandService.findPage(page, size);
        return new Result<PageInfo<Brand>>(true, StatusCode.OK, "分页查询品牌成功", pageInfo);
    }

    /***
     * Brand分页条件搜索实现
     * @param brand
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}")
    public Result<PageInfo<Brand>> findPage(@RequestBody(required = false) Brand brand,
                                            @PathVariable(value = "page") Integer page,
                                            @PathVariable(value = "size") Integer size) {
        PageInfo<Brand> pageInfo = brandService.findPage(brand, page, size);
        return new Result<PageInfo<Brand>>(true, StatusCode.OK, "条件分页查询品牌成功", pageInfo);
    }

}
    