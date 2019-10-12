// 用组合模式实现当用户在商店购物后，显示其所选商品信息，并计算所选商品总价的功能。

import java.util.ArrayList;

public class ShoppingTest
{
    public static void main(String[] args) {
    }
}


// 抽象构件，物品
interface Articles
{
    public float calculation(); // 计算
    public void show();
}

// 树叶构件，商品
class Goods implements Articles
{
    private String name;    // 名字
    private int quantity;    // 数量
    private float unitPrice;    // 单价
    public Goods(String name, int quantity, float unitPrice)
    {
        this.name = name;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    public float calculation()
    {
        return quantity * unitPrice;
    }

    public void show()
    {
        System.out.println(name + "（数量：" + quantity + "，单价：" + unitPrice + "元）");
    }
}

// 树枝构件，袋子
class Bags implements Articles
{
    private String name;    // 名字
    private ArrayList<Articles> bags = new ArrayList<Articles>();
    public Bags(String name)
    {
        this.name = name;
    }
    public void add(Articles c)
    {
        bags.add(c);
    }
    public void remove(Articles c)
    {
        bags.remove(c);
    }
    public Articles getChild(int i)
    {
        return bags.get(i);
    }
    public float calculation()
    {
        float s= 0;
        for(Object obj:bags) {
            s += ((Articles)obj).calculation();
        }
        return s;
    }
    public void show()
    {
        for(Object obj:bags) {
            ((Articles)ojb).show();
        }
    }
}