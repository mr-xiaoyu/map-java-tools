package club.mrxiao.common.utils;

import cn.hutool.core.util.StrUtil;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 *  <pre>
 *      字符串工具
 *  </pre>
 * @author <a href="https://github.com/mr-xiaoyu">xiaoyu</a>
 * @since 2020-01-16
 */
public class StringUtil {

    /**
     * 字符串URLEncoder
     * @param str 字符串
     * @return URLEncoder结果
     */
    public static String utf8encode(String str){
        if(StrUtil.isNotBlank(str)){
            try {
                return URLEncoder.encode(str, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return "";
    }
}
