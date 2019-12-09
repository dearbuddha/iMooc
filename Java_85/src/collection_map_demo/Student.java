package collection_map_demo;

import java.util.HashSet;
import java.util.Set;
/**
 * 学生类
 */

public class Student {

    public String id;

    public String name;

    public Set<Course> courses;

    public Student(String id, String name) {
        this.id = id;
        this.id = name;
        this.courses = new HashSet<Course>();
    }
}
