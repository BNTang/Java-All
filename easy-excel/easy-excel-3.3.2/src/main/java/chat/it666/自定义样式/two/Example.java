package chat.it666.自定义样式.two;

import chat.it666.自定义样式.DemoData;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.metadata.data.WriteCellData;
import com.alibaba.excel.util.BooleanUtils;
import com.alibaba.excel.util.ListUtils;
import com.alibaba.excel.write.handler.CellWriteHandler;
import com.alibaba.excel.write.handler.context.CellWriteHandlerContext;
import com.alibaba.excel.write.metadata.style.WriteCellStyle;
import com.alibaba.excel.write.metadata.style.WriteFont;
import com.alibaba.excel.write.style.HorizontalCellStyleStrategy;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * @author BNTang
 * @version 1.0
 * @description 使用easyexcel的方式完全自己写 不太推荐 尽量使用已有策略
 * @since 2024/12/02/星期一
 **/
public class Example {
    public static void main(String[] args) {
        String fileName = "exampleTwo" + System.currentTimeMillis() + ".xlsx";
        List<DemoData> demoDataList = data();  // 获取原始数据
        EasyExcel.write(fileName, DemoData.class)
                .registerWriteHandler(new CellWriteHandler() {
                    @Override
                    public void afterCellDispose(CellWriteHandlerContext context) {
                        // 当前事件会在数据设置到poi的cell里面才会回调
                        // 判断不是头的情况 如果是fill 的情况 这里会==null 所以用not true
                        if (BooleanUtils.isNotTrue(context.getHead())) {
                            // 获取当前单元格的数据
//                            int columnIndex = context.getColumnIndex();
                            // 获取当前行的索引
                            int rowIndex = context.getRowIndex();
                            // 根据 rowIndex 获取当前行的原始 DemoData 对象
                            // 仅在该行的第一个单元格时输出数据
                            if (context.getColumnIndex() == 0) {
                                // 根据 rowIndex 获取当前行的原始 DemoData 对象
                                if (rowIndex < demoDataList.size()) {
                                    DemoData demoData = demoDataList.get(rowIndex);

                                    // 打印当前行的 DemoData 对象
                                    System.out.println("当前行的 DemoData 对象：" + demoData);

                                    // 可以在这里进行样式设置等其他操作
                                    WriteCellData<?> cellData = context.getFirstCellData();
                                    WriteCellStyle writeCellStyle = cellData.getOrCreateStyle();
                                    writeCellStyle.setFillForegroundColor(IndexedColors.YELLOW1.getIndex());
                                    writeCellStyle.setFillPatternType(FillPatternType.SOLID_FOREGROUND);
                                }
                            }

//                            if (columnIndex != 2) {
//                                return;
//                            }

                            // 第一个单元格
                            // 只要不是头 一定会有数据 当然fill的情况 可能要context.getCellDataList() ,这个需要看模板，因为一个单元格会有多个 WriteCellData
//                            WriteCellData<?> firstCellData = context.getFirstCellData();
                            // 通过 rowIndex 获取当前行的数据
                            // 获取当前行对象
//                            Row currentRow = context.getRow();
//                            Cell currentCell = currentRow.getCell(columnIndex);

                            // 获取 cellDataList，包含当前行所有单元格的数据
//                            List<WriteCellData<?>> cellDataList = context.getCellDataList();
                            // 假设你的 DemoData 有三个字段：String、Date 和 Double
                            // 遍历当前行的所有单元格，按顺序填充到 demoData 对象中

                            // 创建一个 DemoData 对象来保存该行的所有数据
//                            DemoData demoData = new DemoData();
//                            for (int i = 0; i < cellDataList.size(); i++) {
//                                WriteCellData<?> cellData = cellDataList.get(i);
//                                switch (i) {
//                                    case 0: // 第一列
//                                        demoData.setString(cellData.getStringValue());
//                                        break;
//                                    case 1: // 第二列
//                                        demoData.setDate(cellData.getDateValue());
//                                        break;
//                                    case 2: // 第三列
//                                        demoData.setDoubleData(cellData.getNumberValue());
//                                        break;
//                                    // 如果有更多列，可以继续扩展
//                                    default:
//                                        break;
//                                }
//                            }

                            // 打印转换后的 DemoData 对象
//                            System.out.println("转换后的 DemoData 对象：" + demoData);

                            // 打印当前行的所有单元格数据
//                            System.out.println("当前行的所有单元格数据：");
//                            for (WriteCellData<?> data : cellDataList) {  // 修改变量名为 data
//                                System.out.println(data.getStringValue());  // 获取字符串值
//                            }

                            // 如果你需要访问原始数据（POJO 字段），可以使用 originalValue
//                            Object originalValue = context.getOriginalValue();
//                            if ((double) originalValue < 1) {
//                                return;
//                            }
//                            System.out.println("原始数据值：" + originalValue);

                            // 获取原始数据的类型
//                            Class<?> originalFieldClass = context.getOriginalFieldClass();
//                            System.out.println("原始数据类型：" + originalFieldClass);

                            // 如果需要你也可以根据 columnIndex 或其他信息来访问其他单元格的数据
//                            if (columnIndex == 0) {
                                // 处理第一列的数据
//                                String firstColumnData = currentCell.getStringCellValue();
//                                System.out.println("第一列的数据：" + firstColumnData);
//                            }
                            // 这里需要去cellData 获取样式
                            // 很重要的一个原因是 WriteCellStyle 和 dataFormatData绑定的 简单的说 比如你加了 DateTimeFormat
                            // ，已经将writeCellStyle里面的dataFormatData 改了 如果你自己new了一个WriteCellStyle，可能注解的样式就失效了
                            // 然后 getOrCreateStyle 用于返回一个样式，如果为空，则创建一个后返回
//                            WriteCellStyle writeCellStyle = firstCellData.getOrCreateStyle();
//                            writeCellStyle.setFillForegroundColor(IndexedColors.YELLOW1.getIndex());
                            // 这里需要指定 FillPatternType 为FillPatternType.SOLID_FOREGROUND
//                            writeCellStyle.setFillPatternType(FillPatternType.SOLID_FOREGROUND);

                            // 这样样式就设置好了 后面有个FillStyleCellWriteHandler 默认会将 WriteCellStyle 设置到 cell里面去 所以可以不用管了

                            // 设置字体颜色为红色
//                            WriteFont writeFont = new WriteFont();
//                            writeFont.setColor(IndexedColors.WHITE.getIndex());
//                            writeCellStyle.setWriteFont(writeFont);
                        }
                    }
                }).sheet("模板")
                .doWrite(demoDataList);
    }

    private static List<DemoData> data() {
        List<DemoData> list = ListUtils.newArrayList();
        for (int i = 0; i < 10; i++) {
            DemoData data = new DemoData();
            data.setString("字符串" + i);
            data.setDate(LocalDateTime.now());
            data.setDoubleData(new BigDecimal("0.7"));
            list.add(data);
        }
        DemoData data = new DemoData();
        data.setString("other");
        data.setDate(LocalDateTime.now());
        data.setDoubleData(new BigDecimal("25.7"));
        list.add(data);
        return list;
    }
}
