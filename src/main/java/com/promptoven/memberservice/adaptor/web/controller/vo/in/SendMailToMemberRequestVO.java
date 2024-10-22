package com.promptoven.memberservice.adaptor.web.controller.vo.in;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SendMailToMemberRequestVO {

	private String memberNickname;
	private String title;
	private String body; // HTML
}
