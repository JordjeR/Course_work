<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Информация о книге ${book.title}</title>
</head>
<body>
<img src="/img/${book.fileName}" width="300" height="450" alt="Изображение не загрузилось">
<div>
    <strong>Название:</strong> ${book.title}
</div>
<div>
    <strong>Автор:</strong> ${book.author}
</div>
<div>
    <strong>Дата выпуска:</strong> ${book.release}
</div>
<div>
    <strong>Издатель:</strong> ${book.publisher}
</div>
<div>
    <strong>Количество копий:</strong> ${book.numberOfCopies}
</div>
<div>
    <strong>Цена:</strong> ${book.price}
</div>
<div>
    <strong>Количество страниц:</strong> ${book.volume}
</div>
<div>
    <#assign deliverySize = book.getDeliveries()?size>
    <#if deliverySize gt 0>
        <p>${deliverySize} экзмепляров книг было выдано</p>
    <#else>
        <p>Пока ни одной книги не было выдано</p>
    </#if>
</div>
<div>
    <#assign bookingSize = book.getBooking()?size>
    <#if bookingSize gt 0>
        <p>${bookingSize} экзмепляров книг было забронировано</p>
        Такими читателями как:
        <#list bookingReaders as reader>
            <p><i>${reader}</i></p>
        </#list>
    <#else>
        <p>Ни одной книги не было забронировано</p>
    </#if>
</div>
<div>
    <#if book.numberOfCopies gt 0>
        <#if readers?has_content>
            <span>Выберите читателя, для кого будет проводиться бронирование или выдача*</span>
            <select id="select" onchange="saveValueInInput(this)" required>
                <#list readers as reader>
                    <option selected value="${reader.libraryCardNumber}">${reader.fio}</option>
                </#list>
            </select>
        <#else>
            Читателей пока нет в библиотеке
        </#if>
        <button type="button" id="btn-booking" onclick="doAction(this)">Бронирование</button>
        <button type="button" id="btn-delivery" onclick="doAction(this)">Выдача</button>

        <input type="date" id="calendar" onchange="saveDateInInput()" class="calendar-hidden-element" name="date" required hidden>

        <button type="button" id="btn-cancel-booking" class="booking-hidden-element" onclick="cancelAction(this)" hidden>Отменить бронирование</button>
        <form method="post" class="booking-hidden-element" action="/booking/${book.bookCode}">
            <input type="date" class="date-value" name="date" value="date" hidden>
            <input type="text" class="library-card-number-value" name="libraryCardNumber" value="libraryCardNumber" hidden>
            <input type="submit" id="btn-booking" class="booking-hidden-element" name="booking" value="Забронировать" hidden>
        </form>

        <#------------------------------------------------------------------------------------------------------------>

        <button type="button" id="btn-cancel-delivery" class="delivery-hidden-element" onclick="cancelAction(this)" hidden>Отменить выдачу</button>
        <form method="post" class="delivery-hidden-element" action="/delivery/${book.bookCode}">
            <input type="date" class="date-value" name="date" value="date" hidden>
            <input type="text" class="library-card-number-value" name="libraryCardNumber" value="libraryCardNumber" hidden>
            <input type="submit" id="btn-delivery" class="delivery-hidden-element" name="delivery" value="Выдать" hidden>
        </form>
    <#else>
        <p>Экземпляра к бронированию или выдаче - отсутствуют</p>
    </#if>

    <a href="/library">Вернуться в библиотеку</a>
</div>
</body>
<script>
    const bookingHiddenElementsCollection = document.getElementsByClassName('booking-hidden-element');
    const deliveryHiddenElementsCollection = document.getElementsByClassName('delivery-hidden-element');

    const btnBooking = document.getElementById('btn-booking');
    const btnDelivery = document.getElementById('btn-delivery');

    const calendar = document.getElementById('calendar');
    const select = document.getElementById('select');

    const dateValue = document.getElementsByClassName('date-value');
    const libraryCardNumValue = document.getElementsByClassName('library-card-number-value');

    calendar.setAttribute('min', (new Date()).toISOString().slice(0,10));

    function saveDateInInput() {
        for (let dateVal of dateValue) {
            dateVal.value = calendar.value;
        }
    }

    function saveValueInInput(selectedValue) {
        for (let libCardNumVal of libraryCardNumValue) {
            libCardNumVal.value = selectedValue.value;
        }
    }

    function doAction(btn) {
        if (btn.id.includes('booking')) {
            for (let element of bookingHiddenElementsCollection)
                element.removeAttribute('hidden');
        } else {
            for (let element of deliveryHiddenElementsCollection)
                element.removeAttribute('hidden');
        }
        calendar.removeAttribute('hidden');
        btnBooking.setAttribute('hidden', true);
        btnDelivery.setAttribute('hidden', true);
    }

    function cancelAction(btn) {
        if (btn.id.includes('booking')) {
            for (let element of bookingHiddenElementsCollection)
                element.setAttribute('hidden', true);
        } else {
            for (let element of deliveryHiddenElementsCollection)
                element.setAttribute('hidden', true);
        }
        calendar.setAttribute('hidden', true);
        btnBooking.removeAttribute('hidden');
        btnDelivery.removeAttribute('hidden');
    }
</script>
</html>