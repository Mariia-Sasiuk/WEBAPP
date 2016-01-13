package application.lab3.controller.UIActions;

import javax.servlet.http.HttpServletRequest;

public class NavigateHelp implements Action {

    public String execute(HttpServletRequest req) {
        return "/jsp/Help.jsp";
    }

}
