
import java.util.*;
class huffmanNode{
    char character;
    int frequency;
    huffmanNode left;
    huffmanNode right;
    huffmanNode(char character,int frequency){
        this.character=character;
        this.frequency=frequency;
        this.left=null;
        this.right=null;
    }
}

public class Huffman {
    public static void generateHuffmanCodes(Map<Character,Integer>frMap){
    PriorityQueue<huffmanNode> pq=new PriorityQueue<>((x,y)-> Integer.compare(x.frequency, y.frequency));
   for(Map.Entry<Character,Integer> entry:frMap.entrySet()){
    pq.add(new huffmanNode(entry.getKey(), entry.getValue()));

   }
    while(pq.size()>1){
        huffmanNode left=pq.poll();
    huffmanNode right=pq.poll();
    huffmanNode newNode=new huffmanNode('-', left.frequency+right.frequency);
        newNode.left=left;
        newNode.right=right;
        pq.add(newNode);
    }
    huffmanNode root = pq.poll();
        System.out.println("Character with corresponding Huffman Codes:");
        printHuffmanCodes(root, "");
    }
    public static void printHuffmanCodes(huffmanNode root,String code){
        if(root.left==null && root.right==null &&Character.isLetter(root.character)){
            System.out.println(root.character+":"+code);
        }
        if(root.left!=null){
            printHuffmanCodes(root.left, code+"0");
        }
        if(root.right!=null){
            printHuffmanCodes(root.right, code+"1");
        }
    }
    public static void main(String [] args){
        System.out.print("enter number of characters:");
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        Map<Character,Integer> frMap=new HashMap<>();
        for(int i=0;i<n;i++){
            System.out.print("Enter character " + (i + 1) + ": ");
            char ch=sc.next().charAt(0);
            System.out.print("Enter frequency of '" + ch + "': ");
            int frequency=sc.nextInt();
            frMap.put(ch,frequency);
        }
        generateHuffmanCodes(frMap);
    }
}
