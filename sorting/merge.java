import java.util.*;

class merge {
    private static int[] ar;

    public static void mergeSort(int a[], int sta, int end) {
        if (sta < end) {
            int mid = (sta + end) / 2;
            mergeSort(a, sta, mid);
            mergeSort(a, mid + 1, end);
            merge(a, sta, mid, end);
        }
    }

    public static void merge(int a[], int sta, int mid, int end) {
        ar = new int[a.length];
        int i = sta, j = mid + 1, k = sta;
        
        while (i <= mid && j <= end) {
            if (a[i] <= a[j]) {
                ar[k] = a[i];
                i++;
            } else {
                ar[k] = a[j];
                j++;
            }
            k++;
        }
        
        while (i <= mid) {
            ar[k] = a[i];
            i++;
            k++;
        }
        
        while (j <= end) {
            ar[k] = a[j];
            j++;
            k++;
        }
        
        for (int h = sta; h <= end; h++) {
            a[h] = ar[h];
        }
    }
}

class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements in the array: ");
        int n = sc.nextInt();
        int a[] = new int[n];
        System.out.println("Enter the elements: ");
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        
        merge obj = new merge();
        
        obj.mergeSort(a, 0, n - 1);
        
        System.out.println("Sorted array: ");
        for (int num : a) {
            System.out.print(num + " ");
        }
    }
}
