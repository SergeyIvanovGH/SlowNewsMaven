package ua.com.univerpulse;

import java.io.*;
import java.net.URL;

/**
 * Created by svivanov on 06.04.16.
 */
public class ReadRSSTest {
    public static void main(String[] args) {
//        RSSFeedParser parser = new RSSFeedParser("http://news.finance.ua/ru/rss");
//        RSSFeedParser parser = new RSSFeedParser("http://www.vogella.com/article.rss");

//        saveRSS("http://news.yahoo.com/rss/", "yahoo.xml");
//        saveRSS("http://news.finance.ua/ru/rss", "finance_ua.xml");
//        saveRSS("http://www.vogella.com/article.rss", "vogella.xml");
        saveRSS("http://rss.cnn.com/rss/edition.rss", "cnn.xml");
//
//        RSSFeedParser parser = new RSSFeedParser("http://news.yahoo.com/rss/");
//        Feed feed = parser.readFeed();
//        System.out.println(feed);
//        for (Item message : feed.getMessages()) {
//            System.out.println(message);
//        }

/*
        try {
            JAXBContext context = JAXBContext.newInstance(Rss.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            Rss rss = (Rss) unmarshaller.unmarshal(new File("cnn.xml"));

            System.out.println(rss);
        } catch( UnmarshalException ue ) {
            System.out.println("Caught UnmarshalException");
        } catch (JAXBException e) {
            e.printStackTrace();
        }
*/
    }

    private static void saveRSS(String urlRSS, String fileName) {
        try {
            URL url = new URL(urlRSS);

            InputStreamReader reader = new InputStreamReader(url.openStream());
            BufferedReader bReader = new BufferedReader(reader);

            PrintWriter pWriter = new PrintWriter(new FileWriter(fileName));

            String lineContents;
            while ((lineContents = bReader.readLine()) != null) {
                pWriter.println(lineContents);
            }
            bReader.close();
            pWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
