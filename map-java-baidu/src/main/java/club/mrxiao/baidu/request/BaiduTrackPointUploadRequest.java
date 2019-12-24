package club.mrxiao.baidu.request;

import club.mrxiao.baidu.domain.BaiduTraceTrackPoint;
import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.StrUtil;

import java.util.HashMap;

/**
 * 百度鹰眼轨迹点上传
 * @author xiaoyu
 */
public class BaiduTrackPointUploadRequest extends HashMap<String, Object> {

    private static final long serialVersionUID = -1508527357657082761L;

    @Override
    public BaiduTrackPointUploadRequest put(String key, Object value) {
        super.put(key, value);
        return this;
    }

    public BaiduTrackPointUploadRequest(BaiduTraceTrackPoint baiduTraceTrackPoint){
        //entity唯一标识
        if(StrUtil.isNotBlank(baiduTraceTrackPoint.getEntityName())){
            this.put("entity_name",baiduTraceTrackPoint.getEntityName());
        }
        //经度
        if(baiduTraceTrackPoint.getLongitude() != null){
            this.put("longitude",baiduTraceTrackPoint.getLongitude());
        }
        //纬度
        if(baiduTraceTrackPoint.getLatitude() != null){
            this.put("latitude",baiduTraceTrackPoint.getLatitude());
        }
        //定位时设备的时间
        if(baiduTraceTrackPoint.getLocTime() != null){
            this.put("loc_time",baiduTraceTrackPoint.getLocTime());
        }
        //坐标类型
        if(StrUtil.isNotBlank(baiduTraceTrackPoint.getCoordTypeInput())){
            this.put("coord_type_input",baiduTraceTrackPoint.getCoordTypeInput());
        }
        //以上是必填

        //速度
        if(baiduTraceTrackPoint.getSpeed() != null){
            this.put("speed",baiduTraceTrackPoint.getSpeed());
        }
        //方向
        if(baiduTraceTrackPoint.getDirection() != null){
            this.put("direction",baiduTraceTrackPoint.getDirection());
        }
        //高度
        if(baiduTraceTrackPoint.getHeight() != null){
            this.put("height",baiduTraceTrackPoint.getHeight());
        }
        //定位精度，GPS或定位SDK返回的值
        if(baiduTraceTrackPoint.getRadius() != null){
            this.put("radius",baiduTraceTrackPoint.getRadius());
        }
        //对象数据名称
        if(StrUtil.isNotBlank(baiduTraceTrackPoint.getObjectName())){
            this.put("object_name",baiduTraceTrackPoint.getObjectName());
        }
    }
}
