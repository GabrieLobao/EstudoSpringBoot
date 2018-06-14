package br.com.bigwolf.service;

import br.com.bigwolf.domain.Playlist;

import java.util.List;

public interface PlaylistService {

    void salvar(Playlist playlist);
    List<Playlist> recuperar();
    Playlist recuperarPorId(Long id);
    void atualizar(Playlist playlist);
    void excluir(Long id);

}
