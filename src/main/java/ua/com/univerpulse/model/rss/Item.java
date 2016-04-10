package ua.com.univerpulse.model.rss;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@XmlRootElement(name="item")
@XmlAccessorType(XmlAccessType.FIELD)
public class Item {
    private String title;
    private String link;
    private String description;
    private String guid;
    private String pubDate;
    private String author;
    @XmlElement(name = "content")
    private Enclosure enclosule;

    public Item() {
    }

    public String getAuthor() {
        return author;
    }

    public String getDescription() {
        return description;
    }

    public Enclosure getEnclosule() {
        return enclosule;
    }

    public String getGuid() {
        return guid;
    }

    public String getLink() {
        return link;
    }

    public String getPubDate() {
        if (this.pubDate.isEmpty()) {
            return this.pubDate;
        }
        DateFormat formatter = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss Z", Locale.ENGLISH);
        try {
            Date date = formatter.parse(this.pubDate);
            formatter = new SimpleDateFormat("dd MMM yyyy HH:mm", Locale.ENGLISH);
            return formatter.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return pubDate;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Item{");
        sb.append("title='").append(title).append('\'');
        sb.append(", link='").append(link).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append(", author=").append(author);
        sb.append(", enclosule=").append(enclosule);
        sb.append(", guid='").append(guid).append('\'');
        sb.append(", pubDate='").append(pubDate).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
