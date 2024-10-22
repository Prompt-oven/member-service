package com.promptoven.memberservice.application.service;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.promptoven.memberservice.application.port.in.usecase.MemberManagementUseCases;
import com.promptoven.memberservice.application.port.out.call.MemberPersistence;
import com.promptoven.memberservice.application.port.out.call.RolePersistence;
import com.promptoven.memberservice.domain.Member;
import com.promptoven.memberservice.domain.Role;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberManagementServiceImpl implements MemberManagementUseCases {

	private final MemberPersistence memberPersistence;
	private final RolePersistence rolePersistence;
	private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(13);


	@Override
	public void setMemberRole(String memberNickname, String roleName) {
		Role role = rolePersistence.findByName(roleName);
		Member member = memberPersistence.findByNickname(memberNickname);
		memberPersistence.updateMember(Member.updateMemberRole(member, role.getId()));
	}

	@Override
	public void banMember(String memberUUID) {
		Member member = memberPersistence.findByUuid(memberUUID);
		memberPersistence.updateMember(Member.banMember(member));
	}

	@Override
	public void unbanMember(String memberUUID) {
		Member member = memberPersistence.findByUuid(memberUUID);
		memberPersistence.updateMember(Member.unbanMember(member));
	}

	@Override
	public void updateNickname(String memberUUID, String nickname) {
		Member member = memberPersistence.findByUuid(memberUUID);
		memberPersistence.updateMember(Member.updateMemberNickname(member, nickname));
	}

	@Override
	public void clearPassword(String memberUUID) {
		Member member = memberPersistence.findByUuid(memberUUID);
		memberPersistence.updateMember(Member.updateMemberPassword(member, "clear"));
	}

	@Override
	public void createRole(String name, String description) {
		int newRoleID = 1 + rolePersistence.findMaxRoleID();
		rolePersistence.create(Role.createRole(name, newRoleID, description));
	}

	@Override
	public void deleteRole(int ID) {
		rolePersistence.deleteRoleById(ID);
	}

	@Override
	public void updateRole(int ID, String name, String description) {
		Role role = rolePersistence.findRoleById(ID);
		rolePersistence.updateRole(Role.updateRole(role, name, description));
	}

	@Override
	public void AdminRegister(String email, String password, String nickname) {
		String uuid = UUID.randomUUID().toString();
		String encodedPassword = passwordEncoder.encode(password);
		Member member = Member.createMember
			(uuid, email, encodedPassword, nickname, LocalDateTime.now(), 3);
		while (memberPersistence.findByUuid(uuid) != null) {
			uuid = UUID.randomUUID().toString();
		}
		memberPersistence.create(member);
	}
}
