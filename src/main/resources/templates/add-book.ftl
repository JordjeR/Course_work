<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Добавление книги</title>
    <link rel="stylesheet" href="/static/css/style.css">
</head>
<body>
<div class="wrapper">
    <div class="header-book">
        <div class="header-book_title" id="divId">
        </div>
        <div class="block-buttons">
            <div class="block-buttons_button">
                <a class="button_a" href="/readers">Просмотреть читателей</a>
            </div>
            <div class="block-buttons_button">
                <a class="button_a" href="/library">Вернуться в библиотеку</a>
            </div>
        </div>
    </div>
    <div class="body-book">
        <form class="body-book_form" enctype="multipart/form-data" method="post">
            <div class="body-book_form_input">
                <input class="form_input" type="text" name="title" placeholder="Введите название книги" required>
            </div>
            <div class="body-book_form_input">
                <input class="form_input" type="text" name="author" placeholder="Введите автора книги" required>
            </div>
            <div class="body-book_form_input">
                <input class="form_input" type="date" name="release" placeholder="Введите дату выпуска книги" required>
            </div>
            <div class="body-book_form_input">
                <input class="form_input" type="text" name="publisher" placeholder="Введите издателя книги" required>
            </div>
            <div class="body-book_form_input">
                <input class="form_input" type="text" name="numberOfCopies" placeholder="Введите кол-во экземпляров" required>
            </div>
            <div class="body-book_form_input">
                <input class="form_input" type="text" name="price" placeholder="Введите цену" required>
            </div>
            <div class="body-book_form_input">
                <input class="form_input" type="text" name="volume" placeholder="Количество страниц в книге" required>
            </div>
            <div class="body-book_form_buttons">
            <div class="buttons_button-file">
                <input class="button-file" type="file" name="file" required>
            </div>
            <div>
                <input class="button-add" type="submit" value="Добавить">
            </div>
            </div>
        </form>
    </div>
</div>
</body>
<script>
    var arr = ['Главное — не научиться читать. Гораздо важнее научиться сомневаться в прочитанном.',
        'Лучший в мире кинозал — это мозг, и ты понимаешь это, когда читаешь хорошую книгу.',
        'Книга — это вечная мысль. Рука, протянутая через десятилетия и века, когда рядом невозможно найти собеседника.',
        'Книги — это друзья, бесстрастные, но верные.',
        'Нельзя держать книги запертыми, точно в тюрьме; они должны непременно переходить из библиотеки в память.',
        'Любовь к книгам – это любовь, которая не требует ни оправдания, ни извинения, ни обороны',
        'Книга – устройство, способное разжечь воображение.'];
    var rand = Math.floor(Math.random() * arr.length);
    document.getElementById("divId").innerHTML = arr[rand];
</script>
</html>