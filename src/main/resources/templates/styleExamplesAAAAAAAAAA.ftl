<#import "parts/common.ftl" as c>
<#include "parts/security.ftl">

<@c.page>
<div style="text-align: center; font-size: 200%">${message?ifExists}</div>

    <#if isAdmin>
        <div>
            Добавить пример
            <form action="/addExample" method="post" enctype="multipart/form-data">
                <input type="text" name="exampleDesc" placeholder="Введите описание" />
                <input type="hidden" name="styleId" value="${styleId}" />
                <input type="file" name="file">
                <input type="hidden" name="_csrf" value="${_csrf.token}" />
                <button type="submit">Добавить</button>
            </form>
        </div>
    </#if>

    <#list examples as example>
        <div class = "row" style = "margin: 3% 10% 0 10%;">
            <div class = "col-5">
                <img src="/catExamples/${example.exampleImage}">
            </div>
            <div class = "col-7 my-auto">
                ${example.exampleDesc}
            </div>
        </div>
    </#list>

</@c.page>