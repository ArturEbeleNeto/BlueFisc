package br.com.bluefisc.model.dao;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.bluefisc.model.dao.interfaces.PostagemDaoInterface;
import br.com.bluefisc.model.entity.Postagem;

@Repository
@Transactional
public class PostagemDao extends BasicDao<Postagem> implements PostagemDaoInterface{}