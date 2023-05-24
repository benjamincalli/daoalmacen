<%@page import="com.emergentes.modelo.Producto"%>
<%@page import="java.util.List"%>
<%
    List<Producto> producto = (List<Producto>) request.getAttribute("producto");
%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

    </head>
    
    <body>

    <center><table style="border: solid 4px"><tr><td>SEGUNDO PARCIAL TEM-742
                    <p>Nombre:Jhonatan Rodrigo Callisaya Calle</p>
                    <p>Carnet:12638631 </p>
                    
                </td></tr></table></center>
    <center>
        <h1>Gestion de productos</h1>
        <a href="Inicio?action=add">Nuevo producto</a>
        <table border="1">
            <tr>
                <th>Id</th>
                <th>Descripcion</th>
                <th>Cantidad</th>
                <th>Precio</th>
                <th>Categoria</th>
                <th></th>
                <th></th>
            </tr>
            <c:forEach var="item" items ="${producto}">
                <tr>
                    <td>${item.id}</td>
                    <td>${item.descripcion}</td>
                    <td>${item.cantidad}</td>
                    <td>${item.precio}</td>
                    <td>${item.categoria}</td>
                    
                    
                    <td><a href="Inicio?action=edit&id=${item.id}">Editar</a></td>
                    <td><a href="Inicio?action=delete&id=${item.id}">Eliminar</a></td>
                </tr>
            </c:forEach>
        </table>
            </center>
    </body>
</html>