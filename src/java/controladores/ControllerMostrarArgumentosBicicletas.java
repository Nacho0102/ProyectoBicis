/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controladores;

import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelos.ModeloBicis;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

/**
 *
 * @author Nacho
 */
public class ControllerMostrarArgumentosBicicletas extends MultiActionController{
    
    public ModelAndView inicio (HttpServletRequest request, HttpServletResponse response) throws SQLException
    {
        ModelAndView mv = new ModelAndView("WebMostrarBicicletas");
        ModeloBicis modelo = new ModeloBicis(request.getServletContext());
        String lista = modelo.getBicicletas();
        mv.addObject("bicicletas",lista);
        
        return mv;
    }
    
     public ModelAndView argumentoBicicletas (HttpServletRequest request, HttpServletResponse response) throws SQLException
    {
        ModelAndView mv = new ModelAndView("WebMostrarArgumentosBicicletas");
        ModeloBicis modelo = new ModeloBicis(request.getServletContext());
        int idbicicleta = Integer.parseInt(request.getParameter("bicicleta"));
        String lista = modelo.getArgumentoBicicletas(idbicicleta);
        mv.addObject("argumento",lista);
        
        return mv;
    }
     
      public ModelAndView comprar (HttpServletRequest request, HttpServletResponse response) throws SQLException
    {
        ModelAndView mv = new ModelAndView("WebMostrarArgumentosBicicletas");
        ModeloBicis modelo = new ModeloBicis(request.getServletContext());
        int idbicicleta = Integer.parseInt(request.getParameter("bicicleta"));
        String lista = modelo.comprarBicicleta(idbicicleta);
        mv.addObject("compra",lista);
        
        return mv;
    }
    
}

    

