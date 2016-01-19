package application.lab3.controller.actions;

import javax.servlet.http.HttpServletRequest;

public interface Action {
    public String execute(HttpServletRequest req);
}


