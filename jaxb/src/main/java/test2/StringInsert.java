package test2;

public class StringInsert {
    public static void main(String[] args) {
        String word="apple\r";
        word +="\n";
        //word.replaceAll("\\n", "\r\n");
        for (int i = 0; i < word.length(); i++){
            System.out.println(i + ":" + (int)word.charAt(i));
        }
    }
}
