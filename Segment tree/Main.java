// Constructing Segment tree
class Main{
    
    static int tree[] ;
    
    public static void init(int n){
        tree = new int[4*n];
    }
    
    public static int  buildST(int arr[], int i, int st, int en){
        
        if(st==en){
            tree[i] = arr[st];
            return arr[st];
        }
        
        int mid = (st+en) / 2;
        
        buildST(arr, 2*i+1, st, mid);
        buildST(arr, 2*i+2, mid+1, en);
        
        tree[i] = tree[2*i+1] + tree[2*i+2];
        return tree[i];
    }
    
    public static int getSumUtil(int i,int si, int sj, int qi, int qj){
        if(qj <= si || sj <= qi){ // non overlapping case
            return 0;
        }
        else if(qi<=si && qj>=sj){ // completely overlapping case
        return tree[i];
        }
        
        int mid = (si + sj) / 2;
        int left = getSumUtil(2*i+1, si, mid, qi, qj);
        int right = getSumUtil(2*i+2, mid+1, sj, qi , qj);
        
        return left + right;
    }
    public static int getSum(int arr[], int qi, int qj){
        int n = arr.length;
        return getSumUtil(0, 0, 7, qi, qj);
    }
    
    public static void updateUtil(int i, int si, int sj, int idx, int newVal){
        if(si > idx || sj < idx){
            return ;
        }
        
        tree[i] += newVal;
        if(si!=sj){
            int mid = (si + sj) /2;
            updateUtil(2*i+1, si, mid, idx, newVal);
            updateUtil(2*i+2, mid+1, sj, idx, newVal);
        }
        return ;
    }
    public static void update(int arr[], int idx, int newVal){
        int diff  = newVal - arr[idx];
        arr[idx] = newVal;
        updateUtil(0, 0, 7, idx, diff);
    }
    
    public static void main (String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8};
        init(arr.length);
        buildST(arr, 0, 0, arr.length-1);
        System.out.println(" ");
        for(int a:tree){
            System.out.print(a + " ");
        }
        
        System.out.println(" ");
        System.out.println(getSum(arr, 2, 5));
        
        update(arr, 2, 2);
        System.out.println(getSum(arr, 2,5));
    }
}

