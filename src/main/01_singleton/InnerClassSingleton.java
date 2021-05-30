/**
 * 内部类：类中新建私有化的holder内部类，JVM保证线程安全
 */
public class InnerClassSingleton {
    private InnerClassSingleton(){}

    private static class InnerClassSingletonHolder{
        private final static InnerClassSingleton INSTANCE = new InnerClassSingleton();
    }

    public static InnerClassSingleton getInstance(){
        return InnerClassSingletonHolder.INSTANCE;
    }

    public static void main(String[] args) {
        for(int i = 0; i < 100; i++){
            // 此处为java1.8Lambda表达式写法
            new Thread(()->{
                System.out.println(InnerClassSingleton.getInstance().hashCode());
            }).start();
        }
    }
}
