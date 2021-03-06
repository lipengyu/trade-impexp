<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 12-12-7
  Time: 上午10:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>进出口明细按企业性质统计</title>

    <script type="text/javascript">
        $(function () {
            checkAll("all", "codes");
        });

        function genDetailCountChart() {
            $("#form1").attr("action", "${pageContext.request.contextPath}/manage/companytypechart");
            $("#form1").submit();
        }
    </script>

</head>
<body style="padding-top: 60px">

<div class="navbar navbar-fixed-top ">
    <div class="navbar-inner">

        <div class="wrapper">
            <a class="brand" href="#">进出口管理</a>

            <div class="nav-collapse collapse navbar-responsive-collapse">
                <ul class="nav nav-tabs">
                   <li><a href="${pageContext.request.contextPath}/manage/list/detailCompanyType/1">明细总统计</a></li>
                    <li><a href="javascript:" onclick="history.back();">返回</a></li>
                </ul>
            </div>

        </div>
    </div>
</div>


<h2>进出口明细按企业性质统计</h2>
<form:form id="form1" modelAttribute="detailCount"
           action="${pageContext.request.contextPath}${contextUrl}/1"
           method="post" cssClass="well form-inline">
    <input type="hidden" name="pageSize" value="${pageSize}"/>
    <input type="hidden" name="sort" value="${sort}"/>
    <input type="hidden" name="highValue" value=""/>
    <input type="hidden" name="lowValue" value=""/>

    <label class="label ">起始年月:
        <select name="lowYear" class=" input-mini" onchange="">
            <option value="" selected="selected">--</option>
            <c:forEach var="lyr" begin="2000" end="2020" step="1">
                <option value="${lyr}" <c:if test="${lowYear eq lyr}">selected="selected" </c:if>>
                        ${lyr}</option>
            </c:forEach>
        </select> 年&nbsp;
        <select name="lowMonth" class=" input-mini">
            <option value="" selected="selected">--</option>
            <c:forEach var="lmth" begin="1" end="12" step="1">
                <option value="${lmth}" <c:if test="${lowMonth eq lmth}">selected="selected" </c:if>>
                        ${lmth}</option>
            </c:forEach>
        </select>月
    </label>

    <label class="label">结束年月:
        <select name="highYear" class=" input-mini" onchange="">
            <option value="" selected="selected">--</option>
            <c:forEach var="hyr" begin="2000" end="2020" step="1">
                <option value="${hyr}" <c:if test="${highYear eq hyr}">selected="selected" </c:if>>
                        ${hyr}</option>
            </c:forEach>
        </select> 年&nbsp;
        <select name="highMonth" class=" input-mini">
            <option value="" selected="selected">--</option>
            <c:forEach var="hmth" begin="1" end="12" step="1">
                <option value="${hmth}" <c:if test="${highMonth eq hmth}">selected="selected" </c:if>>
                        ${hmth}</option>
            </c:forEach>
        </select>月
    </label>


    <label class="label">月同期查询:
        <select name="month" class=" input-mini">
            <option value="" selected="selected">--</option>
            <c:forEach var="mth" begin="1" end="12" step="1">
                <option value="${mth}" <c:if test="${month eq mth}">selected="selected" </c:if>>
                        ${mth}</option>
            </c:forEach>
        </select>月
    </label>

    <label class="label">进出口类型:
        <select name="impExpType" class=" input-small">
            <option value="0" <c:if test="${impExpType eq 0}">selected="selected" </c:if>>进口</option>
            <option value="1" <c:if test="${impExpType eq 1}">selected="selected" </c:if>>出口</option>
        </select>
    </label>

    <br/>

    <label class="label">
        产品代码:<input name="productCode" cssClass="input-mini search-query"
                    <c:if test='${productCode ne null}'>value="${productCode}" </c:if> />
    </label>
    <label class="label">
        产品名称:<input name="productName" cssClass="input-mini search-query"
                    <c:if test='${productName ne null}'>value="${productName}" </c:if> />
    </label>


    <button type="submit" class="btn btn-success">
        <i class="icon-search icon-white"></i>查询
    </button>
    <%--<div class="btn-group">--%>
    <input id="chart" type="button" class="btn-small btn-primary" value="生成曲线" onclick="genDetailCountChart()"/>

    <div class="pagination-centered">
        <jsp:include page="../../../common/pagination.jsp"/>
    </div>

    <h4><span> 过滤条件:</span>
        <label class="label"> 进出口类型:
            <c:if test="${impExpType eq 0}"><span style="color: yellow;">进口</span></c:if>
            <c:if test="${impExpType eq 1}"><span style="color: yellow;">出口</span></c:if> </label>
        <c:if test="${lowYear ne null and lowMonth ne null}">
            <label class="label"> 起始年月:<span style="color: yellow;">${lowYear}-${lowMonth} </span> </label>
        </c:if>
        <c:if test="${highYear ne null}">
            <label class="label">结束年月: <span style="color: yellow;">${highYear}-${highMonth} </span> </label>
        </c:if>
        <c:if test="${month ne null}">
            <label class="label"> 月同期: <span style="color: yellow;">${month} </span> </label>
        </c:if>
        <c:if test="${productCode ne null}">
            <label class="label">产品代码: <span style="color: yellow;">${productCode}</span> </label>
        </c:if>
        <c:if test="${productName ne null}">
            <label class="label">产品名称: <span style="color: yellow;">${productName}</span> </label>
        </c:if>

    </h4>


    <table class="table table-hover table-bordered table-striped table-condensed">
        <thead>
        <tr>
            <th><label><input type="checkbox" id="all"/>曲线</label></th>
            <th>年月</th>
            <th>产品代码</th>
            <th>产品名称</th>
            <th>企业性质</th>
            <th>数量</th>
            <th>单位</th>
            <th>美元价值</th>
            <th>平均价</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${detailCountList.content}" var="detail" varStatus="st">
            <tr <c:if test="${st.index%2 eq 1}">class="warning" </c:if>>
                <td><input type="checkbox" name="codes" value="${detail.productCode}"/></td>
                <td>${detail.yearMonth}</td>
                <td>${detail.productCode}</td>
                <td>${detail.productName}</td>
                <td>${detail.companyType}</td>
                <td>${detail.num}</td>
                <td>${detail.unit}</td>
                <td>${detail.money}</td>
                <td>${detail.unitPrice}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</form:form>

<div class="pagination-centered">
    <jsp:include page="../../../common/pagination.jsp"/>
</div>



</body>
</html>