package com.zxj.service;

import java.util.List;

import com.zxj.base.IBaseDao;
import com.zxj.bean.Carroute;

public interface ICarRouteService extends IBaseDao<Carroute> {
	
	@Deprecated
	List<Carroute> getByRouteid(Integer id);
}
