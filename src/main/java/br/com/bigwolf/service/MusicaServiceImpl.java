package br.com.bigwolf.service;

import br.com.bigwolf.dao.MusicaDao;
import br.com.bigwolf.domain.Musica;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MusicaServiceImpl implements MusicaService{

    @Autowired
    private MusicaDao musicaDao;

    @Autowired
    private PlaylistService playlistService;



    @Override
    public void salvar(Musica musica, Long playlistId) {
        musica.setPlaylist(playlistService.recuperarPorId(playlistId));
        musicaDao.salvar(musica);
    }

    @Override
    public List<Musica> recuperarPorPlayList(Long playListId) {
        return musicaDao.recuperarPorPlayList(playListId);
    }

    @Override
    public Musica recuperarPorPLayListIdEMusicaId(Long playListId, Long musicaId) {
        return musicaDao.recuperarPorPLayListIdEMusicaId(playListId, musicaId);
    }

    @Override
    public void atualizar(Musica musica, Long playlistId) {
        musica.setPlaylist(playlistService.recuperarPorId(playlistId));
        musicaDao.atualizar(musica);
    }

    @Override
    public void excluir(Long playListId, Long musicaId) {
        musicaDao.excluir(recuperarPorPLayListIdEMusicaId(playListId, musicaId).getId());
    }
}
