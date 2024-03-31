<!DOCTYPE html>
<html>
<head>
    <title>Products</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f2f2f2;
        }

        .container {
            display: flex;
            justify-content: center;
            align-items: flex-start;
            padding: 20px;
        }

        .left-column {
            flex: 1;
            padding: 45px;
            background-color: #fff;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            position: sticky;
            top: 0;

        }

        .right-column {
            flex: 1;
            padding: 20px;
        }

        h1, h3 {
            margin-top: 0;
            color: #333;
        }

        form {
            margin-bottom: 20px;
        }

        input[type="text"],
        input[type="number"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        input[type="submit"] {
            background-color: #007bff;
            color: #fff;
            border: none;
            padding: 10px 20px;
            border-radius: 5px;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #0056b3;
        }

        .product-container {
            background-color: #fff;
            border: 1px solid #ccc;
            border-radius: 5px;
            padding: 15px;
            margin-bottom: 15px;
        }

        .product-title {
            font-size: 18px;
            font-weight: bold;
            color: #333;
        }

        .product-price {
            font-size: 16px;
            color: #555;
        }

        .product-info {
            margin-top: 10px;
            font-size: 14px;
            color: #777;
        }

        .no-products {
            font-size: 18px;
            font-weight: bold;
            color: #555;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="left-column">
        <h1>Products</h1>
        <h3>Создать новый товар</h3>
        <form class="create-product-form" action="/product/create" method="post">
            <label for="title">Название товара:</label><br>
            <input type="text" id="title" name="title"><br><br>
            <label for="description">Описание товара:</label><br>
            <input type="text" id="description" name="description"><br><br>
            <label for="price">Категория товара:</label><br>
            <input type="text" id="category" name="category"><br><br>
            <label for="city">Цена товара:</label><br>
            <input type="number" id="price" name="price"><br><br>
            <label for="author">Количество товара:</label><br>
            <input type="number" id="quantity" name="quantity"><br><br>
            <input type="submit" value="Добавить товар">
        </form>
    </div>

    <div class="right-column">
        <#list products as product>
            <div class="product-container">

                <p>
                    <span class="product-title">${product.title}</span>
                </p>
                <p class="product-info">
                    <b>Описание товара:</b> ${product.description}<br>
                    <b>Категория товара:</b> ${product.category}<br>
                    <b>Цена товара:</b> ${product.price}<br>
                    <b>Количество товара:</b> ${product.quantity}<br>
                    <b>Артикул товара:</b> ${product.id}<br>
                    <b>Дата создания товара:</b> ${product.createTime}<br>
                    <b>Дата изменения количества товара:</b> ${product.lastUpdateQuantity}
                </p>
                <form action="/product/delete" method="post">
                    <input type="hidden" name="id" value="${product.id}">
                    <input type="submit" value="Удалить">
                <form action="/product/update" method="post">
                    <input type="hidden" name="id" value="${product.id}">
                    <label for="newQuantity">Новое количество товара:</label>
                    <input type="number" id="newQuantity" name="newQuantity" min="0" step="1" required>
                    <input type="submit" value="Изменить">
                </form>


            </div>
        <#else>
            <h3 class="no-products">Товаров нет</h3>
        </#list>
    </div>
</div>
</body>
</html>
