/**  
* River Deters - mddeters  
* CIS171 22149
* Jul 16, 2023
* Windows Operating System version 
*/ 
package model;

import java.time.LocalTime;

public class Course {
    private String courseNumber;
    private String courseName;
    private LocalTime startTime;
    private LocalTime endTime;
    private Instructor teacher;
    private Classroom location;

    public Course() {
    	setCourseNumber("12345");
        setCourseName("BIO101");
        setStartTime(LocalTime.of(11, 15));
        setEndTime(LocalTime.of(12, 55));
        setTeacher(new Instructor());
        setLocation(new Classroom());
    }

    public Course(String courseID, String name, LocalTime start, LocalTime end, Instructor instructor, Classroom classroom) {
    	setCourseNumber(courseID);
        setCourseName(name);
        setStartTime(start);
        setEndTime(end);
        setTeacher(instructor);
        setLocation(classroom);
    }

    public String getCourseNumber() {
        return courseNumber;
    }

    public void setCourseNumber(String courseNumber) {
        this.courseNumber = courseNumber;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public Instructor getTeacher() {
        return teacher;
    }

    public void setTeacher(Instructor teacher) {
        this.teacher = teacher;
    }

    public Classroom getLocation() {
        return location;
    }

    public void setLocation(Classroom location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Course [courseNumber=" + courseNumber + ", courseName=" + courseName + ", startTime=" + startTime
                + ", endTime=" + endTime + ", teacher=" + teacher + ", location=" + location + "]";
    }
}

