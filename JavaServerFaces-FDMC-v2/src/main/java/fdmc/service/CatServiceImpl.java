package fdmc.service;

import fdmc.domain.entity.Cat;
import fdmc.domain.models.service.CatServiceModel;
import fdmc.repository.CatRepository;
import org.modelmapper.ModelMapper;

import javax.inject.Inject;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CatServiceImpl implements CatService{
    private final CatRepository catRepository;
    private final ModelMapper modelMapper;

    @Inject
    public CatServiceImpl(CatRepository catRepository, ModelMapper modelMapper) {
        this.catRepository = catRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Optional<CatServiceModel> save(CatServiceModel catServiceModel) {
        if(this.catRepository.save(this.modelMapper.map(catServiceModel, Cat.class)).isPresent()){
            return Optional.of(catServiceModel);
        }
        return Optional.empty();
    }

    @Override
    public List<CatServiceModel> getAll() {
        return this.catRepository.getAll()
                .stream()
                .map(c -> this.modelMapper.map(c,CatServiceModel.class))
                .collect(Collectors.toList());
    }
}
