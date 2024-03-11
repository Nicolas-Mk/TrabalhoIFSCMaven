/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;

public interface InterfaceDAO<T> {

    public abstract void create(T objeto);

    public abstract void retrieve(T objeto);

    public abstract void update(T objeto);

    public abstract void delete(T objeto);

    public abstract List<T> retrieve();

    public abstract T retrieve(int parPK);

    public abstract List<T> retrieve(String parString);

}
