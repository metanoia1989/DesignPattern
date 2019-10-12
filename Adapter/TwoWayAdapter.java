// 双向适配器
// 既可以把适配者接口转换成目标接口，也可以把目标接口转换成适配者接口

// 目标接口
interface TwoWayTarget
{
    public void request();
}

// 适配者接口
interface TwoWayAdaptee
{
    public void specifiRequest();
}

// 目标实现
class TargetRealize implements TwoWayTarget
{
    public void request()
    {
        System.out.println("目标代码被调用！");
    }
}

// 适配者实现
class AdapteeRealize implements TwoWayAdaptee
{
    public void specifiRequest()
    {
        System.out.println("适配者代码被调用！");
    }
}


// 双向适配器
class TwoWayAdapter implements TwoWayTarget, TwoWayAdaptee
{
    private TwoWayTarget target;
    private TwoWayAdaptee adaptee;

    public TwoWayAdapter(TwoWayTarget target)
    {
        this.target = target;
    }

    public TwoWayAdapter(TwoWayAdaptee adaptee)
    {
        this.adaptee = adaptee;
    }

    public void request()
    {
        adaptee.specifiRequest();
    }

    public void specifiRequest()
    {
        target.request();
    }
}

// 客户端代码
public class TwoWayAdapterTest
{
    public static void main(String[] args)
    {
        System.out.println("目标通过双向是配置访问适配者：");
        TwoWayAdaptee adaptee = NEW AdapteeRealize();
        TwoWayTarget target = new TwoWayAdapter(adaptee);
        target.request();

        System.out.println("适配者通过双向适配器访问目标：")
        target = new TargetRealize();
        adaptee = new TwoWayAdapter(target);
        adaptee.specifiRequest();
}