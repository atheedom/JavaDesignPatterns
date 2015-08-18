package com.alextheedom;

/**
 * Created by atheedom on 18/08/15.
 */
public class User implements Observer {

    private String article;
    private Subject blog;

    @Override
    public void setSubject(Subject blog) {
        this.blog = blog;
        article = "No New Article!";
    }

    @Override
    public void update() {
        System.out.println("State change reported by Subject.");
        article = blog.<String>getUpdate();
    }

    public String getArticle() {
        return article;
    }
}
