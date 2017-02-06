package br.com.bluefisc.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.springframework.security.core.context.SecurityContextHolder;

import br.com.bluefisc.model.entity.Usuario;

public class Util {

	
	public static Calendar getDataAtual(){
		Date date = new Date();
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		return calendar;
	}
	
	public static Calendar getHoraAtual(){
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		return sdf.getCalendar(); 
	}
	
	public static Usuario getUsuarioAtual(){
		return (Usuario)SecurityContextHolder.getContext().getAuthentication().getPrincipal();		
	}
	
}
