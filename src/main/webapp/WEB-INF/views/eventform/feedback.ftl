<!DOCTYPE html>
<html>
<head>
    <title>Index</title>

<#include "../macros/header_imports.ftl">
<link href="/static/libs/bootstrapstartrating/star-rating.min.css" rel="stylesheet">

</head>
<body>

<#include "../macros/header.ftl">
<#import "../macros/formMacros.ftl" as formMacros />
<#import  "../macros/spring.ftl" as spring />

<div id="content" class="container">


    <h1>Feedbackbogen zum Deutschen Tourismustag 2014</h1>
    <h2>Sagen Sie uns Ihre Meinung!</h2>
    <p>Liebe Teilnehmerinnen und Teilnehmer,
    schön, dass Sie beim Deutschen Tourismustag 2014 in Freiburg dabei waren.</p>
    <p>Gerne möchten wir wissen, wie Ihnen unsere Veranstaltung gefallen hat. Bitte füllen Sie den Fragebogen aus.</p>


    <form name="feedbackForm" id="feedbackForm" method="POST" action="/post_feedback" accept-charset="UTF-8">

       <h3>Wie zufrieden waren Sie mit der Organisation der Veranstaltung?</h3>

           <h4>Organisation im Vorfeld</h4>
           <@spring.formInput2 'feedbackForm.orgQuestion1'  "class='rating' min=0 max=5 value='${feedbackForm.orgQuestion1}' data-show-caption='false' data-show-clear='false'  step=1 data-size='md' data-rtl='false' "  "rating" "number" />
           <h4>Empfang und Registrierung</h4>
            <@spring.formInput2 'feedbackForm.orgQuestion2'  " class='rating' min=0 max=5 value='${feedbackForm.orgQuestion2}' data-show-caption='false' data-show-clear='false'  step=1 data-size='md' data-rtl='false' "  "rating" "number" />
           <h4>Tagungsunterlagen</h4>
            <@spring.formInput2 'feedbackForm.orgQuestion3'  " class='rating' min=0 max=5 value='${feedbackForm.orgQuestion3}' data-show-caption='false' data-show-clear='false'  step=1 data-size='md' data-rtl='false' "  "rating" "number" />
           <h4>Service & Betreuung vor Ort</h4>
            <@spring.formInput2 'feedbackForm.orgQuestion4'  " class='rating' min=0 max=5 value='${feedbackForm.orgQuestion4}' data-show-caption='false' data-show-clear='false'  step=1 data-size='md' data-rtl='false' "  "rating" "number" />
           <h4>Verpflegung</h4>
            <@spring.formInput2 'feedbackForm.orgQuestion5'  " class='rating' min=0 max=5 value='${feedbackForm.orgQuestion5}' data-show-caption='false' data-show-clear='false'  step=1 data-size='md' data-rtl='false' "  "rating" "number" />
           <h4>Zeitlicher Ablauf (z.B. Länge der Pausen)</h4>
            <@spring.formInput2 'feedbackForm.orgQuestion6'  " class='rating' min=0 max=5 value='${feedbackForm.orgQuestion6}' data-show-caption='false' data-show-clear='false'  step=1 data-size='md' data-rtl='false' "  "rating" "number" />
           <h4>Rahmenprogramm</h4>
            <@spring.formInput2 'feedbackForm.orgQuestion7'  " class='rating' min=0 max=5 value='${feedbackForm.orgQuestion7}' data-show-caption='false' data-show-clear='false'  step=1 data-size='md' data-rtl='false' "  "rating" "number" />
            <h4>Anmerkungen</h4>
            <@spring.formInput 'feedbackForm.remarkOrganisation'/>
            <br/>

        <h3>Wie zufrieden waren Sie inhaltlich mit dem Deutschen Tourismustag?</h3/>
            <h4>Vortrag von Prof. Peter Wippermann</h4>
            <@spring.formInput2 'feedbackForm.contentQuestion1'  "class='rating' min=0 max=5 value='${feedbackForm.contentQuestion1}' data-show-caption='false' data-show-clear='false'  step=1 data-size='md' data-rtl='false' "  "rating" "number" />
            <h4>Vortrag von Prof. Dr. Günther Bachmann </h4>
            <@spring.formInput2 'feedbackForm.contentQuestion2'  "class='rating' min=0 max=5 value='${feedbackForm.contentQuestion2}' data-show-caption='false' data-show-clear='false'  step=1 data-size='md' data-rtl='false' "  "rating" "number" />
            <h4>Vortrag von Prof. Dr. Nick Lin-Hi</h4>
            <@spring.formInput2 'feedbackForm.contentQuestion3'  "class='rating' min=0 max=5 value='${feedbackForm.contentQuestion3}' data-show-caption='false' data-show-clear='false'  step=1 data-size='md' data-rtl='false' "  "rating" "number" />
            <h4>Diskussionsrunde Nachhaltigkeit</h4>
            <@spring.formInput2 'feedbackForm.contentQuestion4'  "class='rating' min=0 max=5 value='${feedbackForm.contentQuestion4}' data-show-caption='false' data-show-clear='false'  step=1 data-size='md' data-rtl='false' "  "rating" "number" />
            <h4>Diskussionsrunde Finanzierung</h4>
            <@spring.formInput2 'feedbackForm.contentQuestion5'  "class='rating' min=0 max=5 value='${feedbackForm.contentQuestion5}' data-show-caption='false' data-show-clear='false'  step=1 data-size='md' data-rtl='false' "  "rating" "number" />
            <h4>Wie zufrieden waren Sie mit der Themenauswahl insgesamt?</h4>
            <@spring.formInput2 'feedbackForm.contentQuestion6'  "class='rating' min=0 max=5 value='${feedbackForm.contentQuestion6}' data-show-caption='false' data-show-clear='false'  step=1 data-size='md' data-rtl='false' "  "rating" "number" />
            <h4>Anmerkungen</h4>
            <@spring.formInput 'feedbackForm.remarkContent'/>

            <h3>Wie zufrieden waren Sie mit der Moderation?</h3/>
            <@spring.formInput2 'feedbackForm.moderation'  "class='rating' min=0 max=5 value='${feedbackForm.moderation}' data-show-caption='false' data-show-clear='false'  step=1 data-size='md' data-rtl='false' "  "rating" "number" />

        <h3>Wie haben Sie von der Veranstaltung erfahren?</h3/>
        <#assign eventDiscoveredCheckboxes = {"Einladung":"Einladung", "Kollegen":"	Kollegen", "Presse":"Presse", "Ich war schon mehrfach auf DTV-Tagungen.":"Ich war schon mehrfach auf DTV-Tagungen."}>
        <@formMacros.checkboxes 'feedbackForm.eventDiscovered'
            <br/>
           <input type="submit" value="Submit">
    </form>


    <!-- Placed at the end of the document so the pages load faster -->
<#include "../macros/footer_imports.ftl">
<script src="/static/libs/bootstrapstartrating/star-rating.min.js"></script>

</body>

