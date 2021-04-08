package course.task;

public class App {

    public static void main(String[] args) {

        int[] a = new int[]{4, 6, 2, 8, 3, 0, 6, 9, 1};
        var staticArray = new StaticArray(a);
        System.out.println(staticArray);

        var sortedArray = new SortedArray(a);
        System.out.println(sortedArray);

        var dynamicArray = new DynamicArray(a);
        System.out.println(dynamicArray);
    }
}
