package com.bianl.listviewwithedittext;

/**
 * Created by fhbianling on 2016/9/13.
 *
 * @mail:fhbianling@163.com
 */
public class Entities {
    String title;
    String et1;
    String et2;

    @Override
    public String toString() {
        return "\nEntities{" +
                "et2='" + et2 + '\'' +
                ", et1='" + et1 + '\'' +
                ", title='" + title + '\'' +
                '}';
    }

    public Entities(String title, String et1, String et2) {
        this.title = title;
        this.et1 = et1;
        this.et2 = et2;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEt1() {
        return et1;
    }

    public void setEt1(String et1) {
        this.et1 = et1;
    }

    public String getEt2() {
        return et2;
    }

    public void setEt2(String et2) {
        this.et2 = et2;
    }
}
