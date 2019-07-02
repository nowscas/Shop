<#import "parts/common.ftl" as c>

<@c.page>

    <div style="margin:5% 10% 5% 10%">
        <div class = "formLabel" style = "text-align: center; font-size: 150%;">Добавить категорию</div>
        <form action="/addCategory" method="post" enctype="multipart/form-data">
            <div class="form-group">
                <label for="formGroupCategoryName">Название</label>
                <input type="text" class="form-control" name="categoryName" placeholder="Введите название">
            </div>
            <input type="hidden" name="_csrf" value="${_csrf.token}"/>
            <div>
                <input type="file" name="file">
                <input type="submit" value="Добавить стиль"/>
            </div>
        </form>
    </div>

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