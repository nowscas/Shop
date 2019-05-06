<#import "parts/common.ftl" as c>

<@c.page>
Редактор пользователя

<form action="/user" method="post">
    <input type="text" name="username" value="${user.username}">
    <label><input type="checkbox" name="blocked" ${user.blocked?string("checked", "")}>Заблокирован</label>

    <input type="hidden" value="${user.id}" name="userId">
    <input type="hidden" value="${_csrf.token}" name="_csrf">
    <button type="submit">Save</button>
</form>
</@c.page>