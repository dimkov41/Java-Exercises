package meTube.web.servlets;

import meTube.domain.models.bindingModel.TubeBindingModel;
import meTube.domain.models.service.TubeServiceModel;
import meTube.repository.TubeRepository;
import meTube.service.TubeService;
import meTube.util.Constants;
import meTube.util.ModelMapper;
import meTube.util.ValidationUtil;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/create/tube")
public class CreateTubeServlet extends HttpServlet {
    private final String CREATE_TUBE_JSP_LOCATION = "../jsps/create-tube.jsp";
    private final String CREATE_TUBE_URL_PATH = "/create/tube";

    private final ModelMapper modelMapper;
    private final TubeService tubeService;
    private final ValidationUtil validationUtil;

    @Inject
    public CreateTubeServlet(ModelMapper modelMapper, TubeService tubeService,ValidationUtil validationUtil) {
        this.modelMapper = modelMapper;
        this.tubeService = tubeService;
        this.validationUtil = validationUtil;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(CREATE_TUBE_JSP_LOCATION).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TubeServiceModel tubeServiceModel = this.modelMapper.map(req.getAttribute(Constants.CREATE_TUBE_BINDING_MODEL_ATTRIBUTE_NAME), TubeServiceModel.class);

        if(!this.validationUtil.isValid(tubeServiceModel)){
            resp.sendRedirect(CREATE_TUBE_URL_PATH);
            return;
        }

        this.tubeService.save(tubeServiceModel);
        resp.sendRedirect("/");
    }
}
