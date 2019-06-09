<#import "parts/common.ftl" as c>
<#include "parts/security.ftl">

<@c.page>

    <link rel="stylesheet" href="/static/categoryPageStyle.css">

    <#if isAdmin>
        <div>
            Добавить стиль
            <form action="/addCategoryStyle" method="post" enctype="multipart/form-data">
                <input type="text" name="categoryStyleName" placeholder="Введите название" />
                <input type="hidden" name="categoryId" value="${categoryId}" />
                <input type="file" name="file">
                <input type="hidden" name="_csrf" value="${_csrf.token}" />
                <button type="submit">Добавить</button>
            </form>
        </div>
    </#if>

    <div class = "container">
        <div class = "card-deck assortCategories">
            <#list styles as style>
                <div class="card my-3">
                    <div class="card-header">
                        ${style.styleName}
                    </div>
                    <a href="/styleExample/${style.id}"><img src="/catImg/${style.styleImage}" class="card-img-top"></a>
                </div>
            </#list>
        </div>
    </div>

</@c.page>