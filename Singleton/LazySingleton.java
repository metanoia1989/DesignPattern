// 懒汉式单例
// 类加载时没有生成单例，只有当第一次调用 getlnstance 方法时才去创建这个单例

public class LazySingleton
{
    private static volatile LazySingleton instance = null;  // 保证 instance 在所有线程中同步

    private LazySingleton() {}  // 避免类在外部被实例化

    public static synchronized LazySingleton getInstance()  // 方法前先加同步
    {
        if (instance == null) {
            instance = new LazySingleton();
        }        
        return instance;
    }
}