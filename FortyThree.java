import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FortyThree {
    public static void main(String[] args) {

        TimeMap map1 = new TimeMap();

        map1.set("foo", "bar", 1);
        map1.set("foo", "bar2", 2);
        map1.set("foo", "bar5", 5);
        map1.set("foo2", "anishdai", 2);

        map1.get("foo", 4);
    }
}

class TimeMap {

    private HashMap<String, List<Pair2>> map = new HashMap<>();

    public TimeMap() {

    }

    public void set(String key, String value, int timestamp) {

        if (!map.containsKey(key)) {
            map.put(key, new ArrayList<>());
        }

        // map.get(key).add(new Pair2(value, timestamp));
        List<Pair2> list = map.get(key);
        list.add(new Pair2(value, timestamp));

        map.put(key, list);
    }

    public String get(String key, int timestamp) {

        if (!map.containsKey(key)) {
            return "";
        }

        List<Pair2> list = map.get(key);

        return search(list, timestamp);
    }

    private String search(List<Pair2> list, int timestamp) {
        int lo = 0, hi = list.size() - 1;
        String res = "";

        while (lo <= hi) {
            int m = (lo + hi) / 2;
            int midTimeStamp = list.get(m).getTimestamp();

            if (midTimeStamp <= timestamp) {
                res = list.get(m).getValue();
                lo = m + 1;
            } else {
                hi = m - 1;
            }

        }
        System.out.println(res);
        return res;
    }

    private class Pair2 {
        private String value;
        private int timestamp;

        public Pair2(String value, int timestamp) {
            this.value = value;
            this.timestamp = timestamp;
        }

        public String getValue() {
            return this.value;
        }

        public int getTimestamp() {
            return this.timestamp;
        }

    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */