<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--<ul class="breadcrumb" style="border-top:none; border-left: none; padding-left: 25px;">--%>
<%--<li>--%>
<%--<a href="${pageContext.request.contextPath}/manage/configlist">配置</a> <span class="divider">|</span>--%>
<%--</li>--%>
<%--<li>--%>
<%--<a href="${pageContext.request.contextPath}/manage/import">导入</a> <span class="divider">|</span>--%>
<%--</li>--%>
<%--<li>--%>
<%--<a href="${pageContext.request.contextPath}/manage/listdetail/1">明细表</a> <span class="divider">|</span>--%>
<%--</li>--%>
<%--<li>--%>
<%--<a href="${pageContext.request.contextPath}/manage/listsum/1">总表</a> <span class="divider">|</span>--%>
<%--</li>--%>
<%--<li>--%>
<%--<a href="javascript:" onclick="history.back();">返回</a>--%>
<%--</li>--%>
<%--</ul>--%>



<%--<div class="navbar navbar-static-top">--%>
<div class="navbar navbar-fixed-top ">
    <div class="navbar-inner">

        <div class="container">
            <a class="brand" href="#">进出口管理</a>

            <div class="nav-collapse collapse navbar-responsive-collapse">

                <ul class="nav">
                    <li>
                        <a href="${pageContext.request.contextPath}/manage/configlist">配置</a>
                    </li>
                    <li>
                        <a href="${pageContext.request.contextPath}/manage/import">导入</a>
                    </li>
                    <li>
                        <a href="${pageContext.request.contextPath}/manage/listdetail/1">明细表</a>
                    </li>
                    <li>
                        <a href="${pageContext.request.contextPath}/manage/list/detailCount/1">明细统计表</a>
                    </li>
                    <li>
                        <a href="${pageContext.request.contextPath}/manage/listsum/1">总表</a>
                    </li>
                    <li>
                        <a href="${pageContext.request.contextPath}/manage/list/allfilter">条件表</a>
                    </li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">导入日志 <b class="caret"></b></a>
                        <ul class="dropdown-menu">
                            <li><a href="${pageContext.request.contextPath}/manage/listlog/0/1">明细表日志</a></li>
                            <li><a href="${pageContext.request.contextPath}/manage/listlog/1/1">总表日志</a></li>
                        </ul>
                    </li>

                    <li>
                        <a href="javascript:" onclick="history.back();">返回</a>
                    </li>
                </ul>
            </div>

        </div>
    </div>
</div>

<c:if test="${message ne null}">
    <div class="container">
        <h3 style="color: #4169e1;">${message}</h3>
    </div>

    <%--<script type="text/javascript">--%>
    <%--//            $(function(){--%>
    <%--//                $("#message").modal({show:false});--%>
    <%--//            })--%>

    <%--function hide() {--%>
    <%--$("#message").modal("hide");--%>
    <%--}--%>
    <%--function show() {--%>
    <%--alert($("#message").val)--%>
    <%--$("#reExtract_win").modal({show:false});--%>
    <%--$("#reExtract_win").modal("show");--%>
    <%--}--%>
    <%--function toggle() {--%>
    <%--$("#message").modal("toggle");--%>
    <%--}--%>

    <%--</script>--%>

    <%--<div class="modal  hide fade" id="message">--%>
    <%--<div class="modal-header">--%>
    <%--<button class="close" data-dismiss="modal" onclick="hide()">x</button>--%>
    <%--<h3>返回消息</h3>--%>
    <%--</div>--%>
    <%--<div class="modal-body">--%>
    <%--<p>${message} </p>--%>
    <%--</div>--%>
    <%--<div class="modal-footer">--%>
    <%--<a href="#" onclick="hide()" class="btn btn-primary">确定</a>--%>
    <%--</div>--%>
    <%--</div>--%>
</c:if>

