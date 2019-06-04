
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
    <h3>
        <?php
            $name = $_POST["Name"];
            $sSurname = $_POST["surname"];
            $sSchool = $_POST["school"];
            $age = $_POST["age"];
            $quantity = $_POST["quant"];
            echo $name;
        ?>

    </h3>
</body>
</html>