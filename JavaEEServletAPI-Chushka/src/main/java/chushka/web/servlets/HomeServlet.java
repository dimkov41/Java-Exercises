package chushka.web.servlets;

import chushka.domain.entity.Product;
import chushka.domain.models.view.ProductViewModel;
import chushka.service.ProductService;
import chushka.util.ViewProvider;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.MessageFormat;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet("/")
public class HomeServlet extends HttpServlet {
    private ViewProvider viewProvider;
    private ProductService productService;

    @Inject
    public HomeServlet(ViewProvider viewProvider, ProductService productService) {
        this.viewProvider = viewProvider;
        this.productService = productService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String html = this.viewProvider.getView("index")
                .replace("{{listAllProducts}}", getProductsAsHtml());
        resp.getWriter().println(html);
    }

    private String getProductsAsHtml(){
        StringBuilder builder = new StringBuilder();

        this.productService.getAllProducts().forEach(productViewModel -> {
            builder.append("<li>")
                    .append(String.format("<a href='/details/product?name=%s'>%s</a>",productViewModel.getName(),productViewModel.getName()))
                    .append("</li>")
                    .append(System.lineSeparator());
        });

        return builder.toString();
    }
}
