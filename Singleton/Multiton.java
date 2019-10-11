import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
 
public class Multition {
 
	//创建2个实例
	private static Multition mul1 = new Multition();
	private static Multition mul2 = new Multition();
	private static List<Multition> list = new ArrayList<Multition>();//用于放多个实例的list  
    private static final int maxCount = 2;//最多的实例数  
    static{  
        list.add(mul1);  
        list.add(mul2);  
    }  
	
	//私有构造函数，确保自己创建自己的实例化
	private Multition(){}
	
	//随机拿取实例
	public static Multition getInstance(){
		Random random = new Random();
		int current = random.nextInt(maxCount);
		return list.get(current);
	}
	
	//指定拿取某一个实例
	public static Multition getInstance(int index){
		return list.get(index);
	}
	
	// 掷骰子 
    public synchronized int mul(){  
        Date d = new Date();  
        Random r = new Random(d.getTime());  
        int value = r.nextInt();  
        value = Math.abs(value)%6+1;  
        return value;  
    }  
	
	public static void main(String[] args) {
		mul1 = Multition.getInstance(1);
		mul2 = Multition.getInstance();		
		System.out.println(mul1.mul() + "\t" + mul2.mul());
	}
}