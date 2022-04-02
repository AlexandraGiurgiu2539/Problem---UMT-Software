import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class Problem {
    private ArrayList<Integer> a = new ArrayList<>();
    private ArrayList<Integer> b = new ArrayList<>();
    private ArrayList<Integer> c = new ArrayList<>();

    /**
     * constructorul clasei
     * @param a
     */
    public Problem(ArrayList<Integer> a){
        this.a = a;
    }

    /**
     * returneaza lungimea array-ului dat ca parametru
     * @param arrayList
     * @return
     */
    public int length(ArrayList<Integer> arrayList){
        int len = 0;

        for (Integer i: arrayList){
            len++;
        }

        return len;
    }

    /**
     * returneaza media elementelor din array-ul dat ca parametru
     * @param arrayList
     * @return
     */
    public float computeAverage(ArrayList<Integer> arrayList){
        int sum = 0;

        for (Integer i: arrayList){
            sum += i;
        }

        return sum/this.length(arrayList);
    }

    /**
     * roteste array-ul dat ca parametru prin mutarea elementului de pe prima pozitie pe ultima
     * @param arrayList
     */
    public void rotateArray(ArrayList<Integer> arrayList){
        Integer aux = arrayList.get(0);
        arrayList.remove(0);
        arrayList.add(aux);
    }

    /**
     * imparte array-ul dat ca parametru in functie de un indice
     * @param arrayList
     * @param splitPoint
     */
    public void splitArray(ArrayList<Integer> arrayList, int splitPoint){
        AtomicInteger count = new AtomicInteger();

        arrayList.forEach(next -> {
            int index = count.getAndIncrement();
            if (index < splitPoint) {
                this.b.add(next);
            } else {
                this.c.add(next);
            }
        });
    }

    /**
     * pentru fiecare indice de la 1 la lungimea array-ului -1 se imparte array-ul a in 2 array-uri
     * se calculeaza media elementelor din fiecare array si se compara rezultatele
     * in caz de egalitate se returneaza true
     * altfel, se roteste array-ul si se executa din nou impartirea array-ului pentru fiecare indice
     * in cel mai rau caz, prin rotiri repetate se ajunge la array-ul initial si se returneaza false
     * @return
     */
    public boolean checkSplit(){
        ArrayList<Integer> copyA = new ArrayList<>(a);
        float avgB = 0;
        float avgC = 0;

        if (this.length(a) == 0) return false;

        for (int j = 0; j < this.length(copyA);j++){
            for (int i = 1;i < this.length(copyA);i++){
                this.b.clear();
                this.c.clear();

                this.splitArray(copyA, i);

                avgB = this.computeAverage(b);
                avgC = this.computeAverage(c);

                if (avgB == avgC) return true;
            }
            this.rotateArray(copyA);
        }

        return false;
    }

}
