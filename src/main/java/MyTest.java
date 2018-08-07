import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomNode;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import java.io.IOException;
import java.net.MalformedURLException;

public class MyTest {
    public static void main(String args[]) {
        try (final WebClient webClient = new WebClient()) {
            final HtmlPage page = webClient.getPage("https://www.douban.com/group/topic/121163791/");


            //<textarea id="last" name="rv_comment" rows="6" class="comment_textarea" cols="64"></textarea>
            System.out.println(page.getTitleText());

            final DomNode formMail = page.querySelector("textarea#rv_comment");

            System.out.println(formMail.getBaseURI());
//            Assert.assertEquals("HtmlUnit - Welcome to HtmlUnit", page.getTitleText());

            final String pageAsXml = page.asXml();
//            Assert.assertTrue(pageAsXml.contains("<body class=\"composite\">"));

            final String pageAsText = page.asText();
//            Assert.assertTrue(pageAsText.contains("Support for the HTTP and HTTPS protocols"));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
