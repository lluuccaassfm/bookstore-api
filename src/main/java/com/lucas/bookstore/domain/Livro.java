package com.lucas.bookstore.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Entity
public class Livro implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotEmpty(message = "Campo TÍTULO é requerido")
  @Length(min = 3, max = 50, message = "O campo TÍTULO deve ter entre 3 e 50 caracteres")
  private String titulo;

  @NotEmpty(message = "Campo NOME_DO_AUTOR é requerido")
  @Length(min = 3, max = 50, message = "O campo NOME_DO_AUTOR deve ter entre 3 e 50 caracteres")
  private String nome_autor;

  @NotEmpty(message = "Campo TEXTO é requerido")
  @Length(min = 3, max = 2000000, message = "O campo TEXTO deve ter entre 10 e 2000000 caracteres")
  private String texto;

  @JsonIgnore
  @ManyToOne
  @JoinColumn
  private Categoria categoria;

  public Livro() {
  }

  public Livro(Long id, String titulo, String nome_autor, String texto, Categoria categoria) {
    this.id = id;
    this.titulo = titulo;
    this.nome_autor = nome_autor;
    this.texto = texto;
    this.categoria = categoria;
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

    return getId().equals(livro.getId());
  }

  @Override
  public int hashCode() {
    return getId().hashCode();
  }
}
