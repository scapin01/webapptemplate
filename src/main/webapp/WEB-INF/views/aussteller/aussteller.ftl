<!DOCTYPE html>
<html>
<head>
    <title>Deutscher Tourismusverband (DTV) | Wir machen Tourismus stark - Deutscher Tourismusverband</title>

<#include "../macros/header_imports.ftl">

</head>
<body>

<#include "../macros/header.ftl">

<div id="content" class="container">

    <div id="aussteller" class="text-center">
        <h2>Austellerliste</h2>


    <form class="navbar-form" role="search">
        <div class="input-group add-on">
            <input class="form-control" placeholder="Suchen nach Organization..." name="srch-term" id="srch-term" type="text" value="${query!}">
            <div class="input-group-btn">
                <button class="btn btn-default" type="submit"><i class="glyphicon glyphicon-search"></i></button>
            </div>
        </div>
    </form>

    <style>
        .table.table-condensed img {
            background-color: #ddd;
            border: 2px solid #fff;
            box-shadow: 0 0 2px #000;
            padding: 5px;
        }
    </style>


    <#if aussteller?? && aussteller?size gt 0>

        <table class="table table-condensed">
            <tbody>

                <#list aussteller as aus>
                <tr>
                    <td>
                        <strong>${aus.organization!}</strong><br>
                        <img alt="${aus.organization!}" src="static/img/aussteller/europapark.png" />
                        <br/>
                        Stand-Nr: ${aus.standNr!}
                        <br/>
                        <a href="http://${aus.website!}">${aus.website!}</a>
                    </td>
                </tr>
                </#list>

            </tbody>
        </table>

        <#if pagesIndexes?size gt 1>

            <ul class="pagination">

                <#if pageIndex == 1>
                    <li class="disabled"><a href="#">&laquo;</a></li>
                <#else>
                    <li><a href="/aussteller?start=${start - max}&max=${max?string}<#if query??>&srch-term=${query}</#if>">&laquo;</a></li>
                </#if>

                <#list pagesIndexes as paginationModel>
                    <#if pageIndex == paginationModel.pageIndex>
                    <li class="active">
                    <#else>
                    <li>
                    </#if>
                    <a href="/aussteller?start=${paginationModel.start?string}&max=${paginationModel.max?string}<#if query??>&srch-term=${query}</#if>">${paginationModel.pageIndex?string} <span class="sr-only">(current)</span></a></li>
                </#list>

                <#if pageIndex == pagesIndexes?size>
                    <li class="disabled"><a href="#">&raquo;</a></li>
                <#else>
                    <li><a href="/aussteller?start=${start + max}&max=${max?string}<#if query??>&srch-term=${query}</#if>">&raquo;</a></li>
                </#if>

            </ul>

        </#if>

    </#if>

    </div>


    <!-- Placed at the end of the document so the pages load faster -->
<#include "../macros/footer_imports.ftl">

</body>
</html>

