<#import "parts/common.ftl" as c>
<#include "parts/security.ftl">

<@c.page>
    <#if isAdmin>
        <div>
            Добавить стиль
            <form action="/addCategoryStyle" method="post" enctype="multipart/form-data">
                <input type="text" name="categoryStyleName" placeholder="Введите название" />
                <input type="text" name="categoryStyleDesc" placeholder="Введите описание" />
                <input type="hidden" name="categoryId" value="${categoryId}" />
                <input type="file" name="file">
                <input type="hidden" name="_csrf" value="${_csrf.token}" />
                <button type="submit">Добавить</button>
            </form>
        </div>
    </#if>

    <#list styles as style>
    <div>
        <img src="/catImg/${style.styleImage}">
    </div>
    </#list>
</@c.page>