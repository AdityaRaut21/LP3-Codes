//Fractional Kanpsack
import java.util.*;
class Item{
    int value;
    int weight;
    Item(int value,int weight){
        this.value=value;
        this.weight=weight;
    }

}
public class Fractional{
    public static  double function(Item [] items,int capacity){
        double totalValue=0;
        Arrays.sort(items,new Comparator<Item>() {
            @Override
            public int compare(Item a,Item b){
                double r1=(double)a.value/a.weight;
                double r2=(double)b.value/b.weight;
                return Double.compare(r2, r1);
            }
        });

        for(Item item:items){
            if(capacity>=item.weight){
                capacity-=item.weight;
                totalValue+=item.value;

            }
            else{
                double fraction=(double)capacity/item.weight;
                totalValue+=(item.value*fraction);
                break;

            }
        }
        return totalValue;
    }
    public static void main(String[] args) {
        Item[] items={new Item(100, 20),new Item(60, 10),new Item(120, 30)};
        int capacity=50;
        double maxValue=function( items,capacity);
        System.out.println("Total Profit"+maxValue);
    }
}