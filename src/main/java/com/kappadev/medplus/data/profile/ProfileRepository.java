/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kappadev.medplus.data.profile;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author tburzynski
 */
interface ProfileRepository extends JpaRepository<Profile, Long> {
    Profile getProfileByName(String name);
}
