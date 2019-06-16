package in.sri.test.algo;

public class RemoveArrayElement {

    public static void main(String[] args) {
        
        int[] arr = {1, 2, 3, 4, 5, 2, 6, 2, 8};
        
        int itemToRemove = 2;
        
        int index = 0;
        
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != itemToRemove) {
                arr[index++] = arr[i];
            }
        }
        
        for (int i = 0; i < index; i++) {
            System.out.println(arr[i]);
        }
        
    }
    
}
