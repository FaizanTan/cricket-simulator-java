package com.practice;

import com.fasterxml.jackson.core.type.TypeReference;
import com.practice.constants.MatchConstants;
import com.practice.models.CricketPlayer;
import com.practice.utils.FileDataLoader;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    private static Map<String, Map<String, List<Object>>> dataMap;

    public static void main(String[] args) {
        loadData();
        initializePlayers();
        initializeTeams();
        initializeMatchesData();
    }

    public static void loadData() {
        try {
            FileDataLoader loader = new FileDataLoader("src/main/resources/data.json");
            loader.loadData(new TypeReference<Map<String, Map<String, List<Object>>>>() {});

            dataMap = (Map<String, Map<String, List<Object>>>) loader.getData();
            System.out.println("Loaded Data: " + dataMap);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void initializePlayers()  {
       if(null != dataMap && !dataMap.isEmpty()) {
           Map<String, List<Object>> playersMap = dataMap.get("players");

           List<CricketPlayer> players = MatchConstants.players;

           if (null != playersMap && !playersMap.isEmpty()) {
               for (Map.Entry<String, List<Object>> entry : playersMap.entrySet()) {
                   entry.getValue().forEach(item -> {

                   });
               }
           }
       }
    }

    public static void initializeTeams() {
        if(null != dataMap && !dataMap.isEmpty()) {
            Map<String, List<Object>> playersMap = dataMap.get("teams");

            if (null != playersMap && !playersMap.isEmpty()) {
                for (Map.Entry<String, List<Object>> entry : playersMap.entrySet()) {
                    System.out.println(entry.getKey());
                    entry.getValue().forEach(item -> {
                        System.out.println("Item: " + item);
                    });
                }
            }
        }
    }

    public static void initializeMatchesData() {
        if(null != dataMap && !dataMap.isEmpty()) {
            Map<String, List<Object>> matchesMap = dataMap.get("matches");

            if (null != matchesMap && !matchesMap.isEmpty()) {
                for (Map.Entry<String, List<Object>> entry : matchesMap.entrySet()) {
                    System.out.println(entry.getKey());
                    entry.getValue().forEach(item -> {
                        System.out.println("Item: " + item);
                    });
                }
            }
        }
    }
}