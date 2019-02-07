package meTube.repository;

import meTube.domain.entities.Tube;

import java.util.Optional;

public interface TubeRepository extends GenericRepository<Tube,Long> {
    Optional<Tube> findByName(String name);
}
