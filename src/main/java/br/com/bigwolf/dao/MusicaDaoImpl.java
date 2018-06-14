package br.com.bigwolf.dao;

import br.com.bigwolf.domain.Musica;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Repository
public class MusicaDaoImpl implements MusicaDao {

    @PersistenceContext
    private EntityManager en;

    @Override
    public void salvar(Musica musica) {
        en.persist(musica);
    }

    @Override
    public List<Musica> recuperarPorPlayList(Long playListId) {
        return en.createQuery("select m from Musicas m where m.playlist.id = :playlistId", Musica.class)
                .setParameter("playlistId", playListId)
                .getResultList();
    }

    @Override
    public Musica recuperarPorPLayListIdEMusicaId(Long playListId, Long musicaId) {
        return en.createQuery("select m from Musicas m where m.playlist.id = :playlistId and m.id = :musicaId", Musica.class)
                .setParameter("playlistId", playListId)
                .setParameter("musicaId", musicaId)
                .getSingleResult();
    }

    @Override
    public void atualizar(Musica musica) {

        en.merge(musica);

    }

    @Override
    public void excluir(Long id) {
        en.remove(en.getReference(Musica.class, id));
    }
}
