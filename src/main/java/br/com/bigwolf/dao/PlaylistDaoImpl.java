package br.com.bigwolf.dao;

import br.com.bigwolf.domain.Playlist;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class PlaylistDaoImpl implements PlaylistDao {


    @PersistenceContext
    private EntityManager en;

    @Override
    public void salvar(Playlist playlist) {
        en.persist(playlist);
    }

    @Override
    public List<Playlist> recuperar() {
        return en.createQuery("select p from Playlist p", Playlist.class).getResultList();
    }

    @Override
    public Playlist recuperarPorId(Long id) {
        return en.find(Playlist.class, id);
    }

    @Override
    public void atualizar(Playlist playlist) {
        en.merge(playlist);
    }

    @Override
    public void excluir(Long id) {
        en.remove(en.getReference(Playlist.class, id));
    }
}
