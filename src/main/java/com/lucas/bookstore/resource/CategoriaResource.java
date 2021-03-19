package com.lucas.bookstore.resource;

import com.lucas.bookstore.domain.Categoria;
import com.lucas.bookstore.dtos.CategoriaDTO;
import com.lucas.bookstore.service.CategoriaService;
import com.sun.source.util.TaskListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {

  @Autowired
  private CategoriaService categoriaService;

  @GetMapping(value = "/{id}")
  public ResponseEntity<Categoria> findbyId(@PathVariable Long id){
    Categoria categoria = categoriaService.findById(id);
    return  ResponseEntity.ok().body(categoria);
  }

  @GetMapping
  public ResponseEntity<List<CategoriaDTO>> findAll() {
    List<Categoria> categorias = categoriaService.findAll();
    List<CategoriaDTO> categoriasDTO = categorias.stream()
            .map(obj -> new CategoriaDTO(obj)).collect(Collectors.toList());
    return ResponseEntity.ok().body(categoriasDTO);
  }

  @PostMapping
  public ResponseEntity<Categoria> create(@RequestBody Categoria categoria) {
    categoria = categoriaService.create(categoria);
    URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(categoria.getId()).toUri();
    return ResponseEntity.created(uri).build();
  }

  @PutMapping(value = "/{id}")
  public ResponseEntity<CategoriaDTO> update(@PathVariable Long id, @RequestBody CategoriaDTO categoriaDTO) {
    Categoria newCategoria = categoriaService.update(id, categoriaDTO);
    return ResponseEntity.ok().body(new CategoriaDTO(newCategoria));
  }

  @DeleteMapping(value = "/{id}")
  public ResponseEntity<Void> delete(@PathVariable Long id) {
    categoriaService.delete(id);
    return ResponseEntity.noContent().build();
  }
}
