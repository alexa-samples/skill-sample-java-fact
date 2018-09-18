package com.amazon.ask.airplanefacts.util;

import java.util.ArrayList;
import java.util.List;

public class FactsUtil {

    public static List<Fact> getFacts() {
        List<Fact> keys = new ArrayList<>();
        keys.add(new Fact("Airbus-A380", "The airbus A-380 is the world's largest passenger airliner. It has 40% more usable floor than the next largest airliner, the Boeing 747-8, and provides seating for 525 people in a typical three-class configuration or up to 853 people in an all-economy class configuration.", "https://s3.amazonaws.com/ask-samples-resources/images/airbus.jpg"));
        keys.add(new Fact("Boeing-747", "The 747-400, the most common variant in service, has a high-subsonic cruise speed of up to 570 miles per hour.", "https://s3.amazonaws.com/ask-samples-resources/images/airplane-1.jpg"));
        keys.add(new Fact("Boeing-767", "In 1985, the 767 became the first twin-engined airliner to receive regulatory approval for extended overseas flights.", "https://s3.amazonaws.com/ask-samples-resources/images/airplane-2.jpg"));
        keys.add(new Fact("Airbus-A320", "As of 31 March 2018, a total of 8,074 Airbus A320-family aircraft have been delivered, of which 7,722 are in service.", "https://s3.amazonaws.com/ask-samples-resources/images/airplane-3.jpg"));
        keys.add(new Fact("Concorde", "The Concorde had a maximum speed over twice the speed of sound at Mach 2.04, that is 1,354 mph at cruise altitude, with seating for 92 to 128 passengers.", "https://s3.amazonaws.com/ask-samples-resources/images/airplane-4.jpg"));
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
