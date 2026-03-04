package club.mrxiao.qq.api;

import club.mrxiao.common.error.QqMapErrorException;
import club.mrxiao.qq.bean.address.*;

/**
 * <pre>
 *  腾讯地图地址服务接口
 * </pre>
 * @author <a href="https://github.com/mr-xiaoyu">xiaoyu</a>
 * @since 2024-08-13
 */
public interface QqMapAddressService {

    String GEOCODER = "https://apis.map.qq.com/ws/geocoder/v1";

    String TRUTH_ANALY = "https://apis.map.qq.com/ws/smart_address/truth_analy";

    String ABNORMAL_ANALY = "https://apis.map.qq.com/ws/smart_address/abnormal_analy";

    String ADDRESS_COMPLETE = "https://apis.map.qq.com/ws/smart_address/address_complete";

    /**
     * 地址解析
     * @param request {@link QqMapGeocoderRequest}
     * @return 解析结果
     * @throws QqMapErrorException 异常
     * @see <a href="https://lbs.qq.com/service/webService/webServiceGuide/address/Gcoder">逆地址解析</a>
     * @see <a href="https://lbs.qq.com/service/webService/webServiceGuide/address/Geocoder">地址解析</a>
     */
    QqMapGeocoderResult geocoder(QqMapGeocoderRequest request) throws QqMapErrorException;

    /**
     * 地址纠正补全
     * @param address 要进行纠正补全的地址
     * @return 地址纠正补全结果
     * @throws QqMapErrorException 异常
     * @see <a href="https://lbs.qq.com/service/webService/webServiceGuide/address/address_complete">地址纠正补全</a>
     */
    QqMapAddressCompleteResult addressComplete(String address) throws QqMapErrorException;

    /**
     * 地址真实性分析（地址验真）
     * @param address 地址（地址中需要包含城市，否则会解析失败）
     * @return 地址真实性分析（地址验真）结果
     * @throws QqMapErrorException 异常
     * @see <a href="https://lbs.qq.com/service/webService/webServiceGuide/address/truth_analy">地址真实性分析（地址验真）</a>
     */
    QqMapTruthAnalyResult truthAnaly(String address) throws QqMapErrorException;

    /**
     * 地址异常错误分析
     * @param address 地址
     * @return 地址异常错误分析结果
     * @throws QqMapErrorException 异常
     * @see <a href="https://lbs.qq.com/service/webService/webServiceGuide/address/abnormal_analy">地址异常错误分析</a>
     */
    QqMapAbnormalAnalyResult abnormalAnaly(String address) throws QqMapErrorException;
}
