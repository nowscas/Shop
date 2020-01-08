<#import "parts/common.ftl" as c>
<#include "parts/security.ftl">

<@c.page>
<link rel="stylesheet" href="/static/exampleStyle.css">

<div style="text-align: center; font-size: 300%">${styleName?ifExists}</div>
<div style="text-align: center; font-size: 200%; margin-top: 2%;">${styleDesc?ifExists}</div>
<div style="text-align: center; font-size: 200%">${message?ifExists}</div>

    <#if isAdmin>
        <div style="margin:3% 25% 0 25%; width: 50%;">
            <div class = "formLabel">Добавить пример</div>

            <div style="text-align: center; font-size: 200%; color: red">${message?ifExists}</div>

            <form action="/addExample" method="post" enctype="multipart/form-data">
                <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                <input type="hidden" name="styleId" value="${styleId}" />
                <div style = "text-align: center;">
                    <input type="file" name="file">
                    <input type="submit" value="Добавить пример"/>
                </div>
            </form>
        </div>
    </#if>

    <div class = "container">
        <div class = "card-deck">
            <#list examples as example>
                <div class="card my-3" data-toggle="modal" data-target="#${example.id}exampleModalCenter">
                    <a><img src="/catExamples/${example.fileName}" class="card-img-top"></a>
                </div>

                <div class="modal fade" id="${example.id}exampleModalCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
                    <div class="modal-dialog modal-dialog-centered">
                        <div class="modal-content">
                            <div class="modal-header">
                                <#if isAdmin>
                                    <form action="/addExampleImage" method="post" enctype="multipart/form-data">
                                        <label for="file">Загрузить новое изображение</label>
                                        <input name="file" type="file" onchange="this.form.submit();">
                                        <input type="hidden" name="exampleId" value="${example.id}">
                                        <input type="hidden" name="styleId" value="${styleId}"">
                                        <input type="hidden" name="_csrf" value="${_csrf.token}" />
                                    </form>
                                </#if>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div class="modal-body">
                                <div id="${example.id}carouselExampleControls" class="carousel slide" data-ride="carousel">
                                    <div class="carousel-inner">
                                        <#list example.exampleImages as image>
                                            <#if image_has_next>
                                                <div class="carousel-item">
                                                    <img class="d-block w-100" src="/catExamplesImages/${image.fileName}">
                                                </div>
                                            <#else>
                                                <div class="carousel-item active">
                                                    <img class="d-block w-100" src="/catExamplesImages/${image.fileName}">
                                                </div>
                                            </#if>
                                        </#list>
                                    </div>
                                    <a class="carousel-control-prev" href="#${example.id}carouselExampleControls" role="button" data-slide="prev">
                                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                                    <span class="sr-only">Previous</span>
                                    </a>
                                    <a class="carousel-control-next" href="#${example.id}carouselExampleControls" role="button" data-slide="next">
                                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                                    <span class="sr-only">Next</span>
                                    </a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </#list>
         </div>
    </div>
</@c.page>