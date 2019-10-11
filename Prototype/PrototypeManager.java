import java.util.Map;

// 原型管理器，创建具体原型类的对象，并记录每一个被创建的对象。
// 原型管理器角色保持一个聚集，作为对所有原型对象的登记，
// 这个角色提供必要的方法，供外界增加新的原型对象和取得已经登记过的原型对象。

public interface Prototype
{
    public Prototype clone();
    public String getName();
    public void setName(String name);
}

public class ConcretePrototype implements Prototype
{
    private String name;

    public Prototype clone()
    {
        ConcretePrototype prototype = new ConcretePrototype();
        prototype.setName(this.name);
        return prototype;
    }

    public String toString()
    {
        return "Now in Prototype, name = " + this.name;
    }

    @Override
    public String getName()
    {
        return name;
    }

    @Override
    public void setName(String name)
    {
        this.name = name;
    }
}

public class PrototypeManager
{
    /**
     * 用来记录原型的编号和原型实例的对应关系
     */
    private static Map<String, Prototype> map = new HashMap<String, Prototype>();

    /**
     * 私有化构造方法，避免外部创建实例
     */
    private PrototypeManager() {}

    /**
     * 向原型管理器里添加或是修改某个原型注册
     * @param prototypeId   原型编号
     * @param prototype  原型实例
     */
    public synchronized static void setPrototype(String prototypeId, Prototype prototype)
    {
        map.put(prototypeId, prototype);
    }

    /**
     * 从原型管理器里面删除某个原型注册
     * @param prototypeId
     */
    public synchronized static void removePrototype(String prototypeId)
    {
        map.remove(prototypeId);
    }

    /**
     * 获取某个原型编号对应的原型实例
     * @param prototypeId   原型编号
     * @return  原型编号对应的原型实例
     * @throws Exception    如果原型编号对应的实例不存在，则抛出异常
     */
    public synchronized static Prototype getPrototype(String prototypeId) throws Exception
    {
        Prototype prototype = map.get(prototypeId);
        if (prototype == null) {
            throw new Exception("您希望获取的原型还没有注册或已被销毁！");
        }
        return prototype;
    }

}

public class Client
{
    public static void main(String[] args)
    {
        try {
            Prototype p1 = new ConcretePrototype();
            PrototypeManager.setPrototype("p1", p1);

            // 获取原型来创建对象
            Prototype p3 = PrototypeManager.getPrototype("p1").clone();
            p3.setName("name张三");
            System.out.println("第一个实例：" + p3);

            // 注销了这个原型
            PrototypeManager.removePrototype("p1");
            // 再次获取原型来创建对象
            Prototype p5 = PrototypeManager.getPrototype("p1").clone();
            p5.setName("name王五");
            System.out.println("第二个实例：" + p5);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}