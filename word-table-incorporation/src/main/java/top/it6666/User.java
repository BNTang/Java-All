package top.it6666;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class User {
    private String week;
    private String name;
    private String date;
    private String content;

    // 省略 getter 和 setter 方法

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    private Map<String, String> map = new HashMap<>();
}
