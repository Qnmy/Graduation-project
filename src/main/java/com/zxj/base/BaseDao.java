package com.zxj.base;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public abstract class BaseDao<T> extends HibernateDaoSupport implements IBaseDao<T> {

	protected Class<T> clazz;
	
	@SuppressWarnings("unchecked")
	public BaseDao(){
		// 通过反射得到T的真实类型
		ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
		this.clazz = (Class<T>) pt.getActualTypeArguments()[0];
		/*try {
			// 得到model的类型信息
			ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
			Class<?> clazz = (Class) pt.getActualTypeArguments()[0];

			// 通过反射生成model的实例
			model = (T) clazz.newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}*/
	}
	
	@Resource(name="sessionFactory")
	public void setSessionFactoryDI(SessionFactory sessionFactory){
		super.setSessionFactory(sessionFactory);
	}
	
	@Override
	public void save(T t) {
		this.getHibernateTemplate().save(t);
	}

	@Override
	public void update(T t) {
		this.getHibernateTemplate().merge(t);
	}

	@Override
	public void delete(T t) {
		this.getHibernateTemplate().merge(t);
	}

	@Override
	public T getByID(int id) {
		T entity = (T) this.getHibernateTemplate().get(clazz, id);
		return entity;
	}

	@Override
	public List<T> findAll() {
		@SuppressWarnings("unchecked")
		List<T> list = this.getHibernateTemplate().find("FROM " +  clazz.getSimpleName() + " WHERE dr = 0");
		return list;
	}

	@Override
	public List<T> getPageMes(int pageNumber, int num) {
		Query query = super.getSession().createQuery("FROM " + clazz.getSimpleName() + " WHERE dr = 0");
		query.setFirstResult((pageNumber - 1) * num);
		query.setMaxResults(num);
		@SuppressWarnings("unchecked")
		List<T> list = query.list();
		return list;
	}

}
