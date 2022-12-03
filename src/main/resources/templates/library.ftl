<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8">
    <title>Библиотека</title>
<body>
<div>
    <div>
        <h2>Количество наших читателей уже : ${readers}</h2>
    </div>
    <#if books?has_content>
        <#list books as book>
            <a href="/book-info/${book.bookCode}">
                <img src="/img/${book.fileName}" width="300" height="450" alt="Изображение не отображается">
            </a>
            <div>
                <span>${book.title}</span>
            </div>
            <div>
                <span>${book.author}</span>
            </div>
            <div>
                <span>${book.release}</span>
            </div>
            <div>
                <span>${book.publisher}</span>
            </div>
            <div>
                <span>${book.numberOfCopies}</span>
            </div>
            <div>
                <span>${book.price}</span>
            </div>
            <div>
                <span>${book.volume}</span>
            </div>
        </#list>
    <#else>
        <span>В библиотеке отсутствуют изображения</span>
    </#if>
</div>
<div>
    <a href="/readers">Просмотреть читателей</a>
</div>
<div>
    <a href="/add-book">Добавить книгу</a>
</div>
<div>
    <a href="/add-reader">Добавить читателя</a>
</div>
</body>
</head>
</html>