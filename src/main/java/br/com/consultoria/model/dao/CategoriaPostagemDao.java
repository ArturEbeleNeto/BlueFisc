package br.com.consultoria.model.dao;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.consultoria.model.dao.interfaces.CategoriaPostagemDaoInterface;
import br.com.consultoria.model.entity.CategoriaPostagem;

@Repository
@Transactional
public class CategoriaPostagemDao extends BasicDao<CategoriaPostagem> implements CategoriaPostagemDaoInterface{}