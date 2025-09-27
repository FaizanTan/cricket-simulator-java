package com.practice.menus;

import com.practice.interfaces.Printable;
import com.practice.models.Identifiable;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Menu extends Identifiable implements Printable {
    ;
    private String title;
    private List<MenuItem> menuItems;

    public Menu(String title, List<MenuItem> menuItems) {
        this.title = null != title && !title.isEmpty() ? title : "Menu";

        this.menuItems = new ArrayList<MenuItem>();
        this.menuItems.add(MenuItem.back);

        if(null != menuItems && !menuItems.isEmpty()) {
            menuItems.sort(Comparator.comparing(MenuItem::getOrder));
            this.menuItems.addAll(menuItems);
        }
    }

    @Override
    public void print() {
        if (menuItems.isEmpty()) return;
        System.out.println("-------------------------------------"+title+"-------------------------------------");
        menuItems.forEach((item) -> { System.out.println("\t\t" + item.getOrder() + ".\t" + item.getDescription() + "."); });
        System.out.println("-----------------------------------------------------------------------------------");
        System.out.print("Enter your choice [1 - " + getItemCount() + "]: ");
    }

    public Integer getItemCount() {
        return menuItems.size() + 1;
    }

    public MenuItem getItemAt(int i) {
        return menuItems.get(i);
    }
}
