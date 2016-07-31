package com.zxj.service;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Service;

import com.zxj.base.BaseDao;
import com.zxj.bean.Sendgoods;

@Service
public class SendGoodsService extends BaseDao<Sendgoods> 
					implements ISendGoodsService{

	@Override
	public List<Sendgoods> findFinishAll() {
		@SuppressWarnings("unchecked")
		List<Sendgoods> finishOrderList = this.getHibernateTemplate().find("FROM Sendgoods WHERE dr = 2");
		return finishOrderList;
	}

	@Override
	public List<Sendgoods> getFinishPageMes(int pageNumber, int num) {
		Query query = super.getSession().createQuery("FROM Sendgoods WHERE dr = 2");
		query.setFirstResult((pageNumber - 1) * num);
		query.setMaxResults(num);
		@SuppressWarnings("unchecked")
		List<Sendgoods> list = query.list();
		return list;
	}

}
