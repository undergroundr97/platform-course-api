package com.courses.ocourses.dashboard;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/dashboard")
public class DashboardController {


    @Autowired
    DashboardService dashboardService;

    @GetMapping
    public ResponseEntity<DashboardDTO> dashBoardRequest(Authentication authentication){
        DashboardDTO dashboardDTO = dashboardService.transformToDashboardDTO(authentication.getName());
        return ResponseEntity.ok().body(dashboardDTO);
    }



}
