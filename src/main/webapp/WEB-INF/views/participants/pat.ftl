<!DOCTYPE html>
<html>
<head>
<#include "../macros/header_imports.ftl">

</head>
<body>

<#include "../macros/header.ftl">

<div id="content" class="container">

    <div id="participants" class="text-center">
        <h2>Alle Pat</h2>


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
                <#list participants as participant>
                <tr>
                    <td>
                        <strong>${participant.lastName!?upper_case}</strong>, ${participant.firstName!}
                    </td>
                </tr>
                </#list>
            </tbody>
        </table>


    </#if>

    </div>

    <!-- Placed at the end of the document so the pages load faster -->
<#include "../macros/footer_imports.ftl">

</body>
</html>

