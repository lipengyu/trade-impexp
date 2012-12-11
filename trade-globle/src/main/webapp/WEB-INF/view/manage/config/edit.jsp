<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>更新配置类</title>

    <link rel="stylesheet" type="text/css" href="<c:url value='/resources/bootstrap/css/bootstrap.min.css' />"/>
    <link rel="stylesheet" type="text/css" href="<c:url value='/resources/bootstrap/css/bootstrap-responsive.min.css' />"/>

</head>
<body>

<%--<jsp:include page="../../common/breadcrumb.jsp" />--%>



<c:url var="action" value="/manage/updatecfg"/>
<form:form modelAttribute="configBean" action="${action}" method="post" id="configForm" cssClass="form-horizontal">
    <fieldset>
        <legend><h3>编辑配置</h3></legend>

        <div class="control-group">
            <label class="control-label">key</label>
            <div class="controls">
                <form:input path="key" id="key" readonly="true" cssClass="input-xlarge" />
                <form:errors path="key" cssClass="help-inline error"/>
            </div>
        </div>

        <div class="control-group">
            <label class="control-label">name</label>
            <div class="controls">
                <form:input path="name" id="name" cssClass="input-xlarge" />
            </div>
        </div>

        <div class="control-group">
            <label class="control-label">value</label>
            <div class="controls">
                <form:input path="value" id="value" cssClass="input-xlarge" />
            </div>
        </div>

        <div class="control-group">
            <label class="control-label" >describe</label>
            <div class="controls">
                <form:input path="describe" id="describe" cssClass="input-xlarge" />
            </div>
        </div>

        <div class="control-group">
            <div class="controls">
                <input type="submit" value="更新" class="btn btn-primary btn-margin-right"/>
                <a class="btn" onclick="history.back();">返回</a>
            </div>
        </div>
    </fieldset>
</form:form>


</body>
</html>