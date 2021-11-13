package democat;
import java.time.LocalDate;
import java.util.ArrayList;
public class Test {
    public static void main(String[] args) {
        //创建猫咖实例
        MyCatCafe myCatCafe = new MyCatCafe();
        //创建顾客列表
        ArrayList<Customer> customerArrayList = new ArrayList<>();
        //创建猫列表
        ArrayList<Cat> catArrayList = new ArrayList<>();
        //给定余额
        myCatCafe.balance = 600;
        //买入猫猫
        myCatCafe.buyCat(new OrangeCat("橘猫",2,"公",OrangeCat.price),catArrayList);
        System.out.println("-----------分割线-----------");
        myCatCafe.buyCat(new BlackCat("黑猫",2,"母",BlackCat.price),catArrayList);
        System.out.println("-----------分割线-----------");
        //招待顾客
        myCatCafe.getCustomer(new Customer("林晨旭先生",20, LocalDate.now()),customerArrayList,catArrayList);
        System.out.println("-----------分割线-----------");
        //歇业
        myCatCafe.stop(catArrayList,customerArrayList);

    }
}
