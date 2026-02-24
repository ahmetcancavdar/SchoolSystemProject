// ======================
// School.java
// Do nothing!
// ======================

public class School {

    private Course[] courses;
    private int courseCount;

    public School(int capacity) {
        courses = new Course[capacity];
        courseCount = 0;
    }

    public void addCourse(Course c) {
        if (courseCount < courses.length) {
            courses[courseCount++] = c;
        }
    }

    public int getCourseCount() {
        return courseCount;
    }

    public Course getCourse(int index) {
        if (index < 0 || index >= courseCount) return null;
        return courses[index];
    }
}
