package com.promptoven.memberservice.adaptor.web.controller.vo.out;

import java.util.List;

import com.promptoven.memberservice.domain.Role;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RoleResponseVO {

	private List<Role> RoleList;
}
