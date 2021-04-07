package course.task;

public class App {

    public static void main(String[] args) {

        int[] a = new int[]{4, 6, 2, 8, 3, 0, 6, 9, 1};
        var staticArray = new StaticArray(a);
        staticArray.sort(ArraySort.HEAP);
        System.out.println(staticArray);

        var sortedArray = new SortedArray(a);
        //System.out.println(sortedArray);

        var dynamicArray = new DynamicArray();
        dynamicArray.add(5);
        dynamicArray.add(10);
        //System.out.println(dynamicArray);
    }
}
