package org.example.service;


import java.util.List;

public interface CollectionService {
    int insertCollection(String username, Integer phone_id);

    int deleteCollection(String username,Integer phone_id);

    List<Integer> getCollectionToUser(String username);
}
