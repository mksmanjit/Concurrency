package foo;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ConcurrentHashMapDemo {

    public static void main(String[] args) {
        Map<String,String> map = Collections.synchronizedMap(new HashMap<String, String>());
    }

}

