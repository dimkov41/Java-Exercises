package chushka.util;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

public class ViewProviderImpl implements ViewProvider {
    @Override
    public String getView(String viewName) throws IOException {
        String viewPath = String.format("views/%s.html", viewName);
        URL url = this.getClass().getClassLoader().getResource(viewPath);
        return Files
                .readAllLines(
                        Paths.get(
                                new File(url.getPath())
                                        .getPath()
                                        .replace("%20", " ")
                        )
                )
                .stream()
                .collect(Collectors.joining("\n"));
    }
}
