package ua.com.univerpulse.model;

import ua.com.univerpulse.model.rss.Item;
import ua.com.univerpulse.model.rss.Rss;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.UnmarshalException;
import javax.xml.bind.Unmarshaller;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class NewsCollection {
    private final String urlRSS = "http://rss.cnn.com/rss/edition.rss";
    private static NewsCollection ourInstance = new NewsCollection();
    private long timeUpdateNews = 0;
    private Rss rss;
    private List<Item> archiveNews = new ArrayList<>();

    public static NewsCollection getInstance() {
        return ourInstance;
    }

    private NewsCollection() {
    }

    public List<Item> getNewsFromRSS () {
        if ((System.currentTimeMillis() - timeUpdateNews) > 30*60*1000) {
            if (rss != null) {
                this.rss.deleteRssContent();
                this.rss = null;
            }
            try {
                URL url = new URL(this.urlRSS);

                JAXBContext context = JAXBContext.newInstance(Rss.class);
                Unmarshaller unmarshaller = context.createUnmarshaller();
                rss = (Rss) unmarshaller.unmarshal(url);
                timeUpdateNews = System.currentTimeMillis();

            } catch (UnmarshalException ue) {
                System.out.println("Caught UnmarshalException");
            } catch (JAXBException e) {
                e.printStackTrace();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
        return rss.getChannel().getItem();
    }

    public boolean putNewsToArchive(String guid) {
        for (Item item : this.rss.getChannel().getItem()) {
            if (item.getGuid().equals(guid)) {
                saveNewsToArchive(item);
                break;
            }
        }
        return true;
    }

    private boolean saveNewsToArchive(Item savedItem) {
        boolean found = false;
        for (Item item : getArchivewNews()) {
            if (item.getGuid().equals(savedItem.getGuid())) {
                found = true;
                break;
            }
        }
        if (!found) {
            archiveNews.add(savedItem);
        }
        return true;
    }

    public boolean deleteNewsFromArchive(String guid) {
        Iterator<Item> iterator = getArchivewNews().iterator();
        while (iterator.hasNext()) {
            if(iterator.next().getGuid().equals(guid)) {
                iterator.remove();
            }
        }
        return true;
    }

    public List<Item> getArchivewNews() {
        return archiveNews;
    }
}
