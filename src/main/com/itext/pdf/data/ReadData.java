package itext.pdf.data;


import com.itextpdf.text.pdf.StringUtils;
import itext.pdf.model.Commodity;
import itext.pdf.model.Template;
import itext.pdf.utils.AmountUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.util.StringUtil;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * :
 * </p>
 *
 * @author Yyan
 * @since 2020-11-17
 */
public class ReadData {

    static DecimalFormat decimalFormat = new DecimalFormat("#");

    public static Map<String, Template> readData(String excelPath) {

        Map<String, Template> dataMap = new HashMap<>();

        try {
            //String encoding = "GBK";
            File excel = new File(excelPath);
            if (excel.isFile() && excel.exists()) {   //判断文件是否存在

                String[] split = excel.getName().split("\\.");  //.是特殊字符，需要转义！！！！！
                Workbook wb;
                //根据文件后缀（xls/xlsx）进行判断
                if ("xls".equals(split[1])) {
                    FileInputStream fis = new FileInputStream(excel);   //文件流对象
                    wb = new HSSFWorkbook(fis);
                } else if ("xlsx".equals(split[1])) {
                    wb = new XSSFWorkbook(excel);
                } else {
                    System.out.println("文件类型错误!");
                    return dataMap;
                }

                //开始解析
                Sheet sheet = wb.getSheetAt(3);     //读取sheet 3

                int firstRowIndex = sheet.getFirstRowNum() +1;   //第一行是列名，所以不读
                int lastRowIndex = sheet.getLastRowNum();
                System.out.println("firstRowIndex: " + firstRowIndex);
                System.out.println("lastRowIndex: " + lastRowIndex);

                //遍历行
                for (int rIndex = firstRowIndex; rIndex <= lastRowIndex; rIndex++) {
                    Row row = sheet.getRow(rIndex);
                    if (row == null) {
                        break;
                    }
                    //合同编码
                    Cell code = row.getCell(1, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                    if (code.toString().equals("")||code.toString().equals(" ")||code==null) {
                        break;
                    }
                    Template template = dataMap.get(code.toString());
                    if (template == null) {
                        template = new Template();
                         if(code.getCellType()==0) {
                            template.setCode(decimalFormat(code.getNumericCellValue()));
                        }else {
                             template.setCode(code.toString());
                        }

                        //合同类型
                        Cell contractType = row.getCell(0, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                        template.setContractType(contractType.toString());
                        //甲方
                        Cell partyA = row.getCell(2, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                        template.setPartyA(partyA.toString());
                        //乙方
                        Cell partyB = row.getCell(3, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                        template.setPartyB(partyB.toString());
                        //交货时间
                        Cell deliveryTime = row.getCell(7, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                        template.setDeliveryTime(deliveryTime.toString());
                        //收件人
                        Cell addressee = row.getCell(6, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                        template.setAddressee(addressee.toString());
                        //结算方式
                        Cell payment = row.getCell(8, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                        template.setPayment(payment.toString());
                        //日期
                        Cell date = row.getCell(9, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
//                        if (date.toString().length() == 6) {
//                            template.setYear(date.toString().substring(0, 4));
//                            template.setMonth(date.toString().substring(4, 6));
//                            template.setDay(date.toString().substring(6));
//                        }

                        template.setYear("2020");
                        template.setMonth("11");
                        template.setDay("17");
                    }

                    Commodity commodity = new Commodity();
                    //商品名称
                    Cell name = row.getCell(10, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                    commodity.setName(name.toString());
                    //产地
                    Cell address = row.getCell(11, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                    commodity.setAddress(address.toString());
                    //型号
                    Cell type = row.getCell(12, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                    commodity.setType(type.toString());
                    //单位
                    Cell unit = row.getCell(13, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                    commodity.setUnit(unit.toString());
                    //数量
                    Cell number = row.getCell(14, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                    commodity.setNumber(number.toString());
                    //单价
                    Cell unitPrice = row.getCell(15, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                    commodity.setUnitPrice(unitPrice.toString().split("\\.")[0] + ".00");
                    //折扣
                    Cell discount = row.getCell(16, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                    commodity.setDiscount(discount.toString());
                    //金额
                    Cell price = row.getCell(17, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                    commodity.setPrice(price.toString().split("\\.")[0] + ".00");
                    //备注
                    Cell remark = row.getCell(18, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                    commodity.setRemark(remark.toString());

                    List<Commodity> commodityList = template.getCommodityList();
                    if (commodityList == null) {
                        commodityList = new ArrayList<>();
                    }
                    commodityList.add(commodity);
                    template.setCommodityList(commodityList);

                    //合计人民币
                    Cell small = row.getCell(4, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);

                    double rmb = Math.abs(small.getNumericCellValue());
                    String total = AmountUtils.convert(rmb) + "         小写 ¥" + small.toString().split("\\.")[0] + ".00";
                    template.setTotal(total);

                    dataMap.put(template.getCode(), template);
                }

                System.out.println(dataMap.size());

            } else {
                System.out.println("找不到指定的文件");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return dataMap;
    }

    private static String  decimalFormat(double d) {
       return decimalFormat.format(d);
    }
}
