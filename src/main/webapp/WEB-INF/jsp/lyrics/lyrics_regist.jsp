<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
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
            <div class="col-md-4 offset-2">
                <form id="lyricsForm" action="/lyrics" method="POST" enctype="multipart/form-data">
                    <input type="hidden" id="_method" name="_method" value=""/>
                    <input type="hidden" id="lyricsId" name="id" value="${lyrics.id}">
                    <div class="mb-2 row">
                    <label for="lyricsName" class="col-sm-3 col-form-label">가사 이름</label>
                    <div class="col-sm-9">
                        <input type="text" class="form-control" id="lyricsName" name="lyricsName" value="${lyrics.lyricsName}">
                    </div>
                </div>
                <div class="mb-2 row">
                    <label for="descriptions" class="col-sm-3 col-form-label">가사</label>
                    <div class="col-sm-9">
                        <textarea class="form-control" id="lyrics" name="lyrics" rows="10">${lyrics.lyrics}</textarea>
                    </div>
                </div>
                <div class="mb-2 row">
                    <label for="descriptions" class="col-sm-3 col-form-label">설명</label>
                    <div class="col-sm-9">
                        <textarea class="form-control" id="descriptions" name="descriptions" rows="3">${lyrics.descriptions}</textarea>
                    </div>
                </div>
                <div class="mb-2 row">
                    <label for="descriptions" class="col-sm-3 col-form-label">등록일</label>
                    <div class="col-sm-9">
                        <input type="text" readonly class="form-control-plaintext" id="createDate" name="createDate" value="">
                    </div>
                </div>
                <div class="mt-5 text-center">
                    <button id="lyrics-regist" type="button" class="btn btn-sm btn-primary">
                        <c:if test="${not empty lyrics.id}">수정</c:if>
                        <c:if test="${empty lyrics.id}">등록</c:if>
                    </button>
                    <button id="lyrics-back" type="button" class="btn btn-sm btn-secondary">목록</button>
                </div>
                </form>
            </div>
        </div>
    </div>

<script>

    $(function(){
        $('#createDate').val(new Date().toISOString().split('T')[0]);

        $('#lyrics-regist').on('click', function () {
            const lyricsId = document.querySelector('#lyricsId').value;
            const form = document.forms['lyricsForm'];
            if (lyricsId == '') {
                form.method = 'POST';
                form.action = '/lyrics';
            } else {
                form.method = 'POST';
                form.action = '/lyrics/'+lyricsId;
            }
            document.getElementById('lyricsForm').submit();
        });

        $('#lyrics-back').on('click', function () {
            location.href = '/lyrics';
        });

    });

</script>
</body>
</html>
