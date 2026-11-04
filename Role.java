package wenzigedouyouxi;

import java.util.Random;
import java.util.Scanner;

public class Role {
    String name;
    char sex;
    int life;
    int LIFE;   // 生命值上限（复活/回血用），【修复】Zayu 原来没初始化它
    int count;  // 剩余回合数

    // 【修复】全局共用一个 Scanner，避免多处 new Scanner(System.in) 导致输入丢失
    public static final Scanner SC = new Scanner(System.in);

    public Role() {
    }

    public Role(String name, char sex) {
        this.name = name;
        this.sex = sex;
        Random random = new Random();
        int life = random.nextInt(100, 200); // 需要 JDK 17+
        this.life = life;
        this.LIFE = life;
        this.count = 20;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public void print() {
    }

    public int attack(Role role) {
        Random random = new Random();
        int j = random.nextInt(0, 40);
        role.life = role.life - j;
        return j;
    }
}
