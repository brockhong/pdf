package itext.pdf.model;

import java.util.List;

/**
 * <p>
 * : 模版
 * </p>
 *
 * @author Yyan
 * @since 2020-11-13
 */
public class Template {
    //合同类型
    private String contractType;
    //合同编码
    private String code;
    //甲方
    private String partyA;
    //乙方
    private String partyB;
    //交货时间
    private String deliveryTime;
    //收件人
    private String addressee;
    //结算方式
    private String payment;
    //年
    private String year;
    //月
    private String month;
    //日
    private String day;

    //合计
    private String total;

    //商品信息
    private List<Commodity> commodityList;

    public String getContractType() {
        return contractType;
    }

    public void setContractType(String contractType) {
        this.contractType = contractType;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPartyA() {
        return partyA;
    }

    public void setPartyA(String partyA) {
        this.partyA = partyA;
    }

    public String getPartyB() {
        return partyB;
    }

    public void setPartyB(String partyB) {
        this.partyB = partyB;
    }

    public String getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(String deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public String getAddressee() {
        return addressee;
    }

    public void setAddressee(String addressee) {
        this.addressee = addressee;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public List<Commodity> getCommodityList() {
        return commodityList;
    }

    public void setCommodityList(List<Commodity> commodityList) {
        this.commodityList = commodityList;
    }

    @Override
    public String toString() {
        return "Template{" +
                "code='" + code + '\'' +
                ", partyA='" + partyA + '\'' +
                ", partyB='" + partyB + '\'' +
                ", deliveryTime='" + deliveryTime + '\'' +
                ", addressee='" + addressee + '\'' +
                ", payment='" + payment + '\'' +
                ", year='" + year + '\'' +
                ", month='" + month + '\'' +
                ", day='" + day + '\'' +
                ", total='" + total + '\'' +
                ", commodityList=" + commodityList +
                '}';
    }
}
