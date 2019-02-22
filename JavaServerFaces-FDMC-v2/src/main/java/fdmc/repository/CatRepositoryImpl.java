package fdmc.repository;

import fdmc.domain.entity.Cat;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class CatRepositoryImpl extends BaseRepository implements CatRepository {
    @Inject
    public CatRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Optional<Cat> save(Cat entity) {
        return this.executeTransaction(em -> {
            em.persist(entity);

            if(entity != null){
                return Optional.of(entity);
            }
            return Optional.empty();
        });
    }

    @Override
    public List<Cat> getAll() {
        return this.executeTransaction(em ->{
            return em.createQuery("SELECT c FROM cats AS c")
                    .getResultList();
        });
    }
}
