package by.it.milosh.daoImpl;

import by.it.milosh.dao.RoleDao;
import by.it.milosh.pojo.Role;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RoleDaoImpl implements RoleDao {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public Role findRoleByRoleName(String roleName) {
        return (Role) getSession()
                .createCriteria(Role.class)
                .add(Restrictions.eq("roleName", roleName))
                .uniqueResult();
    }
}
