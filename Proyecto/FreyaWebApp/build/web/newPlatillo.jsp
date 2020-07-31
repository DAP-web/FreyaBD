<%-- 
    Document   : newPlatillo
    Created on : Jul 30, 2020, 4:02:48 PM
    Author     : Mario
--%>
<html>
    <head>
        <title>New Platillo</title>
        <style>
            h1{
                color: #000000;
                text-align:center;
                font-size: 40px;
            }
            a{
                color:white;
                font-weight: bold;
                font-size: 25px;
            }

        </style>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body bgcolor="#FFDAB9">
        
        <h1>New Platillo</h1>
        <br><br>
        <form action="PlatilloServlet" method="post" style="color:#000000">
            Name:<br>
            <input type="text" id="name" name="name" />
            <br><br>
            Price:<br>
            <input type="text" id="price" name="price" />
            <br><br>
            Description:<br>
            <input type="text" id="description" name="description" />
            <br><br>
        </form>
        

    </body>
</html>
