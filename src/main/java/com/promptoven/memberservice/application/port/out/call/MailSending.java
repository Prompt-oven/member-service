package com.promptoven.memberservice.application.port.out.call;

public interface MailSending {

	void sendMail(String to, String subject, String text);

}
