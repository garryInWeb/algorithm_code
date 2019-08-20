package old.alTrace.deap;

public class DeapTrae {
    int[] deap;
    int count = 0;
    int MAX_COUNT;

    public DeapTrae(int size) {
        this.deap = new int[size];
        MAX_COUNT = size;
    }

    public int take(){
        return deap[0];
    }

    public void put(int num){
        if (count == MAX_COUNT){
            poll();
        }
        deap[count] = num;
        tranfer(deap,count);
        count ++;
    }
    public int poll(){
        int result = deap[0];
        swap(deap,0,count-1);
        heapify(deap,0);
        count --;
        return result;
    }

    private void heapify(int[] deap, int index) {
        int change = index;
        while(true){
            if(index*2+1<count-1 && deap[change]>deap[index*2+1]){
                change = index*2+1;
            }
            if (index*2+2<count-1 && deap[change]>deap[index*2+2]){
                change = index*2+2;
            }
            if (change != index){
                swap(deap,index,change);
                index = change;
            }else{
                break;
            }
        }

    }

    private void tranfer(int[] deap,int index) {
        while(index > 0 && deap[index] < deap[index / 2]) {
            swap(deap, index, index / 2);
            index /= 2;
        }
    }

    private void swap(int[] deap, int index, int aft) {
        int temp = deap[index];
        deap[index] = deap[aft];
        deap[aft] = temp;
    }

    public static void main(String[] args) {
        DeapTrae deapTrae = new DeapTrae(3);
        deapTrae.put(10);
        deapTrae.put(30);
        deapTrae.put(80);
        deapTrae.put(100);
        deapTrae.put(7);
        deapTrae.put(5);
        deapTrae.put(50);
        deapTrae.print();
    }

    private void print() {
        for (int i : deap){
            System.out.println(i);
        }
    }
}
