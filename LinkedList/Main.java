public class Main{
     public static void main (String[] args) {
       LinkedList ll = new LinkedList();
       ll.print();
       ll.addFirst(1);
       ll.print();
       ll.addLast(2);
       ll.print();
       ll.addFirst(0);
       ll.print();
       ll.addLast(3);
       ll.print();
       ll.add(2, 10);
       ll.print();
       ll.add(0,-123);
       ll.print();
       ll.addLast(1000);
       System.out.println("Value: "+ll.removeFirst()+" is deleted");
       ll.print();
       System.out.println("Value : "+ll.removeLast()+" is deleted");
       ll.print();
       System.out.println("Size of LinkedList is: "+ll.size);
       System.out.println("element is at: "+ ll.iterativeSearch(0));
       System.out.println("element is at: "+ ll.recurviseSearch(10));
       
       ll.reverseList();
       ll.print();
       
       ll.removeKthFromEnd(5);
       ll.print();
    }
}


class LinkedList{
    
    class Node{
        int data;
        Node next;
        //Constructor...
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    
    
    public static Node head;
    public static Node tail;
    public static int size;
    
    public void addFirst(int data){
        //create new node
        Node newNode = new Node(data);
        size++;
        //check empty condn
        if(head==null){
            head = tail = newNode;
            return;
        }
        
        //newNode.next = head
        newNode.next = head;
        
        //head = newNode
        head = newNode;
    }
    
    public void addLast(int data){
        Node newNode = new Node(data);
        size++;
        if(head == null){
            head = tail = newNode;
            return;
        }
        
        tail.next = newNode;
        tail = newNode;
    }
    
    public void add(int idx, int data){
        
        // Since we have to manage head if element is added at begining ..
        //.. therefore we have called addfirst method
        
        if(idx==0){
            addFirst(data);
            return;
        }
        Node temp = head;
        int i=0;
        Node newNode = new Node(data);
        size++;
        while(i!=idx - 1){
            i++;
            temp = temp.next;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }
    
    public void print(){
        if(head == null){
            System.out.println("LinkedList is empty");
            return;
        }
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data+ "->");
            temp = temp.next;
        }
        System.out.println("Null");
    }
    
    public int removeFirst(){
        int val;
        if(size == 0){
            System.out.println("LinkedList is empty");
            return Integer.MIN_VALUE;
        }
        else if(size == 1){
            val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        val = head.data;
        head = head.next;
        size--;
        return val;
    }
    
    public int removeLast(){
        int val;
        if(size == 0){
            System.out.println("LinkedList is empty");
            return Integer.MIN_VALUE;
        }
        else if(size == 1){
            val = head.data;
            head = tail = null;
            size = 0;
        }
        val = tail.data;
        Node temp = head;
        while(temp.next.next != null){
            temp = temp.next;
        }
        tail = temp;
        tail.next = null;
        size--;
        return val;
    }
    
    public int iterativeSearch(int key){
        Node temp = head;
        for(int i=0; i<size; i++){
            if(temp.data == key){
                return i;
            }
            temp = temp.next;
        }
        return -1;
    }
    
    public int recurviseSearch(int key){
        return helper(head, key);
    }
    
    public int helper(Node head, int key){
        if(head == null) return -1;
        else if(head.data == key) return 0;
        
        int idx = helper(head.next, key);
        if(idx == -1){
            return -1;
        }
        
        return idx + 1;
    }
    
    public void reverseList(){
        Node prev = null;
        Node curr =tail= head;
        Node next;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        head = prev;
    }
    
    public void removeKthFromEnd(int n){
        //calculate size since in this code size is already given but if it is not given we can calculate it ..
        int size = 0;
        Node temp = head;
        while(temp != null){
            temp = temp.next;
            size++;
        }
        if(n == size){
            head = head.next;
            return;
        }
        
        int i=1;
        Node prev = head;
        while(i< size-n){
            prev = prev.next;
            i++;
        }
        prev.next = prev.next.next;
    }
    
}


