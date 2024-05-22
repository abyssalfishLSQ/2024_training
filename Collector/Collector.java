import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import java.util.*;

public class Collector {

    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                uploadMetrics();
            }
        }, 0, 60000); // 每分钟执行一次
    }

    public static void uploadMetrics() {
        // 模拟采集CPU和内存利用率数据
        List<Metric> metrics = new ArrayList<>();
        // 假设获取了CPU利用率和内存利用率的值
        Metric cpuMetric = new Metric("cpu.used.percent", "my-computer", System.currentTimeMillis() / 1000, 60, 60.1);
        Metric memMetric = new Metric("mem.used.percent", "my-computer", System.currentTimeMillis() / 1000, 60, 35.0);
        metrics.add(cpuMetric);
        metrics.add(memMetric);

        // 发送HTTP POST请求上传数据
        RestTemplate restTemplate = new RestTemplate();
        String serverUrl = "http://server-ip:server-port/api/metric/upload";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<List<Metric>> request = new HttpEntity<>(metrics, headers);
        ResponseEntity<Response> responseEntity = restTemplate.postForEntity(serverUrl, request, Response.class);
        if (responseEntity.getStatusCode() == HttpStatus.OK) {
            System.out.println("Metrics uploaded successfully");
        } else {
            System.out.println("Failed to upload metrics");
        }
    }
}
