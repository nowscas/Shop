<#import "parts/common.ftl" as c>

<@c.page>

<link rel="stylesheet" href="/static/mainPageStyle.css">

    <div>
        <div class = "mainImage">
            <img src="/img/testMainImage.png" width="100%" height="650px">
        </div>
        <div class = "underImageButtons">
            <button type="button" class="btn btn-outline-dark">Позвонить нам</button>
        </div>
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