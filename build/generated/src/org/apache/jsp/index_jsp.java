package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Página</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>Tipos de datos:</h1>\n");
      out.write("        ");

            String nom = "Max";
            int edad = 29;
            double sueldo = 4000.00;
            
            out.println("Nombre: "+nom+"<br>");
            out.println("Edad: "+edad+"<br>");
            out.println("Sueldo: "+sueldo+"<br>");
        
      out.write("\n");
      out.write("        <h2>Formulario de datos:</h2>\n");
      out.write("        <form action=\"resultados.jsp\" method=\"get\">\n");
      out.write("            Producto:\n");
      out.write("            <select name=\"producto\">\n");
      out.write("                <option value=\"Televisor\">Televisor</option>\n");
      out.write("                <option value=\"Radio\">Radio</option>\n");
      out.write("                <option value=\"Cocina\">Cocina</option>\n");
      out.write("            </select><br>\n");
      out.write("            Precio:<input type=\"text\" name=\"precio\"><br>\n");
      out.write("            Cantidad:<input type=\"text\" name=\"cantidad\"><br>\n");
      out.write("            <input type=\"submit\" name=\"enviar\" value=\"Enviar Datos\"><br>\n");
      out.write("            \n");
      out.write("        </form>\n");
      out.write("        <br><br>\n");
      out.write("        <h2 align=\"center\">Listado de usuarios</h2>\n");
      out.write("        <table border=\"1\" width=\"600\" align=\"center\">\n");
      out.write("            <tr bgcolor=\"skyblue\">\n");
      out.write("                <th colspan=\"5\">Mantenimiento de usuarios</th>\n");
      out.write("                <th><a href=\"nuevo.jsp\"><img src=\"icons/add_user.png\" width=\"40\"></a></th>\n");
      out.write("            </tr>\n");
      out.write("            <tr bgcolor=\"skyblue\">\n");
      out.write("                <th>Código</th>\n");
      out.write("                <th>Nombre</th>\n");
      out.write("                <th>Edad</th>\n");
      out.write("                <th>Sexo</th>\n");
      out.write("                <th>Password</th>\n");
      out.write("                <th>Acción</th>\n");
      out.write("            </tr>\n");
      out.write("            ");

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
                    
      out.write("\n");
      out.write("                    <tr>\n");
      out.write("                        <td>");
      out.print(rs.getString(1));
      out.write("</td>\n");
      out.write("                        <td>");
      out.print(rs.getString(2));
      out.write("</td>\n");
      out.write("                        <td>");
      out.print(rs.getString(3));
      out.write("</td>\n");
      out.write("                        <td>");
      out.print(rs.getString(4));
      out.write("</td>\n");
      out.write("                        <td>");
      out.print(rs.getString(5));
      out.write("</td>\n");
      out.write("                        <td>\n");
      out.write("                            <a href=\"editar.jsp?codigo=");
      out.print(rs.getString(1));
      out.write("\">\n");
      out.write("                                <img src=\"icons/edit_user.png\" width=\"30\">\n");
      out.write("                            </a>\n");
      out.write("                            <a href=\"eliminar.jsp?codigo=");
      out.print(rs.getString(1));
      out.write("\">\n");
      out.write("                                <img src=\"icons/delete_user.png\" style=\"float: right\" width=\"30\">\n");
      out.write("                            </a>\n");
      out.write("                        </td>\n");
      out.write("                    </tr>\n");
      out.write("            ");

                }
                sta.close();
                rs.close();
                cnx.close();
            }catch(Exception e){
                out.println("Error al establecer conexión con la base de datos: "+e.getMessage()+" "+e.getCause());
            }
            
      out.write("\n");
      out.write("        </table>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
