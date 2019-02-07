package meTube.service;

import meTube.domain.models.service.TubeServiceModel;

import java.util.List;
import java.util.Optional;

public interface TubeService {
    TubeServiceModel save(TubeServiceModel tubeServiceModel);

    List<TubeServiceModel> findAll();

    Optional<TubeServiceModel> findByName(String name);
}
