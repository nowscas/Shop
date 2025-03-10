<#import "parts/common.ftl" as c>
<#include "parts/security.ftl">

<@c.page>
<div style="text-align: center; font-size: 200%">${message?ifExists}</div>

    <link rel="stylesheet" href="/static/categoryPageStyle.css">

    <#if isAdmin>
        <div style="margin:5% 10% 0 10%">
            <div class = "formLabel">Добавить стиль</div>
            <form action="/addCategoryStyle" method="post" enctype="multipart/form-data">

                <div style="text-align: center; font-size: 200%; color: red">${message?ifExists}</div>

                <div class="form-group">
                    <label for="formGroupStyleName">Название</label>
                    <input type="text" class="form-control" name="categoryStyleName" placeholder="Введите название">
                </div>
                <div class="form-group">
                    <label for="formGroupStyleDescription">Описание стиля</label>
                    <textarea class="form-control" name="categoryStyleDescription" placeholder="Введите описание" rows="5"></textarea>
                </div>
                <div>
                    <input type="file" name="file">
                    <input type="submit" value="Добавить стиль"/>
                </div>
                <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                <input type="hidden" name="categoryId" value="${categoryId}" />
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
                    <a href="/styleExample/${style.id}"><img src="/catStyle/${style.fileName}" class="card-img-top"></a>
                </div>
            </#list>
        </div>
    </div>

</@c.page>