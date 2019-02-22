package fdmc.utils;

import javax.faces.context.FacesContext;
import java.io.IOException;

public final class BeanUtils {
    public static void sendRedirect(FacesContext facesContext, String path) throws IOException {
        facesContext.getExternalContext().redirect(path);
    }
}