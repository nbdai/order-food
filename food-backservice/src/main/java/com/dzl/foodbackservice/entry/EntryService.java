package com.dzl.foodbackservice.entry;

import com.dzl.fooddao.entry.EntryReposity;
import com.dzl.foodpojo.entity.Entry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.List;


@Service("entryService")
public class EntryService {
    @Autowired
    private EntryReposity entryReposity;
    @Autowired
    private JedisPool jedisPool;
    public List<Entry>  fingAll(){
        return entryReposity.findByIsDisplay(true);
    }
    public void addEntry(Entry entry){
           Jedis jedis = jedisPool.getResource();
           Long entryId = jedis.incr("entryId");
           entry.setId(entryId);
           entry.setIsDisplay(true);
           entryReposity.save(entry);
           jedis.close();
    }
     @Transactional
     public void delEntry(Long id){
        entryReposity.updateById(id);
     }
     public Entry uploadEntry(Long id){
        if (id==null){
            return null;
         }
         return entryReposity.getOne(id);
     }
    public void saveEntry(Entry entry){
        entryReposity.save(entry);
    }
}
