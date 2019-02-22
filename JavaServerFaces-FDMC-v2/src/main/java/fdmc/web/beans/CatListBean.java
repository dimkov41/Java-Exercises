package fdmc.web.beans;

import fdmc.domain.models.view.CatViewModel;
import fdmc.service.CatService;
import org.modelmapper.ModelMapper;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;
import java.util.stream.Collectors;

@Named
@RequestScoped
public class CatListBean {
    private CatViewModel catViewModel;

    private ModelMapper modelMapper;
    private CatService catService;

    public CatListBean() {
    }

    @Inject
    public CatListBean(ModelMapper modelMapper, CatService catService) {
        this.modelMapper = modelMapper;
        this.catService = catService;
    }

    @PostConstruct
    public void init(){
        this.catViewModel = new CatViewModel();
    }


    public List<CatViewModel> getAllCats(){
        return this.catService.getAll()
                .stream()
                .map(c -> this.modelMapper.map(c,CatViewModel.class))
                .collect(Collectors.toList());
    }
}
