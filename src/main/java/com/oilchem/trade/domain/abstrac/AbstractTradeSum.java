package com.oilchem.trade.domain.abstrac;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 进出口总表
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 12-11-5
 * Time: 上午10:27
 * To change this template use File | Settings | File Templates.
 */
@MappedSuperclass
public abstract class AbstractTradeSum extends IdEntity implements Serializable {
    //进出口年月
    @Column(name = "year_month")
    private Date yearMonth;
    //产品类型
    @Column(name = "product_type")
    private String productType;
    // 产品名称
    @Column(name = "product_name")
    private String productName;
    //当月数量
    @Column(name = "num_month")
    private BigDecimal numMonth;
    //累计总数量
    @Column(name = "num_sum")
    private BigDecimal numSum;
    //当月金额
    @Column(name = "money_month")
    private BigDecimal moneyMonth;
    //累计金额
    @Column(name = "money_sum")
    private BigDecimal moneySum;
    //当月平均价格
    @Column(name = "avgprice_month")
    private BigDecimal avgPriceMonth;
    //累积平均价格
    @Column(name = "avgprice_sum")
    private BigDecimal avgPriceSum;
    //与上月数量增长比
    @Column(name = "num_premonth_incradio")
    private BigDecimal numPreMonthIncRadio;
    //与上年同月数量增长比
    @Column(name = "num_preyearsamemonth_incratio")
    private BigDecimal numPreYearSameMonthIncRatio;
    //与上年同期数量增长比
    @Column(name = "num_preyearsamequarter_incratio")
    private BigDecimal numPreYearSameQuarterInrRatio;

    public Date getYearMonth() {
        return yearMonth;
    }

    public void setYearMonth(Date yearMonth) {
        this.yearMonth = yearMonth;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigDecimal getNumMonth() {
        return numMonth;
    }

    public void setNumMonth(BigDecimal numMonth) {
        this.numMonth = numMonth;
    }

    public BigDecimal getNumSum() {
        return numSum;
    }

    public void setNumSum(BigDecimal numSum) {
        this.numSum = numSum;
    }

    public BigDecimal getMoneyMonth() {
        return moneyMonth;
    }

    public void setMoneyMonth(BigDecimal moneyMonth) {
        this.moneyMonth = moneyMonth;
    }

    public BigDecimal getMoneySum() {
        return moneySum;
    }

    public void setMoneySum(BigDecimal moneySum) {
        this.moneySum = moneySum;
    }

    public BigDecimal getAvgPriceMonth() {
        return avgPriceMonth;
    }

    public void setAvgPriceMonth(BigDecimal avgPriceMonth) {
        this.avgPriceMonth = avgPriceMonth;
    }

    public BigDecimal getAvgPriceSum() {
        return avgPriceSum;
    }

    public void setAvgPriceSum(BigDecimal avgPriceSum) {
        this.avgPriceSum = avgPriceSum;
    }

    public BigDecimal getNumPreMonthIncRadio() {
        return numPreMonthIncRadio;
    }

    public void setNumPreMonthIncRadio(BigDecimal numPreMonthIncRadio) {
        this.numPreMonthIncRadio = numPreMonthIncRadio;
    }

    public BigDecimal getNumPreYearSameMonthIncRatio() {
        return numPreYearSameMonthIncRatio;
    }

    public void setNumPreYearSameMonthIncRatio(BigDecimal numPreYearSameMonthIncRatio) {
        this.numPreYearSameMonthIncRatio = numPreYearSameMonthIncRatio;
    }

    public BigDecimal getNumPreYearSameQuarterInrRatio() {
        return numPreYearSameQuarterInrRatio;
    }

    public void setNumPreYearSameQuarterInrRatio(BigDecimal numPreYearSameQuarterInrRatio) {
        this.numPreYearSameQuarterInrRatio = numPreYearSameQuarterInrRatio;
    }
}
