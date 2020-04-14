package me.guozi.dao;

import org.springframework.stereotype.Repository;

/**
 * Created by chenyun on 2020/4/6
 */
@Repository
public class BookDao {

    private String label = "1";

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return "BookDao{" +
               "label='" + label + '\'' +
               '}';
    }
}
