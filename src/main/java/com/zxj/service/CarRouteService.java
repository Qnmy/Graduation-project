package com.zxj.service;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Service;

import com.zxj.base.BaseDao;
import com.zxj.bean.Carroute;

@Service
public class CarRouteService extends BaseDao<Carroute> implements ICarRouteService{

	@Override
	public List<Carroute> getByRouteid(Integer id) {
		//List<Carroute> carRouteList = this.getHibernateTemplate().find("FROM " + Carroute.class + " WHERE routeid = " + id +"and dr = 0");
		return null;
	}

}
