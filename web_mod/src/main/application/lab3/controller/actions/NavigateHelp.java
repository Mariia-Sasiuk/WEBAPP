package application.lab3.controller.actions;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Mari on 14.01.2016.
 */
public class NavigateHelp implements Action {
    public String execute(HttpServletRequest req) {
        return "/jsp/Help.jsp";
    }
}
