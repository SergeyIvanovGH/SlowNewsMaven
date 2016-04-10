package ua.com.univerpulse.model.rss;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="rss")
public class Rss {
    @XmlAttribute(name="version")
    private String version;
    @XmlElement(name = "channel")
    private Channel channel;

    public Channel getChannel() {
        return channel;
    }

    public String getVersion() {
        return version;
    }

    public void deleteRssContent() {
        Enclosure enclosure = null;
        for (Item item : channel.getItem()) {
            enclosure = item.getEnclosule();
            enclosure = null;
            item = null;
        }
    }
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Rss{");
        sb.append("Channel=").append(channel);
        sb.append(", version='").append(version).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
