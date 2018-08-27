package com.dzl.fooddao.entry;

import com.dzl.foodpojo.entity.Entry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface EntryReposity extends JpaRepository<Entry,Long>{
     List<Entry> findByIsDisplay(Boolean isDisplay);
     @Modifying
     @Query("update Entry e set e.isDisplay= 0 where e.id = ?1")
     void updateById(Long id);

}
