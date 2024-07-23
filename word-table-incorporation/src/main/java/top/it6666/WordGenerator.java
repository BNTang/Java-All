package top.it6666;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordGenerator {

    public static void main(String[] args) {
        // 模拟数据
        List<User> userList = new ArrayList<>();
        User user1 = new User();
        user1.setWeek("周一");
        user1.setName("张三");
        user1.setDate("6.22");
        user1.setContent("畜栏里");
        userList.add(user1);

        User user2 = new User();
        user2.setWeek("周一");
        user2.setName("李四");
        user2.setDate("6.23");
        user2.setContent("畜栏 d 地方里");
        userList.add(user2);

        User user3 = new User();
        user3.setWeek("周二");
        user3.setName("李四11");
        user3.setDate("6.2111");
        user3.setContent("畜栏 d 地方11里");
        userList.add(user3);

        // 组织合并逻辑
        Map<String, String> mergeMap = new HashMap<>();
        mergeMap.put("pre", "0");
        mergeMap.put("name", "0");
        mergeMap.put("next", "0");

        for (int i = 0; i < userList.size(); i++) {
            // 保存前一个元素的合并状态
            if (i > 0) {
                userList.get(i).getMap().put("pre", userList.get(i - 1).getMap().get("week"));
            }
            // 保存后一个元素的合并状态
            if (i < userList.size() - 1) {
                userList.get(i).getMap().put("next", userList.get(i + 1).getMap().get("week"));
            }
        }

        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("userList", userList);
        dataMap.put("mergeMap", mergeMap);

        createWord(dataMap, "D:/project/Java-All/word-table-incorporation/src/main/resources/template/test.ftl", "D:/project/Java-All/test.doc");
    }

    public static void createWord(Map<String, Object> dataMap, String templateName, String filePath) {
        Configuration configuration = new Configuration();
        configuration.setDefaultEncoding("utf-8");

        try {
            Template template = configuration.getTemplate(templateName);

            File outFile = new File(filePath);
            FileWriter out = new FileWriter(outFile);

            template.process(dataMap, out);
            out.close();
        } catch (IOException | TemplateException e) {
            e.printStackTrace();
        }
    }
}
