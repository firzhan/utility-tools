package fileupload;

import org.apache.commons.fileupload.MultipartStream;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.regex.Matcher;

public class MultipartTest {

    // Lines should end with CRLF
    public static final String MULTIPART_BODY=

            "Content-Type: multipart/form-data; boundary=\"----=_Part_5_1057395253.1448127925961\"\n" +
                    "\n" +
                    "------=_Part_5_1057395253.1448127925961\n" +
                    "Content-Type: text/xml; charset=UTF-8; name=test1.xml\n" +
                    "Content-Transfer-Encoding: binary\n" +
                    "Content-Disposition: form-data; name=\"test1.xml\"; filename=\"test1.xml\"\n" +
                    "\n" +
                    "<a>\n" +
                    "\t<ggggggggg>lll</ggggggggg>\n" +
                    "</a>\n" +
                    "\n" +
                    "------=_Part_5_1057395253.1448127925961--\n" +
                    "\n";


    public static final String MULTIPART_BODY2 =
            "Content-Type: multipart/form-data; boundary=--AaB03x\r\n"
                    + "\r\n"
                    + "----AaB03x\r\n"
                    + "Content-Disposition: form-data; name=\"submit-name\"\r\n"
                    + "\r\n"
                    + "Larry\r\n"
                    + "----AaB03x\r\n"
                    + "Content-Disposition: form-data; name=\"files\"; filename=\"file1.txt\"\r\n"
                    + "Content-Type: text/plain\r\n"
                    + "\r\n"
                    + "HELLO WORLD!\r\n"
                    + "----AaB03x--\r\n";



    public static void main(String[] args) throws Exception {

       byte[] boundary = "--AaB03x".getBytes();
    //    byte[] boundary = "----=_Part_1_814485496.1448126281615".getBytes("UTF-8");

        ByteArrayInputStream content = new ByteArrayInputStream(MULTIPART_BODY2.getBytes("UTF-8"));


        MultipartStream multipartStream =
                new MultipartStream(content, boundary, MULTIPART_BODY2.getBytes().length, null);
        if(multipartStream == null){
            System.out.println("I am null");
        }else {
            System.out.println("I am not null");

        }
        boolean nextPart = multipartStream.skipPreamble();
        System.out.println(nextPart);;

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        if (nextPart) {
            String header = multipartStream.readHeaders();
            System.out.println("");
            System.out.println("Headers:");
            System.out.println(header);
            System.out.println("Body:");
            multipartStream.readBodyData(byteArrayOutputStream);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            System.out.println(Arrays.toString(byteArray));
            System.out.write(byteArray);

            System.out.println("");
           // nextPart = multipartStream.readBoundary();
        }

        System.out.println("Class resource path:" + getClassResource(MultipartStream.class));

    }

    public static String getClassResource(Class<?> klass) {
        return klass.getClassLoader().getResource(
                klass.getName().replace('.', '/') + ".class").toString();
    }

   /* public void parse() throws IOException {
        ByteArrayInputStream input=new ByteArrayInputStream(this.data);
        MultipartStream multipartStream=new MultipartStream(input,this.boundary);
        boolean nextPart=multipartStream.skipPreamble();
        while (nextPart) {
            String headers=multipartStream.readHeaders().replaceAll("\r"," ").replaceAll("\n"," ");
            System.out.println("Headers: [" + headers + "]");
            ByteArrayOutputStream baos=new ByteArrayOutputStream();
            multipartStream.readBodyData(baos);
            Matcher param=parse_file_param.matcher(headers);
            if (param.find()) {
                String pname=param.group(1);
                String filename=param.group(2);
                String contenttype=param.group(3);
                System.out.println("Pname=" + pname + "|Filename="+ filename+ "|CType:"+ contenttype);
                this.fileFields.put(pname,new Filedata(filename,contenttype,baos.toByteArray()));
            }
            else {
                Matcher param2=parse_param.matcher(headers);
                if (param2.find()) {
                    this.params.setProperty(param2.group(1),new String(baos.toByteArray()));
                }
            }
            nextPart=multipartStream.readBoundary();
        }
    }
*/
}
