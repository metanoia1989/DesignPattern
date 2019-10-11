// 饿汉式单例
// 类一旦加载就创建一个单例，保证在调用 getInstance 方法之前单例已经存在了

public class HungrySingleton
{
    private static volatile HungrySingleton instance = new HungrySingleton();  // 保证 instance 在所有线程中同步

    private HungrySingleton() {}  // 避免类在外部被实例化

    public static HungrySingleton getInstance()
    {
        return instance;
    }
}