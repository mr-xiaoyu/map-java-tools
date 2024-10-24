package club.mrxiao.qq.api;

import club.mrxiao.common.error.QqMapErrorException;
import club.mrxiao.qq.bean.district.QqMapDistrictRequest;
import club.mrxiao.qq.bean.district.QqMapDistrictResult;
import club.mrxiao.qq.bean.place.QqMapPlaceRequest;
import club.mrxiao.qq.bean.place.QqMapPlaceResult;

/**
 * <pre>
 *  腾讯地图搜索服务接口
 * </pre>
 * @author <a href="https://github.com/mr-xiaoyu">xiaoyu</a>
 * @since 2024-08-12
 */
public interface QqMapSearchService {

    String PLACE_SEARCH = "https://apis.map.qq.com/ws/place/v1/search";

    String DISTRICT_LIST = "https://apis.map.qq.com/ws/district/v1/list";

    String DISTRICT_GET_CHILDREN = "https://apis.map.qq.com/ws/district/v1/getchildren";

    /**
     * 搜索
     * @param request {@link QqMapPlaceRequest}
     * @return 搜索结果
     * @throws QqMapErrorException 异常
     * @see <a href="https://lbs.qq.com/service/webService/webServiceGuide/search/webServiceSearch">周边搜索</a>
     */
    QqMapPlaceResult placeSearch(QqMapPlaceRequest request) throws QqMapErrorException;

    /**
     * 获取省市区列表
     * @return 省市区列表
     * @throws QqMapErrorException 异常
     * @see <a href="https://lbs.qq.com/service/webService/webServiceGuide/search/webServiceDistrict">行政区划</a>
     */
    QqMapDistrictResult districtList() throws QqMapErrorException;

    /**
     * 获取省市区树形菜单
     * @return 省市区列表
     * @throws QqMapErrorException 异常
     * @see <a href="https://lbs.qq.com/service/webService/webServiceGuide/search/webServiceDistrict">行政区划</a>
     */
    QqMapDistrictResult districtTree() throws QqMapErrorException;

    /**
     * 获取下级行政区划
     * @param request {@link QqMapPlaceRequest}
     * @return 下级行政区划
     * @throws QqMapErrorException 异常
     * @see <a href="https://lbs.qq.com/service/webService/webServiceGuide/search/webServiceDistrict">行政区划</a>
     */
    QqMapDistrictResult districtGetChildren(QqMapDistrictRequest request) throws QqMapErrorException;;
}
