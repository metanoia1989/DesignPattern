// 享元模式

import java.util.HashMap;

public class FlyweightPatten
{
    public static void main(String[] args)
    {

    }
}

// 非享元角色
class UnsharedConcreteFlyweight
{
    private String info;
    UnsharedConcreteFlyweight(String info)
    {
        this.info = info;
    }

    public String getInfo()
    {
        return info;
    }

    public void setInfo(String info)
    {
        this.info = info;
    }
}

// 抽象享元角色
interface Flyweight
{
    public void operation(UnsharedConcreteFlyweight state);
}

// 具体享元角色
class ConcreteFlyweight implements Flyweight
{
    private String key;
    ConcreteFlyweight(String key)
    {
        this.key = key;
        System.out.println("具体享元" + key + "被创建！");
    }

    public void operation(UnsharedConcreteFlyweight outState)
    {
        System.out.println("具体享元" + key + "被调用！");
        System.out.println("非享元信息：" + outState.getInfo());
    }

    }
}

// 享元工厂角色
class FlyweightFactory
{
    private HashMap<String, Flyweight> flyweights = new HashMap<String, Flyweight>();
    public Flyweight getFlyweight(String key) {
        Flyweight flyweight = (Flyweight) flyweights.get(key);
        if (flyweight != null) {
            System.out.println("具体享元" + key + "已经存在，被成功获取");
        } else {
            flyweight = new ConcreteFlyweight(key);
            flyweights.put(key flyweight);
        }
        return flyweight;
    }
}