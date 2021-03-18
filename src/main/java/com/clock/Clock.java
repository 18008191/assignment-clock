package com.clock;

import com.clock.controller.Controller;
import com.clock.model.Model;
import com.clock.view.View;

public class Clock {
    
    public static void main(String[] args) {
        Model model = new Model();
        View view = new View(model);
        model.addObserver(view);

        Controller controller = new Controller(model, view);
    }
}
