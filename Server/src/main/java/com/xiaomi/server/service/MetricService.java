package com.xiaomi.server.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaomi.server.Entity.Metric;
import com.xiaomi.server.mapper.MetricMapper;
import org.springframework.stereotype.Service;

@Service
public class MetricService extends ServiceImpl<MetricMapper, Metric> {
}
