package com.zxj.base;

import java.util.List;

public interface IBaseDao<T> {

	/**
	 * 保存信息
	 * @param t
	 */
	void save(T t);
	
	/**
	 * 更新信息
	 * @param t
	 */
	void update(T t);
	
	/**
	 * 删除信息
	 * @param t
	 */
	void delete(T t);
	
	/**
	 * 通过ID查找信息
	 * @param id
	 * @return
	 */
	T getByID(int id);
	
	/**
	 * 查询所有
	 * @return
	 */
	List<T> findAll();
	
	/**
	 * 获取某页数据
	 * @param pageNumber
	 * @return
	 */
	List<T> getPageMes(int pageNumber, int num);
}
