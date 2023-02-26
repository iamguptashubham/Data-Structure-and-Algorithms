class MaxST{
    
    static int tree[];
    
    public static void init(int n){
        tree = new int[4*n];
    }
    
    public static void buildST(int i, int si, int sj, int arr[]){
        
        if(si==sj){
            tree[i] = arr[si];
            return;
        }
        
        int mid = (si+sj)/2;
        buildST(2*i+1, si, mid, arr);
        buildST(2*i+2, mid+1, sj, arr);
        
        tree[i] = Math.max(tree[2*i+1], tree[2*i+2]);
    }
    
    public static int getMax(int qi, int qj, int arr[]){
        int i = 0;
        int n = arr.length;
        return getMaxUtils(i, 0, n-1, qi ,qj, arr);
    }
    
    public static int getMaxUtils(int i, int si, int sj, int qi, int qj, int arr[]){
        //case : no overlapping
        if(qj < si || sj < qi){
            return Integer.MIN_VALUE;
        }
        //case complete overlapping
        if(si>=qi && sj <= qj){
            return tree[i];
        }
        else{
            int mid = (si+sj)/2;
            int left = getMaxUtils(2*i+1, si, mid, qi, qj, arr);
            int right= getMaxUtils(2*i+2, mid+1, sj, qi, qj, arr);
            
            return Math.max(left, right);
        }
    }

    public static void updateUtils(int i, int si, int sj, int idx, int newVal){
        if(si > idx || sj < idx){
            return ;
        }
        
        tree[i]  = Math.max(tree[i], newVal);
        
        if(si!=sj){
            int mid = (si+sj)/2;
            updateUtils(2*i+1, si, mid, idx, newVal);
            updateUtils(2*i+2, mid+1, sj, idx, newVal);
            
            // tree[i] = Math.max(tree[2*i+1], tree[2*i+2]);
        }
    }   
    
    public static void update(int idx, int newVal, int arr[]){
        arr[idx] = newVal;
        int n = arr.length;
        updateUtils(0, 0, n-1, idx, newVal);
    }
    
    
    
    
    public static void main (String[] args) {
        int arr[] = {6, 8, -1, 2, 17, 1, 3, 2, 4};
        int n = arr.length;
        init(n);
        buildST(0, 0, n-1, arr);
        
        for(int i:tree){
            System.out.print(" "+i);
        }
        
        int max = getMax(5, 8, arr);
        System.out.println(" \n" + max);
        
        update(0, 18, arr);
        
        System.out.println(" New array");
        for(int b:arr){
            System.out.print(" "+ b);
        }
        
        System.out.println(" ");
        for(int c:tree){
            System.out.print(" "+ c);
        }
        
        System.out.println("\n"+ getMax(0,7,arr));
    }
}