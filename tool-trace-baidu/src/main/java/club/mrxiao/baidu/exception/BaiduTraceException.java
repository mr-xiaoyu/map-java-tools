package club.mrxiao.baidu.exception;

import club.mrxiao.baidu.enums.BaiduTraceStatusEnum;
import club.mrxiao.baidu.response.BaiduTraceBaseResponse;
import cn.hutool.json.JSONUtil;

/**
 * 统一错误
 *
 * @author xiaoyu
 */
public class BaiduTraceException extends Exception {

    private static final long serialVersionUID = 7151111337635800055L;

    public BaiduTraceException(BaiduTraceBaseResponse response) {
        super(response.toString());
    }

    public BaiduTraceException(String message) {
        super(message);
    }
}
