package chushka.web.servlets;

import chushka.domain.entity.enums.Type;
import chushka.domain.models.binding.ProductBindingModel;
import chushka.domain.models.service.ProductServiceModel;
import chushka.service.ProductService;
import chushka.util.ModelMapper;
import chushka.util.ViewProvider;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/create/product")
public class CreateServlet extends HttpServlet {
    private ViewProvider viewProvider;
    private ModelMapper modelMapper;
    private ProductService productService;

    @Inject
    public CreateServlet(ViewProvider viewProvider, ModelMapper modelMapper, ProductService productService) {
        this.viewProvider = viewProvider;
        this.modelMapper = modelMapper;
        this.productService = productService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String html = this.viewProvider.getView("create-product");
        resp.getWriter().println(html);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String desc = req.getParameter("description");
        String type = req.getParameter("type");
        ProductBindingModel productBindingModel = new ProductBindingModel(name,desc,type);
        this.productService.save(this.modelMapper.map(productBindingModel,ProductServiceModel.class));

        resp.sendRedirect("/");
    }
}
