/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kappadev.medplus.data.emailSetting;

import com.kappadev.medplus.data.profile.Profile;

/**
 *
 * @author tburzynski
 */
public interface EmailSettingService {

    public EmailSetting getEmailSettingByProfileId(Profile profile);

}
