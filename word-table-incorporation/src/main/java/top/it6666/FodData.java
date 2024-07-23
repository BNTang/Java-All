package top.it6666;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FodData {
    private String project;
    private List<Item> items;

    // Constructor, getters, and setters

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Item {
        private int serialNumber;
        private String type;
        private int quantity;
        private String hazard;

        // Constructor, getters, and setters
    }
}
