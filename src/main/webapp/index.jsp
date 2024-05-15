<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <title>Школа математики "Smarty"</title>
</head>
<body>

<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <form action="registration" method="post">
                <div class="mb-3">
                    <label for="name" class="form-label">Имя</label>
                    <input type="text" class="form-control" id="name" name="name" placeholder="Введите имя">
                </div>
                <div class="mb-3">
                    <label for="lastname" class="form-label">Фамилия</label>
                    <input type="text" class="form-control" id="lastname" name="lastname" placeholder="Введите фамилию">
                </div>
                <div class="mb-3">
                    <label for="subject" class="form-label">Предмет</label>
                    <input type="text" class="form-control" id="subject" name="subject" placeholder="Введите предмет">
                </div>
                <div class="mb-3">
                    <label for="age" class="form-label">Возраст</label>
                    <input type="number" class="form-control" id="age" name="age" placeholder="Введите возраст">
                </div>
                <div class="mb-3">
                    <label for="contact" class="form-label">Контактная информация</label>
                    <input type="text" class="form-control" id="contact" name="contact" placeholder="Введите контактную информацию">
                </div>
                <div class="container d-flex justify-content-between">
                    <button type="submit" class="btn btn-primary me-2">Добавить</button>
                    <button type="submit" formaction="change" formmethod="post" class="btn btn-primary mx-2">Обновить</button>
                </div>
            </form>
            <div class="container d-flex justify-content-between" style="margin-top: 20px">
                <form action="delete" method="post" class="me-2">
                    <button type="submit" class="btn btn-primary">Удалить</button>
                </form>

                <form action="registration" method="get" class="mx-2">
                    <button type="submit" class="btn btn-primary">Посмотреть таблицу</button>
                </form>
            </div>

        </div>

    </div>
</div>

<script src="js/bootstrap.bundle.min.js"></script>
</body>
</html>
