<#import "parts/common.ftl" as c>
<#include "parts/security.ftl">

<@c.page>
<link rel="stylesheet" href="/static/exampleStyle.css">

<div style="text-align: center; font-size: 300%">${styleName?ifExists}</div>
<div style="text-align: center; font-size: 200%; margin-top: 5%;">${styleDesc?ifExists}</div>
<div style="text-align: center; font-size: 200%">${message?ifExists}</div>

    <#if isAdmin>
        <div>
            Добавить пример
            <form action="/addExample" method="post" enctype="multipart/form-data">
                <input type="hidden" name="styleId" value="${styleId}" />
                <input type="file" name="file">
                <input type="hidden" name="_csrf" value="${_csrf.token}" />
                <button type="submit">Добавить</button>
            </form>
        </div>
    </#if>

    <div class = "container">
         <div class = "card-deck">
             <#list examples as example>
                 <div class="card my-3" data-toggle="modal" data-target="#exampleModalCenter">
                     <img src="/catExamples/${example.exampleImage}">
                 </div>

                 <div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
                     <div class="modal-dialog modal-dialog-centered" role="document">
                         <div class="modal-content">
                             <div class="modal-header">
                                 <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                     <span aria-hidden="true">&times;</span>
                                 </button>
                             </div>
                             <div class="modal-body">
                                 <img src="/catExamples/${example.exampleImage}">
                             </div>
                         </div>
                     </div>
                 </div>

            </#list>
         </div>
    </div>
</@c.page>