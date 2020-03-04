package com.changgou.goods.service;

import com.changgou.goods.pojo.Brand;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * description: BrandService <br>
 * date: 2020/3/3 8:45 下午 <br>
 * author: fangpeng <br>
 * version: 1.0 <br>
 */
public interface BrandService {

    /**
     * 根据id查询单个品牌
     * @return
     */
    Brand findById(Integer id);

    /**
     * 查询所有品牌
     */
    List<Brand> findAll();

    /**
     * 增加Brand
     * @param brand
     */
    void add(Brand brand);

    /**
     * 修改品牌
     * @param brand
     */
    void update(Brand brand);

    /**
     * 根据ID删除品牌
     * @param id
     */
    void delete(Integer id);

    /**
     * 根据品牌信息条件查询品牌
     * @param brand
     * @return
     */
    List<Brand> findList(Brand brand);

    /***
     * Brand分页查询
     * @param page 当前页
     * @param size 每页显示的条数
     * @return
     */
    PageInfo<Brand> findPage(Integer page, Integer size);

    /***
     * Brand多条件分页查询
     * @param brand
     * @param page
     * @param size
     * @return
     */
    PageInfo<Brand> findPage(Brand brand, int page, int size);

}
