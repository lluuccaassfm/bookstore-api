package com.lucas.bookstore.resource;

import com.lucas.bookstore.domain.Livro;
import com.lucas.bookstore.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/livros")
public class LivroResource {

  @Autowired
  private LivroService livroService;

  @GetMapping(value = "/{id}")
  public ResponseEntity<Livro> findById(@PathVariable Long id) {
    Livro livro  = livroService.findById(id);
    return ResponseEntity.ok().body(livro);
  }

//  @GetMapping
//  public ResponseEntity<List<Livro>> findAll(){
//    List<Livro> livros = livroService.findAll();
//
//  }
}
