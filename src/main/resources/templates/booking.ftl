<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Бронирование книги ${book.title}</title>
</head>
<body>
<div>
    <form name="reader" action="/booking" method="post">
        <label> Выберите читателя для кого хотите забронировать
            <select name="reader" required>
                <#if readers?has_content>
                    <#list readers as reader>
                        <option>${reader.fio}</option>
                    </#list>
                <#else>
                    <h2>Читателей пока нет</h2>
                </#if>
            </select>
        </label>
        <label for="dateForBooking"> Дата бронирования
            <input type="date" name="bookingDate" required>
        </label>
        <input type="text" name="bookCode" value="${book.bookCode}" hidden required>
        <#if book.numberOfCopies gt 0>
            <input name="send" type="submit" value="Забронировать">
        <#else>
            <span>Данную книгу невозможно забронировать или выдать</span>
        </#if>
    </form>
</div>
<div>
    <form name="reader" action="/unbooking" method="post">
        <label> Выберите читателя для кого хотите разбронировать
            <select name="reader" required>
                <#if readers?has_content>
                    <#list readers as reader>
                        <option>${reader.fio}</option>
                    </#list>
                <#else>
                    <h2>Читателей пока нет</h2>
                </#if>
            </select>
        </label>
        <label> Выберите забронированные книги для разбронирования
            <select name="reader" required>
                <#if bookings?has_content>
                    <#list bookings as booking>
                        <option>${booking.book.title}</option>
                    </#list>
                <#else>
                    <h2>Забронированных книг еще нет</h2>
                </#if>
            </select>
        </label>
        <label for="dateForBooking"> Дата бронирования
            <input type="date" name="bookingDate" required>
        </label>
        <input type="text" name="bookCode" value="${book.bookCode}" hidden required>
        <#if book.numberOfCopies gt 0>
            <input name="send" type="submit" value="Разбронировать">
        <#else>
            <span>Данную книгу невозможно забронировать или выдать</span>
        </#if>
    </form>
</div>
</body>
</html>