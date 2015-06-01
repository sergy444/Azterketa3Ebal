package com.zubiri.src;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Anadir
 */
@WebServlet("/Anadir")
public class Anadir extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Anadir() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		try {
			
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		
		Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/azterketa", "root", "zubiri");
		
		Statement crea = conexion.createStatement();
		Statement usa = conexion.createStatement();
		Statement tablas = conexion.createStatement();
		Statement inserts = conexion.createStatement();
		
		String crear = "create database if no exists Azterketa;";
		crea.executeUpdate(crear);
		
		String usar = "use Azterketa;";
		usa.executeUpdate(usar);
		
		String dni = request.getParameter("dni");
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String ano = request.getParameter("ano");
		
		
		String tabla = "create table if not exists CLIENTE" +
					 "(dni varchar(10) primary key not null," +
					 "nombre varchar(15)," +
					 "apellido varchar(20)," +
					 "ano_nacimiento varchar(10)" +
					 ");";
		
		tablas.executeUpdate(tabla);
		
		String insert = "insert into CLIENTE (dni, nombre, apellido, ano_nacimiento) values("+ dni + ", " + nombre + ", " + apellido + ", " + ano + ")";
		
		inserts.executeUpdate(insert);
		
		
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Respuesta del servidor</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>Respuesta del formulario </h1>");
		out.println("<p> DNI: " + dni + "</p>");
		out.println("br");
		out.println("<p> Nombre: " + nombre + "</p>");
		out.println("br");
		out.println("<p> Apellido: " + apellido + "</p>");
		out.println("br");
		out.println("<p> Año de nacimiento: " + ano + "</p>");
		out.println("br");
		out.println("<a href='Index.html'>Volver</a>");
		out.println("</body>");
		out.println("</html>");
		
		} catch (InstantiationException e) {
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Respuesta de error</title></head>");
			out.println("Error: " + e);
			out.println("<br>");
			out.println("<a href='Index.html'>Volver</a>");
			out.println("</body>");
			out.println("</html>");
			e.printStackTrace();
			
		} catch (IllegalAccessException e) {
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Respuesta de error</title></head>");
			out.println("Error: " + e);
			out.println("<br>");
			out.println("<a href='Index.html'>Volver</a>");
			out.println("</body>");
			out.println("</html>");
			e.printStackTrace();
			
		} catch (ClassNotFoundException e) {
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Respuesta de error</title></head>");
			out.println("Error: " + e);
			out.println("<br>");
			out.println("<a href='Index.html'>Volver</a>");
			out.println("</body>");
			out.println("</html>");
			e.printStackTrace();
			
		} catch (SQLException e) {
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Respuesta de error</title></head>");
			out.println("Error: " + e);
			out.println("<br>");
			out.println("<a href='Index.html'>Volver</a>");
			out.println("</body>");
			out.println("</html>");
			e.printStackTrace();
		}
		
		
	
	}
}
