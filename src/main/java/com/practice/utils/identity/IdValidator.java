package com.practice.utils.identity;

public class IdValidator {

    public static Boolean validateIdInContext(String context, Long id) {
        if(null == context || null == id) {
            System.out.println("Context or id is null");
            return null;
        }

        if(IdGenerator.getCounters() == null || IdGenerator.getCounters().isEmpty()) {
            System.out.println("Could not validate id: " + id + " due to null/empty data source");
            return null;
        }

        // if generated, id would be less or equal
        return IdGenerator.getCounters().get(context).get() <= id;
    }

}
