import java.util.Scanner;
import java.util.LinkedList;

public class LoveCalculator{

     public static void main(String []args){
        
        Scanner konsoli = new Scanner(System.in);
        System.out.print("Anna nimesi?");
        String nimi1 = konsoli.nextLine();
        System.out.println(nimi1);
        System.out.println("loves");
        String nimi2 = konsoli.nextLine();

        int l= 0;
        int o= 0;
        int v= 0;
        int e= 0;
        int s= 0;
        nimi1+=nimi2;
        for (char c: nimi1.toCharArray()) {
            if (c=='l'){
                l++;
            }else if(c=='o'||c=='O'){
                o++;
            }else if(c=='v'||c=='V'){
                v++;
            }else if(c=='e'||c=='E'){
                e++;
            }else if(c=='s'||c=='S'){
                s++;
            };
        };
        
        LinkedList<Integer> oleleo=new LinkedList<Integer>();
        oleleo.addLast(l);
        oleleo.addLast(o);
        oleleo.addLast(v);
        oleleo.addLast(e);
        oleleo.addLast(s);

        oleleo = LoveCalc(oleleo);
        System.out.println("Loves-prosenttinne on "+LoveCalc(oleleo).get(0)+""+oleleo.get(1)+"%");
     }
     
     public static LinkedList<Integer> LoveCalc(LinkedList<Integer> input){
         System.out.println(input);
         if (input.size()<3){
             return input;
         };
	if (input.size()>100){
		input.addFirst(0);
		input.addFirst(10);
	     return input;
	};
         
         LinkedList<Integer> next = new LinkedList<Integer>();
         int sum = 0;
         for(int i=0; i<input.size()-1; i++){
             int c = input.get(i);
             int d = input.get(i+1);
             sum = c+d;                         
             if (sum<10){
                next.addLast(sum);
             }else{
                next.addLast(1);
                next.addLast(sum-10);
             }
         }
         
         return LoveCalc(next);
    }
}


