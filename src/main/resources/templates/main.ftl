<#import "parts/common.ftl" as c>

<@c.page>

<link rel="stylesheet" href="/static/mainPageStyle.css">

    <div class = "mainImage">
        <img src="/img/testMainImage.png" width="100%">
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