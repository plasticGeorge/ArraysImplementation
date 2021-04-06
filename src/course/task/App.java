package course.task;

public class App {

    public static void main(String[] args) {

        SortedArray testArr = new SortedArray(new int[]{13, 5, 3,9 , 2, 5, 6});
        System.out.println(testArr);

        int[] a = new int[]{1, 3, 7, 8, 5, 6, 9, 8};
        var staticArray = new StaticArray(a);
        System.out.println(staticArray);

        var sortedArray = new SortedArray(a);
        System.out.println(sortedArray);

        var dynamicArray = new DynamicArray();
        dynamicArray.add(5);
        dynamicArray.add(10);
        System.out.println(dynamicArray);
    }
}
