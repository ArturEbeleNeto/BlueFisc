package br.com.bluefisc.model.dao;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.bluefisc.model.dao.interfaces.CategoriaPostagemDaoInterface;
import br.com.bluefisc.model.entity.CategoriaPostagem;

@Repository
@Transactional
public class CategoriaPostagemDao extends BasicDao<CategoriaPostagem> implements CategoriaPostagemDaoInterface{}