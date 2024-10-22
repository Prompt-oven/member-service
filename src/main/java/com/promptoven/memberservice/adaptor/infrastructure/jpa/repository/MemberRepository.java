package com.promptoven.memberservice.adaptor.infrastructure.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.promptoven.memberservice.adaptor.infrastructure.jpa.entity.MemberEntity;

public interface MemberRepository extends JpaRepository<MemberEntity, Long> {
	MemberEntity findByEmail(String email);

	MemberEntity findByUuid(String uuid);

	MemberEntity findByNickname(String nickname);

	boolean existsByEmail(String email);

	boolean existsByNickname(String nickname);
}
