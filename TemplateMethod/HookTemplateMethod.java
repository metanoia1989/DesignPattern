// 含钩子方法的模板方法模式

public class HookTemplateMethod
{
    public static void main(String[] args)
    {
        // HookAbstractClass tm = n
    }
}

// 含钩子方法的抽象类
abstract class HookAbstractClass
{
    public void TemplateMethod()    // 模板方法
    {
        abstractMehtod1();
        HookMethod1();
        if (HookMethod2()) {
            SpecificMethod();
        }
        abstractMehtod2();
    }

    public void SpecificMethod()    // 具体方法类
    {
        System.out.println("抽象类中的具体方法被调用...");
    }

    public void HookMethod1() {}    // 钩子方法1
    public void HookMethod2()       // 钩子方法2
    {
        return true;
    }
    public abstract void abstractMehtod1(); // 抽象方法1 
    public abstract void abstractMehtod2(); // 抽象方法2 
}

// 含钩子方法的具体子类
class HookConcreteClass extends HookAbstractClass
{
    public void abstractMehtod1()
    {
        System.out.println("抽象方法1的实现被调用...");
    }

    public void abstractMehtod2()
    {
        System.out.println("抽象方法2的实现被调用...");
    }

    public void HookMethod1()
    {
        System.out.println("钩子方法1被重写...");
    }

    public boolean HookMethod2()
    {
        return false;
    }
}