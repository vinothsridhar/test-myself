package in.sri.test.stream;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamEx {

    public static void main(String[] args) {
        
        List<String> strList = Arrays.asList(new String[] {"1", "2", "3", "4", "5"});
        
        List<Integer> intList = strList.stream()
                .map(s -> Integer.parseInt(s))
                .filter(i -> i == 2)
                .collect(Collectors.toList());
        
        System.out.println("even: " + intList);
        
        Map<String, String> strMap = new HashMap<String, String>();
        strMap.put("Hello", "World");
        strMap.put("Welcome", "Home");
        
        List<String> keyList = strMap.entrySet().stream()
                .map(e -> e.getKey())
                .collect(Collectors.toList());
        
        System.out.println("keyList: " + keyList);
        
    }
    
}
