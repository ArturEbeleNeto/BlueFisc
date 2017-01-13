package br.com.consultoria.model.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.consultoria.model.dao.interfaces.BasicDaoInterface;
import br.com.consultoria.model.entity.BaseEntity;

@SuppressWarnings("unchecked")
@Repository
@Transactional
public abstract class BasicDao<T> implements BasicDaoInterface<T>{

	@PersistenceContext
	protected EntityManager entityManager;

	private Class<?> clazz;

	public BasicDao() {
		this.clazz = (Class<?>) ((ParameterizedType) this.getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
	}

	
	public List<T> findAll() {
		return this.entityManager.createQuery("SELECT e FROM " + this.clazz.getName() + " e")
				.getResultList();
	}

	public T findById(Integer pk) {
		if (pk == null){
			return null;
		}else{
			return (T) this.entityManager.find(this.clazz, pk);
		}
	}

	public T save(T entity) {
		this.entityManager.persist(entity);						
		return entity; 
	}

	public void update(T entity) {
		this.entityManager.merge(entity);
	}

	public void delete(T entity) {
		BaseEntity baseBean = (BaseEntity) entity;
		this.entityManager.remove(this.entityManager.getReference(this.clazz, baseBean.getId()));	
	}
	
	public void saveOrUpdate(T entity){
		BaseEntity baseBean = (BaseEntity) entity;
		if(findById((Integer)baseBean.getId()) == null){		
			save(entity);
		}else{		
			update(entity);
		}			
	}
}