package meTube.repository;

import meTube.domain.entities.Tube;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Optional;

public class TubeRepositoryImpl implements TubeRepository {
    private final EntityManager entityManager;

    public TubeRepositoryImpl() {
        this.entityManager = Persistence.createEntityManagerFactory("soft_uni").createEntityManager();
    }

    @Override
    public Tube save(Tube entity) {
        this.entityManager.getTransaction().begin();
        this.entityManager.persist(entity);
        this.entityManager.getTransaction().commit();

        return entity;
    }

    @Override
    public List<Tube> findAll() {
        return this.entityManager.createQuery("SELECT t FROM tubes AS t").getResultList();
    }

    @Override
    public Optional<Tube> findByName(String name) {
       try {
           return Optional.of(
                   (Tube) this.entityManager.createQuery("SELECT t from tubes AS t WHERE name = :name").setParameter("name", name).getSingleResult()
           );
       } catch (NoResultException e){
           return Optional.empty();
       }
    }
}
