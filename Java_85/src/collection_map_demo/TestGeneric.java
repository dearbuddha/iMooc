package collection_map_demo;

import java.util.ArrayList;
import java.util.List;

public class TestGeneric {

    public List<Course> courses;

    public TestGeneric() {
        this.courses = new ArrayList<Course>();
    }

    public void testAdd() {
        Course cr1 = new Course("1", "大学语文");
        courses.add(cr1);
        // 泛型集合中不能添加泛型规定的类型极其子类型以外的对象，否则会报错
//        courses.add("奇怪的字符串");
        Course cr2 = new Course("2", "Java基础");
        courses.add(cr2);
    }

    public void testForEach() {
        for (Course cr:courses) {
            System.out.println(cr.id+":"+cr.name);
        }
    }

    /**
     *泛型集合可以添加泛型的子类型的对象实例
     */
    public void testChild() {
        ChildCourse ccr = new ChildCourse();
        ccr.id = "3";
        ccr.name = "我是子类型的课程对象实例";
        courses.add(ccr);
    }

    /**
     *
     */
    public void testBasicType() {
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        System.out.println("基本类型必须使用包装类作为泛型！"+list.get(0));
    }

    public static void main(String[] args) {
        TestGeneric tg = new TestGeneric();
        tg.testAdd();
        tg.testForEach();
        tg.testChild();
        tg.testForEach();
    }
}
