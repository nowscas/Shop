<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>

<@c.page>
    <div>
        <@l.logout />
        <span><a href="/user">Список пользователей</a></span>
    </div>
    <div>
        <form method="post" enctype="multipart/form-data">
            <input type="text" name="header" placeholder="Введи заголовок" />
            <input type="text" name="text" placeholder="Введи текст" />
            <input type="file" name="file">
            <input type="hidden" name="_csrf" value="${_csrf.token}" />
            <button type="submit">Добавить</button>
        </form>
    </div>

    <div>Список карточек</div>
    <#list cards as card>
    <div>
        <b>${card.id}</b>
        <span>${card.cardHeader}</span>
        <span>${card.cardText}</span>
        <div>
            <#if card.cardImagePath??>
                <img src="/img/${card.cardImagePath}">
            </#if>
        </div>
    </div>
    </#list>
</@c.page>