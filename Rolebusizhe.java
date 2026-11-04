package wenzigedouyouxi;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Rolebusizhe extends Role {
    List<String> busizheSkills = new ArrayList<>(List.of("兔子的怀表", "黑之力", "大工的长锚", "复活"));

    public Rolebusizhe() {
    }

    public Rolebusizhe(String name, char sex) {
        super(name, sex);
    }

    @Override
    public void print() {
        System.out.println("你的角色的属性是：");
        System.out.println("姓名：" + getName());
        System.out.println("性别：" + getSex());
        System.out.println("生命值：" + getLife());
        System.out.println("回合数：" + count);
    }

    @Override
    public int attack(Role role) {
        System.out.println("回合开始：");
        System.out.println("敌人的信息：");
        System.out.println("姓名：" + role.getName());
        System.out.println("性别：" + role.getSex());
        System.out.println("生命值：" + role.getLife());

        Random random = new Random();
        System.out.println("选择你要使用的技能：");
        for (int i = 0; i < busizheSkills.size(); i++) {
            // 【修复】原来所有技能挤在一行，改为每个技能单独一行
            System.out.println(i + "：" + busizheSkills.get(i));
        }
        int j = Role.SC.nextInt();
        int attackbusizhe = 0;
        switch (j) {
            case 0: // 兔子的怀表：拖延时间，本回合不造成伤害
                this.count += 2;
                break;
            case 1: // 黑之力
                attackbusizhe = random.nextInt(0, 50);
                break;
            case 2: // 大工的长锚
                attackbusizhe = random.nextInt(20, 30);
                break;
            case 3: // 复活
                // 【修复】用 contains 判断，复活用过一次后就不能再用
                if (busizheSkills.contains("复活")) {
                    this.life = LIFE;
                    busizheSkills.remove("复活");
                    System.out.println("你使用了复活，生命值回满！");
                } else {
                    System.out.println("杂鱼，复活已经用过了哦~");
                }
                break;
            default:
                System.out.println("杂鱼，没有这个选项哦~");
                attackbusizhe = 0;
                break;
        }

        // 【修复】回合结束统一扣除回合数
        count--;
        role.life = role.life - attackbusizhe;

        if (role.life <= 0) {
            System.out.println("你击败了" + role.getName() + "，胜利!");
        } else {
            System.out.println("你造成了" + attackbusizhe + "点伤害");
            System.out.println("敌人还有" + role.getLife() + "滴血");
        }
        System.out.println("还剩下" + count + "个回合");
        return attackbusizhe;
    }
}
