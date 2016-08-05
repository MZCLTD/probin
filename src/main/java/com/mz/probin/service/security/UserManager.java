package com.mz.probin.service.security;

import com.mz.probin.entities.security.AppUser;

/**
 * Created by emmanuel on 7/13/16.
 */
public interface UserManager {

    AppUser getUserByUsername(String username);

    String getPasswordByUsername(String username);

	void createOrEditUser(AppUser user);

}
