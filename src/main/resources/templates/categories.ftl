<#import "parts/common.ftl" as c>

<@c.page>

    <a class="nav-link" style="color: #CD0303" href="/addCategory">Добавить категорию</a>
    <#list categories as category>
        <div class="row mb-4">
            <div class="col-2">
                <div style = "padding-top: 40%">
                    ${category.categoryName}
                </div>
            </div>
            <div class="col-4">
                <img src="/catImg/${category.fileName}">
            </div>
        </div>
    </#list>
    <div>

    </div>
</@c.page>