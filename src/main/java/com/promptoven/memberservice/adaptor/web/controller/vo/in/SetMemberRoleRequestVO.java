package com.promptoven.memberservice.adaptor.web.controller.vo.in;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SetMemberRoleRequestVO {

	private String memberNickname;
	private String roleName;
}