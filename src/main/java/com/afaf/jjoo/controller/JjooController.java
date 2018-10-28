package com.afaf.jjoo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.afaf.jjoo.data.model.SedeJjoo;
import com.afaf.jjoo.data.model.SedeJjooPK;
import com.afaf.jjoo.data.model.TipoJjoo;
import com.afaf.jjoo.service.JjooService;

/**
 * Clase controladora para unir el front y el back de la aplicacion CRUD de jjoo
 *
 */
@Controller
public class JjooController {
	
	@Autowired
	private JjooService jjooService;
	
	
	/**
	 * Metodo para controlar la carga de la pagina home obteniendo la lista de sedes de jjoo
	 * y poniendola a disposicion de la pagina.
	 * @return objeto ModelAndView
	 */
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView home() {
		ModelAndView modelAndView = new ModelAndView();
		List<SedeJjoo> listaSedesJjoo = jjooService.listaSedesJjoo();
		modelAndView.addObject("sedes", listaSedesJjoo);
		modelAndView.setViewName("home");
		return modelAndView;
	}
	
	/**
	 * Metodo para controlar la solicitud GET de la pagina home para redirigir a nuevosede
	 * @return objeto ModelAndView
	 */
	@RequestMapping(value="/nuevasede", method=RequestMethod.GET)
	public ModelAndView nuevoContacto() {
		ModelAndView modelAndView = new ModelAndView();
		List<TipoJjoo> listaTipoJjoo = jjooService.listaTipoJjoo();
		modelAndView.addObject("tipos", listaTipoJjoo);
		modelAndView.setViewName("nuevasede");
		return modelAndView;
	}
	
	/**
	 * Metodo para controlar la solicitud POST de la pagina de nuevasede e insertarla en BBDD
	 * @param sedeJjoo objeto SedeJjoo
	 * @return objeto ModelAndView
	 */
	@RequestMapping(value="/nuevasede", method=RequestMethod.POST)
	public ModelAndView nuevaSede(@Valid SedeJjoo sedeJjoo, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView();
		if(bindingResult.hasErrors()){
			// quedan por incluir las etiquetas de error en la pagina porque no las tiene
			modelAndView.setViewName("nuevasede");
		}
		else {
			jjooService.salvaSede(sedeJjoo);
			modelAndView.setViewName("redirect:/");
		}
		return modelAndView;
	}
	
	/**
	 * Metodo para controlar la solicitud POST de la pagina home determinando la opcion para 
	 * modificar una sede o para borrarla
	 * @param toStringSedeJjooPK toString de SedeJjooPK de la sede
	 * @param opcion String modificar o borrar
	 * @return objeto ModelAndView
	 */
	@RequestMapping(value="/", method=RequestMethod.POST)
	public ModelAndView opcionSede(@RequestParam String toStringSedeJjooPK, @RequestParam String opcion) {
		ModelAndView modelAndView = new ModelAndView();
		String anio = toStringSedeJjooPK.substring(0, toStringSedeJjooPK.indexOf("/"));
		String id_tipo_jjoo = toStringSedeJjooPK.substring(toStringSedeJjooPK.indexOf("/")+1, toStringSedeJjooPK.length());
		SedeJjooPK sedeJjooPK = new SedeJjooPK(Integer.parseInt(anio), Integer.parseInt(id_tipo_jjoo));
		if("modificar".equals(opcion)) {
			SedeJjoo sedeJjoo = jjooService.getSede(sedeJjooPK);
			modelAndView.addObject("sede", sedeJjoo);
			modelAndView.setViewName("modificasede");
		}
		else if("borrar".equals(opcion)) {
			jjooService.borrarSede(sedeJjooPK);
			modelAndView.setViewName("redirect:/");
		}
		return modelAndView;
	}
	
	/**
	 * Metodo para controlar la solicitud POST de la pagina modificasede y actualizarla en BBDD
	 * @param sedeJjoo objeto SedeJjoo
	 * @param toStringSedeJjooPK toString de SedeJjooPK de la sede
	 * @return objeto ModelAndView
	 */
	@RequestMapping(value="/modificasede", method=RequestMethod.POST)
	public ModelAndView modificaSede(@Valid SedeJjoo sedeJjoo, String toStringSedeJjooPK, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView();
		if(bindingResult.hasErrors()){
			// quedan por incluir las etiquetas de error en la pagina porque no las tiene
			modelAndView.setViewName("modificasede");
		}
		else {
			String anio = toStringSedeJjooPK.substring(0, toStringSedeJjooPK.indexOf("/"));
			String id_tipo_jjoo = toStringSedeJjooPK.substring(toStringSedeJjooPK.indexOf("/")+1, toStringSedeJjooPK.length());
			SedeJjooPK sedeJjooPK = new SedeJjooPK(Integer.parseInt(anio), Integer.parseInt(id_tipo_jjoo));
			sedeJjoo.setSedeJjooPK(sedeJjooPK);
			jjooService.salvaSede(sedeJjoo);
			modelAndView.setViewName("redirect:/");
		}
		return modelAndView;
	}

}
