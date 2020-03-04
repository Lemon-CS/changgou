package com.changgou.goods.service.impl;

import com.changgou.goods.dao.BrandMapper;
import com.changgou.goods.pojo.Brand;
import com.changgou.goods.service.BrandService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;


/**
 * description: BrandServiceImpl <br>
 * date: 2020/3/3 8:45 下午 <br>
 * author: fangpeng <br>
 * version: 1.0 <br>
 */
@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandMapper brandMapper;

    @Override
    public Brand findById(Integer id) {
        // 根据ID查询，通用Mapper.selectByPrimaryKey(Object o)
        return brandMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询所有品牌
     * @return List
     */
    @Override
    public List<Brand> findAll() {
        // 查询所有->通用Mapper.selectAll()
        return brandMapper.selectAll();
    }

    /**
     * 增加品牌
     * @param brand
     */
    @Override
    public void add(Brand brand) {
        brandMapper.insertSelective(brand);
    }

    /**
     * 根据ID修改品牌
     * @param brand
     */
    @Override
    public void update(Brand brand) {
        brandMapper.updateByPrimaryKeySelective(brand);
    }

    /**
     * 根据ID删除品牌
     * @param id
     */
    @Override
    public void delete(Integer id) {
        brandMapper.deleteByPrimaryKey(id);
    }

    /**
     * 根据品牌信息条件查询品牌
     * @param brand
     * @return
     */
    @Override
    public List<Brand> findList(Brand brand) {
        // 调用方法构造条件
        Example example = createExample(brand);
        return brandMapper.selectByExample(example);
    }

    /***
     * Brand分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<Brand> findPage(Integer page, Integer size) {
        // 分页实现
        PageHelper.startPage(page, size);
        // 查询List
        List<Brand> brands = brandMapper.selectAll();

        // 封装PageInfo
        return new PageInfo<Brand>(brands);
    }

    /***
     * Brand多条件分页查询
     * @param brand
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<Brand> findPage(Brand brand, int page, int size) {
        // 分页实现
        PageHelper.startPage(page, size);
        // 查询品牌
        Example example = createExample(brand);
        List<Brand> brands = brandMapper.selectByExample(example);
        // 封装PageInfo
        return new PageInfo<Brand>(brands);
    }

    /**
     * 条件构造
     * @param brand
     * @return
     */
    private Example createExample(Brand brand) {
        // 自定义条件搜索对象
        Example example = new Example(Brand.class);
        // 条件构造器
        Example.Criteria criteria = example.createCriteria();

        if(brand != null) {
            // 如果名字不为空，则根据名字模糊查询
            if(!StringUtils.isEmpty(brand.getName())) {
                criteria.andLike("name", "%"+brand.getName()+"%");
            }
            // 如果首字母不为空，则根据首字母进行查询
            if(!StringUtils.isEmpty(brand.getLetter())) {
                criteria.andEqualTo("letter", brand.getLetter());
            }
        }
        return example;
    }
}
    