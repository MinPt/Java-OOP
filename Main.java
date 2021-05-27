import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

class Range{
    int start, end;

    Range(int start, int end){
        this.start = Math.min(start,end);
        this.end = Math.max(start,end);
    }
}

public class Main {
    //27 Створіть метод, який приймає параметр int та конвертує його з десятичної у
    // восьмирічну систему числення та повертає у вигляді String. Приклад- приймає 9, повертає =011=
    public static String dexToOct(int decimal){
        ArrayList<Integer> arr = new ArrayList<Integer>();
        int remainder = 1;
        int quotient = 0;
        while(true){
            remainder = decimal%8;
            quotient = (int)Math.floor(decimal/8);
            decimal = (int)Math.floor(decimal/8d);
            if(quotient == 0){

                arr.add(remainder);
                break;
            }

            arr.add(remainder);

        }
        StringBuilder octal = new StringBuilder();
        for(int i = arr.size() - 1;i >= 0;i--){
            octal.append(Integer.toString(arr.get(i)));
        }

        return octal.toString();
    }

    //5 Створіть метод, який дозволяє видаляти всі елементи в масиві int[] ,
    // які мають певне значення, наприклад дорівнюються 23.
    // Масив без видалених елементів повинен повертатися, як результат роботи методу
    public static int[] deleleElems(int[] arr, int elem){
        ArrayList<Integer> newArray = new ArrayList<Integer>();
        for (int i = 0;i < arr.length;i++){
            if(arr[i] == elem){
                continue;
            }
            newArray.add(arr[i]);
        }
        int[] returnArray = new int[newArray.size()];
        for (int i = 0; i < returnArray.length; i++) {
            returnArray[i] = newArray.get(i);
        }
        return returnArray;
    }

    //3 Створіть метод, який дозволяє вставляти в будь яку позицію масиву будь яке число.
    // Метод повинен повертати новий масив.
    public static int[] insert(int[] arr, int pos, int elem){
        if(pos > arr.length){
            throw new ArrayIndexOutOfBoundsException();
        }
        int[] newArray = new int[arr.length + 1];
        int j = 0, i = 0;

        while(i < arr.length){
            if(i == pos && j == i){
                newArray[j++] = elem;
                continue;
            }
            newArray[j++] = arr[i++];
        }

        return newArray;
        }

    //22   Створіть метод, який рахує факторіал числа, використовуючи цикли.
    // Потім створити ще одну реалізацію, яка використовує рекурсію для вирішення цієї задачі
    public static int factLoop(int number){
        int result = 1;
        for (int i = number; i >0 ; i--) {
            result *= i;
        }
        return result;
    }

    public static int factRecursive(int number){
        if(number >= 1){
            return number* factRecursive(number - 1);
        }else{
            return 1;
        }
    }
    //[5,11] && [18,9]
    public static int[] findIntersuction(int start1,int end1,int start2,int end2){

        Range rang1 = new Range(start1,end1);
        Range rang2 = new Range(start2,end2);
        if(rang2.start > rang1.end || rang2.end < rang1.start){
            return new int[0];
        }
        Range intersuction = new Range(Math.max(rang1.start,rang2.start),Math.min(rang1.end, rang2.end));
        int[] intersucked = new int[intersuction.end - intersuction.start + 1];
        int j = 0;
        for (int i = intersuction.start; i <= intersuction.end; i++) {
            intersucked[j++] = i;
        }
        return intersucked;
    }
    //[1,2,3]
    public static int[] findLongestStreak(int[] arr){
        int i, streak = 1, highestStreak = 1, firstIndex = 0, lastIndex = 0, longestFirstIndex = 0, longestLastIndex = 0;
        Arrays.sort(arr);
        for(i = 1;i < arr.length; i++){
            if(arr[i] == arr[i-1] + 1){
                streak++;
                lastIndex = i ;
                if(streak > highestStreak){
                    longestFirstIndex = firstIndex;
                    longestLastIndex = lastIndex;
                }
            }else{
                if(streak > highestStreak){
                    longestFirstIndex = firstIndex;
                    longestLastIndex = lastIndex;
                }
                streak = 1;
                firstIndex = i;
                lastIndex = i;
            }

            if(streak > highestStreak){
                highestStreak = streak;
            }
        }

        ArrayList<Integer> streakList = new ArrayList<Integer>();
        for(int j = longestFirstIndex ; j <= longestLastIndex; j++){
            streakList.add(arr[j]);
        }
        int[] streakArray = new int[streakList.size()];
        for(int j = 0;j < streakList.size();j++){
            streakArray[j] = streakList.get(j);
        }
        return streakArray;
    }
    public static void main(String[] args) {
        int[] arr = {1,3,2,5,7,6,8,9,11,12,99,88,14,15,16,17};
        int[] streakArray = findLongestStreak(arr);
        for(int i = 0;i < streakArray.length;i++){
            System.out.println(streakArray[i]);
        }
    }
}

