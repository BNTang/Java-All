package chat.it666.自定义样式.three;

import chat.it666.自定义样式.DemoData;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.metadata.data.WriteCellData;
import com.alibaba.excel.util.BooleanUtils;
import com.alibaba.excel.util.ListUtils;
import com.alibaba.excel.write.handler.CellWriteHandler;
import com.alibaba.excel.write.handler.context.CellWriteHandlerContext;
import com.alibaba.excel.write.metadata.style.WriteCellStyle;
import org.apache.poi.ss.usermodel.*;

import java.util.Date;
import java.util.List;

/**
 * @author BNTang
 * @version 1.0
 * @description 使用poi的样式完全自己写 不推荐
 * @since 2024/12/02/星期一
 **/
public class Example {
    public static void main(String[] args) {
        String fileName = "exampleThree" + System.currentTimeMillis() + ".xlsx";
        EasyExcel.write(fileName, DemoData.class)
                .registerWriteHandler(new CellWriteHandler() {
                    @Override
                    public void afterCellDispose(CellWriteHandlerContext context) {
                        // 当前事件会在 数据设置到poi的cell里面才会回调
                        // 判断不是头的情况 如果是fill 的情况 这里会==null 所以用not true
                        if (BooleanUtils.isNotTrue(context.getHead())) {
                            Cell cell = context.getCell();
                            // 拿到poi的workbook
                            Workbook workbook = context.getWriteWorkbookHolder().getWorkbook();
                            // 这里千万记住 想办法能复用的地方把他缓存起来 一个表格最多创建6W个样式
                            // 不同单元格尽量传同一个 cellStyle
                            CellStyle cellStyle = workbook.createCellStyle();
                            cellStyle.setFillForegroundColor(IndexedColors.RED.getIndex());
                            // 这里需要指定 FillPatternType 为FillPatternType.SOLID_FOREGROUND
                            cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
                            cell.setCellStyle(cellStyle);

                            // 由于这里没有指定dataformat 最后展示的数据 格式可能会不太正确

                            // 这里要把 WriteCellData的样式清空， 不然后面还有一个拦截器 FillStyleCellWriteHandler 默认会将 WriteCellStyle 设置到
                            // cell里面去 会导致自己设置的不一样
                            context.getFirstCellData().setWriteCellStyle(null);
                        }
                    }
                }).sheet("模板")
                .doWrite(data());
    }

    private static List<DemoData> data() {
        List<DemoData> list = ListUtils.newArrayList();
        for (int i = 0; i < 10; i++) {
            DemoData data = new DemoData();
            data.setString("字符串" + i);
            data.setDate(new Date());
            data.setDoubleData(0.56);
            list.add(data);
        }
        return list;
    }
}
