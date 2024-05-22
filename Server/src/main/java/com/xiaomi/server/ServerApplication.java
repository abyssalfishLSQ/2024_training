package com.xiaomi.server;

import com.xiaomi.server.Entity.InfoEntity;
import com.xiaomi.server.common.Result;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
public class ServerApplication {

    @PostMapping("/api/metric/upload")
    public Result uploadMetric(@RequestBody InfoEntity infoEntity) {
        // TODO 这里处理上传的指标数据，存储到MySQL和Redis中
        //return new Result("ok", 200,null);
        return null;
    }

    @GetMapping("/api/metric/query")
    public Result queryMetric(@RequestParam String endpoint,
                              @RequestParam(required = false) String metric,
                              @RequestParam long start_ts,
                              @RequestParam long end_ts) {
        // 这里查询指标数据，从MySQL或Redis中获取数据并返回
        // 具体实现略
        //return new Result("ok", 200, data);
        return null;
    }



    public static void main(String[] args) {
        SpringApplication.run(ServerApplication.class, args);
    }

}
