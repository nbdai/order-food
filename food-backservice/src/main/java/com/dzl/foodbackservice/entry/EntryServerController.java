package com.dzl.foodbackservice.entry;
import com.dzl.foodpojo.entity.Entry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EntryServerController {
    @Autowired
    private  EntryService entryService;
    @RequestMapping("selectAll")
    public List<Entry> selectAll(){
        return entryService.fingAll();
    }
    @RequestMapping("saveEntry")
    public void saveEntry(@RequestBody Entry entry){
        entryService.addEntry(entry);
    }
    @RequestMapping("delEntry")
    public void delEntry(@RequestParam  Long id){
       entryService.delEntry(id);
    }
    @RequestMapping("uploadEntry")
    public Entry uploadEntry(Long id){
        return entryService.uploadEntry(id);
    }
    @RequestMapping("updateEntry")
    public void updateEntry(@RequestBody Entry entry){
        entryService.saveEntry(entry);
    }
}
