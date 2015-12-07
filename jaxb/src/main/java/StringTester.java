public class StringTester {

    public static void main(String[] args) {
        String contentType = "multipart/form-data; boundary=\"----=_Part_12_1679150938.1448028473580\"";

        String reuestBody = "Content-Type: multipart/form-data; boundary=\"----=_Part_20_253632051.1448092230126\"\n" +
                "\n" +
                "------=_Part_20_253632051.1448092230126\n" +
                "Content-Type: application/octet-stream; name=abcde\n" +
                "Content-Transfer-Encoding: binary\n" +
                "Content-Disposition: form-data; name=\"abcde\"; filename=\"abcde\"\n" +
                "\n" +
                "ifconfig eth1 192.168.0.1 netmask 255.255.255.0 up\n" +
                "gggggggggggggwef\n" +
                "gtttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttt\n" +
                "444444444444444444444444444444444444444444444444444444444444444444444444444\n" +
                "ttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttt4\n" +
                "\n" +
                "\n" +
                "\n" +
                "------=_Part_20_253632051.1448092230126--\n";


        String requestBodyValue = reuestBody.replaceAll("\n", "\r\n");

        System.out.println(requestBodyValue);

        int index = contentType.indexOf("boundary");
        System.out.println(index);

        String boundryString = contentType.substring(index + "boundary=".length());
        System.out.println(boundryString);

        String newValue = "Value:form-data; name=\"name\"";

        int index1 = newValue.indexOf("name");
        String newValue2=  newValue.substring(index1+"name".length() + 1);
        int firstOccurance = newValue2.indexOf("\"");
        int secondOccurnace = newValue2.indexOf("\"", firstOccurance+1);

        //System.out.println(.replaceAll("\"",""));
        System.out.println(newValue2);
        System.out.println(firstOccurance);
        System.out.println(secondOccurnace);
        System.out.println(newValue2.substring(firstOccurance+1, secondOccurnace));
    }
}
