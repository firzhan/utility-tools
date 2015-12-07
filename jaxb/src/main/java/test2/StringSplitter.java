package test2;

import java.util.HashMap;
import java.util.Map;

public class StringSplitter {

    public static void main(String[] args) {

        String headersString = "Content-Disposition: form-data; name=\"file\"; filename=\"abcde\"\n" +
                "Content-Type: application/octet-stream\n" +
                "\n" +
                "\n";

      /*  byte[] headerArrayByte = headersString.getBytes();

        int beginIndex = 0;
        int length = 0;

        String headerString = null;
        String headerValue = null;
        boolean headerFound = false;
        Map<String, String> headerMap = new HashMap<String, String>();
        for (byte headerByte: headerArrayByte){

            ++length;

            if(!headerFound){

                if(headerByte == ':'){
                    System.out.println("FFFFFFFFF");
                    headerFound = true;
                    headerString = new String(headerArrayByte, beginIndex,length-1);
                    beginIndex += length;
                    length = 0;
                    System.out.println("Header:"+headerString);
                }
            } else {

                if(headerByte == '\n' || headerByte == '\r'){
                    headerValue = new String(headerArrayByte,beginIndex, length-1);
                    System.out.println("header value:" + headerValue);
                    headerFound = false;
                    beginIndex += length;
                    length = 0;

                    headerMap.put(headerString, headerValue);
                    headerString = null;
                    headerValue = null;
                }
            }

        }

*/
        String headerValue1 = " form-data; name=\"file\"; filename=\"abcde\"\n";
        System.out.println(headerValue1.trim().substring("form_data".length()+1));

        if(!headerValue1.endsWith(";")){
            System.out.println("FFTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT");
            headerValue1 += ";";
        }

        byte[] byteValue1 = headerValue1.trim().substring("form_data".length()+1).getBytes();

        int beginIndex1 = 0;
        int length1 = 0;
        String key;
        String value;
        boolean keyFound = false;
        boolean valueFound = false;

        Map<String, String> contentDispositionHeaderMap = new HashMap<String, String>();

        for (byte byte1: byteValue1) {

            //System.out.println((int)byte1);
            ++length1;

            if(!keyFound){

                if(byte1 == '='){

                    System.out.println("LLLLLLLLLLLLLLLLl");
                    keyFound = true;
                    key = new String(byteValue1,beginIndex1, length1-1).trim();
                    beginIndex1 += length1;
                    length1 = 0;

                    System.out.println("KEY:"+key);
                }

            } else {
                if(byte1 == '\n' || byte1 == '\r' || byte1 == ';'){

                    System.out.println("came here");
                    value = new String(byteValue1,beginIndex1, length1-1);
                    value = value.replaceAll("\"", "").trim();
                    System.out.println("header value:" + value);
                    keyFound = false;
                    beginIndex1 += length1;
                    length1 = 0;

                   // headerMap.put(headerString, headerValue);
                    contentDispositionHeaderMap.put(key, value);
                    key = null;
                    value = null;
                }
            }
        }

      /*  byte[] HEADER_SEPARATOR = new byte[]{(byte)13, (byte)10, (byte)13, (byte)10};
        System.out.println(new String(HEADER_SEPARATOR));*/

/*
        String[] headerArray = headersString.split(":");

        String headerName = null;
        String headerValue;


        for (int i = 0; i < headerArray.length; i++) {
            System.out.println("==================================" + headerArray[i]);
            if (i % 2 == 0) {
                headerName = headerArray[i];
                headerValue = null;
            } else {
                headerValue = headerArray[i];

                String[] headerContentArray = new String[0];
                headerContentArray = headerValue.split(";");
                int headerContentArraySize = headerContentArray.length;

                if ("Content-Disposition".equalsIgnoreCase(headerName)) {


                    if (headerContentArraySize > 0) {

                        if (headerContentArray[0] != null && "form-data".equalsIgnoreCase
                                (headerContentArray[0].trim())) {
                            for (int j = 1; j < headerContentArray.length; j++) {
                                String headerKeyValue = headerContentArray[j];
                                int index = headerKeyValue.indexOf("=");

                                if (index != -1) {
                                    String key1 = headerKeyValue.substring(0, index).replaceAll("\"", "").trim();
                                    String value1 = headerKeyValue.substring(index + 1, headerKeyValue.length()).replaceAll("\"", "").trim();
                                    System.out.println(key1 + ":" + value1);
                                }
                            }
                        }
                    }
                } else if ("Content-Type".equalsIgnoreCase(headerName)) {
                    System.out.println("Content Type:" + headerContentArray[0]);
                }
*/
/*                if(headerValue  != null){

                    String[] valueSplit = headerValue.split(";");

                    if(valueSplit != null){
                        Map<String, String> valueMap = new HashMap<String, String>();
                        for (int j=0; j < valueSplit.length; j++){
                            String one = valueSplit[j];
                            int index = one.indexOf("=");

                            if( index != -1 ){
                                String key1 =  one.substring(0, index).replaceAll("\"", "").trim();
                                String value1 = one.substring(index + 1, one.length()).replaceAll("\"", "").trim();
                                System.out.println(key1+":"+value1);
                            } else{
                                System.out.println("This key doesn't contain the value" + one);
                            }
                        }
                    }
                }*//*

                headerName = null;
            }
        }
*/
    }
}
