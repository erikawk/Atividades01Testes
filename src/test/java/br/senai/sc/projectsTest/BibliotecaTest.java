package br.senai.sc.projectsTest;

import br.senai.sc.projects.Biblioteca;
import br.senai.sc.projects.Livro;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BibliotecaTest {

    Biblioteca biblioteca;
    Livro livro;

    @BeforeEach
    public void setup() {
        biblioteca = new Biblioteca("sol");
        livro = new Livro("O Príncipe", "Nicolau Maquiavel", "Não ficção", 1532);
    }

    @Test
    public void getQuantidadeLivrosTest() {
        biblioteca.adicionarLivro(livro);
        assertEquals(1, biblioteca.getQuantidadeLivros());
    }
    @Test
    public void getNomeTest() {
        assertEquals("sol", biblioteca.getNome());
    }
    @Test
    public void setNomeTest() {
        biblioteca.setNome("novoNome");
        assertEquals("novoNome", biblioteca.getNome());
    }
    @Test
    public void getLivrosTest() {
        biblioteca.adicionarLivro(livro);
        assertEquals(1, biblioteca.getLivros().size());
    }

    @Test
    public void adicionarLivro() {
        assertTrue(biblioteca.adicionarLivro(livro));
        assertFalse(biblioteca.adicionarLivro(null));
    }

    @Test
    public void removerLivro() {
        Livro livro1 = new Livro("titulo", "autor", "genero", 2000);
        assertFalse(biblioteca.removerLivro(livro1));
    }

    @Test
    public void buscarLivroPorTitulo() {
        biblioteca.adicionarLivro(livro);
        assertNull(biblioteca.buscarLivroPorTitulo("erroTitulo"));
        assertEquals("O Príncipe", biblioteca.buscarLivroPorTitulo("O Príncipe").getTitulo());
    }

    @Test
    public void buscarLivrosPorAutor() {
        biblioteca.adicionarLivro(livro);
        assertEquals(0, biblioteca.buscarLivrosPorAutor("autorError").size());
        assertEquals(1, biblioteca.buscarLivrosPorAutor("Nicolau Maquiavel").size());
    }

    @Test
    public void buscarLivrosPorGenero() {
        biblioteca.adicionarLivro(livro);
        assertEquals(0, biblioteca.buscarLivrosPorGenero("generoError").size());
        assertEquals(1, biblioteca.buscarLivrosPorGenero("Não ficção").size());
    }
}
