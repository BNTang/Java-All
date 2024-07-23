package top.it6666;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import lombok.SneakyThrows;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.rmi.ServerException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FodDataDemo {
    public static void main(String[] args) {
        // Prepare the data
        List<FodData.Item> items = new ArrayList<>();
        items.add(new FodData.Item(1, "A滑行道", 5, "高危数量"));
        items.add(new FodData.Item(2, "B滑行道", 5, "高危数量"));
        items.add(new FodData.Item(3, "H滑行道", 897, "中危数量"));
        // Add more items as needed...

        FodData fodData = new FodData();
        fodData.setProject("道面FOD收集统计");
        fodData.setItems(items);

        // Put the data in a map
        Map<String, Object> data = new HashMap<>();
        data.put("fodData", fodData);

        // Generate the Word document
        String templateName = "fod.ftl";
        String docName = "output.doc";
        generateWord(templateName, data, docName);
    }

    @SneakyThrows
    public static String generateWord(String templateName, Map<String, Object> data, String docName) {
        // 初始化配置文件
        Configuration configuration = new Configuration();
        // 设置编码
        configuration.setDefaultEncoding(StandardCharsets.UTF_8.name());
        // 获取文件所在文件夹
        configuration.setClassForTemplateLoading(FodDataDemo.class, "/template");
        Template template;
        try {
            template = configuration.getTemplate(templateName);
        } catch (IOException e) {
            throw new ServerException("doc模板文件未找到");
        }
        String savePath = System.getProperty("user.dir");
        Path filePath = Paths.get(savePath, docName);
        try (Writer out = new BufferedWriter(new OutputStreamWriter(Files.newOutputStream(filePath.toFile().toPath()), StandardCharsets.UTF_8), 10240)) {
            template.process(data, out);
        } catch (IOException | TemplateException e) {
            throw new ServerException("解析模板生成word失败！");
        }
        return filePath.toString();
    }
}
