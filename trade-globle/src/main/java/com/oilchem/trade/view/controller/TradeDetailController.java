package com.oilchem.trade.view.controller;

import com.oilchem.trade.dao.condition.*;
import com.oilchem.trade.domain.abstrac.TradeDetail;
import com.oilchem.trade.domain.condition.*;
import com.oilchem.trade.domain.detail.ExpTradeDetail;
import com.oilchem.trade.domain.detail.ImpTradeDetail;
import com.oilchem.trade.service.CommonService;
import com.oilchem.trade.service.TaskService;
import com.oilchem.trade.service.TradeDetailService;
import com.oilchem.trade.bean.CommonDto;
import com.oilchem.trade.bean.YearMonthDto;
import com.oilchem.trade.service.TradeSumService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.*;

import static com.oilchem.trade.bean.DocBean.Config.upload_detailzip_dir;
import static com.oilchem.trade.bean.DocBean.ImpExpType.export_type;
import static com.oilchem.trade.bean.DocBean.ImpExpType.import_type;
import static com.oilchem.trade.util.EHCacheUtil.setValue;
import static com.oilchem.trade.util.QueryUtils.*;
import static org.apache.commons.lang3.StringUtils.isBlank;

/**
 * Created with IntelliJ IDEA.
 * User: luowei
 * Date: 12-11-8
 * Time: 下午11:52
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("/manage")
public class TradeDetailController extends CommonController {

    @Autowired
    CommonService commonService;

    @Autowired
    TradeDetailService tradeDetailService;
    @Autowired
    TradeSumService tradeSumService;

    @Autowired
    TaskService taskService;

//    @ModelAttribute
//    public CommonDto  createCommonDto(){
//        return new CommonDto();
//    }

    /**
     * 明细列表
     *
     * @param model
     * @param commonDto
     * @param tradeDetail
     * @return
     */
    @RequestMapping("/listdetail/{pageNumber}")
    public String listexpTradeDetail(Model model, CommonDto commonDto,
                                     YearMonthDto yearMonthDto,
                                     TradeDetail tradeDetail) {

        Integer impExp = yearMonthDto.getImpExpType();
        if (impExp == null)
            yearMonthDto.setImpExpType(impExp = 0);

        if(isBlank(commonDto.getSort())){
            commonDto.setSort("yearMonth:desc");
        }

        if (impExp.equals(import_type.ordinal())) {
            Page<ImpTradeDetail> impTradeDetails = tradeDetailService.findImpWithCriteria(
                    new ImpTradeDetail(tradeDetail), commonDto, yearMonthDto, getPageRequest(commonDto));

            getDetailCriteriaData(addPageInfo(model, impTradeDetails, "/manage/listdetail"))
                    .addAttribute("tradeDetailList", impTradeDetails);
        }
        if (impExp.equals(export_type.ordinal())) {
            Page<ExpTradeDetail> expTradeDetails = tradeDetailService .findExpWithCriteria(
                    new ExpTradeDetail(tradeDetail), commonDto, yearMonthDto, getPageRequest(commonDto));

            getDetailCriteriaData(addPageInfo(model, expTradeDetails, "/manage/listdetail"))
                    .addAttribute("tradeDetailList", expTradeDetails);
        }

        addAtrribute2Model(model, tradeDetail, commonDto, yearMonthDto);

        return "manage/trade/listdetail";
    }


    @RequestMapping("/getProduct")
    @ResponseBody
    public List<String> getProduct(){

        List<Product> prodList = tradeDetailService.findAllProduct();
        List<String> prodStrList = new ArrayList<String>();
        for(Product product:prodList){
            prodStrList.add(product.getProductCode()+"->"+product.getProductName());
        }
        return prodStrList;
    }


    /**
     * 进入导入数据页面
     *
     * @return
     */
    @RequestMapping("/import")
    public String importpage(Model model) {

        model.addAttribute("sumTypeList", tradeSumService.getSumTypeList());
        return "manage/trade/import";
    }

    /**
     * 导入明细数据
     * @param file         从 DefaultMultipartHttpServletRequest获得的file
     * @param yearMonthDto 年月。。。
     * @return
     */
    @RequestMapping("/importdetail")
    public String importTradeDetail(@RequestParam("file") MultipartFile file,
                                    Model model, YearMonthDto yearMonthDto,
                                    RedirectAttributes redirectAttrs) {

        Boolean validate = (file.getOriginalFilename().endsWith(".rar")
                || file.getOriginalFilename().endsWith(".zip"))
                && yearMonthDto.validYearMonth(yearMonthDto);
        if (!validate) {
            addRedirectError(redirectAttrs, "输入的年月、或文件格式错误！");
            return "redirect:/manage/import";
        }

        //上传
        try {
            String uploadUrl = tradeDetailService.uploadFile(file, yearMonthDto);
            addRedirectMessage(redirectAttrs,"文件已上传到：<em>" + upload_detailzip_dir.value() +
                    uploadUrl.substring(uploadUrl.lastIndexOf("/"))+"</em>");

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            addRedirectError(redirectAttrs,"文件上传发生了错误");
        }

        //导入
        try{
            taskService.unDetailPackageAndImportTask(yearMonthDto);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            addRedirectError(redirectAttrs,"<br/>文件解压或导入发生了错误");
        }

        return "redirect:/manage/import";
    }


    /**
     * 获得查询条件数据
     *
     * @param model 模型
     * @return
     */
    private Model getDetailCriteriaData(Model model) {

        List<City> cityList = commonService.findAllIdEntityList(CityDao.class, City.class.getSimpleName());
        List<CompanyType> companyTypeList = commonService.findAllIdEntityList(CompanyTypeDao.class, CompanyType.class.getSimpleName());
        List<Country> countryList = commonService.findAllIdEntityList(CountryDao.class, Country.class.getSimpleName());
        List<Customs> customsList = commonService.findAllIdEntityList(CustomsDao.class, Customs.class.getSimpleName());
        List<TradeType> tradeTypeList = commonService.findAllIdEntityList(TradeTypeDao.class, TradeType.class.getSimpleName());
        List<Transportation> transportationList = commonService.findAllIdEntityList(TransportationDao.class, Transportation.class.getSimpleName());

        model.addAttribute(cityList)
                .addAttribute(companyTypeList)
                .addAttribute(countryList)
                .addAttribute(customsList)
                .addAttribute(tradeTypeList)
                .addAttribute(transportationList);

        return model;
    }

    /**
     * 将属性添加到模型中
     * @param model
     * @param tradeDetail
     * @param commonDto
     * @param yearMonthDto
     * @return
     */
    private Model addAtrribute2Model(Model model, TradeDetail tradeDetail,
                                     CommonDto commonDto, YearMonthDto yearMonthDto) {

        model = yearMonth2Model(model, yearMonthDto)
                .addAttribute("nameSelType",commonDto.getNameSelType());

        for (PropertyFilter filter : tradeDetailService
                .getdetailQueryProps(tradeDetail, commonDto)) {
            model.addAttribute(filter.getName(), filter.getValue());
        }
        return model;
    }


}
