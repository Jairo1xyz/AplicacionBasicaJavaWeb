<%-- 
    Document   : editar
    Created on : 17/01/2020, 05:17:02 AM
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
        <h2 align="center">Editar usuario</h2>
        <%
            String codigo=request.getParameter("codigo");
            Connection cnx=null;
            Statement sta=null;
            ResultSet rs=null;
            
            try{
                Class.forName("com.mysql.jdbc.Driver");
                cnx=DriverManager.getConnection
        ("jdbc:mysql://localhost/cursojsp?user=root&password=");
                sta=cnx.createStatement();
                rs=sta.executeQuery("select * from usuarios where codusu='"+codigo+"'");
                
                while(rs.next()){
        %>
        <form action="">
            <table border="1" width="250" align="center">
                <tr>
                    <td>Código:</td>
                    <td><input type="text" name="codigou" value="<%=rs.getString(1)%>" readonly></td>
                </tr>
                <tr>
                    <td>Nombre:</td>
                    <td><input type="text" name="nombre" value="<%=rs.getString(2)%>"></td>
                </tr>
                <tr>
                    <td>Edad:</td>
                    <td><input type="text" name="edad" value="<%=rs.getString(3)%>"></td>
                </tr>
                <tr>
                    <td>Sexo:</td>
                    <td><input type="text" name="sexo" value="<%=rs.getString(4)%>"></td>
                </tr>
                <tr>
                    <td>Password:</td>
                    <td><input type="text" name="password" value="<%=rs.getString(5)%>"></td>
                </tr>
                <tr>
                    <td colspan="2" align="center"><input type="submit" name="grabar" value="Grabar Usuario"></td>
                </tr>
            </table>
        </form>
        <%
                }
                
            }catch(Exception e){
                out.println("Error al establecer conexión con la base de datos: "+e.getMessage()+" "+e.getCause());
            }
            if(request.getParameter("grabar")!=null){
                String codigou=request.getParameter("codigou");
                String nombreu=request.getParameter("nombre");
                int edadu=Integer.parseInt(request.getParameter("edad"));
                String sexou= request.getParameter("sexo");
                String passwordu=request.getParameter("password");

                sta.executeUpdate("UPDATE USUARIOS SET NOMUSU='"+nombreu+"', EDADUSU="+edadu+", SEXOUSU='"+sexou+"', PASSUSU='"+passwordu+"' WHERE CODUSU='"+codigou+"'");

                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
            %>
    </body>
</html>
