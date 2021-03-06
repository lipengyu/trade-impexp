package com.oilchem.trade.domain.abstrac;

import com.oilchem.trade.domain.abstrac.IdEntity;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 进出口明细表
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 12-11-5
 * Time: 上午10:15
 * To change this template use File | Settings | File Templates.
 */
@MappedSuperclass
public class TradeDetail
        extends IdEntity implements Serializable {
    //年
    @Column(name = "col_year")
    private Integer year;
    //月
    @Column(name = "col_month")
    private Integer month;
    @Column(name = "year_month")
    private String yearMonth;
    //产品代码
    @Column(name = "product_code")
    private String productCode;
    //产品名称
    @Column(name = "product_name")
    private String productName;
    //产品名称
    @Column(name = "product_type")
    private String productType;
    //产品类型码
    @Column(name = "type_code")
    private Integer typeCode;
    //企业性质
    @Column(name = "company_type")
    private String companyType;
    //贸易方式
    @Column(name = "trade_type")
    private String tradeType;
    //运输方式
    @Column(name = "transportation")
    private String transportation;
    //海关
    @Column(name = "customs")
    private String customs;
    //城市
    @Column(name = "city")
    private String city;
    //产销国家
    @Column(name = "country")
    private String country;
    //数量
    @Column(name = "amount")
    private BigDecimal amount;
    //计量单位
    @Column(name = "unit")
    private String unit;
    //金额
    @Column(name = "amount_money")
    private BigDecimal amountMoney;
    //单价
    @Column(name = "unit_price")
    private BigDecimal unitPrice;


    public TradeDetail() {
    }

    public TradeDetail(String productName) {
        this.productName = productName;
    }

    public TradeDetail(String productCode,String productName, BigDecimal amount,
                       BigDecimal amountMoney, BigDecimal unitPrice) {
        this.productCode = productCode;
        this.productName = productName;
        this.amount = amount;
        this.amountMoney = amountMoney;
        this.unitPrice = unitPrice;
    }

    public TradeDetail(BigDecimal amount, BigDecimal amountMoney,
                       BigDecimal unitPrice) {
        this.amount = amount;
        this.amountMoney = amountMoney;
        this.unitPrice = unitPrice;
    }

    public Integer getYear() {
        return year;
    }

    public TradeDetail setYear(Integer year) {
        this.year = year;
        return this;
    }

    public Integer getMonth() {
        return month;
    }

    public TradeDetail setMonth(Integer month) {
        this.month = month;
        return this;
    }

    public String getYearMonth() {
        return yearMonth;
    }

    public TradeDetail setYearMonth(String yearMonth) {
        this.yearMonth = yearMonth;
        return this;
    }

    public String getProductCode() {
        return productCode;
    }

    public TradeDetail setProductCode(String productCode) {
        this.productCode = productCode;
        return this;
    }

    public String getProductName() {
        return productName;
    }

    public TradeDetail setProductName(String productName) {
        this.productName = productName;
        return this;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public Integer getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(Integer typeCode) {
        this.typeCode = typeCode;
    }

    public String getCompanyType() {
        return companyType;
    }

    public TradeDetail setCompanyType(String companyType) {
        this.companyType = companyType;
        return this;
    }

    public String getTradeType() {
        return tradeType;
    }

    public TradeDetail setTradeType(String tradeType) {
        this.tradeType = tradeType;
        return this;
    }

    public String getTransportation() {
        return transportation;
    }

    public TradeDetail setTransportation(String transportation) {
        this.transportation = transportation;
        return this;
    }

    public String getCustoms() {
        return customs;
    }

    public TradeDetail setCustoms(String customs) {
        this.customs = customs;
        return this;
    }

    public String getCity() {
        return city;
    }

    public TradeDetail setCity(String city) {
        this.city = city;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public TradeDetail setCountry(String country) {
        this.country = country;
        return this;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public TradeDetail setAmount(BigDecimal amount) {
        this.amount = amount;
        return this;
    }

    public String getUnit() {
        return unit;
    }

    public TradeDetail setUnit(String unit) {
        this.unit = unit;
        return this;
    }

    public BigDecimal getAmountMoney() {
        return amountMoney;
    }

    public TradeDetail setAmountMoney(BigDecimal amountMoney) {
        this.amountMoney = amountMoney;
        return this;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public TradeDetail setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
        return this;
    }

}
