package club.mrxiao.qq.bean.coord;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.Builder;
import lombok.Data;

/**
 *  <pre>
 *  腾讯地图坐标转换服务请求对象
 *  </pre>
 * @author <a href="https://github.com/mr-xiaoyu">xiaoyu</a>
 * @since 2025-09-02
 */
@Data
@Builder
public class QqMapCoordRequest {

    /**
     * 坐标列表
     * <pre>
     * 是否必填： 是
     * 描述：
     * 预转换的坐标，支持批量转换，
     * 格式：纬度前，经度后，纬度和经度之间用",“分隔，每组坐标之间使用”;"分隔；
     * locations参数字符符总长度不可超过2048个，经度和纬度小数点后不可超过16位
     * </pre>
     */
    private String locations;

    /**
     * 输入的locations的坐标类型
     * <pre>
     * 是否必填： 是
     * 描述：
     * 1 GPS坐标
     * 2 sogou经纬度
     * 3 baidu经纬度
     * 4 mapbar经纬度
     * 6 sogou墨卡托
     * </pre>
     */
    private String type;

    public JSONObject toJson(){
        String beanString = JSON.toJSONString(this);
        return JSONObject.parseObject(beanString);
    }
}
