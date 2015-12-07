package byteh;


import sun.misc.BASE64Encoder;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        String attachment = "I am fucked up over here.";

        byte[] attachmentArray = attachment.getBytes();

        byte[] contentArray = new byte[1000];

        String contentType = "Content-Type:application/json\n";

        byte[] accumulatedArray = new byte[attachmentArray.length + 1000];

        for (int i = 0; i < contentType.length(); i++){
            contentArray[i] = (byte)contentType.charAt(i);
        }

        System.arraycopy(contentArray, 0, accumulatedArray, 0, 1000);
        System.arraycopy(attachmentArray, 0, accumulatedArray, 1000, attachmentArray.length);

        System.out.println(new String(accumulatedArray));

      /*  List<> b1 = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for(byte b:accumulatedArray){
            if(b == '\n'){
                break;
            }

            b1
            i++;
        }

        System.out.println(new String(b1));*/

        BASE64Encoder base64Encoder = new BASE64Encoder();
        String encodedString = base64Encoder.encode("admin:admin".getBytes());
        System.out.println(encodedString);
    }
}
