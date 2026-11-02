package wenzigedouyouxi;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你要选择的角色类型：(不死者/家成)");
        String x = sc.next();
        if (x.equals("不死者")) {
            System.out.println("请输入角色的姓名以及性别");
            Zayu zayu=new Zayu("deepseek");
            String name = sc.next();
            char sex = sc.next().charAt(0);
            Role role1 = new Rolebusizhe(name, sex);
            role1.print();
            role1.attack(zayu);
        } else if (x.equals("家成")) {
            System.out.println("请输入角色的姓名以及性别");
            Zayu zayu=new Zayu("deepseek");
            String name = sc.next();
            char sex = sc.next().charAt(0);
            Role role2 = new Rolelijiacheng(name, sex);
            role2.print();
            role2.attack(zayu);
        } else {
            System.out.println("输入角色类型不合法");
        }

    }

}
