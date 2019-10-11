
// 原型接口
public interface Prototype 
{
    /**
     * 克隆自身的方法
     * @return 一个从自身克隆出来的对象
     */
    public Object clone();
}

// 具体原型
public class ConcretePrototype implements Prototype 
{
    /** 
     * 最简单的克隆，新建一个自身对象
     */
    public Prototype clone()
    {
        Prototype prototype = new ConcretePrototype();
        return prototype;
    }
}

// 客户端角色
public class Client
{
    /**
     * 持有需要使用的原型接口对象
     */
    private Prototype prototype;

    /**
     * 构造方法，传入需要使用的原型接口对象
     */
    public Client(Prototype prototype) 
    {
        this.prototype = prototype;    
    }

    public void operation(Propotype example)
    {
        // 需要创建原型接口的对象
        Prototype copyPrototype = prototype.clone();
    }
}