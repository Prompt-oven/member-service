package com.promptoven.memberservice.domain;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class Member {

	private String uuid;

	private String email;
	private String password;
	private String nickname;

	private LocalDateTime createdAt;
	private Boolean isDeleted;
	private Boolean isBanned;

	private int role;

	public static Member createMember(
		String uuid, String email, String password, String nickname, LocalDateTime createdAt, int role) {
		return Member.builder()
			.uuid(uuid)
			.email(email)
			.password(password)
			.nickname(nickname)
			.createdAt(LocalDateTime.now())
			.isDeleted(false)
			.isBanned(false)
			.role(role)
			.build();
	}

	public static Member updateMemberNickname(Member member, String nickname) {
		return Member.builder()
			.uuid(member.getUuid())
			.email(member.getEmail())
			.password(member.getPassword())
			.nickname(nickname)
			.createdAt(member.getCreatedAt())
			.isDeleted(member.getIsDeleted())
			.isBanned(member.getIsBanned())
			.role(member.getRole())
			.build();
	}

	public static Member updateMemberPassword(Member member, String password) {
		return Member.builder()
			.uuid(member.getUuid())
			.email(member.getEmail())
			.password(password)
			.nickname(member.getNickname())
			.createdAt(member.getCreatedAt())
			.isDeleted(member.getIsDeleted())
			.isBanned(member.getIsBanned())
			.role(member.getRole())
			.build();
	}

	public static Member updateMemberRole(Member member, int role) {
		return Member.builder()
			.uuid(member.getUuid())
			.email(member.getEmail())
			.password(member.getPassword())
			.nickname(member.getNickname())
			.createdAt(member.getCreatedAt())
			.isDeleted(member.getIsDeleted())
			.isBanned(member.getIsBanned())
			.role(role)
			.build();
	}

	public static Member deleteMember(Member member) {
		return Member.builder()
			.uuid(member.getUuid())
			.email(member.getEmail())
			.password(member.getPassword())
			.nickname(member.getNickname())
			.createdAt(member.getCreatedAt())
			.isDeleted(true)
			.isBanned(member.getIsBanned())
			.role(member.getRole())
			.build();
	}

	public static Member banMember(Member member) {
		return Member.builder()
			.uuid(member.getUuid())
			.email(member.getEmail())
			.password(member.getPassword())
			.nickname(member.getNickname())
			.createdAt(member.getCreatedAt())
			.isDeleted(member.getIsDeleted())
			.isBanned(true)
			.role(member.getRole())
			.build();
	}

	public static Member unbanMember(Member member) {
		return Member.builder()
			.uuid(member.getUuid())
			.email(member.getEmail())
			.password(member.getPassword())
			.nickname(member.getNickname())
			.createdAt(member.getCreatedAt())
			.isDeleted(member.getIsDeleted())
			.isBanned(false)
			.role(member.getRole())
			.build();
	}
	
}
