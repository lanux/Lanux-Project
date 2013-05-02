package com.lanux.dao.common;

import java.io.Serializable;
import java.util.List;

public abstract interface IBaseDao<T, K extends Serializable>
{
  public abstract T get(K paramK);

  public abstract List<T> getAll();

  public abstract boolean delete(K paramK);

  public abstract boolean update(T paramT);

  public abstract boolean add(T paramT);

  public abstract List<T> findBySql(String paramString);

  public abstract List<T> findByHql(String paramString);

  public abstract boolean execute(String paramString);
}