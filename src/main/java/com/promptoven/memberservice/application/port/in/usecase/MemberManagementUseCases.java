package com.promptoven.memberservice.application.port.in.usecase;

import org.springframework.lang.Nullable;

public interface MemberManagementUseCases {

	void AdminRegister(String email, String password, String nickname);

	void setMemberRole(String memberUUID, String roleName);

	void banMember(String memberUUID);

	void unbanMember(String memberUUID);

	void updateNickname(String memberUUID, String nickname);

	void clearPassword(String memberUUID);

	void createRole(String name, @Nullable String description);

	void deleteRole(int ID);

	void updateRole(int ID, String name, String description);
}
