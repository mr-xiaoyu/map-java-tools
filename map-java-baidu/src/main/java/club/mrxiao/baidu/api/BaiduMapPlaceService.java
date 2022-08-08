package club.mrxiao.baidu.api;

import club.mrxiao.baidu.bean.place.BaiduMapPlaceRequest;
import club.mrxiao.baidu.bean.place.BaiduMapPlaceResult;
import club.mrxiao.common.error.BaiduMapErrorException;

import java.util.List;

/**
 * <pre>
 *  百度地图地点检索V2.0接口
 * </pre>
 * @author <a href="https://github.com/mr-xiaoyu">xiaoyu</a>
 * @since 2019-12-26
 */
public interface BaiduMapPlaceService {

    /**
     * 地点检索
     */
    String PLACE_SEARCH = "https://api.map.baidu.com/place/v2/search";

    /**
     * 地点详情
     */
    String PLACE_DETAIL = "https://api.map.baidu.com/place/v2/detail";


    /**
     * 地点检索(行政区划区域检索、圆形区域检索、矩形区域检索)
     * @param request 百度地图地点检索服务请求对象
     * @param <T> 需使用{@link BaiduMapPlaceResult}集合 或者{@link club.mrxiao.common.bran.ResultDataTable}
     * @return 百度地图地点检索服务响应对象集合，分页时返回分页对象
     * @throws BaiduMapErrorException 错误信息
     * <pre>
     *   <a href="http://lbsyun.baidu.com/index.php?title=webapi/guide/webservice-placeapi">查看文档</a>
     * </pre>
     */
    <T> T placeSearch(BaiduMapPlaceRequest request) throws BaiduMapErrorException;

    /**
     * 地点详情检索
     * @param uids poi的uid 最多可以传入10个uid。
     * @param scope 检索结果详细程度 。1或空，则返回基本信息；取值为2，返回检索POI详细信息
     * @return 百度地图地点检索服务响应对象集合
     * @throws BaiduMapErrorException 错误信息
     * <pre>
     *   <a href="http://lbsyun.baidu.com/index.php?title=webapi/guide/webservice-placeapi">查看文档</a>
     * </pre>
     */
    List<BaiduMapPlaceResult> placeDetail(String scope, List<String> uids)throws BaiduMapErrorException;
}
