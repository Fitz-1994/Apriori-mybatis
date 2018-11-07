package edu.ncu.controller;

import edu.ncu.model.FrequentItems;
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

    @RequestMapping(value = "test")
    public ResponseEntity test(){
        List<FrequentItems> list = aprori.getFrequentItems();
        System.out.println(list);
        return ResponseEntity.ok("test success");
    }
}
