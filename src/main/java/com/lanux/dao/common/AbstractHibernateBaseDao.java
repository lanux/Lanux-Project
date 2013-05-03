package com.lanux.dao.common;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public abstract class AbstractHibernateBaseDao<T, K extends Serializable> extends HibernateDaoSupport implements IBaseDao<T, K> {
	protected Logger logger = Logger.getLogger(AbstractHibernateBaseDao.class);
	protected Class<T> clazz;

	@SuppressWarnings("unchecked")
	protected Class<T> getEntityClass() {
		if (this.clazz == null) {
			this.clazz = ((Class<T>) ((java.lang.reflect.ParameterizedType) super.getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
		}
		return this.clazz;
	}

	public T get(K id) {
		try {
			return getHibernateTemplate().get(getEntityClass(), id);
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean delete(K id) {
		try {
			Object entity = get(id);
			if (entity != null)
				getHibernateTemplate().delete(entity);
		} catch (DataAccessException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean update(T t) {
		try {
			getHibernateTemplate().update(t);
		} catch (DataAccessException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean add(T t) {
		try {
			if (getHibernateTemplate().save(t) != null)
				return true;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	public List<T> findBySql(final String sql) {
		List<T> list = null;
		try {
			list = getHibernateTemplate().executeFind(new HibernateCallback<List<T>>() {
				public List<T> doInHibernate(final Session session) throws HibernateException, SQLException {
					SQLQuery query = session.createSQLQuery(sql);
					return query.list();
				}
			});
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<T> findByHql(String hql) {
		List<T> list = null;
		try {
			list = getHibernateTemplate().find(hql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public boolean execute(final String sql) {
		boolean res = false;
		try {
			Integer c = (Integer) getHibernateTemplate().execute(new HibernateCallback<Integer>() {
				public Integer doInHibernate(Session session) throws HibernateException, SQLException {
					return Integer.valueOf(session.createQuery(sql).executeUpdate());
				}
			});
			if (c != null)
				res = c.intValue() > 0;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return res;
	}

	public boolean updateOrDelete(String hql) {
		boolean res = false;
		try {
			int count = getHibernateTemplate().bulkUpdate(hql);
			res = count > 0;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return res;
	}

	public List<T> getAll() {
		List<T> list = null;
		try {
			list = getHibernateTemplate().loadAll(getEntityClass());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
