<%-- 
    Document   : resultados
    Created on : 13/01/2020, 10:10:28 PM
    Author     : Jairo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Resultados de venta</h1>
        <% 
            String producto=request.getParameter("producto");
            double precio = Double.parseDouble(request.getParameter("precio"));
            int cantidad = Integer.parseInt(request.getParameter("cantidad"));
            
            double subtotal=cantidad*precio;
            double igv = subtotal*0.18;
            double total = subtotal+igv;
            
        %>
        
        Producto:<%=producto%><br>
        Precio:<%=precio%><br>
        Cantidad:<%=cantidad%><br>
        Subtotal:<%=subtotal%><br>
        IGV:<%=igv%><br>
        Total:<%=total%><br>
        
        <a href="index.jsp">Volver a la página anterior</a>
    </body>
</html>
