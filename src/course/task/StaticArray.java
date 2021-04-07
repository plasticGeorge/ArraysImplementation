package course.task;

public class StaticArray implements Array {

    protected int[] array;

    public StaticArray(int[] a) {
        this.array = new int[a.length];
        System.arraycopy(a, 0, this.array, 0, a.length);
    }

    @Override
    public int size() {
        // TODO: вернуть длину массива
        return array.length;
    }

    @Override
    public boolean contains(int value) {
        // TODO: проверить, что элемент есть в массиве
        for (int j : array) {
            if (j == value)
                return true;
        }
        return false;
    }

    @Override
    public int get(int index) {
        // TODO: получить элемент по индексу
        return array[index];
    }

    @Override
    public int set(int index, int value) {
        // TODO: присвоить значение по индексу. Вернуть значение элемента, которое заменили
        int oldValue = array[index];
        array[index] = value;
        return oldValue;
    }

    @Override
    public int indexOf(int value) {
        // TODO: получить индекс первого подходящего элемента
        for(int i = 0; i < array.length; i++){
            if(array[i] == value)
                return i;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(int value) {
        // TODO: получить индекс последнего подходящего элемента
        int res = -1;
        for(int i = 0; i < array.length; i++){
            if(array[i] == value)
                res = i;
        }
        return res;
    }

    @Override
    public void reverse() {
        // TODO: перевернуть массив
        for(int i = 0; i < array.length / 2; i++){
            int temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }
    }

    @Override
    public Array subArray(int fromIndex, int toIndex) {
        // TODO: вернуть подмассив, начиная с индекса fromIndex включительно и заканчивая индексом toIndex невкоючительно
        int[] res = new int[toIndex - fromIndex];
        for(int i = fromIndex; i < toIndex; i++) {
            res[i - fromIndex] = array[i];
        }
        return new StaticArray(res);
    }

    @Override
    public void sort() {
        bubbleSort();
    }

    @Override
    public void sort(ArraySort sort) {
        switch (sort) {
            case BUBBLE:
                bubbleSort();
                break;
            case INSERTION:
            case SELECTION:
            case MERGE:
            case QUICK:
            default:
                sort();
        }
    }

    @Override
    public String toString() {
        // TODO: вернуть массив в виде строки. Например, [3, 4, 6, -2]
        StringBuilder builder = new StringBuilder(array.length * 3 + 2);

        builder.append('[');
        for (int j : array) {
            builder.append(j).append(", ");
        }
        builder.replace(builder.lastIndexOf(", "), builder.length(), "]");

        return builder.toString();
    }

    private void bubbleSort() {
        // TODO: сортировка пузырьком (по возрастанию)
        for(int i = 0; i < array.length - 1; i++){
            int swapsCount = 0;
            for(int j = 0; j < array.length - i - 1; j++){
                if(array[j] > array[j + 1]){
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapsCount++;
                }
            }
            if(swapsCount == 0)
                break;
        }
    }

    private void insertionSort() {
        //TODO*: сортировка вставками (по возрастанию)
        for(int i = 1; i < array.length; i++){
            for(int j = i; j > 0 && array[j - 1] > array[j]; j--){
                int temp = array[j];
                array[j] = array[j - 1];
                array[j - 1] = temp;
            }
        }
    }

    private void selectionSort() {
        //TODO*: сортировка выбором (по возрастанию)
        for(int i = 0; i < array.length; i++){
            int min = i;
            for(int j = i; j < array.length; j++){
                if(array[j] < array[min])
                    min = j;
            }
            if(i != min){
                int temp = array[i];
                array[i] = array[min];
                array[min] = temp;
            }
        }
    }

    private void mergeSort() {
        //TODO**: сортировка слиянием (по возрастанию)
    }

    private void quickSort(){
        quickSort(0, array.length - 1);
    }

    private void quickSort(int start, int end) {
        //TODO**: быстрая сортировка (по возрастанию)
        int s = start,
            e = end,
            pivot = array[(start + end) / 2];
        while(s <= e){
            while(array[s] < pivot)
                s++;
            while (array[e] > pivot)
                e--;
            if(s < e){
                int temp = array[s];
                array[s] = array[e];
                array[e] = temp;
                s++; e--;
            }
            else if(s == e) {
                s++; e--;
                break;
            }
        }
        if(s < end)
            quickSort(s, end);
        if(e > start)
            quickSort(start, e);
    }

    public boolean isAscSorted() {
        // TODO: проверить, что массив отсортирован по возрастанию
        for(int i = 0 ; i < array.length - 1; i++) {
            if (array[i] > array[i + 1])
                return false;
        }
        return true;
    }
}
