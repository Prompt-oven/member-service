package com.promptoven.memberservice.adaptor.web.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.promptoven.memberservice.adaptor.web.controller.vo.in.BanRequestVO;
import com.promptoven.memberservice.adaptor.web.controller.vo.in.ClearPasswordRequestVO;
import com.promptoven.memberservice.adaptor.web.controller.vo.in.CreateRoleRequestVO;
import com.promptoven.memberservice.adaptor.web.controller.vo.in.DeleteRoleRequestVO;
import com.promptoven.memberservice.adaptor.web.controller.vo.in.RegisterRequestVO;
import com.promptoven.memberservice.adaptor.web.controller.vo.in.UnbanRequestVO;
import com.promptoven.memberservice.adaptor.web.controller.vo.in.SetMemberRoleRequestVO;
import com.promptoven.memberservice.adaptor.web.controller.vo.in.UpdateNicknameRequestVO;
import com.promptoven.memberservice.adaptor.web.controller.vo.in.UpdateRoleRequestVO;
import com.promptoven.memberservice.application.port.in.usecase.MemberManagementUseCases;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/admin/member")
public class MemberAdminRestController {

	private final MemberManagementUseCases memberManagementUseCases;

	@PostMapping("/admin-register")
	public void adminRegister(@RequestBody RegisterRequestVO registerRequestVO) {
		memberManagementUseCases.AdminRegister(registerRequestVO.getEmail(), registerRequestVO.getPassword(),
			registerRequestVO.getNickname());
	}

	@PutMapping("/ban")
	public void banMember(@RequestBody BanRequestVO banRequestVO) {
		memberManagementUseCases.banMember(banRequestVO.getMemberUUID());
	}

	@PutMapping("/unban")
	public void unbanMember(@RequestBody UnbanRequestVO unbanRequestVO) {
		memberManagementUseCases.unbanMember(unbanRequestVO.getMemberUUID());
	}

	@PutMapping("/nickname")
	public void updateNickname(@RequestBody UpdateNicknameRequestVO updateNicknameRequestVO) {
		memberManagementUseCases.updateNickname(
			updateNicknameRequestVO.getMemberUUID(), updateNicknameRequestVO.getNickname());
	}

	@PutMapping("/member-role")
	public void updateMemberRole(@RequestBody SetMemberRoleRequestVO setMemberRoleRequestVO) {
		memberManagementUseCases.setMemberRole(
			setMemberRoleRequestVO.getMemberNickname(), setMemberRoleRequestVO.getRoleName());
	}

	@PutMapping("/clearPW")
	public void clearPassword(@RequestBody ClearPasswordRequestVO clearPasswordRequestVO) {
		memberManagementUseCases.clearPassword(clearPasswordRequestVO.getMemberUUID());
	}

	@PostMapping("/role")
	public void createRole(@RequestBody CreateRoleRequestVO createRoleRequestVO) {
		memberManagementUseCases.createRole(createRoleRequestVO.getName(), createRoleRequestVO.getDescription());
	}

	@PutMapping("/role")
	public void updateRole(@RequestBody UpdateRoleRequestVO updateRoleRequestVO) {
		memberManagementUseCases.updateRole(updateRoleRequestVO.getId(), updateRoleRequestVO.getName(),
			updateRoleRequestVO.getDescription());
	}

	@DeleteMapping("/role")
	public void deleteRole(@RequestBody DeleteRoleRequestVO deleteRoleRequestVO) {
		memberManagementUseCases.deleteRole(deleteRoleRequestVO.getRoleID());
	}

}
