package com.amazon.ask.airplanefacts.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FactsUtil {

    public static Map getFactMap() {
        Map<String, String> map = new HashMap<>();
        map.put("Airbus-A380", "The airbus A-380 is the world's largest passenger airliner. It has 40% more usable floor than the next largest airliner, the Boeing 747-8, and provides seating for 525 people in a typical three-class configuration or up to 853 people in an all-economy class configuration.");
        map.put("Boeing-747", "The 747-400, the most common variant in service, has a high-subsonic cruise speed of up to 570 miles per hour.");
        map.put("Boeing-767", "In 1985, the 767 became the first twin-engined airliner to receive regulatory approval for extended overseas flights.");
        map.put("Airbus-A320", "As of 31 March 2018, a total of 8,074 Airbus A320-family aircraft have been delivered, of which 7,722 are in service.");
        map.put("Concorde", "The Concorde had a maximum speed over twice the speed of sound at Mach 2.04, that is 1,354 mph at cruise altitude, with seating for 92 to 128 passengers.");
        return map;
    }

    public static Map getImageMap() {
        Map<String, String> map = new HashMap<>();
        map.put("Airbus-A380", "https://s3.amazonaws.com/ask-samples-resources/images/airbus.jpg");
        map.put("Boeing-747", "https://s3.amazonaws.com/ask-samples-resources/images/airplane-1.jpg");
        map.put("Boeing-767", "https://s3.amazonaws.com/ask-samples-resources/images/airplane-2.jpg");
        map.put("Airbus-A320", "https://s3.amazonaws.com/ask-samples-resources/images/airplane-3.jpg");
        map.put("Concorde", "https://s3.amazonaws.com/ask-samples-resources/images/airplane-4.jpg");
        return map;
    }

    public static List getKeys() {
        List<String> keys = new ArrayList<>();
        keys.add("Airbus-A380");
        keys.add("Boeing-747");
        keys.add("Boeing-767");
        keys.add("Airbus-A320");
        keys.add("Concorde");
        return keys;
    }

}

/*
Royalty free image URLS
https://www.pexels.com/photo/airplane-on-sky-during-sunset-48786/
https://www.pexels.com/photo/airplane-aircraft-airport-transportation-system-113017/
https://www.pexels.com/photo/jet-cloud-landing-aircraft-46148/
https://www.pexels.com/photo/white-passenger-plane-flying-on-sky-during-day-time-67807/
https://www.pexels.com/photo/royalty-free-airbus-passenger-aircraft-auckland-68155/
https://www.pexels.com/photo/sky-traveling-airport-airplane-87460/
*/
