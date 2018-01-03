package com.forezp.entity.xml;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by jh on 2017/7/13.
 */
@XmlRootElement
public class Test {
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
