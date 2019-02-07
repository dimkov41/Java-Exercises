package meTube.service;

import meTube.domain.entities.Tube;
import meTube.domain.models.service.TubeServiceModel;
import meTube.repository.TubeRepository;
import meTube.util.ModelMapper;

import javax.inject.Inject;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class TubeServiceImpl implements TubeService {
    private TubeRepository tubeRepository;
    private ModelMapper modelMapper;

    @Inject
    public TubeServiceImpl(TubeRepository tubeRepository, ModelMapper modelMapper) {
        this.tubeRepository = tubeRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public TubeServiceModel save(TubeServiceModel tubeServiceModel) {
        Tube tube = this.modelMapper.map(tubeServiceModel,Tube.class);
        this.tubeRepository.save(tube);

        return tubeServiceModel;
    }

    @Override
    public List<TubeServiceModel> findAll() {
        List<Tube> tubes = this.tubeRepository.findAll();
        return Arrays.asList(this.modelMapper.map(tubes,TubeServiceModel[].class));
    }

    @Override
    public Optional<TubeServiceModel> findByName(String name) {
        Optional<Tube> tube = this.tubeRepository.findByName(name);

        if(tube.isPresent()){
            return Optional.of(this.modelMapper.map(tube.get(),TubeServiceModel.class));
        }

        return Optional.empty();
    }
}
