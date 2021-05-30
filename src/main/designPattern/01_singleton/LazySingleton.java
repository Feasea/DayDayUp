/**
 * 懒汉式：该模式只会在你需要该对象时才会实例化，但线程不安全。
 * 多个线程同时调用方法时，可以同时进入创建对象语句，故会创建多个对象
 */
public class LazySingleton {
    private static LazySingleton INSTANCE;
    private LazySingleton(){}
    public static LazySingleton getInstance(){
        if(null == INSTANCE){
            try{
                Thread.sleep(1);
            } catch(InterruptedException e){
                e.printStackTrace();
            }
            INSTANCE = new LazySingleton();
        }
        return INSTANCE;
    }

    public static void main(String[] args) {
        for(int i = 0; i < 100; i++){
           // 此处为java1.8Lambda表达式写法
           new Thread(()->{
               System.out.println(LazySingleton.getInstance().hashCode());
           }).start();
        }
    }
}
