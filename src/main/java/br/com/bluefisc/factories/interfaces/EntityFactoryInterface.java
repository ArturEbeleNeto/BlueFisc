package br.com.bluefisc.factories.interfaces;

public interface EntityFactoryInterface<T> {
	
	public T getEntity(T entity);
	
	public T getEntity(Integer id);
	
	public T getEntity(); 
	
}
