package br.com.bigwolf.service;

import br.com.bigwolf.domain.Musica;

import java.util.List;

public interface MusicaService {

    void salvar(Musica musica, Long playlistId);
    List<Musica> recuperarPorPlayList(Long playListId);
    Musica recuperarPorPLayListIdEMusicaId(Long playListId, Long musicaId);
    void atualizar(Musica musica, Long playlistId);
    void excluir(Long playListId, Long musicaId);

}
