<#import "parts/common.ftl" as c>

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

         <div class = "card-deck assortCategories">
            <#list cards as card>
                <div class="card my-3" style = "min-width: 26%; max-width: 26%; margin-left: 16%">
                    <div class="card-header">
                        ${card.cardHeader}
                    </div>
                    <img src="/img/${card.cardImagePath}" class="card-img-top">
                    <div class="m-2">
                        ${card.cardText}
                    </div>
                </div>
            </#list>
         </div>
    </div>
</@c.page>