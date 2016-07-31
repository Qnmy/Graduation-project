package com.zxj.service;

import java.util.List;

import com.zxj.base.IBaseDao;
import com.zxj.bean.Sendgoods;

public interface ISendGoodsService extends IBaseDao<Sendgoods> {

	List<Sendgoods> findFinishAll();
	
	List<Sendgoods> getFinishPageMes(int pageNumber, int num);
}
