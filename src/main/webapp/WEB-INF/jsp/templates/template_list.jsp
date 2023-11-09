<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmtDt" uri="/WEB-INF/common/tlds/dates.tlds" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link href="/static/css/bootstrap.min.css" rel="stylesheet">
    <link href="/static/css/base.css" rel="stylesheet">
    <script src="/static/js/bootstrap.min.js"></script>
    <script src="/static/js/jquery-3.7.1.min.js"></script>
    <script src="/static/js/commonUtil.js"></script>
    <title>ppt-gen</title>
</head>
<body>
    <jsp:include page="/WEB-INF/jsp/common/nav.jsp" />

    <div class="container">
        <div style="text-align: center; margin: 50px 0;">
            <h4>템플릿 관리</h4>
        </div>
        <div class="row">
            <div class="col-8 offset-2 col-sm-12 offset-sm-0">
                <form action="" method="get">
                    <input type="hidden" >
                    <table id="templateListTable" class="table">
                        <thead style="text-align: center">
                        <th scope="col">#</th>
                        <th scope="col">템플릿 이름</th>
                        <th scope="col">설명</th>
                        <th scope="col">파일</th>
                        <th scope="col">등록일</th>
                        <th scope="col">수정일</th>
                        </thead>
                        <tbody class="table-group-divider">
                        <c:forEach var="template" items="${templates}">
                            <tr data-id="${template.id}">
                                <td>${template.id}</td>
                                <td>${template.templateName}</td>
                                <td class="txt-ellipsis">${template.descriptions}</td>
                                <td style="text-align: center"><c:if test="${not empty template.uploadFile.id}">&#x1F5C2</c:if>️</td>
                                <td style="text-align: center"><c:out value="${fmtDt:formatLocalDateTime(template.createDate, 'yyyy-MM-dd')}" /></td>
                                <td style="text-align: center"><c:out value="${fmtDt:formatLocalDateTime(template.modifiedDate, 'yyyy-MM-dd')}" /></td>
                            </tr>
                        </c:forEach>
                        <c:if test="${empty templates}">
                            <td colspan="6" style="text-align: center">등록된 템플릿이 없습니다.</td>
                        </c:if>
                        </tbody>
                    </table>
                </form>
                <div class="mt-5 text-center">
                    <button id="templates-btn" type="button" class="btn btn-sm btn-primary">등록</button>
                </div>
            </div>
        </div>
    </div>
<script>

    $(function(){

        $('#templates-btn').on('click', function () {
            location.href = '/templates/regist';
        });

        $('#templateListTable tbody tr').on('click', function (e) {
            const id = $(this).data('id');
            if (commonUtil.isNotEmpty(id) && id > 0) {
                location.href = '/templates/'+id;
            }
        });

    });
</script>

</body>
</html>
