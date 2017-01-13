package br.com.consultoria.model.dao.interfaces;

import java.util.List;

public interface BasicDaoInterface<T>{
	
	public List<T> findAll();

	public T findById(Integer pk);

	public T save(T entity);

	public void update(T entity);

	public void delete(T entity);
	
}