package itext.pdf.template;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itext.pdf.Pdf;
import itext.pdf.model.Commodity;
import itext.pdf.model.Template;


/**
 * <p>
 * : 软镜样机销售合同
 * </p>
 *
 * @author Yyan
 * @since 2020-11-17
 */
public class SoftMirror extends Pdf {

    // 生成PDF文件
    public void generatePDF(Document document, Template template) throws Exception {

        // 段落
        Paragraph h1 = new Paragraph("软镜样机销售合同", titleFont);
        h1.setAlignment(1); //设置文字居中 0靠左   1，居中     2，靠右
        h1.setLeading(20f); //行间距

        document.add(h1);

        Paragraph h2 = new Paragraph("编号：" + template.getCode(), textFont);
        h2.setAlignment(2); //设置文字居中 0靠左   1，居中     2，靠右
        h2.setLeading(20f); //行间距

        document.add(h2);

        Paragraph h3 = new Paragraph("甲方（需方）：", companyFont);
        h3.setAlignment(0); //设置文字居中 0靠左   1，居中     2，靠右
        h3.setLeading(20f); //行间距

        Chunk h3_value = new Chunk(template.getPartyA(), textFont);
        h3_value.setUnderline(0.1f, -2f);
        h3.add(h3_value);

        document.add(h3);

        Paragraph h4 = new Paragraph("乙方（供方）：", companyFont);
        h4.setAlignment(0); //设置文字居中 0靠左   1，居中     2，靠右
        h4.setLeading(20f); //行间距

        Chunk h4_value = new Chunk(template.getPartyB(), textFont);
        h4_value.setUnderline(0.1f, -2f);
        h4.add(h4_value);

        document.add(h4);


        Paragraph h5 = new Paragraph("根据《中华人民共和国合同法》和有关法律、法规规定，经双方协商一致签订本合同。", textFont);
        h5.setAlignment(0); //设置文字居中 0靠左   1，居中     2，靠右
        h5.setLeading(20f); //行间距

        document.add(h5);


        Paragraph h6 = new Paragraph("1、商品的品名、规格、价格、生产企业(若不够填写，可另附页)。", textFont);
        h6.setAlignment(0); //设置文字居中 0靠左   1，居中     2，靠右
        h6.setLeading(20f); //行间距
        h6.setSpacingAfter(10f); //设置段落下空白
        h6.setFirstLineIndent(24); //设置首行缩进

        document.add(h6);

        // 表格
        PdfPTable table = createTable(new float[]{120, 60, 150, 50, 50, 100, 100, 100, 100}, null);

        table.addCell(createCell("商品名称", textFont, Element.ALIGN_CENTER));
        table.addCell(createCell("产地", textFont, Element.ALIGN_CENTER));
        table.addCell(createCell("型号", textFont, Element.ALIGN_CENTER));
        table.addCell(createCell("单位", textFont, Element.ALIGN_CENTER));
        table.addCell(createCell("数量", textFont, Element.ALIGN_CENTER));
        table.addCell(createCell("单价（含税价）", textFont, Element.ALIGN_CENTER));
        table.addCell(createCell("金额", textFont, Element.ALIGN_CENTER));
        table.addCell(createCell("机器编号", textFont, Element.ALIGN_CENTER));
        table.addCell(createCell("备注", textFont, Element.ALIGN_CENTER));

        for (Commodity commodity : template.getCommodityList()) {
            table.addCell(createCell(commodity.getName(), textFont));
            table.addCell(createCell(commodity.getAddress(), textFont));
            table.addCell(createCell(commodity.getType(), textFont));
            table.addCell(createCell(commodity.getUnit(), textFont));
            table.addCell(createCell(commodity.getNumber(), textFont));
            table.addCell(createCell(commodity.getUnitPrice(), textFont));
            table.addCell(createCell(commodity.getPrice(), textFont));
            table.addCell(createCell("见发货清单", textFont));
            table.addCell(createCell(commodity.getRemark(), textFont));
        }
        table.addCell(createCell("合计人民币", textFont));
        PdfPCell cell = new PdfPCell();
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setPhrase(new Phrase(template.getTotal(), textFont));
        cell.setColspan(8);
        table.addCell(cell);

        document.add(table);

        Paragraph h7 = new Paragraph("2、本次销售的可视软性喉镜仅供甲方在临床推广过程中作为展示或临床试用时使用。若挪做它用，经调查情况属实，乙方将终止与甲方的合作，并有权向甲方要求经济赔偿以及取消样机优惠政策。", textFont);
        h7.setAlignment(0); //设置文字居中 0靠左   1，居中     2，靠右
        h7.setLeading(20f); //行间距
        h7.setAlignment(Element.ALIGN_LEFT);//左对齐
        h7.setFirstLineIndent(24); //设置首行缩进

        document.add(h7);

        Paragraph h8 = new Paragraph("3、本次销售的可视软性喉镜如非机器本身质量问题，不予做退换货处理。", textFont);
        h8.setAlignment(0); //设置文字居中 0靠左   1，居中     2，靠右
        h8.setLeading(20f); //行间距
        h8.setAlignment(Element.ALIGN_LEFT);//左对齐
        h8.setFirstLineIndent(24); //设置首行缩进

        document.add(h8);

        Paragraph h9 = new Paragraph("4、质量标准：供方所提供的商品必须符合国家有关医疗器械行业标准。", textFont);
        h9.setAlignment(0); //设置文字居中 0靠左   1，居中     2，靠右
        h9.setLeading(20f); //行间距
        h9.setAlignment(Element.ALIGN_LEFT);//左对齐
        h9.setFirstLineIndent(24); //设置首行缩进

        document.add(h9);

        Paragraph h10 = new Paragraph("5、发货货时间、地点、方式：", textFont);
        h10.setAlignment(0); //设置文字居中 0靠左   1，居中     2，靠右
        h10.setLeading(20f); //行间距
        h10.setAlignment(Element.ALIGN_LEFT);//左对齐
        h10.setFirstLineIndent(24); //设置首行缩进

        Chunk h10_value = new Chunk(template.getDeliveryTime(), textFont);
        h10_value.setUnderline(0.1f, -2f);
        h10.add(h10_value);

        document.add(h10);

        Paragraph h11 = new Paragraph("6、运输方式及到达（港）站和费用负担：", textFont);
        h11.setAlignment(0); //设置文字居中 0靠左   1，居中     2，靠右
        h11.setLeading(20f); //行间距
        h11.setAlignment(Element.ALIGN_LEFT);//左对齐
        h11.setFirstLineIndent(24); //设置首行缩进

        Chunk h11_value = new Chunk("供方以快递方式运输（默认 EMS），运输费用由供方承担。货到地点及收件人：" + template.getAddressee(), textFont);
        h11_value.setUnderline(0.1f, -2f);
        h11.add(h11_value);

        document.add(h11);

        Paragraph h12 = new Paragraph("7、结算方式：", textFont);
        h12.setAlignment(0); //设置文字居中 0靠左   1，居中     2，靠右
        h12.setLeading(20f); //行间距
        h12.setAlignment(Element.ALIGN_LEFT);//左对齐
        h12.setFirstLineIndent(24); //设置首行缩进

        Chunk h12_value = new Chunk(template.getPayment(), textFont);
        h12_value.setUnderline(0.1f, -2f);
        h12.add(h12_value);

        document.add(h12);

        Paragraph h13 = new Paragraph("8、验收标准、方法及提出异议期限：", textFont);
        h13.setAlignment(0); //设置文字居中 0靠左   1，居中     2，靠右
        h13.setLeading(20f); //行间距
        h13.setAlignment(Element.ALIGN_LEFT);//左对齐
        h13.setFirstLineIndent(24); //设置首行缩进

        Chunk h13_value = new Chunk("需方签收后5天内验收，如有异议，签收后5天内提出，逾期未提出异议的，视为验收合格。", textFont);
        h13_value.setUnderline(0.1f, -2f);
        h13.add(h13_value);

        document.add(h13);

        Paragraph h14 = new Paragraph("9、有效和修改：本合同于", textFont);
        h14.setAlignment(0); //设置文字居中 0靠左   1，居中     2，靠右
        h14.setLeading(20f); //行间距
        h14.setAlignment(Element.ALIGN_LEFT);//左对齐
        h14.setFirstLineIndent(24); //设置首行缩进

        Chunk h14_value1 = new Chunk(" " + template.getYear() + " ", textFont);
        h14_value1.setUnderline(0.1f, -2f);
        h14.add(h14_value1);

        Chunk h14_value2 = new Chunk("年", textFont);
        h14.add(h14_value2);

        Chunk h14_value3 = new Chunk(" " + template.getMonth() + " ", textFont);
        h14_value3.setUnderline(0.1f, -2f);
        h14.add(h14_value3);

        Chunk h14_value4 = new Chunk("月", textFont);
        h14.add(h14_value4);

        Chunk h14_value5 = new Chunk(" " + template.getDay() + " ", textFont);
        h14_value5.setUnderline(0.1f, -2f);
        h14.add(h14_value5);

        Chunk h14_value6 = new Chunk("日经双方的授权代表签字并盖章后生效。本合同的任何修改、补充应以书面形式进行，并经双方的授权代表签字并盖章后方为有效。", textFont);
        h14.add(h14_value6);

        document.add(h14);

        Paragraph h15 = new Paragraph("10、售后服务：凡属产品本身质量引起的故障，凭保修卡由供方提供可视软性喉镜", textFont);
        h15.setAlignment(0); //设置文字居中 0靠左   1，居中     2，靠右
        h15.setLeading(20f); //行间距
        h15.setAlignment(Element.ALIGN_LEFT);//左对齐
        h15.setFirstLineIndent(24); //设置首行缩进

        Chunk h15_value1 = new Chunk(" 24 ", textFont);
        h15_value1.setUnderline(0.1f, -2f);
        h15.add(h15_value1);

        Chunk h15_value2 = new Chunk("个月的整机保修服务；保修期过后仍可由供方维修，但需方应支付相应的维修费用，具体条款见保修卡。", textFont);
        h15.add(h15_value2);

        document.add(h15);

        Paragraph h16 = new Paragraph("11、软镜样机的优惠政策：", textFont);
        h16.setAlignment(0); //设置文字居中 0靠左   1，居中     2，靠右
        h16.setLeading(20f); //行间距
        h16.setAlignment(Element.ALIGN_LEFT);//左对齐
        h16.setFirstLineIndent(24); //设置首行缩进

        document.add(h16);

        Paragraph h17 = new Paragraph("甲方购买的每台样机自乙方发货日起已使用满两年，且两年内每台样机为乙方增加10台的软镜销量，则满两年后至第三年内的任意时间，甲方均可申请以下优惠政策。", textFont);
        h17.setAlignment(0); //设置文字居中 0靠左   1，居中     2，靠右
        h17.setLeading(20f); //行间距
        h17.setSpacingAfter(10f); //设置段落下空白
        h17.setAlignment(Element.ALIGN_LEFT);//左对齐
        h17.setFirstLineIndent(24); //设置首行缩进

        document.add(h17);

        //表格
        PdfPTable table18 = createTable(new float[]{100, 100, 100, 120}, 400);


        PdfPCell cell181 = new PdfPCell();
        cell181.setUseAscender(true);
        cell181.setLeading(0f, 1.4f);
        cell181.setPadding(5f);
        cell181.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cell181.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell181.setPhrase(new Phrase("软镜样机优惠政策", textFont));
        cell181.setColspan(4);
        table18.addCell(cell181);

        PdfPCell cell182 = new PdfPCell();
        cell182.setUseAscender(true);
        cell182.setLeading(0f, 1.4f);
        cell182.setPadding(5f);
        cell182.setVerticalAlignment(Element.ALIGN_CENTER);
        cell182.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell182.setPhrase(new Phrase("优惠政策的前置条件", textFont));
        cell182.setColspan(3);
        table18.addCell(cell182);

        PdfPCell cell183 = new PdfPCell();
        cell183.setUseAscender(true);
        cell183.setLeading(0f, 1.4f);
        cell183.setPadding(5f);
        cell183.setVerticalAlignment(Element.ALIGN_CENTER);
        cell183.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell183.setPhrase(new Phrase("优惠政策", textFont));
        table18.addCell(cell183);

        table18.addCell(createCell("期 限", textFont));

        PdfPCell cell184 = new PdfPCell();
        cell184.setUseAscender(true);
        cell184.setLeading(0f, 1.4f);
        cell184.setPadding(5f);
        cell184.setVerticalAlignment(Element.ALIGN_CENTER);
        cell184.setHorizontalAlignment(Element.ALIGN_LEFT);
        cell184.setPhrase(new Phrase("  每台样机为乙方增加的销量", textFont));
        table18.addCell(cell184);

        table18.addCell(createCell("执行优惠政策期限", textFont));

        PdfPCell cell185 = new PdfPCell();
        cell185.setUseAscender(true);
        cell185.setLeading(0f, 1.4f);
        cell185.setPadding(5f);
        cell185.setVerticalAlignment(Element.ALIGN_CENTER);
        cell185.setHorizontalAlignment(Element.ALIGN_LEFT);
        cell185.setPhrase(new Phrase("  在前置条件下，甲方购买的每台样机享有一次权利，该权利赋予甲方购买乙方一台软镜赠送一台软镜的优惠。", textFont));
        cell185.setRowspan(2);
        table18.addCell(cell185);

        table18.addCell(createCell("从发货日起满两年", textFont));
        table18.addCell(createCell("≧10台软镜", textFont));

        PdfPCell cell186 = new PdfPCell();
        cell186.setUseAscender(true);
        cell186.setLeading(0f, 1.4f);
        cell186.setPadding(5f);
        cell186.setVerticalAlignment(Element.ALIGN_CENTER);
        cell186.setHorizontalAlignment(Element.ALIGN_LEFT);
        cell186.setPhrase(new Phrase("  发货日期满两年至第三年", textFont));
        table18.addCell(cell186);

        document.add(table18);

        Paragraph h19 = new Paragraph("12、本合同一式两份，甲乙双方盖章生效（传真件和电子扫描件有效），甲乙双方各持一份。", textFont);
        h19.setAlignment(0); //设置文字居中 0靠左   1，居中     2，靠右
        h19.setLeading(20f); //行间距
        h19.setAlignment(Element.ALIGN_LEFT);//左对齐
        h19.setFirstLineIndent(24); //设置首行缩进

        document.add(h19);

        Paragraph h20 = new Paragraph("13、如发生争议，双方可以协商或提交供方所在地法院诉讼解决。", textFont);
        h20.setAlignment(0); //设置文字居中 0靠左   1，居中     2，靠右
        h20.setLeading(20f); //行间距
        h20.setAlignment(Element.ALIGN_LEFT);//左对齐
        h20.setSpacingAfter(10f); //设置段落下空白
        h20.setFirstLineIndent(24); //设置首行缩进

        document.add(h20);

        // 表格
        PdfPTable table2 = createTable(new float[]{260, 260}, null);

        Chunk table2_value11 = new Chunk("甲方：", textFont);
        Chunk table2_value12 = new Chunk(template.getPartyA(), textFont);
        table2_value12.setUnderline(0.1f, -2f);
        PdfPCell cell1 = new PdfPCell();
        cell1.setBorderWidth(0);
        Phrase p1 = new Phrase();
        p1.add(table2_value11);
        p1.add(table2_value12);
        p1.add(Chunk.NEWLINE);
        p1.add(new Chunk("\n", CHUNK_NEWLINE));

        Chunk table2_value13 = new Chunk("法人代表或授权代表：", textFont);
        Chunk table2_value14 = new Chunk(createSpace(10), keyFont);
        table2_value14.setUnderline(0.1f, -2f);
        p1.add(table2_value13);
        p1.add(table2_value14);
        p1.add(Chunk.NEWLINE);
        p1.add(new Chunk("\n", CHUNK_NEWLINE));

        Chunk table2_value15 = new Chunk("帐号：", textFont);
        Chunk table2_value16 = new Chunk(createSpace(17), keyFont);
        table2_value16.setUnderline(0.1f, -2f);
        p1.add(table2_value15);
        p1.add(table2_value16);
        p1.add(Chunk.NEWLINE);
        p1.add(new Chunk("\n", CHUNK_NEWLINE));

        Chunk table2_value17 = new Chunk("开户行：", textFont);
        Chunk table2_value18 = new Chunk(createSpace(16), keyFont);
        table2_value18.setUnderline(0.1f, -2f);
        p1.add(table2_value17);
        p1.add(table2_value18);
        p1.add(Chunk.NEWLINE);
        p1.add(new Chunk("\n", CHUNK_NEWLINE));

        Chunk table2_value19 = new Chunk("税号：", textFont);
        Chunk table2_value20 = new Chunk(createSpace(17), keyFont);
        table2_value20.setUnderline(0.1f, -2f);
        p1.add(table2_value19);
        p1.add(table2_value20);
        p1.add(Chunk.NEWLINE);
        p1.add(new Chunk("\n", CHUNK_NEWLINE));

        Chunk table2_value21 = new Chunk("地址：", textFont);
        Chunk table2_value22 = new Chunk(createSpace(17), keyFont);
        table2_value22.setUnderline(0.1f, -2f);
        p1.add(table2_value21);
        p1.add(table2_value22);
        p1.add(Chunk.NEWLINE);
        p1.add(new Chunk("\n", CHUNK_NEWLINE));

        Chunk table2_value23 = new Chunk("日期： ", textFont);
        Chunk table2_value24 = new Chunk(" " + template.getYear() + " ", textFont);
        Chunk table2_value25 = new Chunk("年", textFont);
        Chunk table2_value26 = new Chunk(" " + template.getMonth() + " ", textFont);
        Chunk table2_value27 = new Chunk("月", textFont);
        Chunk table2_value28 = new Chunk(" " + template.getDay() + " ", textFont);
        Chunk table2_value29 = new Chunk("日", textFont);
        table2_value24.setUnderline(0.1f, -2f);
        table2_value26.setUnderline(0.1f, -2f);
        table2_value28.setUnderline(0.1f, -2f);
        p1.add(table2_value23);
        p1.add(table2_value24);
        p1.add(table2_value25);
        p1.add(table2_value26);
        p1.add(table2_value27);
        p1.add(table2_value28);
        p1.add(table2_value29);

        cell1.setPhrase(p1);
        table2.addCell(cell1);


        Chunk table2_value1 = new Chunk("乙方：", textFont);
        Chunk table2_value2 = new Chunk(template.getPartyB(), textFont);
        table2_value2.setUnderline(0.1f, -2f);
        PdfPCell cell2 = new PdfPCell();
        cell2.setBorderWidth(0);
        Phrase p2 = new Phrase();
        p2.add(table2_value1);
        p2.add(table2_value2);
        Chunk table2_ = new Chunk(createSpace(3), keyFont);
        table2_.setUnderline(0.1f, -2f);
        p2.add(table2_);
        p2.add(Chunk.NEWLINE);
        p2.add(new Chunk("\n", CHUNK_NEWLINE));

        p2.add(table2_value13);
        p2.add(table2_value14);
        p2.add(Chunk.NEWLINE);
        p2.add(new Chunk("\n", CHUNK_NEWLINE));
        p2.add(table2_value15);
        p2.add(table2_value16);
        p2.add(Chunk.NEWLINE);
        p2.add(new Chunk("\n", CHUNK_NEWLINE));
        p2.add(table2_value17);
        p2.add(table2_value18);
        p2.add(Chunk.NEWLINE);
        p2.add(new Chunk("\n", CHUNK_NEWLINE));
        p2.add(table2_value19);
        p2.add(table2_value20);
        p2.add(Chunk.NEWLINE);
        p2.add(new Chunk("\n", CHUNK_NEWLINE));
        p2.add(table2_value21);
        p2.add(table2_value22);
        p2.add(Chunk.NEWLINE);
        p2.add(new Chunk("\n", CHUNK_NEWLINE));

        p2.add(table2_value23);
        p2.add(table2_value24);
        p2.add(table2_value25);
        p2.add(table2_value26);
        p2.add(table2_value27);
        p2.add(table2_value28);
        p2.add(table2_value29);

        cell2.setPhrase(p2);
        table2.addCell(cell2);

        document.add(table2);
    }
}
