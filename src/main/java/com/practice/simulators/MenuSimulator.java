package com.practice.simulators;

import com.practice.interfaces.Simulator;
import com.practice.menus.Menu;
import com.practice.models.SimulationResult;
import com.practice.utils.Printer;
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

        if(null == firstMenu) return null;

        Deque<Menu> menuStack = new ArrayDeque<>();
        menuStack.push(firstMenu);

        while (!menuStack.isEmpty()) {
            System.out.print("\033[H\033[2J");
            System.out.flush();

            Menu currentMenu = menuStack.peek();
            Printer.print(currentMenu);

            int choice = getUserChoice();

            if(choice == 1) {
                menuStack.pop();
            } else {
                Menu nextMenu = currentMenu.getItemAt(choice).getNextMenu();
                menuStack.push(nextMenu);
            }
        }

        return null;
    }

    private int getUserChoice() {
        return scanner.nextInt();
    }
}
