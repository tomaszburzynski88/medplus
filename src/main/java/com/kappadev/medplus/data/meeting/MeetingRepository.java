/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kappadev.medplus.data.meeting;

import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author tburzynski
 */
interface MeetingRepository extends JpaRepository<Meeting, Long> {

    Meeting findMeetingByPatientId(Long patientId);

    List<Meeting> findMeetingsByDate(Date date);

}
