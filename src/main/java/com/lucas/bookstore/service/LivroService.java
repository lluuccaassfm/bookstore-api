package com.lucas.bookstore.service;

import com.lucas.bookstore.domain.Categoria;
import com.lucas.bookstore.domain.Livro;
import com.lucas.bookstore.exceptions.ObjectNotFoundException;
import com.lucas.bookstore.repositories.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

  @Autowired
  private LivroRepository livroRepository;

  @Autowired
  private CategoriaService categoriaService;

  public Livro findById(Long id) {
    Optional<Livro> obj = livroRepository.findById(id);
    return obj.orElseThrow(() -> new ObjectNotFoundException("Livro não encontrado! Id: " + id + ", Tipo: "+ Livro.class.getName()));
  }

  public List<Livro> findAll(Long idCategoria) {
    if(idCategoria == 0){
      return livroRepository.findAll();
    }
    categoriaService.findById(idCategoria);
    return livroRepository.findAllByCategoria(idCategoria);
  }
}
