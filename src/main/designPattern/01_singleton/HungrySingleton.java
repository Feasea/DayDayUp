/**
 * 01单例模式：当全局仅需要一个实例化对象的时候，要使用此模式。
 * 例如：manager等类
 * 饿汉式：该模式在初始化项目的时候，即会被实例化入内存中，但其是线程安全的。
 */
public class HungrySingleton {
    // 静态变量赋初始值
    private static final HungrySingleton INSTANCE = new HungrySingleton();
    // 私有构造方法，禁止new对象
    private HungrySingleton(){}
    // 此处必须为静态方法，无法初始化对象，使用其余方法关键字，无法执行该方法
    public static HungrySingleton getInstance(){
        return INSTANCE;
    }

    public static void main(String[] args) {
        for(int i = 0; i < 100; i++){
            // 此处为java1.8Lambda表达式写法
            new Thread(()->{
                System.out.println(HungrySingleton.getInstance().hashCode());
            }).start();
        }
    }
}
