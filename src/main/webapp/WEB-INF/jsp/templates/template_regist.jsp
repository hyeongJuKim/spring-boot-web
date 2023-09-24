<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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
                    <a class="nav-link active" aria-current="page" href="/templates">템플릿 관리</a>
                    <a class="nav-link" href="/lyrics">가사 관리</a>
                </div>
            </div>
        </div>
    </nav>

    <div class="container">
        <div class="row">
            <div class="col-6 offset-3">
                <form id="templateForm" action="/templates/template_regist" method="POST" enctype="multipart/form-data">
                <div class="mb-2 row">
                    <label for="templateName" class="col-sm-3 col-form-label">템플릿 이름</label>
                    <div class="col-sm-9">
                        <input type="text" class="form-control" id="templateName" name="templateName">
                    </div>
                </div>
                <div class="mb-2 row">
                    <label for="descriptions" class="col-sm-3 col-form-label">설명</label>
                    <div class="col-sm-9">
                        <textarea class="form-control" id="descriptions" name="descriptions" rows="3"></textarea>
                    </div>
                </div>
                <div class="mb-2 row">
                    <label for="templateFile" class="col-sm-3 col-form-label">파일</label>
                    <div class="col-sm-9">
                        <input class="form-control" type="file" id="templateFile" name="templateFile">
                    </div>
                </div>
                    <div class="mb-2 row">
                        <label for="descriptions" class="col-sm-3 col-form-label">등록일</label>
                        <div class="col-sm-9">
                            <input type="text" readonly class="form-control-plaintext" id="createDate" name="createDate" value="">
                        </div>
                    </div>
                <div class="mt-5 text-center">
                    <button id="templates-regist" type="button" class="btn btn-sm btn-primary">등록</button>
                    <button id="templates-back" type="button" class="btn btn-sm btn-secondary">목록</button>
                </div>
                </form>
            </div>
        </div>
    </div>

<script>

    $(function(){

        // TODO:: init sample data
        document.getElementById('templateName').value = '23 가을 가사 템플릿';
        document.getElementById('descriptions').value = '주황색 컬러가 메인인 23 가을 가사 템플릿입니다.\n끝';
        // TODO:: init sample data

        $('#createDate').val(new Date().toISOString().split('T')[0]);

        $('#templates-regist').on('click', function () {
            document.getElementById('templateForm').submit();
        });

        $('#templates-back').on('click', function () {
            window.history.back();
        });

    });

</script>
</body>
</html>
