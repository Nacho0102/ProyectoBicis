/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controladores;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelos.ModeloBicis;
import objetos.Bicicleta;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 *
 * @author Nacho
 */
public class ControllerCarritoCompra implements Controller {

    @Override
    public ModelAndView handleRequest(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
   ModelAndView mv = new ModelAndView("WebCarritoCompra");
        HttpSession sesion = hsr.getSession();
        
        ArrayList<Integer> listacompra;
        if (hsr.getParameter("eliminar") != null)
        {
            int idpelicula = Integer.parseInt(hsr.getParameter("eliminar"));
            listacompra = (ArrayList<Integer>)
                    sesion.getAttribute("CARRITO");
            listacompra.remove((Integer)idpelicula);
            if (listacompra.isEmpty())
            {
                sesion.setAttribute("CARRITO", null);
            }
        }
        
        if (sesion.getAttribute("CARRITO") != null)
        {
            ModeloBicis modelo = new ModeloBicis(hsr.getServletContext());
            ArrayList<Integer> compra = (ArrayList<Integer>)
                    sesion.getAttribute("CARRITO");
            ArrayList<Bicicleta> lista = modelo.getBicicletasCarrito(compra);
            mv.addObject("bicicletas", lista);
        }else{
            mv.addObject("mensaje", "No hay bicicletas en el carrito.");
        }
        return mv;
    }
    
}