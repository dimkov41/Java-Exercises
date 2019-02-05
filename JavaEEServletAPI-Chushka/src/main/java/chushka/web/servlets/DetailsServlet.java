package chushka.web.servlets;

import chushka.domain.models.view.ProductViewModel;
import chushka.service.ProductService;
import chushka.util.ViewProvider;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/details/product")
public class DetailsServlet extends HttpServlet {
    private ProductService productService;
    private ViewProvider viewProvider;

    @Inject
    public DetailsServlet(ProductService productService, ViewProvider viewProvider) {
        this.productService = productService;
        this.viewProvider = viewProvider;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getQueryString()
                .split("=")[1]
                .replace("%20", " ");
        ProductViewModel productViewModel = this.productService.findByName(name);

        if(productViewModel == null){
            resp.sendRedirect("/");
            return;
        }

        String html = this.viewProvider.getView("details-product")
                .replace("{{name}}",productViewModel.getName())
                .replace("{{description}}",productViewModel.getDescription())
                .replace("{{type}}",productViewModel.getType());

        resp.getWriter().println(html);
    }
}

