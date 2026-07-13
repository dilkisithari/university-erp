package com.uni.universityERP.controller;

import com.uni.universityERP.dto.DashboardSummaryResponse;
import com.uni.universityERP.service.AuthService;
import com.uni.universityERP.service.DashboardService;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin(origins = "*")   // Allow requests from anywhere (for development)
@RestController
@RequestMapping("/api/dashboard")
public class DashboardController {

    private final DashboardService dashboardService;

    public DashboardController(DashboardService dashboardService) {
        this.dashboardService = dashboardService;
    }

    @GetMapping("/summary")
    public ResponseEntity<DashboardSummaryResponse> summary(HttpSession session) {
        Object authenticated = session.getAttribute(AuthService.SESSION_AUTHENTICATED);
        if (!Boolean.TRUE.equals(authenticated)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        return ResponseEntity.ok(dashboardService.getSummary());
    }
}
