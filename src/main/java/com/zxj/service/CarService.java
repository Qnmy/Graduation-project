package com.zxj.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.zxj.base.BaseDao;
import com.zxj.bean.Car;

@Service
public class CarService extends BaseDao<Car> implements ICarService{

	@Override
	public List<Car> getByCarNumber(String number) {
		@SuppressWarnings("unchecked")
		List<Car> carList = this.getHibernateTemplate().find("FROM Car where dr = 0 and carnumber = '" + number + "'");
		return carList;
	}

}
