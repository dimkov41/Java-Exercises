package chushka.util;

import java.io.IOException;

public interface ViewProvider {
    String getView(String viewName) throws IOException;
}
