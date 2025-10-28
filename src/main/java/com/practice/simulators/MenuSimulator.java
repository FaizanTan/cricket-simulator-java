package com.practice.simulators;

import com.practice.interfaces.Simulator;
import com.practice.menus.Menu;
import com.practice.menus.MenuItem;
import com.practice.models.SimulationResult;
import lombok.Setter;

import java.util.*;

@Setter
public class MenuSimulator implements Simulator {

    private Scanner scanner = new Scanner(System.in);
    private Menu firstMenu;

    public MenuSimulator(Menu menu) {
        this.firstMenu = menu;
    }

    @Override
    public SimulationResult simulate() {
        loadMenus();
        return null;
    }

    private int getUserChoice() {
        return scanner.nextInt();
    }

    private void loadMenus() {

    }
}
