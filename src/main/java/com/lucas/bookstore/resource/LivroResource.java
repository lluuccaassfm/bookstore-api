package com.lucas.bookstore.resource;

import com.lucas.bookstore.domain.Livro;
import com.lucas.bookstore.dtos.LivroDTO;
import com.lucas.bookstore.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

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

  //localhost:8080/livros?categoria=1
  @GetMapping
  public ResponseEntity<List<LivroDTO>> findAll(@RequestParam(value = "categoria", defaultValue = "0") Long idCat) {
    List<Livro> livros = livroService.findAll(idCat);
    List<LivroDTO> livrosDTO = livros.stream().map(obj -> new LivroDTO(obj)).collect(Collectors.toList());
    return ResponseEntity.ok().body(livrosDTO);
  }

  @PutMapping(value = "/{id}")
  public ResponseEntity<Livro> update(@PathVariable Long id, @RequestBody Livro livro) {
    Livro newLivro = livroService.update(id, livro);
    return ResponseEntity.ok().body(newLivro);
  }

  @PatchMapping(value = "/{id}")
  public ResponseEntity<Livro> updatePath(@PathVariable Long id, @RequestBody Livro livro) {
    Livro newLivro = livroService.update(id, livro);
    return ResponseEntity.ok().body(newLivro);
  }

  @PostMapping
  public ResponseEntity<Livro> create(
          @RequestParam(value = "categoria", defaultValue = "0") Long idCategoria,
          @RequestBody Livro livro)
  {
    Livro newLivro = livroService.create(idCategoria, livro);
    URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/livros/{id}").buildAndExpand(newLivro.getId()).toUri();
    return ResponseEntity.created(uri).build();
  }
}
