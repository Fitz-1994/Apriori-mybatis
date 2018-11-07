package edu.ncu.mapper;

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
}
