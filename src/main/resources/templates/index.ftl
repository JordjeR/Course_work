<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8">
    <title>start</title>
<body>
<div>
    <h4>Пока</h4>

    <#if files?has_content>
        <#list files as file>
            <a href="index.ftl">
                <img src="/uploads/${file.name}" width="300" height="300" alt="Изображение не отображается">
            </a>
        </#list>
    <#else>
        <span>В библиотеке отсутствуют изображения</span>
    </#if>
    <div>
        <form enctype="multipart/form-data" method="post">
            <p><input type="file" name="file">
                <input type="submit" value="Отправить"></p>
        </form>
    </div>
    <div>
        <div>
            <a href="/">Добавить читателя</a>
        </div>
        <div>
            <a href="/">Добавить книгу</a>
        </div>
    </div>
</div>
</body>
</head>
</html>