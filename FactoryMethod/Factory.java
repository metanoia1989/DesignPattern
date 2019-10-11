
public class AbstractFactoryTest
{
    public static void main(String[] args)
    {
        try {
            Product a; 
            AbstractFactory af;
            af = new ConcreteFactory1();
            a = af.newProduct();
            a.show();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

// 抽象产品，提供产品的接口
interface Product
{
    public void show();
}

// 具体产品1
class ConcreteProduct1 implements Product
{
    public void show()
    {
        System.out.println("具体产品1显示...");
    }
}

// 具体产品2
class ConcreteProduct2 implements Product
{
    public void show()
    {
        System.out.println("具体产品2显示...");
    }
}

// 抽象工厂，提供了产品的生成方法
interface AbstractFactory
{
    public Product newProduct();
}

// 具体工厂1
class ConcreteFactory1 implements AbstractFactory
{
    public Product newProduct()
    {
        System.out.println("具体工厂1生成-->具体产品1...");
        return new ConcreteProduct1();
    }
}

// 具体工厂2
class ConcreteFactory2 implements AbstractFactory
{
    public Product newProduct()
    {
        System.out.println("具体工厂2生成-->具体产品2...");
        return new ConcreteProduct2();
    }
}