package br.com.consultoria.model.dao;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.consultoria.model.dao.interfaces.AreaDaoInterface;
import br.com.consultoria.model.entity.Area;

@Repository
@Transactional
public class AreaDao extends BasicDao<Area> implements AreaDaoInterface{}