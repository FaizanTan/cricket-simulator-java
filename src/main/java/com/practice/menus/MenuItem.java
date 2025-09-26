package com.practice.menus;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Builder
@Setter
public class MenuItem {
    private String description;
    private Runnable action;
    private Menu nextMenu;
}
