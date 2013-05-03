package com.lanux.dao.common;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Service;

@Service("baseDao")
@Scope("singleton")
public class JdbcBaseDao<T> extends JdbcDaoSupport {
	public int update(String sql, Class<T> clazz) {
		return getJdbcTemplate().update(sql, new Object[] { new BeanPropertySqlParameterSource(clazz) });
	}

	protected T get(String sql, Class<T> clazz, Object[] paramValue) {
		return (T) getJdbcTemplate().queryForObject(sql, new BeanPropertyRowMapper<T>(clazz), paramValue);
	}

	public List<T> getList(String sql, Class<T> clazz, Object[] paramValue) {
		return getJdbcTemplate().query(sql, new BeanPropertyRowMapper<T>(clazz), paramValue);
	}

	protected List<T> getList(String sql, Class<T> clazz) {
		return getJdbcTemplate().query(sql, new BeanPropertyRowMapper<T>(clazz));
	}
}
