package collection_map_demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * 备选课程类
 */
public class ListTest {

    /**
     * 用于存放备选课程的List
     */

    public List coursesToSelect;

    public ListTest() {
        this.coursesToSelect = new ArrayList();
    }

    /**
     * 往coursesToSelect中添加备选课程
     */
    public void testAdd() {
        //创建一个课程对象，并通过调用add方法，添加到备选课程list中
        Course cr1 = new Course("1", "数据结构");
        coursesToSelect.add(cr1);
        Course temp = (Course) coursesToSelect.get(0);
        System.out.println("添加了课程："+temp.id + ":" + temp.name);

        Course cr2 = new Course("2", "C语言");
        coursesToSelect.add(0,cr2);
        Course temp2 = (Course) coursesToSelect.get(0);
        System.out.println("添加了课程："+temp2.id+":"+temp2.name);

        Course[] course = {new Course("3","离散数学"), new Course("4", "汇编语言")};
        coursesToSelect.addAll(Arrays.asList(course));
        Course temp3 = (Course) coursesToSelect.get(2);
        Course temp4 = (Course) coursesToSelect.get(3);
        System.out.println("添加了两门课程"+temp3.id+":"+temp3.name+";"+temp4.id+":"+temp4.name);

        Course[] course2 = {new Course("5","高等数学"), new Course("6", "大学英语")};
        coursesToSelect.addAll(2,Arrays.asList(course2));
        Course temp5 = (Course) coursesToSelect.get(2);
        Course temp6 = (Course) coursesToSelect.get(3);
        System.out.println("添加了两门课程"+temp5.id+":"+temp5.name+";"+temp6.id+":"+temp6.name);
    }

    /**
     * 取得List中元素的方法
     */
    public void testGet() {
        int size = coursesToSelect.size();
        System.out.println("有如下课程待选:");
        for (int i=0; i<size;i++) {
            Course cr = (Course) coursesToSelect.get(i);
            System.out.println("课程"+cr.id+":"+cr.name);
        }
    }

    /**
     * 通过迭代器来遍历list
     */
    public void testiterator() {
        Iterator it = coursesToSelect.iterator();
        System.out.println("有如下课程待选(通过迭代器访问):");
        while (it.hasNext()){
            Course cr = (Course) it.next();
            System.out.println("课程"+cr.id+":"+cr.name);
        }
    }

    public void testForEach() {
        System.out.println("有如下课程待选(通过foreach访问):");
        for (Object obj:coursesToSelect) {
            Course cr = (Course) obj;
            System.out.println("课程"+cr.id+":"+cr.name);
        }
    }

    /**
     *修改List中的元素
     */
    public void testModify() {
        coursesToSelect.set(4, new Course("7", "毛概"));
    }

    /**
     *删除List中的元素
     */

    public void testRemove() {
//        Course cr = (Course) coursesToSelect.get(4);
//        System.out.println("我是课程："+cr.id+":"+cr.name+"即将被删除");
        Course[] courses = {(Course) coursesToSelect.get(4),(Course)coursesToSelect.get(5)};
        coursesToSelect.removeAll(Arrays.asList(courses));
//        coursesToSelect.remove(4);
        System.out.println("成功删除课程！");
        testForEach();
    }

    /**
     *往List中添加一些奇怪的东西
     */

    public void testType() {
        System.out.println("能不能往List中添加一些奇怪的东西呢");
        coursesToSelect.add("一个无辜的字符串");
    }

    public static void main(String[] args) {
        ListTest lt = new ListTest();
        lt.testAdd();
        lt.testGet();
        lt.testiterator();
        lt.testForEach();
        lt.testModify();
        lt.testForEach();
        lt.testRemove();
    }
}
