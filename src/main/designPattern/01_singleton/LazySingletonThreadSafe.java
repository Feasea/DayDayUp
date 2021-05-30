/**
 * 懒汉式（线程安全式写法）：需要对懒汉式正常写法进行改进，对方法进行加锁
 */
public class LazySingletonThreadSafe {
    private static LazySingletonThreadSafe INSTANCE;
    private LazySingletonThreadSafe(){}

    public static LazySingletonThreadSafe getInstance(){
        // 此处进行双重检查，主要是为了第一次实例化直接进行初次判断，无需后续加锁操作
        if (null == INSTANCE){
            synchronized (LazySingletonThreadSafe.class){
                if(null == INSTANCE){
                    try{
                        Thread.sleep(1);
                    } catch(InterruptedException e){
                        e.printStackTrace();
                    }
                    INSTANCE = new LazySingletonThreadSafe();
                }
            }
        }
        return INSTANCE;
    }

    public static void main(String[] args) {
        for(int i = 0; i < 100; i++){
            // 此处为java1.8Lambda表达式写法
            new Thread(()->{
                System.out.println(LazySingletonThreadSafe.getInstance().hashCode());
            }).start();
        }
    }
}
