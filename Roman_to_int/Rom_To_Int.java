import java.util.*;

public class Rom_To_Int{

    public static int calRoman(String rom) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        
        int len = rom.length();

        int result = map.get(rom.charAt(len-1));

        for(int i = len -1; i>0; i--){
            if(map.get(rom.charAt(i-1)) >= map.get(rom.charAt(i))){
                result+= map.get(rom.charAt(i-1));
            }
            else if(map.get(rom.charAt(i-1)) < map.get(rom.charAt(i))){
                result-= map.get(rom.charAt(i-1));
            }
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a roman number");
        String rom = sc.next();
        int equivalentInteger = calRoman(rom);
        System.out.println("The integer value of "+rom+" is : "+ equivalentInteger);
    }
}