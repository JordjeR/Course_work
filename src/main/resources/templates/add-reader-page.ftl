<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Добавление нового читателя</title>
</head>
<body>
    <div>
        <form action="/add-reader" method="post">
            <input type="text" name="fio" placeholder="ФИО" required>
            <input type="text" name="address" placeholder="Адрес" required>
            <input type="text" name="phoneNumber" placeholder="Номер телефона" required>
            <input type="submit" name="submit" value="Добавить">
        </form>
    </div>
    <div>
        <a href="/library">Вернуться в библиотеку</a>
    </div>
</body>
</html>