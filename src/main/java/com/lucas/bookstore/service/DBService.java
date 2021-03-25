package com.lucas.bookstore.service;

import com.lucas.bookstore.domain.Categoria;
import com.lucas.bookstore.domain.Livro;
import com.lucas.bookstore.repositories.CategoriaRepository;
import com.lucas.bookstore.repositories.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DBService {

  @Autowired
  private CategoriaRepository categoriaRepository;
  @Autowired
  private LivroRepository livroRepository;

  public void instanciaBaseDeDados(){
    Categoria cat1 = new Categoria(null, "Informática", "Livros de TI");
    Categoria cat2 = new Categoria(null, "Psicologia", "Livros de Psicologia");
    Categoria cat3 = new Categoria(null, "Pedagogia", "Livros de Pedagogia");

    Livro l1 = new Livro(null, "Clean Code", "Robert M.", "Lorem Ipsum", cat1);
    Livro l2 = new Livro(null, "JAVA", "Oracle", "Lorem Ipsum", cat1);
    Livro l3 = new Livro(null, "Estudo da mente", "Lucas F.", "Lorem Ipsum", cat2);
    Livro l4 = new Livro(null, "O corpo fala", "Fulano S.", "Lorem Ipsum", cat2);

    cat1.getLivros().addAll(Arrays.asList(l1, l2));
    cat2.getLivros().addAll(Arrays.asList(l3, l4));

    this.categoriaRepository.saveAll(Arrays.asList(cat1));
    this.categoriaRepository.saveAll(Arrays.asList(cat2));
    this.categoriaRepository.saveAll(Arrays.asList(cat3));

    this.livroRepository.saveAll(Arrays.asList(l1));
    this.livroRepository.saveAll(Arrays.asList(l2));
    this.livroRepository.saveAll(Arrays.asList(l3));
    this.livroRepository.saveAll(Arrays.asList(l4));
  }
}
