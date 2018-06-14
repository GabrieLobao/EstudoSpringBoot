package br.com.bigwolf.dao;

import br.com.bigwolf.domain.Musica;

import java.util.List;

public interface MusicaDao {

    void salvar(Musica musica);
    List<Musica> recuperarPorPlayList(Long playListId);
    Musica recuperarPorPLayListIdEMusicaId(Long playListId, Long musicaId);
    void atualizar(Musica musica);
    void excluir(Long id);

}
