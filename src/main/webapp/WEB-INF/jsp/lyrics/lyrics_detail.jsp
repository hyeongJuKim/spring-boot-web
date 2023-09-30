<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmtDt" uri="/WEB-INF/common/tlds/dates.tlds" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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
                    <a class="nav-link" href="/generate">생성</a>
                    <a class="nav-link" aria-current="page" href="/templates">템플릿 관리</a>
                    <a class="nav-link active" href="/lyrics">가사 관리</a>
                </div>
            </div>
        </div>
    </nav>

    <div class="container">
        <div class="row">
            <div class="col-6 offset-3">
            <form id="" action="/lyrics/regist" method="POST" enctype="multipart/form-data">
                <input type="hidden" id="lyricsId" name="id" value="${lyrics.id}">
                <div class="mb-2 row">
                    <label class="col-sm-3 col-form-label">가사 이름</label>
                    <div class="col-sm-9">
                        <c:out value="${lyrics.lyricsName}" />
                    </div>
                </div>
                <div class="mb-2 row">
                    <label class="col-sm-3 col-form-label">가사</label>
                    <div class="col-sm-9">
                        <c:out value='${fn:replace(lyrics.lyrics, crcn, "<br/>")}' escapeXml="false"/>
                    </div>
                </div>
                <div class="mb-2 row">
                    <label class="col-sm-3 col-form-label">설명</label>
                    <div class="col-sm-9">
                        <c:out value='${fn:replace(lyrics.descriptions, crcn, "<br/>")}' escapeXml="false"/>
                    </div>
                </div>
                <div class="mb-2 row">
                    <label class="col-sm-3 col-form-label">등록일시</label>
                    <div class="col-sm-9">
                        <c:out value="${fmtDt:formatLocalDateTime(lyrics.createDate, 'yyyy-MM-dd hh:mm:ss')}" />
                    </div>
                </div>
                <div class="mb-2 row">
                    <label class="col-sm-3 col-form-label">수정일시</label>
                    <div class="col-sm-9">
                        <c:out value="${fmtDt:formatLocalDateTime(lyrics.modifiedDate, 'yyyy-MM-dd hh:mm:ss')}" />
                    </div>
                </div>
                <div class="mt-5 text-center">
                    <button id="lyrics-edit" type="button" class="btn btn-sm btn-primary">수정</button>
                    <button id="lyrics-back" type="button" class="btn btn-sm btn-secondary">목록</button>
                </div>
            </form>
            <form id="fileDownload" action="/download/">
                <input type="hidden" id="fileId" name="fileId">
            </form>
            </div>
        </div>
    </div>

<script>

    $(function(){

        $('#lyrics-edit').on('click', function () {
            location.href = '/lyrics/edit/'+document.querySelector('#lyricsId').value;
        });

        $('#lyrics-back').on('click', function () {
            window.history.back();
        });

    });

</script>
</body>
</html>
