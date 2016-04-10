package ua.com.univerpulse.model.rss;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@XmlRootElement(name = "channel")
@XmlAccessorType(XmlAccessType.FIELD)
public class Channel {
    private String title;
    private String link;
    private String description;
    private String language;
    private String copyright;
    private String pubDate;
    private List<Item> item = new ArrayList<>();

    public List<Item> getItem() {
        return item;
    }

    public Date getPubDateInDateFormat()  {
        DateFormat formatter = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss Z", Locale.ENGLISH);
        //new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz", Locale.ENGLISH);;
        Date date = null;
        try {
            date = formatter.parse(this.pubDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Channel{");
        sb.append("copyright='").append(copyright).append('\'');
        sb.append(", title='").append(title).append('\'');
        sb.append(", link='").append(link).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append(", language='").append(language).append('\'');
        sb.append(", pubDate='").append(pubDate).append('\'');
        sb.append(", items=").append(item);
        sb.append('}');
        return sb.toString();
    }
}
