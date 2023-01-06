<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8">
    <title>Библиотека</title>
    <link rel="stylesheet" href="/static/css/style.css">
<body>
<div class="wrapper">
    <div class="header">
       <p class="header_title">
           Библиотека классической литературы
       </p>
        <p class="header_subtitle">
            Количество наших читателей уже ${readers}
        </p>
        <div class="block-buttons">
            <div class="block-buttons_button">
                <a class="button_a" href="/readers">Просмотреть читателей</a>
            </div>
            <div class="block-buttons_button">
                <a class="button_a" href="/add-book">Добавить книгу</a>
            </div>
            <div class="block-buttons_button">
                <a class="button_a" href="/add-reader">Добавить читателя</a>
            </div>
        </div>
    </div>
    <div class="main">
        <div class="catalog">
        <#if books?has_content>
            <#list books as book>
                <div class="block-image">
                    <a href="/book-info/${book.bookCode}">
                        <img class="block-image_image-cover" src="/img/${book.fileName}" alt="Изображение не отображается">
                    </a>
                </div>
                <div class="block-description">
                    <div class="block-description_title">
                        <span>${book.title}</span>
                    </div>
                    Автор:
                    <div class="block-decription_subtitle">
                        <span>${book.author}</span>
                    </div>
                    Дата выпуска:
                    <div class="block-decription_subtitle">
                        <span>${book.release}</span>
                    </div>
                    Издательство:
                    <div class="block-decription_subtitle">
                        <span>${book.publisher}</span>
                    </div>
                    Количество экземпляров:
                    <div class="block-decription_subtitle">
                        <span>${book.numberOfCopies}</span>
                    </div>
                    Цена:
                    <div class="block-decription_subtitle">
                        <span>${book.price}</span>
                    </div>
                    Количество страниц:
                    <div class="block-decription_subtitle">
                        <span>${book.volume}</span>
                    </div>
                </div>
            </#list>
        <#else>
            <span>В библиотеке отсутствуют изображения:(</span>
        </#if>
        </div>
    </div>

</div>

</body>
</head>
</html>