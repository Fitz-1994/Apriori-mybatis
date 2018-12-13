package edu.ncu.service.warning;

import edu.ncu.mapper.WarningMapper;
import edu.ncu.model.FrequentItem;
import edu.ncu.model.Warning;
import edu.ncu.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 告警数据功能接口
 * @author forward
 */
@Service
public class WarningService {
    @Autowired
    private WarningMapper warningMapper;

    /**
     * 查询所有告警数据的方法
     * @return
     */
    public List<Warning> findAllList(){
        return warningMapper.findList(null,null);
    }

    /**
     * 对查询出来的告警数据进行分割，暂定5分钟为一组数据。
     * @param warningList
     * @return
     */
    public List<List<Warning>> groupWarning(List<Warning> warningList){
        if (warningList == null || warningList.size() == 0){
            return null;
        }else {
            List<List<Warning>> result = new ArrayList<>();
            List<Warning> tempList = new ArrayList<>();
            long startTime = 0L;
            for (Warning w : warningList){
                if (tempList.size() == 0){
                    tempList.add(w);
                    startTime = w.getWarningTime().getTime();
                }else {
                    if (w.getWarningTime().getTime() - startTime <= (5*60*1000)){
                        tempList.add(w);
                    }else {
                        result.add(tempList);
                        tempList = new ArrayList<>();
                        tempList.add(w);
                        startTime = w.getWarningTime().getTime();
                    }
                }
            }
            if (tempList.size() > 0){
                result.add(tempList);
            }
            return result;
        }
    }

    public void saveFrequentItems(List<FrequentItem> frequentItems){
        /*
        * 1、在Frequent_Items表中添加数据
        * 2、在Frequent_Warning表中添加频繁项数据
        * */
        for(FrequentItem f : frequentItems){
            warningMapper.insertFrequentItem(f);
            boolean first = true;
            for (Warning w : f.getItems()){
                if (first){
                    warningMapper.insertFrequentWarning(f.getId(), StringUtils.UUID(),"0",w);
                    first = false;
                }else {
                    warningMapper.insertFrequentWarning(f.getId(), StringUtils.UUID(),"1",w);
                }
            }
        }

    }

    public List<FrequentItem> findFrequentItemWithWarning(){
        return warningMapper.findFrequentItemWithWarning();
    }

    public List<FrequentItem> findFrequentItemByFators(String deviceId,String oid,String degree){
        List<String> ids = warningMapper.findFrequentItemByFators(deviceId, oid, degree);
        return warningMapper.findFrequentItemByIds(ids);
    }

    public void deleteFrequentItems(){
        warningMapper.deleteFrequentWarning();
        warningMapper.deleteFrequentItems();
    }

    public void insertTest(){
        Warning warning = new Warning();
        warning.setId("id");
        warning.setDeviceId("deviceId");
        warning.setDegree("0");
        warning.setStatus("0");
        warning.setOid("oid");
        warningMapper.insertFrequentWarning("itemID","newId","1",warning);
    }
}
