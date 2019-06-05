<#import "parts/common.ftl" as c>

<@c.page>

<div style="text-align: center; font-size: 200%">${message?ifExists}</div>
    <div>
        Добавить категорию
        <form action="/addCategory" method="post" enctype="multipart/form-data">
            <input type="text" name="categoryName" placeholder="Введите название" />
            <input type="text" name="categoryDesc" placeholder="Введите описание" />
            <input type="file" name="file">
            <input type="hidden" name="_csrf" value="${_csrf.token}" />
            <button type="submit">Добавить</button>
        </form>
    </div>
</@c.page>