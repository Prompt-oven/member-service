package com.promptoven.memberservice.adaptor.web.controller.vo.in;

import org.springframework.lang.Nullable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateRoleRequestVO {

	private int id;
	private String name;
	@Nullable
	private String description;
}
