package club.mrxiao.baidu.enums;

import lombok.Getter;

/**
 * 返回码枚举
 * @author xiaoyu
 */
@Getter
public enum BaiduTraceStatusEnum {

    /**
     * 请求成功
     */
    succeed(0,"成功"),

    /**
     * 该服务响应超时或系统内部错误
     */
    server_error(1,"服务器内部错误"),

    /**
     * 参数错误	具体错误信息将在 message 中给出
     */
    param_error(2,"参数错误"),

    /**
     * 	http method错误	检查请求的 http method（GET/POST）是否与接口描述一致
     */
    http_method_error(3,"http method错误"),

    /**
     * 指定 entity 不存在	未查询到 entity_name 为设定值的 entity，请检查 entity_name 是否输入错误或已被删除
     */
    entity_nonentity(3003,"指定entity不存在"),

    /**
     * entity_name已存在	entity_name 是 entity 的唯一标识，在同一 service 中不可创建 entity_name 重复的 entity，请更换名字后再次尝试
     */
    entity_name_nonentity(3005,"entity_name已存在"),

    /**
     * entity_name不符合命名规范：仅支持中文、英文大小字母、英文下划线"_"、英文横线"-"和数字。
     */
    point_nimiety(3006,"查询时间段内的轨迹点过多，无法进行纠偏，请缩短查询时间"),


    /**
     * 返回的字段值中存在非 utf8编码的字符。所有上传的字符均应以 utf8 编码
     */
    analysis_error(3007,"数据解析失败，数据中包含非utf8编码字符"),

    /**
     * 请求参数中service_id填写错误或不属于当前账号，请检查是否填写了正确的service_id
     */
    service_id_nonentity(4005,"指定service_id不存在"),

    /**
     * 一个监控对象最多可创建100个围栏，建议定期清理无效围栏
     */
    out_of_range(5101,"监控对象的围栏个数超出范围，最多100个"),

    /**
     * 创建或更新围栏时，指定的监控对象 entity_name 不存在
     */
    object_nonentity(5102,"监控对象不存在"),

    /**
     * 监控对象上没有fence_id为XXX的围栏
     */
    object_fence_id_nonentity(5103,"监控对象上没有fence_id为XXX的围栏"),

    /**
     * 指定fence_id不存在
     */
    fence_id_nonentity(5104,"指定fence_id不存在"),


    /**
     * 查询时间段内的轨迹点过多，无法进行轨迹分析，请缩短查询时间	一次请求查询的轨迹点不可超过两万，否则将返回失败
     */
    point_too_many(9001,"查询时间段内的轨迹点过多，无法进行轨迹分析，请缩短查询时间");

    private Integer code;
    private String message;

    BaiduTraceStatusEnum (Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public void setMessage(String message){
        this.message = message;
    }

    public static BaiduTraceStatusEnum getBaiduTraceStatusEnumByCode(Integer code){
        BaiduTraceStatusEnum resultEnum = null;
        for(BaiduTraceStatusEnum renum : BaiduTraceStatusEnum.values()){
            if(renum.code.equals(code)){
                resultEnum = renum;
                break;
            }
        }
        return resultEnum;
    }

}
