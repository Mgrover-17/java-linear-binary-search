import java.util.HashSet;

public class RemoveDuplicates {
    public static String removeCharacters(String input){
        StringBuilder sb=new StringBuilder();
        HashSet<Character>set=new HashSet<>();
        //iterate
        for(char ch:input.toCharArray()){
            if(!set.contains(ch)){
                sb.append(ch);
                set.add(ch);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String input="maanvvi";
        String output=removeCharacters(input);
        System.out.println("original:"+input);
        System.out.println("without duplicates:"+output);
    }


}
