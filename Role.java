package wenzigedouyouxi;

import java.util.Random;

public class Role {
    String name;
    char sex;
    int life;
    int LIFE;

    public Role() {
    }

    public Role(String name, char sex) {
        this.name = name;
        this.sex = sex;
        Random random = new Random();
        int life=random.nextInt(100,200);
        this.life = life;
        this.LIFE=life;
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
    public void print(){}
    public int attack(Role role){
        Random random = new Random();
        int j=random.nextInt(0,40);
        role.life = role.life - j;
        return j;
    }
}
