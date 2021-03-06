package course.task;

/**
 * Сортированный статический массив (по возрастанию).
 *
 * Любая операция должна гарантировать, что массив, по ее окончании, отстортирован
 */
public class SortedArray extends StaticArray {

    public SortedArray(int[] array) {
        super(array);
        if (!isAscSorted()) {
            sort();
        }
    }

    @Override
    public boolean contains(int value) {
        return binarySearch(value, 0, array.length) != -1;
    }

    @Override
    public int set(int index, int value) {
        // TODO: присовить значение по индексу
        return super.set(index, value);
    }

    @Override
    public int indexOf(int value) {
        return binarySearch(value);
    }

    @Override
    public int lastIndexOf(int value) {
        // TODO: получить индекс последнего подходящего элемента
        int index = binarySearch(value);
        if(index != -1) {
            for (; index < array.length - 1; index++){
                if(array[index] != value)
                    break;
            }
        }
        return index;
    }


    /**
     * Здесь были методы sort(),
     * но я не понял зачем они нужны,
     * если их уже определили в StaticArray
     */


    private int binarySearch(int value, int left, int right) {
        // TODO: реализовать бинарный поиск
        int index = -1;
        while (left != right){
            int pivot = (left + right) / 2;
            if(array[pivot] == value){
                index = pivot;
                break;
            }
            else if(value < array[pivot]){
                right = pivot - 1;
            }
            else if(value > array[pivot]){
                left = pivot + 1;
            }
        }
        return index;
    }

    /**
     * Добавил реализацию реализацию с аргументами по умолчанию
     */
    private int binarySearch(int value) {
        // TODO: реализовать бинарный поиск
        return binarySearch(value, 0, array.length - 1);
    }

    public SortedArray merge(SortedArray other) {
        // TODO: произвести слиянеие двух сортированных массивов
        SortedArray array = new SortedArray(new int[this.size() + other.size()]);
        for(int l = 0, r = 0, i = 0; i < array.size(); i++){
            if(l < this.size() && r < other.size()) {
                array.set(i, this.get(l) < other.get(r) ? this.get(l++) : other.get(r++));
            }
            else if(l < this.size()){
                for(int j = l; j < this.size(); j++, i++)
                    array.set(i, this.get(j));
            }
            else if(r < other.size()){
                for(int j = r; j < other.size(); j++, i++)
                    array.set(i, other.get(j));
            }
        }
        return array;
    }

    public SortedArray mergeAll(SortedArray... others) {
        // TODO: произвести слиянеие N + 1 сортированных массивов
        SortedArray array = this;
        for(int i = 0; i < others.length; i++) {
            array = array.merge(others[i]);
        }
        return array;
    }
}
