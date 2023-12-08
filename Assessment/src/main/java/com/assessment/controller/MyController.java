package com.assessment.controller;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

@RestController
@RequestMapping("/api")
public class MyController {

    private final Map<String, String> responseMap = new HashMap<>();

    @GetMapping("/finddata")
    public Map<String, String> getData() {
        // Return the existing data in the HashMap
        return responseMap;
    }

    @PostMapping("/data")
    public Map<String, String> addData(@RequestBody Map<Object, Object> dataMap) {
        // Add new data to the HashMap
		/* responseMap.put(id, name); */

        // Return the updated data in the HashMap
    	System.out.print(responseMap);
    	Set<Entry<Object, Object>> entrySet = dataMap.entrySet();
    	for(Entry<Object, Object> data:entrySet) {
    		responseMap.put(data.getKey().toString(), data.getValue().toString());
    	}
        return responseMap;
    }
}

