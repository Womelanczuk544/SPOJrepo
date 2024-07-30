import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        var numberOfTests= Integer.parseInt(scanner.nextLine());

        for(int i=0; i<numberOfTests; i++){
            List<Integer> list = new ArrayList<>();
            var dimensionSize = Integer.parseInt(scanner.nextLine());
            boolean isEvenASolution = false;
            boolean isSumEven = false;

            for(int j=0; j<dimensionSize; j++){
                var line = scanner.nextLine();
                var numbers = line.split(" ");

                for(String number : numbers){
                    list.add(Integer.parseInt(number));
                }
            }

            for(int j=0; j<list.size();j++){
                if(list.get(j)==0){
                    int x = dimensionSize;
                    int posX=(j%(x*x))%x,posY=(j%(x*x))/x,posZ=j/(x*x);
                    int sum = x-1-posX + x-1-posY + x-1-posZ;

                    if(sum%2==0)
                        isEvenASolution=true;
                }
            }
            int sum=0;

            for(int j=0; j<list.size(); j++){
                if(list.get(j)==0 && j!=list.size()-1)
                {
                    int element1 = list.get(j);
                    int element2 = list.get(list.size()-1);
                    list.set(j, element2);
                    list.set(list.size()-1, element1);
                    sum += 1;
                    j--;
                    continue;
                }

                if(list.get(j)==0 && j==list.size()-1)
                    continue;

                if(list.get(j)==j+1)
                    continue;

                int element1 = list.get(j);
                int element2 = list.get(list.get(j)-1);
                list.set(j, element2);
                list.set(element1-1, element1);
                sum += 1;
                j--;
            }
            if(sum%2==0)
                isSumEven=true;

            if(isSumEven == isEvenASolution)
                System.out.println("Puzzle can be solved.");
            else
                System.out.println("Puzzle is unsolvable.");
        }
        scanner.close();
    }
}