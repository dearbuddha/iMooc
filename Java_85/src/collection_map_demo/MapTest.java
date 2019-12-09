package collection_map_demo;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class MapTest {
    /**
     * 创建Map类型的属性用来承装学生类型对象，students为属性名称
     */
    public Map<String, Student> students;

    public MapTest(){
        this.students = new HashMap<String, Student>();
    }

    /**
     *测试添加
     */
    public void testPut() {
        Scanner console = new Scanner(System.in);
        int i = 0;
        while (i<3) {
            System.out.println("请输入学生ID：");
            String ID = console.next();
            //判断该ID是否已经被占用
            Student st = students.get(ID);
            if (st == null){
                //提示输入学生姓名
                System.out.println("请输入学生姓名：");
                String name = console.next();
                //创建新的学生对象
                Student newStudent = new Student(ID, name);
                //通过调用student的put方法，添加ID-学生映射
                students.put(ID,newStudent);
                System.out.println("成功添加学生："+ students.get(ID).name);
                i++;
            } else{
                System.out.println("该学生ID已被占用！");
                continue;
            }
        }
    }

    /**
     *
     */

    public void testKeySet(){
        //通过keySet方法，返回Map中的所有"键"的Set集合
        Set<String> keySet = students.keySet();
        //取得students的容量
        System.out.println("总共有："+students.size()+"个学生！");
        //遍历keySet，取得每一个键，再调用get方法取得每个键对应的value
        for (String stuId:keySet){
            Student st = students.get(stuId);
            if (st!=null){
                System.out.println("学生："+st.name);
            }
        }
    }

    public void testRemove() {
        //提示用户输入待删除学生的ID
        System.out.println("要删除学生的ID：");
        while (true) {
            //获取从键盘输入的待删除学生的ID
            Scanner console = new Scanner(System.in);
            String ID = console.next();
            //判断该ID是否有对应的学生对象
            Student st = students.get(ID);
            if (st==null) {
                //提示输入的ID并不存在
                System.out.println("该ID不存在");
                continue;
            }
            students.remove(ID);
            System.out.println("成功删除学生："+st.name);
            break;
        }

    }

    /**
     *通过entrySet方法来遍历Map
     */
    public void testEntrySet() {
        Set<Map.Entry<String, Student>> entrySet = students.entrySet();
        for (Map.Entry<String, Student> entry:entrySet) {
            System.out.println("取得键："+entry.getKey());
            System.out.println("对应的值为：" + entry.getValue().name);
        }
    }

    /**
     *利用put方法修改Map中已经的映射
     */
    public void testModify() {
        System.out.println("请输入要修改的学生ID：");
        Scanner console = new Scanner(System.in);
        while (true){
            String stuID = console.next();
            Student student = students.get(stuID);
            if (student == null){
                System.out.println("该ID不存在！请重新输入：");
                continue;
            }
            System.out.println("当前查找到的学生为："+ student.name);
            System.out.println("请输入新的学生姓名：");
            String name = console.next();
            Student newStudent = new Student(stuID, name);
            students.put(stuID, newStudent);
            System.out.println("修改成功");
            break;
        }
    }

    public static void main(String[] args) {
        MapTest mt = new MapTest();
        mt.testPut();
        mt.testKeySet();
        mt.testRemove();
        mt.testEntrySet();
        mt.testModify();
        mt.testEntrySet();
    }
}
