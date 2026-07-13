package com.uni.universityERP.dto;

public class DashboardSummaryResponse {

    private long totalStudents;
    private long totalCourses;
    private long examsScheduled;
    private double attendanceRate;

    public DashboardSummaryResponse() {
    }

    public DashboardSummaryResponse(
            long totalStudents, long totalCourses, long examsScheduled, double attendanceRate) {
        this.totalStudents = totalStudents;
        this.totalCourses = totalCourses;
        this.examsScheduled = examsScheduled;
        this.attendanceRate = attendanceRate;
    }

    public long getTotalStudents() {
        return totalStudents;
    }

    public void setTotalStudents(long totalStudents) {
        this.totalStudents = totalStudents;
    }

    public long getTotalCourses() {
        return totalCourses;
    }

    public void setTotalCourses(long totalCourses) {
        this.totalCourses = totalCourses;
    }

    public long getExamsScheduled() {
        return examsScheduled;
    }

    public void setExamsScheduled(long examsScheduled) {
        this.examsScheduled = examsScheduled;
    }

    public double getAttendanceRate() {
        return attendanceRate;
    }

    public void setAttendanceRate(double attendanceRate) {
        this.attendanceRate = attendanceRate;
    }
}
