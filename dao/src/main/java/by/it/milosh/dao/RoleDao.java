package by.it.milosh.dao;

import by.it.milosh.pojo.Role;

public interface RoleDao {

    Role findRoleByRoleName(String roleName);

}
