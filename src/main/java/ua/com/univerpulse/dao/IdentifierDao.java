package ua.com.univerpulse.dao;

import java.io.Serializable;


public interface IdentifierDao<PK extends Serializable> {
    public PK getId();
}
