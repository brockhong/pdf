package itext.pdf;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import itext.pdf.model.Template;
import itext.pdf.template.SoftMirror;


import java.io.File;
import java.io.FileOutputStream;
import java.util.Map;

/**
 * <p>
 * :
 * </p>
 *
 * @author Yyan
 * @since 2020-11-15
 */
public class CreatePdf {

    public void createPdf(Map<String, Template> dataMap, String newPDFPath) {
        try {

            for (String code : dataMap.keySet()) {
                Template template = dataMap.get(code);

                //根据数据判断路径
                StringBuilder filePath = new StringBuilder();

                if (template.getPartyB().contains("浙江")) {
                    filePath.append("/zj/");
                    filePath.append(template.getPartyA());
                    filePath.append("_zj_");
                    filePath.append(template.getCode());
                    filePath.append(".pdf");
                }

                if (template.getPartyB().contains("杭州")) {
                    filePath.append("/hz/");
                    filePath.append(template.getPartyA());
                    filePath.append("_hz_");
                    filePath.append(template.getCode());
                    filePath.append(".pdf");
                }

                if (template.getPartyB().contains("仙居")) {
                    filePath.append("/xj/");
                    filePath.append(template.getPartyA());
                    filePath.append("_xj_");
                    filePath.append(template.getCode());
                    filePath.append(".pdf");
                }

                // 1.新建document对象
                Document document = new Document(PageSize.A4, 55, 55, 50, 50);// 建立一个Document对象

                // 2.建立一个书写器(Writer)与document对象关联


                if ("软镜样机销售合同".equals(template.getContractType())) {
                    File file = new File( newPDFPath + filePath.toString() );
                    boolean success = file.createNewFile();
                    if (!success) {
                        System.out.println("===================》创建pdf失败！！");
                        break;
                    }
                    PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(file));
                    writer.setPageEvent(new com.itext.pdf.MyHeaderFooter());// 页眉/页脚

                    // 3.打开文档
                    document.open();

                    // 4.向文档中添加内容
                    new SoftMirror().generatePDF(document, template);

                    // 5.关闭文档
                    document.close();
                    System.out.println(template.getCode());
                    break;
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
