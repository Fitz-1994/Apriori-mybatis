package edu.ncu.mapper;

import edu.ncu.model.FrequentItem;
import edu.ncu.model.Warning;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * @author forward
 * 告警数据接口
 */
@Mapper
public interface WarningMapper {
    /**
     * 查询数据库里所有的告警数据
     * @param start 开始时间
     * @param end 结束时间
     * @return
     */
    List<Warning> findList(@Param(value = "start") Date start,@Param("end") Date end);

    /**
     * 将挖掘出来的频繁项写入数据库中
     * @param frequentItem
     */
    void insertFrequentItem(FrequentItem frequentItem);

    /**
     * @param id
     * @param firstItem
     * @param warning
     */
    void insertFrequentWarning(@Param("itemId") String itemId, @Param(value = "id") String id,@Param("firstItem") String firstItem, @Param("warning") Warning warning);

    List<FrequentItem> findFrequentItemWithWarning();

    void deleteFrequentItems();

    void deleteFrequentWarning();

}
