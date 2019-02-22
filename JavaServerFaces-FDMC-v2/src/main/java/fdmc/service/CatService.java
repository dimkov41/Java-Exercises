package fdmc.service;

import fdmc.domain.models.service.CatServiceModel;

import java.util.List;
import java.util.Optional;

public interface CatService {
    Optional<CatServiceModel> save(CatServiceModel catServiceModel);

    List<CatServiceModel> getAll();
}
