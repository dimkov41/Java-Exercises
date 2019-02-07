package meTube.web.servlets;

import meTube.domain.models.service.TubeServiceModel;
import meTube.domain.models.view.DetailsTubeViewModel;
import meTube.service.TubeService;
import meTube.util.Constants;
import meTube.util.ModelMapper;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Optional;

@WebServlet("/details/tube")
public class DetailsTube extends HttpServlet {
    private final String DETAILS_JSP_LOCATION = "../jsps/details-tube.jsp";
    private final String TUBE_NOT_FOUND_MESSAGE = "Tube with name %s not found!";

    private TubeService tubeService;
    private ModelMapper modelMapper;

    @Inject
    public DetailsTube(TubeService tubeService, ModelMapper modelMapper) {
        this.tubeService = tubeService;
        this.modelMapper = modelMapper;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getQueryString().split("=")[1];
        name = java.net.URLDecoder.decode(name, StandardCharsets.UTF_8.name());

        Optional<TubeServiceModel> tubeServiceModel = this.tubeService.findByName(name);

        if (!tubeServiceModel.isPresent()) {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND, String.format(TUBE_NOT_FOUND_MESSAGE, name));
            return;
        }

        req.setAttribute(Constants.DETAILS_PAGE_ATTRIBUTE_NAME,this.modelMapper.map(tubeServiceModel.get(),DetailsTubeViewModel.class));
        req.getRequestDispatcher(DETAILS_JSP_LOCATION).forward(req, resp);
    }
}
