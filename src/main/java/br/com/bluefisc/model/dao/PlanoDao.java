package br.com.bluefisc.model.dao;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.bluefisc.model.dao.interfaces.PlanoDaoInterface;
import br.com.bluefisc.model.entity.Plano;

@Repository
@Transactional
public class PlanoDao extends BasicDao<Plano> implements PlanoDaoInterface{	}