package edu.ncu.controller;

import edu.ncu.model.FrequentItem;
import edu.ncu.service.warning.WarningService;
import edu.ncu.utils.Aprori;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author forward
 */
@Controller
public class WarningController {
    @Autowired
    private WarningService warningService;
    @Autowired
    private Aprori aprori;

    @RequestMapping(value = "warning")
    public ResponseEntity warning(){
        List<FrequentItem> list = warningService.findFrequentItemWithWarning();
        return ResponseEntity.ok(list);
    }

    @RequestMapping(value = "select")
    public ResponseEntity select(String deviceId,String oid,String degree){
        List<FrequentItem> list = warningService.findFrequentItemByFators(deviceId,oid,degree);
        return ResponseEntity.ok(list);
    }


    @RequestMapping(value = "update")
    public ResponseEntity updateFrequentItems(){
        aprori.saveFrequentItems();
        return ResponseEntity.ok("update success");
    }
}
