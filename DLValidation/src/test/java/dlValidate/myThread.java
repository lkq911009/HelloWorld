package dlValidate;



public class myThread implements Runnable {

    private Data data;

    public myThread(Data d) {
        data = d;
    }

    @Override
    public void run() {
        while (true)
        {
            int val = data.getEven();
            if (val % 2 != 0) {
                System.out.println(val + " not even!");
            }
        }
    }

}