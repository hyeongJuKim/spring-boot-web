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
        <div style="text-align: center; margin: 50px 0;">
            <h4>가사 관리</h4>
        </div>
        <div class="row">
            <div class="col-8 offset-2 col-sm-12 offset-sm-0">
                <form action="" method="get">
                    <input type="hidden" >
                    <table id="lyricsListTable" class="table">
                        <thead style="text-align: center">
                        <th scope="col">#</th>
                        <th scope="col">가사 이름</th>
                        <th scope="col">가사</th>
                        <th scope="col">설명</th>
                        <th scope="col">등록일</th>
                        <th scope="col">수정일</th>
                        </thead>
                        <tbody class="table-group-divider">
                        <c:forEach var="lyrics" items="${lyrics}">
                            <tr data-id="${lyrics.id}">
                                <td>${lyrics.id}</td>
                                <td>${lyrics.lyricsName}</td>
                                <td class="txt-ellipsis">${lyrics.lyrics}</td>
                                <td class="txt-ellipsis">${lyrics.descriptions}</td>
                                <td style="text-align: center"><c:out value="${fmtDt:formatLocalDateTime(lyrics.createDate, 'yyyy-MM-dd')}" /></td>
                                <td style="text-align: center"><c:out value="${fmtDt:formatLocalDateTime(lyrics.modifiedDate, 'yyyy-MM-dd')}" /></td>
                            </tr>
                        </c:forEach>
                        <c:if test="${empty lyrics}">
                            <td colspan="6" style="text-align: center">등록된 가사가 없습니다.</td>
                        </c:if>
                        </tbody>
                    </table>
                </form>
                <div class="mt-5 text-center">
                    <button id="lyrics-btn" type="button" class="btn btn-sm btn-primary">등록</button>
                </div>
            </div>
        </div>
    </div>
<script>

    $(function(){

        $('#lyrics-btn').on('click', function () {
            location.href = '/lyrics/regist';
        });

        $('#lyricsListTable tbody tr').on('click', function (e) {
            const id = $(this).data('id');
            if (commonUtil.isNotEmpty(id) && id > 0) {
                location.href = '/lyrics/'+id;
            }
        });

    });
</script>

</body>
</html>
