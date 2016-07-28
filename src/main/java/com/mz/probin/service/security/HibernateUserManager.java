package com.mz.probin.service.security;

import com.mz.probin.dao.impl.AbstractHibernateDao;
import com.mz.probin.entities.security.AppUser;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public class HibernateUserManager extends AbstractHibernateDao implements UserManager {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    public HibernateUserManager(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public AppUser getUserByUsername(String username) {
        return (AppUser) createCriteria(AppUser.class)
                        .add(Restrictions.ilike("username", username, MatchMode.EXACT))
                        .uniqueResult();
    }

    @Override
    public String getPasswordByUsername(String username) {
        return (String) createSQLQuery("SELECT password FROM APP_USERS WHERE username = :username")
                            .addScalar("password", StandardBasicTypes.STRING)
                            .setString("username", username)
                            .uniqueResult();
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    public void createOrEditUser(AppUser user) {

        //Save new user

        //Make sure user has been saved first so we have an id for the user
        //encode the plain text password save it
        String encodedPassword = this.passwordEncoder.encode(user.getPassword());
        savePassword(user.getId(), encodedPassword);



    }

    private void savePassword(Long userId, String password) {
        createSQLQuery("UPDATE APP_USERS SET password = :password WHERE user_id = :userId")
                .setString("password", password)
                .setLong("userId", userId)
                .executeUpdate();
    }
}
