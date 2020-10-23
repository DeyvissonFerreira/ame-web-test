package util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class GeradorEmail {
	
	private GregorianCalendar dt;
	
	public GeradorEmail() {
		Calendar data = Calendar.getInstance();   

		int ano = data.get(Calendar.YEAR);   
		int mes = data.get(Calendar.MONTH);   
		int dia = data.get(Calendar.DAY_OF_MONTH);   
		int hora = data.get(Calendar.HOUR_OF_DAY);
		int minuto = data.get(Calendar.MINUTE);
		int seconds = data.get(Calendar.SECOND);
		dt = new GregorianCalendar(ano,mes,dia,hora,minuto, seconds);
	}
	
	public String gerarEmailAleatorio() {
		return "email_".concat(new SimpleDateFormat("HHmmss").format(dt.getTime())).concat("@email.com.br");
	}
}
