package edu.ncu.mapper;

import edu.ncu.model.OidThreshold;
import edu.ncu.model.OidValue;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 与OidValue相关的数据库方法集合
 */
@Mapper
public interface OidValueMapper {
    /**
     * 通过ip和oid值查询到相关的OidValue集合
     * @param ip
     * @param oid
     * @return
     */
    List<OidValue> getOidValue(@Param("ip") String ip, @Param("oid") String oid);

    /**
     * 通过ip获取到该服务器设备所有的oid值
     * @param ips
     * @return
     */
    List<OidThreshold> getOidList(@Param("ips") List<String> ips);
}
