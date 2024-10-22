package com.promptoven.memberservice.application.port.out.call;

import com.promptoven.memberservice.domain.Role;

public interface RolePersistence {

	void create(Role role);

	Role findRoleById(int roleID);

	Role findByName(String roleName);

	int findMaxRoleID();

	void deleteRoleById(int roleID);

	void updateRole(Role role);
}
