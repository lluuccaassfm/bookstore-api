package com.lucas.bookstore.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Livro implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  private String titulo;

  private String nome_autor;

  private String texto;

  @ManyToOne
  @JoinColumn
  private Categoria categoria;

  public Livro() {
  }

  public Livro(int id, String titulo, String nome_autor, String texto, Categoria categoria) {
    this.id = id;
    this.titulo = titulo;
    this.nome_autor = nome_autor;
    this.texto = texto;
    this.categoria = categoria;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getTitulo() {
    return titulo;
  }

  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }

  public String getNome_autor() {
    return nome_autor;
  }

  public void setNome_autor(String nome_autor) {
    this.nome_autor = nome_autor;
  }

  public String getTexto() {
    return texto;
  }

  public void setTexto(String texto) {
    this.texto = texto;
  }

  public Categoria getCategoria() {
    return categoria;
  }

  public void setCategoria(Categoria categoria) {
    this.categoria = categoria;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Livro)) return false;

    Livro livro = (Livro) o;

    return getId() == livro.getId();
  }

  @Override
  public int hashCode() {
    return getId();
  }
}
