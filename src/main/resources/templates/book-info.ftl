<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Информация о книге ${book.title}</title>
</head>
<body>
<p id="message" hidden></p>
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
    <h3>Таблица выданных</h3>

    <div class="delivery-table">
        <#if deliveries?size gt 0>
            <form id="delivery-form" method="post"></form>
            <div class="table">
                <span class="td">
                    ФИО
                </span>
                <span class="td">
                    Дата выдачи
                </span>
                <#list deliveries as delivery>
                    <div class="tr">
                        <span class="td">
                            ${delivery.reader.fio}
                        </span>
                        <span class="td">
                            ${delivery.dateOfIssue}
                        </span>
                        <span class="td">
                            <button formmethod="post"
                                    formaction="/returnBook/${book.bookCode}/${delivery.issueCode}"
                                    form="delivery-form"
                            >
                                Вернуть
                            </button>
                        </span>
                    </div>
                </#list>
            </div>
        <#else>
            Выданных книг нет.
        </#if>
    </div>

    <h3>Таблица бронирований</h3>

    <div class="booking-table">
        <#if bookings?size gt 0>
            <form id="booking-form" method="post"></form>
            <div class="table">
                <span class="td">
                    ФИО
                </span>
                <span class="td">
                    Дата бронирования
                </span>
                <#list bookings as booking>
                    <div class="tr">
                        <span class="td">
                            ${booking.reader.fio}
                        </span>
                        <span class="td">
                            ${booking.orderDate}
                        </span>
                        <span class="td">
                            <button formmethod="post"
                                    formaction="/unbooking/${book.bookCode}/${booking.bookingСode}"
                                    form="booking-form"
                            >
                                Разбронировать
                            </button>
                        </span>
                        <span class="td">
                            <button formmethod="post"
                                    formaction="/delivery/${book.bookCode}/${booking.reader.libraryCardNumber}/${booking.bookingСode}"
                                    form="booking-form"
                            >
                                Выдать
                            </button>
                        </span>
                    </div>
                </#list>
            </div>
        <#else>
            <p>Забронированных книг нет.</p>
        </#if>
    </div>

    <#if readers?has_content && book.numberOfCopies gt 0>
        <span>Выберите читателя, для кого будет проводиться бронирование или выдача</span>

        <select id="select" onchange="saveValueInInput(this)" required>
            <option selected disabled>Выберите читателя</option>
            <#list readers as reader>
                <option value="${reader.libraryCardNumber}">${reader.fio}</option>
            </#list>
        </select>

        <input type="date" id="calendar" name="date" required hidden>

        <button id="btn-booking" onclick="showElements()">
            Бронирование
        </button>
        <button id="btn-cancel-booking" class="booking-hidden" onclick="hideElements()" hidden>
            Отменить бронирование
        </button>

        <form method="post" class="booking-hidden" action="/booking/${book.bookCode}">
            <input type="date" class="date-value" name="date" hidden>
            <input type="text" class="library-card-number-value" name="libraryCardNumber" hidden>
            <button id="btn-booking" class="booking-hidden" name="booking" onclick="return checkBooking()" hidden>
                Забронировать
            </button>
        </form>

        <form method="post" class="delivery-hidden" action="/delivery/${book.bookCode}">
            <input type="date" class="date-value" name="date" hidden>
            <input type="text" class="library-card-number-value" name="libraryCardNumber" hidden>
            <button onclick="return checkDeliveryButton()">
                Выдать
            </button>
        </form>
    <#else>
        Книг на бронирование или выдачу не осталось
    </#if>
    <a href="/library">Вернуться в библиотеку</a>
</div>
</body>
<script>
    const bookingHiddenElementsCollection = document.getElementsByClassName('booking-hidden');

    const btnBooking = document.getElementById('btn-booking');

    const calendar = document.getElementById('calendar');
    const select = document.getElementById('select');

    const dateValue = document.getElementsByClassName('date-value');
    const libraryCardNumValue = document.getElementsByClassName('library-card-number-value');

    const message = document.getElementById('message');
    const dateNow = (new Date()).toISOString().slice(0, 10);

    if (calendar.value === "") {
        calendar.setAttribute('min', dateNow);
        calendar.value = dateNow;
    }

    function setMessage(text, seconds) {
        message.removeAttribute('hidden');
        message.innerHTML = text;
        setTimeout(function () {
            message.setAttribute('hidden', true);
        }, seconds * 1000);
    }

    function checkBooking() {
        const selectedValue = select.options[select.selectedIndex].text;
        if (selectedValue === 'Выберите читателя') {
            setMessage("Выберите читателя для бронирования книги.", 5);
            return false;
        }
        for (let dateVal of dateValue) dateVal.value = calendar.value;
    }

    function checkDeliveryButton() {
        const numberOfCopies = '${book.numberOfCopies}';
        const readersArray = [<#list bookings as booking>'${booking.reader.fio}', </#list>];
        const selectedValue = select.options[select.selectedIndex].text;
        const isFoundReader = readersArray.includes(selectedValue);
        for (let dateVal of dateValue) dateVal.value = dateNow;

        if (selectedValue === 'Выберите читателя') {
            setMessage("Выберите читателя для выдачи книги.", 5);
            return false;
        }
        if (readersArray.length === 0 && numberOfCopies !== "0") return true;

        if (isFoundReader === true) {
            setMessage("Сначала разбронируйте все забронированные книги или получите их.", 5);
            return false;
        } else if ((isFoundReader === false && numberOfCopies === "0") || isFoundReader === false) {
            setMessage("Книга не может быть выдана читателю '" + selectedValue + "' " +
                "по причине отсутствия экземпляров или предварительного бронирования.", 5);
            return false;
        } else if (isFoundReader === false && numberOfCopies !== "0") return true;
        return true;
    }

    function saveDateInInput() {
        for (let dateVal of dateValue)
            dateVal.value = calendar.value;
    }

    function saveValueInInput(selectedValue) {
        for (let libCardNumVal of libraryCardNumValue)
            libCardNumVal.value = selectedValue.value;
    }

    function showElements() {
        for (let element of bookingHiddenElementsCollection)
            element.removeAttribute('hidden');
        calendar.removeAttribute('hidden');
        btnBooking.setAttribute('hidden', true);
    }

    function hideElements() {
        for (let element of bookingHiddenElementsCollection)
            element.setAttribute('hidden', true);
        calendar.setAttribute('hidden', true);
        btnBooking.removeAttribute('hidden');
    }
</script>
</html>