package com.qa.persistence.dao;

import java.util.List;

public interface Dao<T> {

    List<String> readAll();
    
    String readOne(T t);
     
    void create(T t);
     
    void update(T t);
     
    void delete(T t);

}
	