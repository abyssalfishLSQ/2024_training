package com.xiaomi.server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xiaomi.server.Entity.Metric;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MetricMapper extends BaseMapper<Metric> {
}

