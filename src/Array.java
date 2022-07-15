public class Array {
    private int[] items;
    private int count;

    public Array(int length) {
        items = new int[length];
    }

    public void insert(int item) {
        checkIfResizeIsNeeded();
        items[count++] = item;
    }

    private void checkIfResizeIsNeeded() {
        if (items.length == count) {
            int[] newItems = new int[count * 2];
            for (int i = 0; i < count; i++)
                newItems[i] = items[i];
            items = newItems;
        }
    }

    public void insertAtIndex (int item, int index){
        if(index < 0 || index >= count)
            throw new IndexOutOfBoundsException();

        checkIfResizeIsNeeded();
        for(int i = count - 1; i >= index;i--)
            items[i + 1] = items[i];

        for (int i = 0; i < count; i++)
            items[index] = item;
       count++;
    }


    public void removeAtIndex(int index) {
        if (index < 0 || index >= count)
            throw new IndexOutOfBoundsException();

        for (int i = 0; i < count; i++)
            items[i] = items[i + 1];
        count--;
    }

    public int indexOfNumber(int item) {
        for (int i = 0; i < count; i++)
            if (items[i] == item)
                return i;
        return -1;
    }

    public void maxNumber(){
        int nrMax = items[0];
        for (int i = 0; i < count; i++){
            if(items[i] > nrMax)
                nrMax = items[i];
        }
        System.out.println(nrMax);
    }

    public void reverse() {
        for(int i = count - 1; i>=0; --i){
            System.out.println(items[i]);
        }
    }

    public void print() {
        for (int i = 0; i < count; i++) {
            System.out.println(items[i]);
        }
    }
}
