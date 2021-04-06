package course.task;

/**
 * Динамический массив
 */
public class DynamicArray extends StaticArray implements Dynamic {

    private static final int DEFAULT_CAPACITY = 10;
    private static final float GROW_FACTOR = 1.5f;

    /**
     * текущая длина массива
     */
    private int size;

    public DynamicArray() {
        super(new int[DEFAULT_CAPACITY]);
        size = 0;
    }

    public DynamicArray(int[] array) {
        super(array);
        size = array.length;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(int value) {
        // TODO: добавить элемент в конец массива
        add(size, value);
    }

    @Override
    public void add(int index, int value) {
        // TODO: добавить элемент в указанный индекс (остальные сдвинуть вправо)
        if(index > array.length)
            throw new ArrayIndexOutOfBoundsException("oops");
        if(array.length == size){
            int[] newArr = new int[(int)(array.length * GROW_FACTOR)];
            for(int i = 0; i < array.length; i++) {
                newArr[i] = array[i];
            }
            array = newArr;
        }
        if(index != size){
            for(int i = index + 1; i < size + 1; i++){
                int temp = array[i];
                array[i] = array[index];
                array[index] = temp;
            }
        }

        array[index] = value;
        size++;
    }

    @Override
    public void addAll(Array array) {
        // TODO: конкатенация с переданным массивом
        int size = array.size();
        for(int i = 0; i < size; i++){
            add(array.get(i));
        }
    }

    @Override
    public boolean remove(int value) {
        // TODO: удалить элемент из массива
        int rightIndex = -1;
        for(int i = 0; i < size; i++) {
            if (array[i] == value) {
                rightIndex = i;
                break;
            }
        }
        if(rightIndex != -1){
            for(int i = rightIndex; i < size - 1; i++){
                array[i] = array[i + 1];
            }
            size--;
            return true;
        }

        return false;
    }


    /**
     * Здесь я немного не понял при каких условях какой результат я должен вернуть.
     * Вернуть false в случае сли хотя бы одного элемента не было или только в случае
     * если вообще ни одного элемента из values не было в массиве??
     */

    @Override
    public boolean removeAll(int[] values) {
        // TODO: удалить все указанные элементы из массива
        boolean indicator = true;
        for(int i = 0; i < values.length; i++){
            if(!remove(values[i]))
                indicator = false;
        }
        return indicator;
    }


    @Override
    public int removeOf(int index) {
        // TODO: удалить элемент по индексу
        int removedElement = array[index];
        for(int i = index; i < size - 1; i++){
            array[i] = array[i + 1];
        }
        size--;
        return removedElement;
    }

    /**
     * Переопределил функцию для этого класса чтобы не выводить пустые элементы
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(size * 3 + 2);

        builder.append('[');
        for (int i = 0; i < size; i++){
            builder.append(array[i] + ", ");
        }
        builder.replace(builder.lastIndexOf(", "), builder.length(), "]");

        return builder.toString();
    }
}
