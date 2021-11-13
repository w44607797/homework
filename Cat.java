package democat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;
abstract class Cat{
    protected String name;
    protected int age;
    protected String gender;
    protected double price;
    public Cat(String name,int age,String gender,double price){
    this.name = name;
    this.age = age;
    this.gender = gender;
    this.price = price;
    }
    @Override
    abstract public String toString();
}
class OrangeCat extends Cat{
    boolean isFat;
    static final double price = 200;
    public OrangeCat(String name, int age, String gender, double price) {
        super(name, age, gender,price);
    }
    @Override
    public String toString() {
        return "猫的名字是:"+name+"\n猫的年龄是:"+age+"\n猫的性别是:"+gender+"\n猫的价格是:"+price+"\n猫的胖瘦是:"+isFat;
    }
}
class BlackCat extends Cat{
    static final double price = 350;
    public BlackCat(String name, int age, String gender,double price) {
        super(name, age, gender,price);
    }
    @Override
    public String toString() {
        return "猫的名字是:"+name+"\n猫的年龄是:"+age+"\n猫的性别是:"+gender+"\n猫的价格是:"+price;
    }
}
class Customer{
    String name;
    int rua;
    LocalDate time;
    public Customer(String name, int rua, LocalDate time) {
        this.name = name;
        this.rua = rua;
        this.time = time;
    }
    @Override
    public String toString(){
        return "顾客的名字是:"+name+"\n顾客要rua的次数是:"+rua+"\n顾客的到店时间是:"+time;
    }
}
interface CatCafe{
    void buyCat(Cat cat,ArrayList<Cat> CatArrayList);
    void stop(ArrayList<Cat> CatArrayList,ArrayList<Customer> CustomerArrayList);
    void getCustomer(Customer customer,ArrayList<Customer> CustomerArrayList,ArrayList<Cat> catArrayList);
}
class MyCatCafe implements CatCafe{
    double balance;
        @Override
        public void buyCat (Cat cat,ArrayList<Cat> catArrayList){

            //我自己定义了一个CanNotAfford,所以第一个if估计用不到，但是题目要求我就蛮写
            //我怕程序终止所以加了trycatch

            try {
                if (balance < 0) {
                    throw new InsufficientBalanceException("余额小于0,无法购买");
                }
            }catch (InsufficientBalanceException e){
                System.out.println(e.getMessage());
            }
            try {
                if (balance < cat.price) {
                    throw new CanNotAfford("买不起阿");
                }else{
                    catArrayList.add(cat);
                    balance -= cat.price;
                }
            }catch (CanNotAfford canNotAfford){
                System.out.println(canNotAfford.getMessage());
            }
    }
    @Override
    public void stop(ArrayList<Cat> CatArrayList,ArrayList<Customer> CustomerArrayList) {
        int totalRua = 0;
        int profit;
        int spend = 0;
        for(Customer customer:CustomerArrayList){
            System.out.print("今日关顾的顾客信息:\n");
            if(Objects.equals(customer.time, LocalDate.now())){
                System.out.println(customer);
            }
        }
        for(Customer customer:CustomerArrayList) {
            totalRua += customer.rua;
        }
        for(Cat cat:CatArrayList){
            spend += cat.price;
        }
        profit = totalRua*15 - spend;
        System.out.println("店内猫被rua的次数是:"+totalRua+"次"+"\n今天的花费是:"+spend+"\n今天的利润是:"+profit);
    }
    @Override
    public void getCustomer(Customer customer, ArrayList<Customer> CustomerArrayList,ArrayList<Cat> catArrayList) {
            Random random = new Random();
            CustomerArrayList.add(customer);
            try {
                if (catArrayList.size() == 0) {
                    throw new CatNotFoundException("店内没有猫可以rua");
                } else {
                    System.out.println(customer.name+"摸的猫是:\n"+catArrayList.get(random.nextInt(catArrayList.size())));
                }
            }catch (CatNotFoundException catNotFoundException){
                System.out.println(catNotFoundException.getMessage());
            }
    }
}
class CatNotFoundException extends RuntimeException{
    public CatNotFoundException(String message){
        super(message);
    }
}
class InsufficientBalanceException extends RuntimeException{
    public InsufficientBalanceException(String message){
        super(message);
    }
}
class CanNotAfford extends RuntimeException{
    public CanNotAfford(String message){super(message);}
}

