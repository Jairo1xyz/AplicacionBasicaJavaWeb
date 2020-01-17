<%-- 
    Document   : nuevo
    Created on : 14/01/2020, 12:22:22 PM
    Author     : Jairo
--%>

<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h2 align="center">Registro de usuario</h2>
        <form action="">
            <table border="1" width="250" align="center">
                <tr>
                    <td>Código:</td>
                    <td><input type="text" name="codigo"></td>
                </tr>
                <tr>
                    <td>Nombre:</td>
                    <td><input type="text" name="nombre"></td>
                </tr>
                <tr>
                    <td>Edad:</td>
                    <td><input type="text" name="edad"></td>
                </tr>
                <tr>
                    <td>Sexo:</td>
                    <td><input type="text" name="sexo"></td>
                </tr>
                <tr>
                    <td>Password:</td>
                    <td><input type="text" name="password"></td>
                </tr>
                <tr>
                    <td colspan="2" align="center"><input type="submit" name="grabar" value="Grabar Usuario"></td>
                </tr>
            </table>
        </form>
        <%
            if(request.getParameter("grabar")!=null){
                String codigo=request.getParameter("codigo");
                String nombre=request.getParameter("nombre");
                int edad=Integer.parseInt(request.getParameter("edad"));
                String sexo=request.getParameter("sexo");
                String password=request.getParameter("password");

                Connection cnx=null;
                ResultSet rs=null;
                Statement sta=null;

                try{
                    Class.forName("com.mysql.jdbc.Driver");
                    cnx=DriverManager.getConnection
                    ("jdbc:mysql://localhost/cursojsp?user=root&password=");

                    sta=cnx.createStatement();

                    sta.executeUpdate("INSERT INTO USUARIOS VALUES('"+
                        codigo+"','"+nombre+"',"+edad+",'"+sexo+"','"+password+"')");
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                }catch(Exception e){
                    out.println("Error: "+e.getMessage()+" e:"+e);
                }
            }
        %>
    </body>
</html>
