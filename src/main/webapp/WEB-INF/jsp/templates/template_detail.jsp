<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    pageContext.setAttribute("crcn", "\r\n");
    pageContext.setAttribute("br", "<br/>");
%>

<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
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

    <div class="container">
        <div class="row">
            <form id="" action="/templates/template_regist" method="POST" enctype="multipart/form-data">
                <div class="col-lg-6 col-md-8 col-sm-12 col-xs">
                    <div class="mb-2 row">
                        <label class="col-sm-3 col-form-label">템플릿 이름</label>
                        <div class="col-sm-9">
                            <c:out value="${template.templateName}" />
                        </div>
                    </div>
                    <div class="mb-2 row">
                        <label class="col-sm-3 col-form-label">설명</label>
                        <div class="col-sm-9">
                            <c:out value='${fn:replace(template.descriptions, crcn, "<br/>")}' escapeXml="false"/>
                        </div>
                    </div>
                    <div class="mb-2 row">
                        <label class="col-sm-3 col-form-label">파일</label>
                        <div class="col-sm-9">
                            <c:out value="${template.uploadFile.originalName}" />
                        </div>
                    </div>

                    <div class="mt-5 text-center">
                        <button id="templates-edit" type="button" class="btn btn-sm btn-primary">수정</button>
                        <button id="templates-back" type="button" class="btn btn-sm btn-secondary">목록</button>
                    </div>
                </div>
            </form>
        </div>
    </div>

<script>

    $(function(){

        $('#templates-back').on('click', function () {
            window.history.back();
        });

    });

</script>
</body>
</html>
