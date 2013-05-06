package com.lanux.dao.common;

import java.io.Serializable;
import java.util.List;

public interface IBaseDao<T, PK extends Serializable> {
	public T get(PK paramK);

	public List<T> getAll();

	public void delete(PK paramK);

	public void update(T paramT);

	public boolean add(T paramT);

	public List<T> findBySql(String paramString);

	public List<T> findByHql(String paramString);

	public boolean execute(String paramString);
	
}