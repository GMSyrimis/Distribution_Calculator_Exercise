import java.net.URL;

/**
 * Created by c4q-george on 3/31/15.
 */
public class ExtendedEditor {

    public static String sanitizeURL(String website){
        String result="";

        URL url = HTTP.stringToURL(website);
        String fetchedURL = HTTP.get(url);


        while(fetchedURL.indexOf("<script")!=-1){
            int beginSUB = fetchedURL.indexOf("<script");
            int endSUB = fetchedURL.indexOf("</script>",beginSUB)+9;
            String replaceScript = fetchedURL.substring(beginSUB,endSUB);
            fetchedURL = fetchedURL.replace(replaceScript,"");

        }


        return fetchedURL;
    }

    public static void main(String[] args){

        System.out.println(sanitizeURL("http://ilovefreeconcerts.com/disney-buys-the-worlds-fair-grounds-producing-major-festival-for-2016/"));
    }
}
