/**
 * 枚举类：Effective Java 中推荐的此方式，可以实现单例模式。并且可以实现反序列化
 * 枚举类本身无构造方法；
 */
public enum EnumSingleton {
    INSTANCE;

    public static void main(String[] args) {
        for(int i = 0; i < 100; i++){
            // 此处为java1.8Lambda表达式写法
            new Thread(()->{
                System.out.println(EnumSingleton.INSTANCE.hashCode());
            }).start();
        }
    }
}
