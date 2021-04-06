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
        for(int i = 0; i < array.length; i++) {
            if (array[i] == value)
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
        for (int i = 0; i < array.length; i++){
            builder.append(array[i] + ", ");
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
    }

    private void selectionSort() {
        //TODO*: сортировка выбором (по возрастанию)
    }

    private void mergeSort() {
        //TODO**: сортировка слиянием (по возрастанию)
    }

    private void quickSort() {
        //TODO**: быстрая сортировка (по возрастанию)
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
