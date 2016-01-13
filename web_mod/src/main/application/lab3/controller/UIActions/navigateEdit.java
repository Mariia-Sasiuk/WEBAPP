package application.lab3.controller.UIActions;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Mari on 14.01.2016.
 */
public class navigateEdit implements Action {
    public String execute(HttpServletRequest req) {
        return "/jsp/edit.jsp";
    }
}
