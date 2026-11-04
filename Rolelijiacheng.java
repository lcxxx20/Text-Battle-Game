package wenzigedouyouxi;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Rolelijiacheng extends Role {
    List<String> Rolelijiacheng = new ArrayList<>(List.of("脱裤子放屁", "食油饼", "内卷", "大狗叫"));

    public Rolelijiacheng() {
    }

    public Rolelijiacheng(String name, char sex) {
        super(name, sex);
    }

    public void print() {
        System.out.println("你的角色的属性是：");
        System.out.println("姓名" + getName());
        System.out.println("性别：" + getSex());
        System.out.println("生命值：" + getLife());
    }

    public int attack(Role role) {
        Scanner sc = new Scanner(System.in);
        System.out.println("回合开始：");
        System.out.println("敌人的信息：");
        System.out.println("姓名：" + role.getName());
        System.out.println("性别：" + role.getSex());
        System.out.println("生命值：" + role.getLife());
        System.out.println("你的血量：" + this.life);
        Random random = new Random();
        System.out.println("选择你要使用的技能：");
        int attackbusizhe = 0;
        for (int i = 0; i < Rolelijiacheng.size(); i++) {
            System.out.print(i);
            System.out.print(Rolelijiacheng.get(i));
        }
        int j = sc.nextInt();
        switch (j) {
            case 0:
                attackbusizhe = random.nextInt(-50, 50);
                break;
            case 1: {
                attackbusizhe = this.life + random.nextInt(5, 15);
                break;
            }
            case 2:
                attackbusizhe = random.nextInt(30, 45);
                break;
            case 3:
                attackbusizhe = random.nextInt(-20, 50);
                break;
            default:
                System.out.println("杂鱼，没有这个选项哦~");
                attackbusizhe = 0;

        }
        System.out.println("敌人还有" + role.life + "滴血");

        return attackbusizhe;
    }


}
