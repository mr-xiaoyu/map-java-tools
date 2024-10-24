package club.mrxiao.qq.api.impl;

import club.mrxiao.common.error.QqMapErrorException;
import club.mrxiao.qq.api.QqMapSearchService;
import club.mrxiao.qq.api.QqMapService;
import club.mrxiao.qq.bean.district.QqMapDistrictRequest;
import club.mrxiao.qq.bean.district.QqMapDistrictResult;
import club.mrxiao.qq.bean.place.QqMapPlaceRequest;
import club.mrxiao.qq.bean.place.QqMapPlaceResult;
import lombok.AllArgsConstructor;

/**
 * <pre>
 *  腾讯地图搜索服务接口实现
 * </pre>
 * @author <a href="https://github.com/mr-xiaoyu">xiaoyu</a>
 * @since 2024-08-12
 */
@AllArgsConstructor
public class QqMapSearchServiceImpl implements QqMapSearchService {

    private final QqMapService qqMapService;

    @Override
    public QqMapPlaceResult placeSearch(QqMapPlaceRequest request) throws QqMapErrorException {
        String result = this.qqMapService.get(PLACE_SEARCH,request.toJson());
        return QqMapPlaceResult.fromJson(result);
    }

    @Override
    public QqMapDistrictResult districtList() throws QqMapErrorException {
        QqMapDistrictRequest request = QqMapDistrictRequest.builder().build();
        String result = this.qqMapService.get(DISTRICT_LIST,request.toJson());
        return QqMapDistrictResult.fromJson(result);
    }

    @Override
    public QqMapDistrictResult districtTree() throws QqMapErrorException {
        QqMapDistrictRequest request = QqMapDistrictRequest.builder()
                .structType("1")
                .build();
        String result = this.qqMapService.get(DISTRICT_LIST,request.toJson());
        return QqMapDistrictResult.treeFromJson(result);
    }

    @Override
    public QqMapDistrictResult districtGetChildren(QqMapDistrictRequest request) throws QqMapErrorException {
        String result = this.qqMapService.get(DISTRICT_GET_CHILDREN,request.toJson());
        return QqMapDistrictResult.fromJson(result);
    }
}
