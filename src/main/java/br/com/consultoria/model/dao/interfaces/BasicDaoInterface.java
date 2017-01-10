package br.com.consultoria.model.dao.interfaces;

import java.util.List;

public interface BasicDaoInterface<T>{
	
	List<T> findAll();

	T findById(Integer pk);

	T save(T entity);

	void update(T entity);

	void delete(T entity);
	
	public void saveOrUpdate(T entity);

}