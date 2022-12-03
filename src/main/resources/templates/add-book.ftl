<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Добавление книги</title>
</head>
<body>
<div>
    <form enctype="multipart/form-data" method="post">
        <input type="text" name="title" placeholder="Введите название" required>
        <input type="text" name="author" placeholder="Введите автора" required>
        <input type="date" name="release" placeholder="Введите дату выпуска" required>
        <input type="text" name="publisher" placeholder="Введите издателя" required>
        <input type="text" name="numberOfCopies" placeholder="Введите кол-во экземпляров" required>
        <input type="text" name="price" placeholder="Введите цену" required>
        <input type="text" name="volume" placeholder="Кол-во страниц" required>
        <input type="file" name="file" required>
        <input type="submit" value="Добавить">
    </form>
</div>
<div>
    <div>
        <a href="/readers">Просмотреть читателей</a>
    </div>
    <div>
        <a href="/library">Вернуться в библиотеку</a>
    </div>
</div>
</body>
</html>