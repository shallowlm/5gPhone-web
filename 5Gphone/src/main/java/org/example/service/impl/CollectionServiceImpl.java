package org.example.service.impl;

import org.example.dao.CollectionMapper;
import org.example.service.CollectionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("CollectionService")

public class CollectionServiceImpl implements CollectionService {
    @Resource(name = "CollectionMapper")
    private CollectionMapper collectionMapper;
    public int insertCollection(String username, Integer phone_id){
        try {
            return collectionMapper.insertCollection(username,phone_id);
        }
        catch (Exception e) {
            if (e.getMessage().contains("Duplicate entry")) {
                return 0;
            }
            throw e;
        }
    }

    public int deleteCollection(String username,Integer phone_id){
        return collectionMapper.deleteCollection(username, phone_id);
    }

    public List<Integer> getCollectionToUser(String username){
        return collectionMapper.getCollectionToUser(username);
    }
}
