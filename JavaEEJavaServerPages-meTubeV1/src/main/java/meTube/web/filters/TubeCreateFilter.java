package meTube.web.filters;

import meTube.domain.models.bindingModel.TubeBindingModel;
import meTube.util.Constants;
import meTube.util.ValidationUtil;

import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/create/tube")
public class TubeCreateFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;

        if (req.getMethod().equalsIgnoreCase("Post")) {
            TubeBindingModel tubeBindingModel = new TubeBindingModel();
            tubeBindingModel.setName(req.getParameter("title"));
            tubeBindingModel.setDescription(req.getParameter("description"));
            tubeBindingModel.setUploader(req.getParameter("uploader"));
            tubeBindingModel.setYoutubeLink(req.getParameter("youtubeLink"));

            req.setAttribute(Constants.CREATE_TUBE_BINDING_MODEL_ATTRIBUTE_NAME, tubeBindingModel);
        }

        filterChain.doFilter(req, res);
    }
}
