package club.mrxiao.baidu.exception;

import club.mrxiao.baidu.response.BaiduTraceBaseResponse;
import com.alibaba.fastjson.JSON;

/**
 * 统一错误
 *
 * @author xiaoyu
 */
public class BaiduTraceException extends Exception {

    private static final long serialVersionUID = 7151111337635800055L;

    public BaiduTraceException(BaiduTraceBaseResponse response) {
        super(JSON.toJSONString(response));
    }

    public BaiduTraceException(String message) {
        super(message);
    }
}
