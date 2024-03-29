// 对象适配器


// 目标接口
interface Target
{
    public void request();
}

// 适配者接口
class Adaptee
{
    public void specificRequest()
    {
        System.out.println("适配器中的业务代码被调用");
    }
}

// 对象适配器类
class ObjectAdapter implements Target
{
    private Adaptee adaptee;
    public ObjectAdapter(Adaptee adaptee)
    {
        this.adaptee = adaptee;
    }

    public void request()
    {
        adaptee.specificRequest();
    }
}

// 客户端代码
public class ObjectAdapterTest
{
    public static void main(String[] args)
    {
        System.out.println("对象适配器模板测试：");
        Adaptee adaptee = new Adaptee();
        Target target = new ObjectAdapter(adaptee);
        target.request();
    }
}