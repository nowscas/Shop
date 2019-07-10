<#import "parts/common.ftl" as c>
<#include "parts/security.ftl">

<@c.page>

<link rel="stylesheet" href="/static/mainPageStyle.css">

    <div class = "container">
        <div class = "mainImage">
            <img src="/img/testMainImage.png" width="100%">
        </div>
        <form method="get">
            <button type="submit" formaction="/contacts" class="btn btn-outline-dark underImageLeftButtons">Позвонить нам</button>
            <button type="submit" formaction="/calculator" class="btn btn-outline-dark underImageRightButtons">Заказать просчет</button>
        </form>
    </div>

    <div class = "container secondLayer">
         <div class = "assortLabel"><h3>Ассортимент</h3></div>

         <#if isAdmin>
             <div class = "addForm">
                 <div class = "formLabel">Добавить категорию</div>
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
         </#if>

         <div class = "card-deck assortCategories">
            <#list categories as category>
                <div class="card my-3" style = "min-width: 26%; max-width: 26%; margin-left: 16%">
                    <div class="card-header">
                        ${category.categoryName}
                    </div>
                    <a href="/categoryPage/${category.id}"><img src="/catImg/${category.fileName}" class="card-img-top"></a>
                </div>
            </#list>
         </div>
    </div>
</@c.page>