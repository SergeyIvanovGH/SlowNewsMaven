package ua.com.univerpulse.model.rss;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "content")
public class Enclosure {
    @XmlAttribute
    private String url;
    @XmlAttribute
    private int length;
    @XmlAttribute
    private String type;

    public int getLength() {
        return length;
    }

    public String getType() {
        return type;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Enclosure{");
        sb.append("length=").append(length);
        sb.append(", url='").append(url).append('\'');
        sb.append(", typeMIME='").append(type).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
