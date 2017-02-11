package dlValidate;

public class Data {

    public int num = 0;

    public synchronized int getEven() {
        ++num;
        System.out.println("lkq");
        Thread.yield();//让另外线程先执行,加大测试效果几率
        ++num;
        return num;
    }

}