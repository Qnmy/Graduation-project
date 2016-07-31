package com.zxj.base;


import java.lang.reflect.ParameterizedType;

import com.opensymphony.xwork2.ModelDriven;


public abstract class ModelDrivenBaseAction<T> extends BaseAction implements ModelDriven<T> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected T model;

	
	@SuppressWarnings("unchecked")
	public ModelDrivenBaseAction() {
		try {
			// 得到model的类型信息
			ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
			Class<?> clazz = (Class<?>) pt.getActualTypeArguments()[0];

			// 通过反射生成model的实例
			model = (T) clazz.newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public T getModel() {
		return model;
	}
	
}
