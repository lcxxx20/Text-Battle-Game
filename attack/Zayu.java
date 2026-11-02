package wenzigedouyouxi;

import java.util.Random;

public class Zayu extends Role{

    public Zayu(String name) {
        Random random = new Random();
        this.name = name;
        int i=random.nextInt(0,2);
        if(i==0){
            setSex('女');
        }else{
            setSex('男');
        }

        this.life = random.nextInt(100,200);
    }
    public String toString(){
        return "姓名："+name+"性别："+sex+"生命值："+life;
    }

}
