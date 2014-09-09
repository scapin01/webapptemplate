<#--
 * spring.ftl
 *
 * This file consists of a collection of FreeMarker macros aimed at easing
 * some of the common requirements of web applications - in particular
 * handling of forms.
 *
 * Spring's FreeMarker support will automatically make this file and therefore
 * all macros within it available to any application using Spring's
 * FreeMarkerConfigurer.
 *
 * To take advantage of these macros, the "exposeSpringMacroHelpers" property
 * of the FreeMarker class needs to be set to "true". This will expose a
 * RequestContext under the name "springMacroRequestContext", as needed by
 * the macros in this library.
 *
 * @author Darren Davison
 * @author Juergen Hoeller
 * @since 1.1
 -->

<#--
 * spring:bind
 *
 * Exposes a BindStatus object for the given bind path, which can be
 * a bean (e.g. "person") to get global errors, or a bean property
 * (e.g. "person.name") to get field errors. Can be called multiple times
 * within a form to bind to multiple command objects and/or field names.
 *
 * This macro will participate in the default HTML escape setting for the given
 * RequestContext. This can be customized by calling "setDefaultHtmlEscape"
 * on the "springMacroRequestContext" context variable, or via the
 * "defaultHtmlEscape" context-param in web.xml (same as for the JSP bind tag).
 * Also regards a "htmlEscape" variable in the namespace of this library.
 *
 * Producing no output, the following context variable will be available
 * each time this macro is referenced (assuming you import this library in
 * your templates with the namespace 'spring'):
 *
 *   spring.status : a BindStatus instance holding the command object name,
 *   expression, value, and error messages and codes for the path supplied
 *
 * @param path : the path (string value) of the value required to bind to.
 *   Spring defaults to a command name of "command" but this can be overridden
 *   by user config.
 -->
<#macro bind path>
    <#if htmlEscape?exists>
        <#assign status = springMacroRequestContext.getBindStatus(path, htmlEscape)>
    <#else>
        <#assign status = springMacroRequestContext.getBindStatus(path)>
    </#if>
</#macro>

<#--
 * spring:bindEscaped
 *
 * Similar to spring:bind, but takes an explicit HTML escape flag rather
 * than relying on the default HTML escape setting.
 -->
<#macro bindEscaped path, htmlEscape>
    <#assign status = springMacroRequestContext.getBindStatus(path, htmlEscape)>
</#macro>

<#--
 * formInput
 *
 * Display a form input field of type 'text' and bind it to an attribute
 * of a command or bean.
 *
 * @param path the name of the field to bind to
 * @param attributes any additional attributes for the element (such as class
 *        or CSS styles or size
 -->
<#macro formInput path attributes="" fieldType="text">
    <@bind path/>
    <#if spring.status.errorMessages!?size gt 0>
	    <input class="txtinput inputInvalid" type="${fieldType}" name="${spring.status.expression}"
	           value="${spring.status.value?default("")}" ${attributes} <@closeTag/>
    <#else>
	    <input class="txtinput inputValid" type="${fieldType}" name="${spring.status.expression}"
	           value="${spring.status.value?default("")}" ${attributes} <@closeTag/>
    </#if>
</#macro>

<#macro formInput2 path attributes="" additionalclass="" fieldType="text">
    <@bindEscaped path, true/>
    <#if spring.status.errorMessages!?size gt 0>

    <@showErrors "<br/>"/>
    <input class="inputInvalid ${additionalclass}" type="${fieldType}" name="${spring.status.expression}"
           value="${spring.status.value?default("")}" ${attributes} <@closeTag/>
    <#else>
    <input class="inputValid ${additionalclass}" type="${fieldType}" name="${spring.status.expression}"
           value="${spring.status.value?default("")}" ${attributes} <@closeTag/>
    </#if>
</#macro>

<#--
 * formInputListing
 *
 * Display a form input field of type 'text' and bind it to an attribute
 * of a command or bean.
 *
 * @param path the name of the field to bind to
 * @param attributes any additional attributes for the element (such as class
 *        or CSS styles or size
 -->
<#macro formInputListing path attributes="" fieldType="text">
    <@bindEscaped path, true/>
    <#if spring.status.errorMessages!?size gt 0>
    <input type="${fieldType}" name="${spring.status.expression}"
           value="${spring.status.value?default("")}" ${attributes} <@closeTag/>
    <#else>
    <input type="${fieldType}" name="${spring.status.expression}"
           value="${spring.status.value?default("")}" ${attributes} <@closeTag/>
    </#if>
</#macro>


<#--
 * formPasswordInput
 *
 * Display a form input field of type 'password' and bind it to an attribute
 * of a command or bean.  No value will ever be displayed.  This functionality
 * can also be obtained by calling the formInput macro with a 'type' parameter
 * of 'password'
 *
 * @param path the name of the field to bind to
 * @param attributes any additional attributes for the element (such as class
 *        or CSS styles or size
 -->
<#macro formPasswordInput path attributes="" >
    <@formInput path, attributes, "password"/>
</#macro>
<#--
 * formTextarea
 *
 * Display a text area and bind it to an attribute of a command or bean.
 *
 * @param path the name of the field to bind to
 * @param attributes any additional attributes for the element (such as class
 *        or 
 styles or size
 -->
<#macro formTextarea path attributes="" >
    <@bind path/>
<textarea class="txtinput" rows="10"
          name="${spring.status.expression}" ${attributes}>${spring.status.value?default("")}</textarea>
</#macro>

<#macro formTextarea2 path attributes="" >
    <@bind path/>
<textarea name="${spring.status.expression}" ${attributes}>${spring.status.value?default("")}</textarea>
</#macro>

<#--
 * formSingleSelect
 *
 * Show a selectbox (dropdown) input element allowing a single value to be chosen
 * from a list of options.
 *
 * @param path the name of the field to bind to
 * @param options a map (value=label) of all the available options
 * @param attributes any additional attributes for the element (such as class
 *        or CSS styles or size
-->
<#macro formSingleSelect path options attributes="">
    <@bind path/>
<select name="${spring.status.expression}" ${attributes}>
    <#list options?keys as value>
        <option value="${value}"
                <#if spring.status.value?default("") == value>selected="true"</#if>>${options[value]}</option>
    </#list>
</select>
</#macro>

<#--
 * formMultiSelect
 *
 * Show a listbox of options allowing the user to make 0 or more choices from
 * the list of options.
 *
 * @param path the name of the field to bind to
 * @param options a map (value=label) of all the available options
 * @param attributes any additional attributes for the element (such as class
 *        or CSS styles or size
-->
<#macro formMultiSelect path options attributes="">
    <@bind path/>
<select multiple="multiple" name="${spring.status.expression}" ${attributes}>
    <#list options?keys as value>
        <#assign isSelected = contains(spring.status.value?default([""]), value)>
        <option value="${value}" <#if isSelected>selected="true"</#if>>${options[value]}</option>
    </#list>
</select>
</#macro>

<#--
 * formRadioButtons
 *
 * Show radio buttons.
 *
 * @param path the name of the field to bind to
 * @param options a map (value=label) of all the available options
 * @param separator the html tag or other character list that should be used to
 *        separate each option.  Typically '&nbsp;' or '<br>'
 * @param attributes any additional attributes for the element (such as class
 *        or CSS styles or size
-->
<#macro formRadioButtons path options separator attributes="">
    <@bind path/>
    <#list options?keys as value>
            <input type="radio" name="${spring.status.expression}" value="${value}"
                   <#if spring.status.value?default("") == value>checked="checked"</#if> ${attributes}
        <@closeTag/>
    ${options[value]}${separator}
    </#list>
</#macro>



<#--
 * formCheckboxes
 *
 * Show checkboxes.
 *
 * @param path the name of the field to bind to
 * @param options a map (value=label) of all the available options
 * @param separator the html tag or other character list that should be used to
 *        separate each option.  Typically '&nbsp;' or '<br>'
 * @param attributes any additional attributes for the element (such as class
 *        or CSS styles or size
-->


<#macro formCheckboxes path options separator attributes="">
    <@bind path/>
    <#list options as value>
        <#assign id="${status.expression}${value_index}">
        <#assign tmp = spring.status.value?default(" ")>
        <#if tmp?contains(value) >
            <#assign isSelected = true>
        <#else>
            <#assign isSelected = false>
        </#if>
        <div class="checkdiv">
            <input type="checkbox" id="${id}" name="${status.expression}" value="${value?html}"<#if isSelected>
                   checked="checked"</#if> ${attributes}<@closeTag/>
            <label for="${id}">${value!}${separator}</label>
       </div>
    </#list>
</#macro>


<#--
* checkboxes
*
* Show checkboxes.
*
* @param path the name of the field to bind to
* @param options a map (value=label) of all the available options
* @param attributes any additional attributes for the element (such as class or CSS styles or size)
-->
<#macro checkboxes path options attributes="">
    <@bind path/>
    <#list options?keys as value>
        <#assign id="${spring.status.expression?replace('[','')?replace(']','')}${value_index}">
        <#assign isSelected = spring.contains(spring.status.actualValue?default([""]), value)>
    <div class="control-group">

        <div class="controls">
            <input type="checkbox" id="${id}" name="${spring.status.expression}" value="${value?html}"<#if isSelected> checked="checked"</#if> ${attributes}>
            <label class="control-label" for="${id}">${options[value]?html}</label>
        </div>
    </div>
    </#list>
<input type="hidden" name="_${spring.status.expression}" value="on"/>
</#macro>

<#--
 * formCheckboxesFeatures
 *
 * Show checkboxes.
 *
 * @param path the name of the field to bind to
 * @param options a map (value=label) of all the available options
 * @param separator the html tag or other character list that should be used to
 *        separate each option.  Typically '&nbsp;' or '<br>'
 * @param attributes any additional attributes for the element (such as class
 *        or CSS styles or size
-->


<#macro formCheckboxesFeatures path options separator attributes="">
    <@bind path/>
    <#list options as feature>
        <#assign id="${status.expression}${feature_index}">
        <#assign tmp = spring.status.value?default(" ")>
        <#if tmp?contains(feature.id) >
            <#assign isSelected = true>
        <#else>
            <#assign isSelected = false>
        </#if>
            <div class="checkdiv">
                <input class="exInput" type="checkbox" id="${id}" name="${status.expression}" value="${feature.id?html}"<#if isSelected>
                       checked="checked"</#if> ${attributes}<@closeTag/>
                <label class="exLabel" for="${id}">${feature.name!}${separator}</label>
            </div>
    </#list>
</#macro>


<#macro formCheckbox path attributes="">
    <@spring.bind path />
<input type="hidden" name="_${spring.status.expression}" value="false"/>
        <input type="checkbox" id="${spring.status.expression}" name="${spring.status.expression}" value="true" 
               <#if spring.status.value?? && spring.status.value?string=="true">checked="true"</#if>
${attributes}
    <@spring.closeTag/>
</#macro>

<#macro formCheckbox2 path attributes="">
    <@spring.bind path />

        <input type="checkbox" id="${spring.status.expression}" name="${spring.status.expression}" value="true"
               <#if spring.status.value?? && spring.status.value?string=="true">checked="true"</#if>
${attributes}
    <@spring.closeTag/>

</#macro>



<#macro formRadiobox path value attributes="">
    <@spring.bind path />
        <input type="radio" id="${spring.status.expression}" name="${spring.status.expression}" value="${value}"
               <#if spring.status.value?? && spring.status.value?string==value>checked="true"</#if>
${attributes}
    <@spring.closeTag/>
</#macro>

<#--
 * showErrors
 *
 * Show validation errors for the currently bound field, with
 * optional style attributes.
 *
 * @param separator the html tag or other character list that should be used to
 *        separate each option. Typically '<br>'.
 * @param classOrStyle either the name of a CSS class element (which is defined in
 *        the template or an external CSS file) or an inline style.  If the value passed in here
 *        contains a colon (:) then a 'style=' attribute will be used, else a 'class=' attribute
 *        will be used.
-->
<#macro showErrors separator classOrStyle="">
    <#list spring.status.errorMessages?sort as error>
        <#if classOrStyle == "">
        <span style="color: #f00;">${error}</span>
        <#else>
            <#if classOrStyle?index_of(":") == -1>
                <#assign attr="class">
            <#else>
                <#assign attr="style">
            </#if>
        <span style="color: #f00;" ${attr}="${classOrStyle}">${error}</span>
        </#if>${separator}
    </#list>
</#macro>

<#--
 * listContains
 *
 * Macro to return true if the list contains the scalar, false if not.
 * Surprisingly not a FreeMarker builtin. This function is used internally but
 * can be accessed by user code if required.
 *
 * @param list the list to search for the item
 * @param item the item to search for in the list
 * @return true if item is found in the list, false otherwise.
-->
<#function contains list item>
    <#list list as nextInList>
        <#if nextInList == item><#return true></#if>
    </#list>
    <#return false>
</#function>

<#--
 * closeTag
 *
 * Simple macro to close an HTML tag that has no body with '>' or '/>',
 * depending on the value of a 'xhtmlCompliant' variable in the namespace
 * of this library.
-->
<#macro closeTag>
    <#if xhtmlCompliant?exists && xhtmlCompliant>/><#else>></#if>
</#macro>

<#macro formHidden path attributes="">
    <@bind path/>
	    <input class="txtinput inputValid" type="hidden" name="${spring.status.expression}"
	           value="${spring.status.value?default("")}" ${attributes} <@closeTag/>
</#macro>


<#--
 * formSingleSelect
 *
 * Show a selectbox (dropdown) input element allowing a single value to be chosen
 * from a list of options.
 *
 * @param path the name of the field to bind to
 * @param options a map (value=label) of all the available options
 * @param attributes any additional attributes for the element (such as class
 *        or CSS styles or size
-->
<#macro formSingleSelectFromList path options attributes="">
    <@bind path/>
	<select name="${spring.status.expression}" ${attributes}>
	    <#list options as value>
	        <option value="${value}" <#if spring.status.value?default("") == value>selected="true"</#if>>${value}</option>
	    </#list>
	</select>
</#macro>

