public class Minheap {
    int hsize,msize;
    int arr[];
    Minheap(int ms){
        msize=ms;
        hsize=0;
        arr=new int[msize];
    }
    int lchild(int i){
        return (2*i)+1;
    }
    int rchild(int i){
        return (2*i)+2;
    }
    int parent(int i){
        return (i-1)/2;
    }
    void insert(int x){
        if(hsize==msize)
            System.out.println("heap is overloaded");
        int i=hsize;
        arr[i]=x;
        hsize++;
        while(i!=0 && arr[parent(i)]>arr[i]){
            int temp=arr[parent(i)];
            arr[parent(i)]=arr[i];
            arr[i]=temp;
            i=parent(i);
        }
    }
    int getmin(){
        return arr[0];
    }
    int currsize(){
        return hsize;
    }
    void removemin(){
        if(hsize<=0)
            System.out.println("nothing to remove");
        else if(hsize==1)
            hsize--;
        else{
            arr[0]=arr[hsize-1];
            hsize--;
            Minheapify(0);
        }
    }
    void Minheapify(int i){
        int l=lchild(i);
        int r=rchild(i);
        int small=i;
        if(l<hsize&&arr[l]<arr[small])
            small=l;
        if(r<hsize&&arr[r]<arr[small])
            small=r;
        if(small!=i){
            int temp=arr[small];
            arr[small]=arr[i];
            arr[i]=temp;
            Minheapify(small);
        }

    }
    void printHeap() {
        for (int i = 0; i < hsize; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Minheap h = new Minheap(5);
        int elements[] = {3, 6, 4, 7};
        for (int e : elements) {
            h.insert(e);
        }
        System.out.println("Min-Heap:");
        h.printHeap();
        h.removemin();
        h.printHeap();
    }
}
