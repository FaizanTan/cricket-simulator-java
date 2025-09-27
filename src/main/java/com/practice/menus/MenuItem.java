package com.practice.menus;

import com.practice.interfaces.Printable;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Builder
@Setter
public class MenuItem {
    private Integer order;
    private String description;
    private String action;

    public static MenuItem back = MenuItem.builder()
            .order(1)
            .description("<-- Back")
            .action("gotoPrevMenu")
            .build();
}
