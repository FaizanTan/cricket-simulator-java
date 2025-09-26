package com.practice.menus;

import com.practice.interfaces.Printable;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Menu implements Printable {

    private String title;
    private Map<Integer, MenuItem> items = new TreeMap<>();

    public Menu(String title) {
        this.title = title;
        MenuItem item = MenuItem.builder()
                .description("<- Go Back")
                .build();
        items.put(1, item);
    }

    public String getTitle() {
        return title;
    }

    public void addItem(String description, Runnable action) {
        MenuItem item = MenuItem.builder()
                .description(description)
                .action(action)
                .build();
        items.put(items.size() + 1, item);
    }

    public MenuItem removeItem(int key) {
        if(key > items.size() || key <= 1) return null;
        return items.remove(key);
    }

    public void removeItems(List<Integer> keys) {
        keys.forEach(this::removeItem);
    }

    public MenuItem getItemAt(int key) {
        return items.get(key);
    }

    public void setNextMenuForItemAt(int key, Menu nextMenu) {
        if(key > items.size() || key <= 1) return;

        MenuItem item = items.get(key);
        if (item != null) {
            item.setNextMenu(nextMenu);
        }
    }

    @Override
    public void print() {
        if (items.isEmpty()) return;

        System.out.println("-------------------------------------"+title+"-------------------------------------");

        items.forEach((key, item) -> {
           System.out.println("\t\t" + key + ".\t" + item.getDescription() + ".");
        });

        System.out.println("-----------------------------------------------------------------------------------");

        System.out.print("Enter your choice [1 - " + items.size() + "]: ");
    }
}
