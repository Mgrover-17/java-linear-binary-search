public class ConcatenateStrings {
    public static String concatStrings(String words[]){
        StringBuffer sb=new StringBuffer();
        for(String str:words){
            sb.append(str);
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        String[] words = {"Hello", " ", "World", "!", " StringBuffer", " is", " efficient."};
        String result=concatStrings(words);
        System.out.println("concatenated string:"+result);
    }
}
