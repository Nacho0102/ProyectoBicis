/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controladores;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelos.ModeloBicis;
import objetos.Bicicleta;
import objetos.TipoGenero;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 *
 * @author Nacho
 */
public class ControllerBicicletasGeneros implements Controller {

    @Override
    public ModelAndView handleRequest(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
        ModelAndView mv = new ModelAndView("WebBicicletasGeneros");
        ModeloBicis modelo = new ModeloBicis(hsr.getServletContext());
        ArrayList<TipoGenero> lista = modelo.getGeneros();
        mv.addObject("generos", lista);
        if (hsr.getParameter("idgenero") != null) {
            int idgenero = Integer.parseInt(hsr.getParameter("idgenero"));
            ArrayList<Bicicleta> bicis = modelo.getBicicletasGenero(idgenero);
            mv.addObject("bicicletas", bicis);
        }
        return mv;
    }

   

}
