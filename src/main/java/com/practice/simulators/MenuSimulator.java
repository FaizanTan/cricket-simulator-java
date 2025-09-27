package com.practice.simulators;

import com.practice.interfaces.Simulator;
import com.practice.menus.Menu;
import com.practice.menus.MenuItem;
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

        loadMenus();

        if(null == firstMenu) return null;

        Deque<Menu> menuStack = new ArrayDeque<>();
        menuStack.push(firstMenu);

        while (!menuStack.isEmpty()) {

            Menu currentMenu = menuStack.peek();

            Printer.print(currentMenu);

            int choice = getUserChoice();

            if (choice >= 1 && choice <= currentMenu.getItemCount()) {

                MenuItem userSelectedMenu = currentMenu.getItemAt(choice - 1);
                Boolean isBackOption = userSelectedMenu.getOrder().equals(1);
                String action = userSelectedMenu.getAction();

                if (isBackOption) {
                    menuStack.pop();
                }

                if (action != null) {
                    if(action.equals("")) {

                    }
                } else {
                    System.out.println("No action or submenu defined for this choice.");
                }

            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }

        return null;
    }

    private int getUserChoice() {
        return scanner.nextInt();
    }

    private void loadMenus() {

    }
}
