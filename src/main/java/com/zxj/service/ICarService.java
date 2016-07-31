package com.zxj.service;

import java.util.List;

import com.zxj.base.IBaseDao;
import com.zxj.bean.Car;

public interface ICarService extends IBaseDao<Car> {
	
	List<Car> getByCarNumber(String number);
}
