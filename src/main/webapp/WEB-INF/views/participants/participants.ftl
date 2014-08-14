<!DOCTYPE html>
<html>
<head>
    <title>Index</title>

<#include "../macros/header_imports.ftl">

</head>
<body>

<#include "../macros/header.ftl">

<div id="content" class="container">


    <form class="navbar-form" role="search">
        <div class="input-group add-on">
            <input class="form-control" placeholder="Suchen nach Name, Unternehmen..." name="srch-term" id="srch-term" type="text" value="${query!}">
            <div class="input-group-btn">
                <button class="btn btn-default" type="submit"><i class="glyphicon glyphicon-search"></i></button>
            </div>
        </div>
    </form>


    <#if participants?? && participants?size gt 0>

        <table class="table table-condensed">
            <tbody>

        <#list participants as participant>
            <tr>
                <td>
                ${participant.firstName!} ${participant.lastName!}
                <br/>
                ${participant.organization!}
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
                <li><a href="/participants?start=${start - max}&max=${max?string}<#if query??>&srch-term=${query}</#if>">&laquo;</a></li>
            </#if>

            <#list pagesIndexes as paginationModel>
                <#if pageIndex == paginationModel.pageIndex>
                    <li class="active">
                <#else>
                    <li>
                </#if>
                <a href="/participants?start=${paginationModel.start?string}&max=${paginationModel.max?string}<#if query??>&srch-term=${query}</#if>">${paginationModel.pageIndex?string} <span class="sr-only">(current)</span></a></li>
            </#list>

            <#if pageIndex == pagesIndexes?size>
                <li class="disabled"><a href="#">&raquo;</a></li>
            <#else>
                <li><a href="/participants?start=${start + max}&max=${max?string}<#if query??>&srch-term=${query}</#if>">&raquo;</a></li>
            </#if>

        </ul>


    </#if>






    </#if>

    <!-- Placed at the end of the document so the pages load faster -->
<#include "../macros/footer_imports.ftl">

</body>

