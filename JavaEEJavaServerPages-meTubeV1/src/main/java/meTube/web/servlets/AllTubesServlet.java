package meTube.web.servlets;

import meTube.domain.models.service.TubeServiceModel;
import meTube.domain.models.view.AllTubesViewModel;
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
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet("/all/tubes")
public class AllTubesServlet extends HttpServlet {
    private final String ALL_TUBES_JSP_LOCATION = "../jsps/all-tubes.jsp";

    private final TubeService tubeService;
    private final ModelMapper modelMapper;

    @Inject
    public AllTubesServlet(TubeService tubeService, ModelMapper modelMapper) {
        this.tubeService = tubeService;
        this.modelMapper = modelMapper;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<AllTubesViewModel> tubes = Arrays.stream(this.modelMapper.map(this.tubeService.findAll(), AllTubesViewModel[].class)).collect(Collectors.toList());

        req.setAttribute(Constants.ALL_TUBES_VIEW_MODEL_ATTRIBUTE_NAME,tubes);
        req.getRequestDispatcher(ALL_TUBES_JSP_LOCATION).forward(req,resp);
    }
}
