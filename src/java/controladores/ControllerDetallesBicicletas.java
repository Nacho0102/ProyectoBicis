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
public class ControllerDetallesBicicletas implements Controller
{

    @Override
    public ModelAndView handleRequest(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
        ModelAndView mv = new ModelAndView("WebDetallesBicicleta");
        ModeloBicis modelo = new ModeloBicis(hsr.getServletContext());        
        if (hsr.getParameter("idbicicleta") != null)
        {
            int idbicicleta = 
                    Integer.parseInt(hsr.getParameter("idbicicleta"));
            Bicicleta bici = modelo.getBicicleta(idbicicleta);
            mv.addObject("bicicleta", bici);
        }
        if (hsr.getParameter("comprar") != null)
        {
            int idbicicleta = 
                    Integer.parseInt(hsr.getParameter("comprar"));
            ArrayList<Integer> listacompra;
            HttpSession sesion = hsr.getSession();
            if (sesion.getAttribute("CARRITO") != null)
            {
                listacompra = (ArrayList<Integer>)
                        sesion.getAttribute("CARRITO");
            }else{
                listacompra = new ArrayList();
            }
            listacompra.add(idbicicleta);
            sesion.setAttribute("CARRITO", listacompra);
            Bicicleta bici = modelo.getBicicleta(idbicicleta);
            mv.addObject("bicicleta", bici);
            mv.addObject("mensaje", "Bicicletas compradas: "
            + listacompra.size());
        }        
        return mv;
    }

 
    
} 