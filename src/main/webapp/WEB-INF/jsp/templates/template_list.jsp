<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link href="/static/css/bootstrap.min.css" rel="stylesheet">
    <link href="/static/css/base.css" rel="stylesheet">
    <script src="/static/js/bootstrap.min.js"></script>
    <script src="/static/js/jquery-3.7.1.min.js"></script>
    <title>ppt-gen</title>
</head>
<body>

    <nav class="navbar navbar-expand-lg bg-body-tertiary mb-3" data-bs-theme="dark">
        <div class="container">
            <a class="navbar-brand" href="/">PPT-GEN</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <div class="navbar-nav">
                    <a class="nav-link active" aria-current="page" href="/templates">템플릿 관리</a>
                    <a class="nav-link" href="/lyrics">가사 관리</a>
                </div>
            </div>
        </div>
    </nav>

    <div style="text-align: center; margin: 50px 0;">
        <h4>템플릿 관리</h4>
    </div>
    <table class="table">
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
            <tr>
                <td>${template.id}</td>
                <td>${template.templateName}</td>
                <td>${template.descriptions}</td>
                <td style="text-align: center"><c:if test="${not empty template.fileId}"> 🗂 </c:if>️</td>
                <td style="text-align: center">2022-12-12</td>
                <td style="text-align: center">2022-12-12</td>
            </tr>
        </c:forEach>
        <c:if test="${empty templates}">
            <td colspan="6" style="text-align: center">등록된 템플릿이 없습니다.</td>
        </c:if>
        </tbody>
    </table>

    <div class="mt-5 text-center">
        <button id="templates-btn" type="button" class="btn btn-sm btn-primary">등록</button>
    </div>


<script>

    const registTemplates = document.getElementById('templates-btn');
    registTemplates.addEventListener("click", function(){
        location.href = '/templates/template_regist';
    });

</script>

</body>
</html>
