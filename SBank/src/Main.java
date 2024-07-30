import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        for(int i = 0; i < n; i++){

            TreeMap<String, Integer> treeMap =new TreeMap<>();
            int x = Integer.parseInt(scanner.nextLine());
            for(int j = 0; j < x; j++){

                String account = scanner.nextLine();
                if(treeMap.containsKey(account)){
                    int currentValue = treeMap.get(account);
                    treeMap.put(account, currentValue + 1);
                }else{
                    treeMap.put(account, 1);
                }
            }

            String blank = scanner.nextLine();

            for(Map.Entry<String, Integer> entry : treeMap.entrySet()){
                String key = entry.getKey();
                Integer number = entry.getValue();
                System.out.println(key + " " + number);
            }

            System.out.println("\n");
        }
        scanner.close();
    }
}