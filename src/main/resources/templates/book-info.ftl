<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Информация о книге ${book.title}</title>
</head>
<body>
<img src="/img/${book.fileName}" width="300" height="450" alt="Изображение не загрузилось">
<div>
    ${book.title}
</div>
<div>
    ${book.author}
</div>
<div>
    ${book.price}
</div>

<div>
    <form name="reader" action="/booking" method="post">
        <div>
            Выберите читателя для кого хотите забронировать
        </div>
        <select name="reader" required>
            <#list readers as reader>
                <option>${reader.fio}</option>
            </#list>
        </select>
        <label for="dateForBooking">
            Дата бронирования
            <input type="date" name="bookingDate" required>
        </label>
        <input type="text" name="bookCode" value="${book.bookCode}" hidden required>
        <input type="submit" value="Отправить">
    </form>
</div>
</body>
</html>