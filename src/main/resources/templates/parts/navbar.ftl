<#include "security.ftl">
<#import "login.ftl" as l>

<nav class="navbar navbar-expand-lg navbar-light bg-light" style = "height: 80px">
    <a class="navbar-brand" href="/">Furniture Shop</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link" href="/">Главная</a>
            </li>
        </ul>

        <div class="navbar-text mr-3">${name}</div>
        <#if user??>
            <@l.logout />
        </#if>
    </div>
</nav>
<div style = "text-align: center">
    <a class="nav-link" style = "text-decoration: none; color: black;" href="/"><h1>Мебель не от  бороды </h1></a>
</div>