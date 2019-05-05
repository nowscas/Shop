<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>

<@c.page>
    <div>
        <@l.logout />
    </div>
    <div>
        <form method="post">
            <input type="text" name="header" placeholder="Введи заголовок" />
            <input type="text" name="text" placeholder="Введи текст" />
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
    </div>
    </#list>
</@c.page>