<!DOCTYPE html>
<html>
<head>
    <title>Deutscher Tourismusverband (DTV) | Wir machen Tourismus stark - Deutscher Tourismusverband</title>

<#include "../macros/header_imports.ftl">
<link href="/static/libs/bootstrapstartrating/star-rating.min.css" rel="stylesheet">

</head>
<body>

<#include "../macros/header.ftl">
<#--<#import "../macros/formMacros.ftl" as formMacros />-->
<#import  "../macros/spring.ftl" as spring />

<div id="content" class="container">


    <div id="feedback" class="text-center">
        <h2>Feedbackbogen zum Deutschen Tourismustag 2014</h2>
        <br>
        <p>
            Sagen Sie uns Ihre Meinung!<br>
            Liebe Teilnehmerinnen und Teilnehmer,
            schön, dass Sie beim Deutschen Tourismustag 2014 in Freiburg dabei waren.
        </p>
        <p>Gerne möchten wir wissen, wie Ihnen unsere Veranstaltung gefallen hat. Bitte füllen Sie den Fragebogen aus.</p>



    <form name="feedbackForm" id="feedbackForm" method="POST" action="/post_feedback" accept-charset="UTF-8">

       <p>Wie zufrieden waren Sie mit der Organisation der Veranstaltung?</p>

           <span><b>Organisation im Vorfeld</b></span>
           <@spring.formInput2 'feedbackForm.orgQuestion1'  "class='rating' min=0 max=5 value='${feedbackForm.orgQuestion1}' data-show-caption='false' data-show-clear='false'  step=1 data-size='md' data-rtl='false' "  "rating" "number" />
           <span><b>Empfang und Registrierung</b></span>
            <@spring.formInput2 'feedbackForm.orgQuestion2'  " class='rating' min=0 max=5 value='${feedbackForm.orgQuestion2}' data-show-caption='false' data-show-clear='false'  step=1 data-size='md' data-rtl='false' "  "rating" "number" />
           <span><b>Tagungsunterlagen</b></span>
            <@spring.formInput2 'feedbackForm.orgQuestion3'  " class='rating' min=0 max=5 value='${feedbackForm.orgQuestion3}' data-show-caption='false' data-show-clear='false'  step=1 data-size='md' data-rtl='false' "  "rating" "number" />
           <span><b>Service & Betreuung vor Ort</b></span>
            <@spring.formInput2 'feedbackForm.orgQuestion4'  " class='rating' min=0 max=5 value='${feedbackForm.orgQuestion4}' data-show-caption='false' data-show-clear='false'  step=1 data-size='md' data-rtl='false' "  "rating" "number" />
           <span><b>Verpflegung</b></span>
            <@spring.formInput2 'feedbackForm.orgQuestion5'  " class='rating' min=0 max=5 value='${feedbackForm.orgQuestion5}' data-show-caption='false' data-show-clear='false'  step=1 data-size='md' data-rtl='false' "  "rating" "number" />
           <span><b>Zeitlicher Ablauf (z.B. Länge der Pausen)</b></span>
            <@spring.formInput2 'feedbackForm.orgQuestion6'  " class='rating' min=0 max=5 value='${feedbackForm.orgQuestion6}' data-show-caption='false' data-show-clear='false'  step=1 data-size='md' data-rtl='false' "  "rating" "number" />
           <span><b>Rahmenprogramm</b></span>
            <@spring.formInput2 'feedbackForm.orgQuestion7'  " class='rating' min=0 max=5 value='${feedbackForm.orgQuestion7}' data-show-caption='false' data-show-clear='false'  step=1 data-size='md' data-rtl='false' "  "rating" "number" />
            <span><b>Anmerkungen</b></span>
            <@spring.formInput 'feedbackForm.remarkOrganisation'/>
            <br/>

        <p>Wie zufrieden waren Sie inhaltlich mit dem Deutschen Tourismustag?</p>
            <span><b>Vortrag von Prof. Peter Wippermann</b></span>
            <@spring.formInput2 'feedbackForm.contentQuestion1'  "class='rating' min=0 max=5 value='${feedbackForm.contentQuestion1}' data-show-caption='false' data-show-clear='false'  step=1 data-size='md' data-rtl='false' "  "rating" "number" />
            <span><b>Vortrag von Prof. Dr. Günther Bachmann </b></span>
            <@spring.formInput2 'feedbackForm.contentQuestion2'  "class='rating' min=0 max=5 value='${feedbackForm.contentQuestion2}' data-show-caption='false' data-show-clear='false'  step=1 data-size='md' data-rtl='false' "  "rating" "number" />
            <span><b>Vortrag von Prof. Dr. Nick Lin-Hi</b></span>
            <@spring.formInput2 'feedbackForm.contentQuestion3'  "class='rating' min=0 max=5 value='${feedbackForm.contentQuestion3}' data-show-caption='false' data-show-clear='false'  step=1 data-size='md' data-rtl='false' "  "rating" "number" />
            <span><b>Diskussionsrunde Nachhaltigkeit</b></span>
            <@spring.formInput2 'feedbackForm.contentQuestion4'  "class='rating' min=0 max=5 value='${feedbackForm.contentQuestion4}' data-show-caption='false' data-show-clear='false'  step=1 data-size='md' data-rtl='false' "  "rating" "number" />
            <span><b>Diskussionsrunde Finanzierung</b></span>
            <@spring.formInput2 'feedbackForm.contentQuestion5'  "class='rating' min=0 max=5 value='${feedbackForm.contentQuestion5}' data-show-caption='false' data-show-clear='false'  step=1 data-size='md' data-rtl='false' "  "rating" "number" />
            <span><b>Wie zufrieden waren Sie mit der Themenauswahl insgesamt?</b></span>
            <@spring.formInput2 'feedbackForm.contentQuestion6'  "class='rating' min=0 max=5 value='${feedbackForm.contentQuestion6}' data-show-caption='false' data-show-clear='false'  step=1 data-size='md' data-rtl='false' "  "rating" "number" />
            <span><b>Anmerkungen</b></span>
            <@spring.formInput 'feedbackForm.remarkContent'/>

            <p>Wie zufrieden waren Sie mit der Moderation?</p>
            <@spring.formInput2 'feedbackForm.moderation'  "class='rating' min=0 max=5 value='${feedbackForm.moderation}' data-show-caption='false' data-show-clear='false'  step=1 data-size='md' data-rtl='false' "  "rating" "number" />

        <p>Wie haben Sie von der Veranstaltung erfahren?</p>
        <#assign eventDiscoveredCheckboxes = {"Einladung":"Einladung", "Kollegen":"	Kollegen", "Presse":"Presse", "Ich war schon mehrfach auf DTV-Tagungen.":"Ich war schon mehrfach auf DTV-Tagungen."}>
        <@spring.checkboxes 'feedbackForm.eventDiscovered' eventDiscoveredCheckboxes />

        <span><b>Andere</h4/>
        <@spring.formInput 'feedbackForm.eventDiscoveredOther'/>

        <p>Warum sind Sie gekommen? </p>
        <#assign eventwhy = {"	Die Fachvorträge hörten sich interessant und spannend an.":"Die Fachvorträge hörten sich interessant und spannend an.", "Die Fachvorträge entsprechen den aktuell diskutierten Branchenthemen.":"Die Fachvorträge entsprechen den aktuell diskutierten Branchenthemen.", "Zum Netzwerken, um meine/n Lieblingskollegin/-kollegen mal wieder zu sehen.":"Zum Netzwerken, um meine/n Lieblingskollegin/-kollegen mal wieder zu sehen.", "Ich war schon mehrfach auf DTV-Tagungen.":"Ich war schon mehrfach auf DTV-Tagungen.","Eigentlich nur wegen dem Deutschen Tourismuspreis.":"Eigentlich nur wegen dem Deutschen Tourismuspreis.","Ich wollte ohnehin einmal/wieder mal nach Freiburg.":"Ich wollte ohnehin einmal/wieder mal nach Freiburg."}>
        <@spring.checkboxes 'feedbackForm.why' eventwhy />

        <p>Wie hat Ihnen die Veranstaltung insgesamt gefallen?</p>
        <@spring.formInput2 'feedbackForm.likeOverall'  "class='rating' min=0 max=5 value='${feedbackForm.likeOverall}' data-show-caption='false' data-show-clear='false'  step=1 data-size='md' data-rtl='false' "  "rating" "number" />




        <p>Besonders gut gefallen hat mir...</p>
        <@spring.formInput 'feedbackForm.like'/>

        <p>Gar nicht gefallen hat mir...</p>
        <@spring.formInput 'feedbackForm.didNotLike'/>

        <p>Was müssen WIR für SIE tun, damit Sie wieder kommen? (Anregungen, Tipps und Verbesserungsvorschläge)</p>
        <@spring.formInput 'feedbackForm.comeBack'/>

        <p>Diese Themen würden mich auf dem nächsten Deutschen Tourismustag interessieren:</p>
        <@spring.formInput 'feedbackForm.otherThemes'/>



        <br/><br/>
           <input type="submit" value="Feedback Absenden">
    </form>


   </div>


    <!-- Placed at the end of the document so the pages load faster -->
<#include "../macros/footer_imports.ftl">
<script src="/static/libs/bootstrapstartrating/star-rating.min.js"></script>

</body>
</html>

