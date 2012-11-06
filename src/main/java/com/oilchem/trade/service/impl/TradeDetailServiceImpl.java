package com.oilchem.trade.service.impl;

import com.oilchem.trade.config.ImpExpType;
import com.oilchem.trade.dao.*;
import com.oilchem.trade.service.CommonService;
import com.oilchem.trade.service.TradeDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 12-11-5
 * Time: 下午5:43
 * To change this template use File | Settings | File Templates.
 */
@Service("tradeDetailService")
public class TradeDetailServiceImpl implements TradeDetailService {

    @Autowired
    CommonService commonService;

    @Resource
    CityDao cityDao;
    @Resource
    ComplanyTypeDao companyTypeDao;
    @Resource
    CountryDao countryDao;
    @Resource
    CustomsDao customsDao;
    @Resource
    ProductTypeDao productTypeDao;
    @Resource
    TransportationDao transportationDao;
    @Resource
    ExpTradeDetailDao expTradeDetailDao;
    @Resource
    ImpTradeDetailDao impTradeDetailDao;


    @Override
    public String unZipAccess(String zipFullName, String unZipFullName) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Boolean importAccess(String accessFileFullName, Enum<ImpExpType> impExpTypeEnum) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
