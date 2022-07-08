//import java.util.stream.IntStream;
//import java.util.Arrays;
import java.util.ArrayList;
import java.util.Random;


public class Prison {
    int size;
    boolean success = true;
    //int[] boxLabel;
    ArrayList<Integer> boxLabel = new ArrayList<>();
    int[] boxCont;
    Random rand = new Random();
    //ArrayList<Integer> boxCont = new ArrayList<>();

    Prison(int size) {
        //TimeLog tl = new TimeLog();
        this.size = size;
        for (int i = 1; i <= size; i++)
        {
            boxLabel.add(i);
        }
        //tl.logTime();
        
        boxCont = new int[size];
        
        for (int i = 0 ; i < size ; i++){
            Integer n = 0;
            /*do{
                n = ((int)(Math.random() * 100) % size + 1);
            } while (contains(boxCont, n) == true);
            boxCont[i-1] = n;*/
            //System.out.println(n);
            //int bLs = boxLabel.size();
            n = ((int)(Math.random()*(boxLabel.size()) % boxLabel.size() + 1));
            
            //System.out.println(size-i);
            //n = ((int)(Math.random()*(size-i) % size-i + 1));
            //System.out.println(""+(size-i) + " " + n + " ");
            //System.out.println(size-i);
            /*if (size-i > 1){
                n = rand.ints(1,size-i).findFirst().getAsInt();
            }
            else{
                n = size-i;
            }*/
            //System.out.println(n);
            
            boxCont[i] = boxLabel.get(n-1);

            /*if (i < 95){
                boxCont[i+5] = boxLabel.get(n-1);
            }
            else{
                boxCont[i-95] = boxLabel.get(n-1);
            }*/

            boxLabel.remove(n-1);
       }
       //tl.logTime();
       //tl.displayLog();
       for (int i = 1; i < size+1 ; i++){
           //System.out.println(i);
           int pR = prisonerRun(i);
           if (pR > size/2){
               success = false;
               break;
           }
       }
       //tl.logTime();
       //tl.displayLog();
    }

    public static <Integer> boolean contains(final int[] array, final int v) {

        for (final int e : array)
            if (e == v)
                return true;
        return false;
    }

    private int prisonerRun(int i){
        int currentNumber = i+5;
        int tries = 0;
        int cN = 0;
        while(true){
            tries++;
            cN = boxCont[currentNumber-1];

            /*
            if (currentNumber < 95){
                cN = boxCont[currentNumber+4];
            }
            else{
                cN = boxCont[currentNumber-89];
            }
            */


            if (cN == i){
                return tries;
            }
            else {
                currentNumber = cN;
            }
            System.out.println(cN);
        }
    }
}