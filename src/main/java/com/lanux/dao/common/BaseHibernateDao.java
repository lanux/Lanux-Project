package com.lanux.dao.common;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public abstract class BaseHibernateDao<T, PK extends Serializable> implements IBaseDao<T, PK> {

	private final Class<T> clazz;

	@SuppressWarnings("unchecked")
	public BaseHibernateDao() {
		this.clazz = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;

	public Session getSession() {
		// 事务必须是开启的(Required)，否则获取不到
		return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	public PK save(T t) {
		return (PK) getSession().save(t);
	}

	public void saveOrUpdate(T t) {
		getSession().saveOrUpdate(t);
	}

	public void update(T t) {
		getSession().update(t);
	}

	public void merge(T t) {
		getSession().merge(t);
	}

	public void delete(PK id) {
		getSession().delete(id);

	}

	public void deleteObject(T t) {
		getSession().delete(t);
	}

	public boolean exists(PK id) {
		return get(id) != null;
	}

	@SuppressWarnings("unchecked")
	public T get(PK id) {
		return (T) getSession().get(clazz, id);
	}

	public void flush() {
		getSession().flush();
	}

	public void clear() {
		getSession().clear();
	}

	@SuppressWarnings("unchecked")
	public List<T> findByHql(String hql, Object... values) {
		Query query = getSession().createQuery(hql);
		setParameters(query, values);
		return query.list();
	}

	@SuppressWarnings("unchecked")
	public List<T> findBySql(String sql, Object... values) {
		SQLQuery query = getSession().createSQLQuery(sql);
		return query.list();
	}

	/**
	 * 根据查询条件返回唯一一条记录
	 */
	@SuppressWarnings("unchecked")
	protected T getUnique(String hql, Object... paramlist) {
		Query query = getSession().createQuery(hql);
		setParameters(query, paramlist);
		return (T) query.uniqueResult();
	}

	/**
	 * 执行批处理语句.如 之间insert, update, delete 等.
	 */
	protected int batchExecteHql(final String hql, final Object... paramlist) {
		Query query = getSession().createQuery(hql);
		setParameters(query, paramlist);
		Object result = query.executeUpdate();
		return result == null ? 0 : ((Integer) result).intValue();
	}

	protected int batchExecteSql(final String sql, final Object... paramlist) {
		Query query = getSession().createSQLQuery(sql);
		setParameters(query, paramlist);
		Object result = query.executeUpdate();
		return result == null ? 0 : ((Integer) result).intValue();
	}

	protected void setParameters(Query query, Object[] params) {
		if (params != null) {
			for (int i = 0; i < params.length; i++) {
				if (params[i] instanceof Date) {
					// TODO 难道这是bug 使用setParameter不行？？
					query.setTimestamp(i, (Date) params[i]);
				} else {
					query.setParameter(i, params[i]);
				}
			}
		}
	}

}
