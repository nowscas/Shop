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