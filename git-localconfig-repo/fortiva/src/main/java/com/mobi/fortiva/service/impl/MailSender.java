package com.mobi.fortiva.service.impl;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import com.mobi.fortiva.dto.Mail;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

@Service
public class MailSender {

	@Value("${email.header.image}")
	private String imagePath;

	@Autowired
	private JavaMailSender emailSender;

	@Autowired
	@Qualifier("emailConfigBean")
	private Configuration emailConfig;
	
	@Value("${mail.fromMail}")
	private String fromMail;

	public void sendEmail(Mail mailModel) throws MessagingException, IOException, TemplateException {

		Map model = new HashMap();
		if(mailModel.getContent().containsKey("url"))
		model.put("url", mailModel.getContent().get("url"));
		MimeMessage message = emailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED, StandardCharsets.UTF_8.name());
		Template template = emailConfig.getTemplate(mailModel.getContent().get("templateName"));
		String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, model);
		mimeMessageHelper.setFrom(fromMail);
		mimeMessageHelper.setTo(mailModel.getTo());
		mimeMessageHelper.setText(html, true);
		mimeMessageHelper.setSubject("Sift Notification");
		MimeBodyPart messageBodyPart = new MimeBodyPart();
		messageBodyPart.setContent(html, "text/html");
		Multipart multipart = new MimeMultipart();
		multipart.addBodyPart(messageBodyPart);
		MimeBodyPart imagePart = new MimeBodyPart();
		imagePart.setHeader("Content-ID", "<image>");
		imagePart.setDisposition(MimeBodyPart.INLINE);
		try {
			File f = new File(imagePath);
			imagePart.attachFile(f);
			multipart.addBodyPart(imagePart);
		} catch (Exception e) {
			e.printStackTrace();
		}
		message.setContent(multipart);
		emailSender.send(message);

	}

}
