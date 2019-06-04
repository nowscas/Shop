<#import "parts/common.ftl" as c>

<@c.page>
    <div>
        Добавить категорию
        <form action="/categories" method="post">
            <input type="text" name="categoryName" placeholder="Введите название" />
            <input type="hidden" name="_csrf" value="${_csrf.token}" />
            <button type="submit">Добавить</button>
        </form>
    </div>
        <#list categories as category>
            <div>
                ${category.categoryName}
            </div>
        </#list>
    <div>

    </div>
</@c.page>