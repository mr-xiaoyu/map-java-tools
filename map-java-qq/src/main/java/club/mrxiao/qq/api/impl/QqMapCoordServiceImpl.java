package club.mrxiao.qq.api.impl;

import club.mrxiao.common.error.QqMapErrorException;
import club.mrxiao.qq.api.QqMapCoordService;
import club.mrxiao.qq.api.QqMapService;
import club.mrxiao.qq.bean.coord.QqMapCoordRequest;
import club.mrxiao.qq.bean.coord.QqMapCoordResult;
import lombok.AllArgsConstructor;

/**
 * <pre>
 *  腾讯地图坐标服务接口实现
 * </pre>
 * @author <a href="https://github.com/mr-xiaoyu">xiaoyu</a>
 * @since 2025-09-02
 */
@AllArgsConstructor
public class QqMapCoordServiceImpl implements QqMapCoordService {

    private final QqMapService qqMapService;

    @Override
    public QqMapCoordResult translate(QqMapCoordRequest request) throws QqMapErrorException {
        String result = this.qqMapService.get(TRANSLATE,request.toJson());
        return QqMapCoordResult.fromJson(result);
    }
}
