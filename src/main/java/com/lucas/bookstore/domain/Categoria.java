package com.lucas.bookstore.domain;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Categoria implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotEmpty(message = "Campo NOME requerido")
  @Length(min = 3, max = 100, message = "O campo NOME deve ter entre 3 e 100 caracteres")
  private String nome;

  @NotEmpty(message = "Campo DESCRIÇAO requerido")
  @Length(min = 3, max = 200, message = "O campo DESCRIÇAO deve ter entre 3 e 200 caracteres")
  private String descricao;

  @OneToMany(mappedBy = "categoria")
  private List<Livro> livros = new ArrayList<>();

  public Categoria() {
  }

  public Categoria(Long id, String nome, String descricao) {
    this.id = id;
    this.nome = nome;
    this.descricao = descricao;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public List<Livro> getLivros() {
    return livros;
  }

  public void setLivros(List<Livro> livros) {
    this.livros = livros;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Categoria)) return false;

    Categoria categoria = (Categoria) o;

    return getId().equals(categoria.getId());
  }

  @Override
  public int hashCode() {
    return getId().hashCode();
  }
}
