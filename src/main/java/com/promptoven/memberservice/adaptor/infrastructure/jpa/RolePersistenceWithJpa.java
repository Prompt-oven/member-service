package com.promptoven.memberservice.adaptor.infrastructure.jpa;

import org.springframework.stereotype.Service;

import com.promptoven.memberservice.adaptor.infrastructure.jpa.entity.RoleEntity;
import com.promptoven.memberservice.adaptor.infrastructure.jpa.repository.RoleRepository;
import com.promptoven.memberservice.application.port.out.call.RolePersistence;
import com.promptoven.memberservice.domain.Role;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class RolePersistenceWithJpa implements RolePersistence {

	private final RoleRepository roleRepository;

	@Override
	public void create(Role role) {
		RoleEntity roleEntity = RoleEntity.fromDomain(role);
		roleRepository.save(roleEntity);
	}

	@Override
	public Role findRoleById(int roleID) {
		RoleEntity roleEntity = roleRepository.findById(roleID).orElse(new RoleEntity());
		return roleEntity.toDomain();
	}

	@Override
	public Role findByName(String roleName) {
		RoleEntity roleEntity = roleRepository.findByName(roleName);
		return roleEntity != null ? roleEntity.toDomain() : null;
	}

	@Override
	public int findMaxRoleID() {
		return roleRepository.findMaxRoleID();
	}

	@Override
	public void deleteRoleById(int roleID) {
		roleRepository.deleteById(roleID);
	}

	@Override
	public void updateRole(Role updatedRole) {
		roleRepository.save(RoleEntity.fromDomain(updatedRole));
	}

}
