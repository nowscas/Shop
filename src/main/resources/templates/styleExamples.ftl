<#import "parts/common.ftl" as c>
<#include "parts/security.ftl">

<@c.page>

    <#if isAdmin>
        <div>
            Добавить пример
            <form action="/" method="post" enctype="multipart/form-data">
                <input type="text" name="exampleDesc" placeholder="Введите описание" />
                <input type="hidden" name="styleId" value="${styleId}" />
                <input type="file" name="file">
                <input type="hidden" name="_csrf" value="${_csrf.token}" />
                <button type="submit">Добавить</button>
            </form>
        </div>
    </#if>

</@c.page>