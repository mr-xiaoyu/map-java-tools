package club.mrxiao.qq.bean.coord;

import club.mrxiao.qq.bean.Location;
import com.alibaba.fastjson.JSON;
import lombok.Data;

import java.util.List;

/**
 *  <pre>
 *  腾讯地图坐标转换服务响应对象
 *  </pre>
 * @author <a href="https://github.com/mr-xiaoyu">xiaoyu</a>
 * @since 2025-09-02
 */
@Data
public class QqMapCoordResult {

    /**
     * 坐标列表
     */
    private List<Location> locations;

    public static QqMapCoordResult fromJson(String json){
        return JSON.toJavaObject(JSON.parseObject(json),QqMapCoordResult.class);
    }
}
