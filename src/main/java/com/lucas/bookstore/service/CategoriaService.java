package com.lucas.bookstore.service;

import com.lucas.bookstore.dtos.CategoriaDTO;
import com.lucas.bookstore.exceptions.ObjectNotFoundException;
import com.lucas.bookstore.domain.Categoria;
import com.lucas.bookstore.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

  @Autowired
  private CategoriaRepository categoriaRepository;

  public Categoria findById(Long id) {
    Optional<Categoria> obj = categoriaRepository.findById(id);
    return obj.orElseThrow(() -> new ObjectNotFoundException("Categoria não encontrada! Id: " + id + ", Tipo: "+ Categoria.class.getName()));
  }

  public List<Categoria> findAll() {
    return categoriaRepository.findAll();
  }

  public Categoria create(Categoria categoria) {
    categoria.setId(null);
    return categoriaRepository.save(categoria);
  }

  public Categoria update(Long id, CategoriaDTO categoriaDTO) {
    Categoria categoria = findById(id);
    categoria.setNome(categoriaDTO.getNome());
    categoria.setDescricao(categoriaDTO.getDescricao());
    return categoriaRepository.save(categoria);
  }

  public void delete(Long id) {
    findById(id);
    try {
      categoriaRepository.deleteById(id);
    }catch (DataIntegrityViolationException e){
      throw new com.lucas.bookstore.exceptions.DataIntegrityViolationException("Categoria não pode ser deletada! Possui livros associados");
    }
  }
}
