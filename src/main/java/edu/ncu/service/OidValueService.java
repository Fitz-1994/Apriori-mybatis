package edu.ncu.service;

import edu.ncu.mapper.OidValueMapper;
import edu.ncu.model.OidThreshold;
import edu.ncu.model.OidValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author forward
 */
@Service
public class OidValueService {
    @Autowired
    private OidValueMapper oidValueMapper;

    public List<OidValue> getOidValue(String ip,String oid){
        List<OidValue> list = oidValueMapper.getOidValue(ip, oid);
        System.out.println(list.size());
        return list;
    }

    public List<OidThreshold> getOidList(List<String> ips){
        return oidValueMapper.getOidList(ips);
    }
}
