package br.senai.sc.projectsTest;
import br.senai.sc.projects.Musica;
import br.senai.sc.projects.PlaylistMusica;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PlaylistTest {

    Musica musica;
    Musica musica1;
    Musica musica2;
    Musica musica3;
    PlaylistMusica playlistMusica;

   @BeforeEach
    public void setup() {
        musica = new Musica("rua", "jão", 200);
        playlistMusica = new PlaylistMusica("rock");

       // Sugestões de setup do CHATGPT ---------------------------

       Musica musica1 = new Musica("Titulo 1", "Artista 1", 400);
       Musica musica2 = new Musica("Titulo 2", "Artista 2", 200);
       Musica musica3 = new Musica("Titulo 3", "Artista 3", 100);
       playlistMusica.adicionarMusica(musica1);
       playlistMusica.adicionarMusica(musica2);
       playlistMusica.adicionarMusica(musica3);

       // ----------------------------------------------------------
    }

    @Test
    public void getNome() {
        assertEquals("rock",playlistMusica.getNome());
    }

    @Test
    public void setNome() {
       playlistMusica.setNome("novoNome");
       assertEquals("novoNome",playlistMusica.getNome());
    }

    @Test
    public void getMusicas() {
        List<Musica> listMusicas = new ArrayList<>();
        assertEquals(listMusicas, playlistMusica.getMusicas());
    }

    @Test
    public void adicionarMusicaTest() {
        assertFalse(playlistMusica.adicionarMusica(null));
        assertTrue(playlistMusica.adicionarMusica(musica));
    }

    @Test
    public void removerMusicaTest(){
        Musica musica1 = new Musica("titulo", "artista", 1000);
        assertFalse(playlistMusica.removerMusica(musica1));
    }

    @Test
    public void buscarMusicaPorTituloTest(){
        playlistMusica.adicionarMusica(musica);
        assertNull(playlistMusica.buscarMusicaPorTitulo("erroTitulo"));
        assertEquals("rua", playlistMusica.buscarMusicaPorTitulo("rua").getTitulo());
    }

    @Test
    public void buscarMusicasPorArtistaTest(){
        Musica musica1 = new Musica("Titulo 1", "Artista 1", 400);
        Musica musica2 = new Musica("Titulo 2", "Artista 2", 200);
        playlistMusica.adicionarMusica(musica1);
        playlistMusica.adicionarMusica(musica2);
        List<Musica> listMusica = playlistMusica.buscarMusicasPorArtista("Artista 1");
        assertEquals(0, playlistMusica.buscarMusicasPorArtista("artistaError").size());
        assertEquals(1, playlistMusica.buscarMusicasPorArtista("Artista 1").size());
    }

    @Test
    public void ordenarPorArtistaTest(){
        Musica musica1 = new Musica("Titulo 1", "Artista 1", 400);
        Musica musica2 = new Musica("Titulo 2", "Artista 2", 200);
        Musica musica3 = new Musica("Titulo 3", "Artista 3", 100);
        playlistMusica.adicionarMusica(musica1);
        playlistMusica.adicionarMusica(musica2);
        playlistMusica.adicionarMusica(musica3);
        playlistMusica.ordenarPorArtista();
        assertEquals(List.of(musica1, musica2, musica3), playlistMusica.getMusicas());
    }

    @Test
    public void ordenarPorTituloTest(){
        Musica musica1 = new Musica("Titulo 1", "Artista 1", 400);
        Musica musica2 = new Musica("Titulo 2", "Artista 2", 200);
        Musica musica3 = new Musica("Titulo 3", "Artista 3", 100);
        playlistMusica.adicionarMusica(musica1);
        playlistMusica.adicionarMusica(musica2);
        playlistMusica.adicionarMusica(musica3);
        playlistMusica.ordenarPorTitulo();
        assertEquals(List.of(musica1, musica2, musica3), playlistMusica.getMusicas());
    }

    // Sugestão do CHATGPT para o teste ordenarPorTituloTest() ----------
    @Test
    public void shouldNotBeOrderedByTitleInitially() {
        assertNotEquals(List.of(musica1, musica2, musica3), playlistMusica.getMusicas());
    }

    @Test
    public void shouldOrderMusicByTitle() {
        playlistMusica.ordenarPorTitulo();
        Musica[] expected = {musica1, musica2, musica3};
        assertArrayEquals(expected, playlistMusica.getMusicas().toArray());
    }

    // --------------------------------------------------------------------


    @Test
    public void getQuantidadeMusicasTest() {
        Musica musica1 = new Musica("Titulo 1", "Artista 1", 400);
        playlistMusica.adicionarMusica(musica1);
        assertEquals(1, playlistMusica.getQuantidadeMusicas());
    }

}
