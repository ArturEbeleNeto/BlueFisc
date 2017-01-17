package br.com.bluefisc.model.dao;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.bluefisc.model.dao.interfaces.AreaDaoInterface;
import br.com.bluefisc.model.entity.Area;

@Repository
@Transactional
public class AreaDao extends BasicDao<Area> implements AreaDaoInterface{}