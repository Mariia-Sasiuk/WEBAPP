package application.lab3.controller.UIActions;

import javax.servlet.http.HttpServletRequest;


public class NavigateMain implements Action {

    public String execute(HttpServletRequest req) {
        return "/jsp/Main.jsp";
    }

}
