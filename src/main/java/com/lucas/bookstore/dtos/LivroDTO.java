package com.lucas.bookstore.dtos;

import com.lucas.bookstore.domain.Livro;

import java.io.Serializable;

public class LivroDTO implements Serializable {

  private static final long serialVersionUID = 1L;

  private Long id;

  private String titulo;

  public LivroDTO () {
    super();
  }

  public LivroDTO(Livro livro) {
    super();
    this.id = livro.getId();
    this.titulo = livro.getTitulo();
  }

  public static long getSerialVersionUID() {
    return serialVersionUID;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTitulo() {
    return titulo;
  }

  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }
}
