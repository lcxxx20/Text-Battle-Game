package wenzigedouyouxi;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


public class Rolebusizhe extends Role {
    List<String> Rolebusizheskills = new ArrayList<>(List.of("兔子的怀表", "黑之力", "大工的长锚", "复活"));

    public Rolebusizhe() {
    }

    public Rolebusizhe(String name, char sex) {
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

        Random random = new Random();
        System.out.println("选择你要使用的技能：");
        int attackbusizhe = 0;
        for (int i = 0; i < Rolebusizheskills.size(); i++) {
            System.out.print(i);
            System.out.print(Rolebusizheskills.get(i));
        }
        int j = sc.nextInt();
        switch (j) {
            case 0:
                this.count += 2;
                break;
            case 1:
                attackbusizhe = random.nextInt(0, 50);
                break;

            case 2:
                attackbusizhe = random.nextInt(20, 30);
                break;

            case 3:
                this.life = LIFE;
                Rolebusizheskills.remove(3);
                break;

            default:
                System.out.println("杂鱼，没有这个选项哦~");
                attackbusizhe = 0;
                break;
        }
        count--;
        role.life = role.life - attackbusizhe;
        if (role.life <= 0) {
            System.out.println("你击败了" + role.name + ",胜利!");
        }

        System.out.println("敌人还有" + role.life + "滴血");
        System.out.println("还剩下" + count + "个回合");
        return attackbusizhe;
    }
}

