class Maxheap {
    int arr[];
    int hsize, msize;

    Maxheap(int ms) {
        msize = ms;
        hsize = 0;
        arr = new int[msize];
    }

    int parent(int i) {
        return (i - 1) / 2;
    }

    int lchild(int i) {
        return (2 * i) + 1;
    }

    int rchild(int i) {
        return (2 * i) + 2;
    }

    void insert(int x) {
        if (hsize == msize) {
            System.out.println("Heap is full (over size)");
            return;
        }
        int i = hsize;
        arr[i] = x;
        hsize++;
        while (i != 0 && arr[parent(i)] < arr[i]) {
            int temp = arr[parent(i)];
            arr[parent(i)] = arr[i];
            arr[i] = temp;
            i = parent(i);
        }
    }

    int getMax() {
        if (hsize == 0) {
            throw new IllegalStateException("Heap is empty");
        }
        return arr[0];
    }

    int currsize() {
        return hsize;
    }
    void removemax(){
        if(hsize<=0)
            System.out.println("nothing to remove");
        else if(hsize==1)
            hsize--;
        else
            arr[0]=arr[hsize-1];
            hsize--;
            Maxheapify(0);
    }
    void Maxheapify(int i){
        int l=lchild(i);
        int r=rchild(i);
        int largest=i;
        if(l<hsize&&arr[l]>arr[largest])
            largest=l;
        if(r<hsize&&arr[r]>arr[largest])
            largest=r;
        if(largest!=i){
            int temp=arr[largest];
            arr[largest]=arr[i];
            arr[i]=temp;
            Maxheapify(largest);
        }
    }
    void printHeap() {
        for (int i = 0; i < hsize; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Maxheap h = new Maxheap(5);
        int elements[] = {3, 6, 4, 7};
        for (int e : elements) {
            h.insert(e);
        }
        System.out.println("Max-Heap:");
        h.printHeap();
        h.removemax();
        h.printHeap();
    }
}
