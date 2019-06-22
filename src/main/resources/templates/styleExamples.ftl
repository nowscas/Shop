<#import "parts/common.ftl" as c>
<#include "parts/security.ftl">

<@c.page>
<link rel="stylesheet" href="/static/exampleStyle.css">

<div style="text-align: center; font-size: 300%">${styleName?ifExists}</div>
<div style="text-align: center; font-size: 200%; margin-top: 5%;">${styleDesc?ifExists}</div>
<div style="text-align: center; font-size: 200%">${message?ifExists}</div>

    <#if isAdmin>
        <div>
            Добавить пример
            <form action="/addExample" method="post" enctype="multipart/form-data">
                <input type="hidden" name="styleId" value="${styleId}" />
                <input type="file" name="file">
                <input type="hidden" name="_csrf" value="${_csrf.token}" />
                <button type="submit">Добавить</button>
            </form>
        </div>
    </#if>

    <div class = "container">
         <div class = "card-deck">
            <#list examples as example>
                <div class="card my-3">
                    <img src="/catExamples/${example.exampleImage}">
                </div>
            </#list>
         </div>
    </div>
</@c.page>