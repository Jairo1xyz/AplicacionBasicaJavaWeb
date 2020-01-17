<%-- 
    Document   : index
    Created on : 13/01/2020, 09:49:15 PM
    Author     : Jairo
--%>

<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Página</title>
    </head>
    <body>
        <h1>Tipos de datos:</h1>
        <%
            String nom = "Max";
            int edad = 29;
            double sueldo = 4000.00;
            
            out.println("Nombre: "+nom+"<br>");
            out.println("Edad: "+edad+"<br>");
            out.println("Sueldo: "+sueldo+"<br>");
        %>
        <h2>Formulario de datos:</h2>
        <form action="resultados.jsp" method="get">
            Producto:
            <select name="producto">
                <option value="Televisor">Televisor</option>
                <option value="Radio">Radio</option>
                <option value="Cocina">Cocina</option>
            </select><br>
            Precio:<input type="text" name="precio"><br>
            Cantidad:<input type="text" name="cantidad"><br>
            <input type="submit" name="enviar" value="Enviar Datos"><br>
            
        </form>
        <br><br>
        <h2 align="center">Listado de usuarios</h2>
        <table border="1" width="600" align="center">
            <tr bgcolor="skyblue">
                <th colspan="5">Mantenimiento de usuarios</th>
                <th><a href="nuevo.jsp"><img src="icons/add_user.png" width="40"></a></th>
            </tr>
            <tr bgcolor="skyblue">
                <th>Código</th>
                <th>Nombre</th>
                <th>Edad</th>
                <th>Sexo</th>
                <th>Password</th>
                <th>Acción</th>
            </tr>
            <%
            Connection cnx=null;
            Statement sta=null;
            ResultSet rs=null;
            
            try{
                Class.forName("com.mysql.jdbc.Driver");
                cnx=DriverManager.getConnection
        ("jdbc:mysql://localhost/cursojsp?user=root&password=");
                sta=cnx.createStatement();
                rs=sta.executeQuery("select * from usuarios");
                
                while(rs.next()){
                    %>
                    <tr>
                        <td><%=rs.getString(1)%></td>
                        <td><%=rs.getString(2)%></td>
                        <td><%=rs.getString(3)%></td>
                        <td><%=rs.getString(4)%></td>
                        <td><%=rs.getString(5)%></td>
                        <td>
                            <a href="editar.jsp?codigo=<%=rs.getString(1)%>">
                                <img src="icons/edit_user.png" width="30">
                            </a>
                            <a href="eliminar.jsp?codigo=<%=rs.getString(1)%>">
                                <img src="icons/delete_user.png" style="float: right" width="30">
                            </a>
                        </td>
                    </tr>
            <%
                }
                sta.close();
                rs.close();
                cnx.close();
            }catch(Exception e){
                out.println("Error al establecer conexión con la base de datos: "+e.getMessage()+" "+e.getCause());
            }
            %>
        </table>
    </body>
</html>

