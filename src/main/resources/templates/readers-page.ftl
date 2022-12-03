<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Читатели</title>
</head>
<body>
<div class="readers">
    <#if readers?has_content>
        <#list readers as reader>
            <div>
                ${reader.fio}
            </div>
        </#list>
        <div>
            <a href="/add-reader">Добавить читателя</a>
        </div>
        <div>
            <a href="/library">Вернуться в библиотеку</a>
        </div>
    <#else>
        <div>
            <h2>Читателей в данной библиотеке - нет. Добавить читателей?</h2>
        </div>
        <div>
            <a href="/add-reader">Да</a>
        </div>
        <div>
            <a href="/library">Вернуться в библиотеку</a>
        </div>
    </#if>
</div>


</body>
</html>