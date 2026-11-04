package wenzigedouyouxi;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("请输入你想要玩的模式：（1：狂扁deepseek                    2：双人对打）");
            int A = sc.nextInt();
            if (A == 1) {
                while (true) {
                    System.out.println("请输入你要选择的角色类型：(不死者/家成)");
                    String x = sc.next();
                    if (x.equals("不死者")) {
                        System.out.println("请输入角色的姓名以及性别");
                        Zayu zayu = new Zayu("deepseek");
                        String name = sc.next();
                        char sex = sc.next().charAt(0);
                        Role role1 = new Rolebusizhe(name, sex);
                        role1.print();
                        role1.attack(zayu);
                        zayu.attack(role1);
                    } else if (x.equals("家成")) {
                        System.out.println("请输入角色的姓名以及性别");
                        Zayu zayu = new Zayu("deepseek");
                        String name = sc.next();
                        char sex = sc.next().charAt(0);
                        Role role2 = new Rolelijiacheng(name, sex);
                        role2.print();
                        role2.attack(zayu);
                        zayu.attack(role2);
                    } else {
                        System.out.println("输入角色类型不合法");
                    }
                }

            } else if (A == 2) {
                Role role1=null;
                Role role2=null;
                while (true) {
                    System.out.println("请输入角色A的角色类型：（不死者/家成）");
                    String xa = sc.next();
                    if (xa.equals("不死者")) {
                        System.out.println("请输入角色的姓名以及性别");

                        String name = sc.next();
                        char sex = sc.next().charAt(0);
                        role1 = new Rolebusizhe(name, sex);
                        role1.print();
                        break;
                    } else if (xa.equals("家成")) {
                        System.out.println("请输入角色的姓名以及性别");

                        String name = sc.next();
                        char sex = sc.next().charAt(0);
                        role1 = new Rolelijiacheng(name, sex);
                        role1.print();
                        break;
                    } else {
                        System.out.println("输入角色类型不合法");
                    }
                }
                while (true) {
                    System.out.println("请输入角色B的角色类型：（不死者/家成）");
                    String xb = sc.next();
                    if (xb.equals("不死者")) {
                        System.out.println("请输入角色的姓名以及性别");
                        String name = sc.next();
                        char sex = sc.next().charAt(0);
                        role2 = new Rolebusizhe(name, sex);
                        role2.print();
                        break;
                    } else if (xb.equals("家成")) {
                        System.out.println("请输入角色的姓名以及性别");
                        String name = sc.next();
                        char sex = sc.next().charAt(0);
                        role2 = new Rolelijiacheng(name, sex);
                        role2.print();
                        break;
                    } else {
                        System.out.println("输入角色类型不合法");
                    }
                }
                // 这里前面应该是你选好 role1 和 role2 的代码
                System.out.println("=== 双人对战开始 ===");

                while (true) {
                    System.out.println("\n请选择你的操作：");
                    System.out.println("1." + role1.getName() + " 攻击 " + role2.getName());
                    System.out.println("2." + role2.getName() + " 攻击 " + role1.getName());
                    System.out.println("0.退出");

                    int a = sc.nextInt();

                    if (a == 0) {
                        System.out.println("游戏已退出。");
                        break;
                    }
                    else if (a == 1) {
                        // 玩家1出手
                        role1.attack(role2);

                        // 【裁判立刻检查】：玩家2死了没？
                        if (role2.getLife() <= 0) {
                            System.out.println("💀 " + role2.getName() + " 倒下了！");
                            System.out.println("🎉 " + role1.getName() + " 获得了最终胜利！");
                            break; // 游戏结束，跳出循环！
                        }
                    }
                    else if (a == 2) {
                        // 玩家2出手
                        role2.attack(role1);

                        // 【裁判立刻检查】：玩家1死了没？
                        if (role1.getLife() <= 0) {
                            System.out.println("💀 " + role1.getName() + " 倒下了！");
                            System.out.println("🎉 " + role2.getName() + " 获得了最终胜利！");
                            break; // 游戏结束，跳出循环！
                        }
                    }
                    else {
                        System.out.println("杂鱼，选项都选不对吗~");
                    }
                }
            }
        }
    }
}
