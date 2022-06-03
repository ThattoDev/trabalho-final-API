package br.org.serratec.api.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

@Configuration
public class MailConfig {
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	public void enviarEmail(String para, String assunto, String texto) {
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		
		simpleMailMessage.setFrom("douglas.m.pereira@estudante.firjan.senai.br");
		simpleMailMessage.setTo(para);
		simpleMailMessage.setSubject(assunto);
		simpleMailMessage.setText("Dados da inscrição do usuario \n\n\n" +texto+ "\n\n\nSerratec - Residência - 2022");
		javaMailSender.send(simpleMailMessage);
	}
	
}
