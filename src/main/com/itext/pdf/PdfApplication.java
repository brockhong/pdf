package itext.pdf;


import itext.pdf.CreatePdf;
import itext.pdf.data.ReadData;
import itext.pdf.model.Template;

import java.util.Map;

public class PdfApplication {

    public static void main(String[] args) {

        //读取数据
        Map<String, Template> dataMap = ReadData.readData("C:\\Users\\zhy\\Desktop\\3.xlsx");

        //生成pdf
        new CreatePdf().createPdf(dataMap, "d:\\pdf\\");
    }
}

