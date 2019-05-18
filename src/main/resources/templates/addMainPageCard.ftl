<#import "parts/common.ftl" as c>

<@c.page>
<div>
    <form action="/addMainPageCard" method="post" enctype="multipart/form-data">
        <input type="text" name="header" placeholder="Введи заголовок" />
        <input type="text" name="text" placeholder="Введи текст" />
        <input type="file" name="file">
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <button type="submit">Добавить</button>
    </form>
</div>

</@c.page>