<!DOCTYPE html>
<html>
<head>
    <title>Deutscher Tourismusverband (DTV) | Wir machen Tourismus stark - Deutscher Tourismusverband</title>

<#include "../macros/header_imports.ftl">

</head>
<body>

<#include "../macros/header.ftl">

<div id="content" class="container">

    <div id="participants">
        <h2>Teilnehmerliste</h2>


    <form class="navbar-form" role="search">
        <div class="input-group add-on">
            <input class="form-control" placeholder="Suchen nach Nachname, Unternehmen..." name="srch-term" id="srch-term" type="search" value="${query!}">
            <div class="input-group-btn">
                <button class="btn btn-default" type="submit"><i class="glyphicon glyphicon-search"></i></button>
            </div>
        </div>
    </form>
    <#if participants?? && participants?size gt 0>
    <table class="table table-condensed">
        <tbody>

        <#assign firstLetter = "">
        <#list participants as participant>

            <#assign newFirstletter = participant.lastName?substring(0,1)/>
            <#if newFirstletter != firstLetter && firstLetter?length gt 0>
                <td  class="participantLetterSeparator">
                    ${newFirstletter?upper_case}
                </td>
            </#if>
            <#assign firstLetter = newFirstletter/>
            <tr>
            <td>

                    <strong>${participant.lastName!?upper_case}</strong>, <#if participant.title?? && participant.title?length gt 1>${participant.title!} </#if>${participant.firstName!}

                    <#if participant.position?? && participant.position?length gt 1><br/><span class="cellSubtitle">${participant.position!}</span></#if>

                    <br/>
                <#if participant.address1?? && participant.address1?length gt 1>${participant.address1!}</#if><#if participant.city?? && participant.city?length gt 0>, ${participant.city!}</#if>
                <#if participant.xing?? && participant.xing?length gt 0><a href="${participant.xing!}" target="_blank" rel="me"><br/><img src="http://www.xing.com/img/buttons/9_de_btn.gif" width="80" height="15" alt="XING"></a>
                </#if>
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

    </div>

    <!-- Placed at the end of the document so the pages load faster -->
<#include "../macros/footer_imports.ftl">

</body>
</html>

