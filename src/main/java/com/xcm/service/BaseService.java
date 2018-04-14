package com.xcm.service;

/**
 * 基础业务
 * created by lq at 2018-04-11 17:46
 **/
public interface BaseService<T> {

    /**
     * 新增
     *
     * @param t 新增的对象
     */
    void save(T t);

    /**
     * 根据id删除
     *
     * @param id 删除的数据的id
     */
    void deleteById(Integer id);

    /**
     * 更新
     *
     * @param t 更新的数据
     */
    void update(T t);

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    T getById(Integer id);
}
