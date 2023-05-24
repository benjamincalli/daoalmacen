package com.emergentes.controlador;

import com.emergentes.dao.Productodao;
import com.emergentes.dao.Productodaoimpl;
import com.emergentes.modelo.Producto;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Inicio", urlPatterns = {"/Inicio"})
public class Inicio extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //System.out.println("INICIAMOS PROYECTO..."+ request.getParameter("action"));
        try {
            int id;
            Producto pro = new Producto();
            Productodao dao = new Productodaoimpl();
            
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
            
            switch (action) {
                case "add":
                    request.setAttribute("producto", pro);
                    request.getRequestDispatcher("frmproducto.jsp").forward(request, response);
                    break;
                case "edit":
                    id = Integer.parseInt(request.getParameter("id"));
                    pro = dao.getById(id);
                    request.setAttribute("producto", pro);
                    request.getRequestDispatcher("frmproducto.jsp").forward(request, response);
                    break;
                case "delete":
                    id = Integer.parseInt(request.getParameter("id"));
                    dao.delete(id);
                    response.sendRedirect("Inicio");
                    break;
                case "view":
                    List<Producto> lista = dao.getAll();
                    request.setAttribute("producto", lista);
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                    break;
            }
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Productodao dao = new Productodaoimpl();
        
        int id = Integer.parseInt(request.getParameter("id"));
        String descripcion = request.getParameter("descripcion");
        int cantidad = Integer.parseInt(request.getParameter("cantidad"));
        float precio = Float.parseFloat(request.getParameter("precio"));
        String categoria = request.getParameter("categoria");
        Producto pro = new Producto();
        
        pro.setId(id);
        pro.setDescripcion(descripcion);
        pro.setCantidad(cantidad);
        pro.setPrecio(precio);
        pro.setCategoria(categoria);
        
        try {
            if (id == 0) {
                dao.insert(pro);
            } else {
                dao.update(pro);
            }
        } catch (Exception e) {
            
            System.out.println("ERROR al guardar datos.. ");
        }
        response.sendRedirect("Inicio");
    }
    
}
