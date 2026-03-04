package club.mrxiao.qq.api;

import club.mrxiao.common.error.QqMapErrorException;
import club.mrxiao.qq.bean.coord.QqMapCoordRequest;
import club.mrxiao.qq.bean.coord.QqMapCoordResult;

/**
 * <pre>
 *  腾讯地图坐标服务接口
 * </pre>
 * @author <a href="https://github.com/mr-xiaoyu">xiaoyu</a>
 * @since 2025-09-02
 */
public interface QqMapCoordService {


    String TRANSLATE = "https://apis.map.qq.com/ws/coord/v1/translate";

    /**
     * 坐标转换
     * @param request {@link QqMapCoordResult}
     * @return {@link QqMapCoordResult}
     * @throws QqMapErrorException 异常
     * @see <a href="https://lbs.qq.com/service/webService/webServiceGuide/webServiceTranslate">坐标转换</a>
     */
    QqMapCoordResult translate(QqMapCoordRequest request) throws QqMapErrorException;
}
