package com.alexbackfish.urlshortenerbackend.Entities;

import com.alexbackfish.urlshortenerbackend.Generators.StringIdGenerator;
import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

@Entity(name = "URLEntry")
@Table(name = "urlentry")
public class URLEntry {

    @Id
    private String id;

    @Column(name="url", nullable = false)
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getId() {
        return id;
    }

    public URLEntry(String url) {
        this.id = StringIdGenerator.getID();
        this.url = url;
    }

    public URLEntry() {
    }
}
