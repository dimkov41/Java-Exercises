package fdmc.web.beans;

import fdmc.domain.models.binding.CatRegisterBindingModel;
import fdmc.domain.models.service.CatServiceModel;
import fdmc.repository.CatRepository;
import fdmc.service.CatService;
import fdmc.utils.BeanUtils;
import org.modelmapper.ModelMapper;
import org.primefaces.event.SelectEvent;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.FacesComponent;
import javax.faces.context.FacesContext;
import javax.faces.view.facelets.FaceletContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.IOException;
import java.text.SimpleDateFormat;

@Named
@RequestScoped
public class CatRegisterBean {
    private CatRegisterBindingModel catRegisterBindingModel;
    private CatService catService;
    private ModelMapper modelMapper;

    public CatRegisterBean() {
    }

    @Inject
    public CatRegisterBean(CatService catService,ModelMapper modelMapper) {
        this.catService = catService;
        this.modelMapper = modelMapper;
    }

    @PostConstruct
    private void init(){
        this.catRegisterBindingModel = new CatRegisterBindingModel();
    }

    public CatRegisterBindingModel getCatRegisterBindingModel() {
        return catRegisterBindingModel;
    }

    public void setCatRegisterBindingModel(CatRegisterBindingModel catRegisterBindingModel) {
        this.catRegisterBindingModel = catRegisterBindingModel;
    }

    public void register() throws IOException {
        this.catService.save(this.modelMapper.map(this.catRegisterBindingModel, CatServiceModel.class))
                .orElseThrow(() -> new IllegalArgumentException("Can't register cat"));

        BeanUtils.sendRedirect(FacesContext.getCurrentInstance(),"/all-cats");
    }

    public void onDateSelect(SelectEvent event){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        FacesContext
                .getCurrentInstance()
                .addMessage(null,
                        new FacesMessage(
                                FacesMessage.SEVERITY_INFO, "Date Selected" , simpleDateFormat.format(event.getObject())
                        )
                );

    }
}
