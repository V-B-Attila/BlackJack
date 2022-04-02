import java.util.ArrayList;

public class RefernceVsPrimitive {
    public static void main(String[] args) {
        ArrayList<Integer> refArray = new ArrayList<>();
        refArray.add(10);
        refArray.add(20);

        System.out.println("-before swap!-");
        System.out.println("a=" + refArray.get(0));
        System.out.println("b=" + refArray.get(1));

        swap3(refArray);

        System.out.println("-after swap!-");
        System.out.println("a=" + refArray.get(0));
        System.out.println("b=" + refArray.get(1));

//        int[] array = {10, 20};
//
//        swap2(array);
//
//        System.out.println("-after swap!-");
//        System.out.println("a=" + array[0]);
//        System.out.println("b=" + array[1]);
//        System.out.println();
//        int a = 5;
//        int b = 10;
//        System.out.println("-before swap!");
//        System.out.println("a=" + a);
//        System.out.println("b=" + b);
//        System.out.println();
//
//        swap(a, b);
//
//        System.out.println("-after swap!");
//        System.out.println("a=" + a);
//        System.out.println("b=" + b);
//    }
    }

    private static void swap3(ArrayList<Integer> refArray) {
        int temp = refArray.get(0);

        refArray.set(0, refArray.get(1));
        refArray.set(1, temp);
    }

    private static void swap2(int[] array) {
        int temp = array[0];
        array[0] = array[1];
        array[1] = temp;

        System.out.println("-inside swap!-");
        System.out.println("a=" + array[0]);
        System.out.println("b=" + array[1]);
        System.out.println();
    }

    // int = primitív típus
    private static void swap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;

        System.out.println("-inside swap!-");
        System.out.println("a=" + a);
        System.out.println("b=" + b);
        System.out.println();
    }
}
