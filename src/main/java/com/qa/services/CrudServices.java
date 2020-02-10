package com.qa.services;

import java.util.List;

public interface CrudServices<T> {

    public List<String> readAll();
    
    public String readOne(T t);
     
    void create(T t);
     
    void update(T t);
 
    void delete(T t);

}
