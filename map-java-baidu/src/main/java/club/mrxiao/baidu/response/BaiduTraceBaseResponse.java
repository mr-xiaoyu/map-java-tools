package club.mrxiao.baidu.response;

import lombok.Data;

import java.io.Serializable;

/**
 * 响应类
 * @author xiaoyu
 */

@Data
public class BaiduTraceBaseResponse implements Serializable {

    private static final long serialVersionUID = 8062826512981436559L;


    /**
     * 返回状态码
     */
    private Integer status;


    /**
     * 返回信息
     */
    private String message;
}
