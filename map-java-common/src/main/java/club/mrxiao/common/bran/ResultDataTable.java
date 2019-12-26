package club.mrxiao.common.bran;

import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;
import java.util.List;

/**
 *  <pre>
 *      分页响应对象
 *  </pre>
 * @author <a href="https://github.com/mr-xiaoyu">xiaoyu</a>
 * @since 2019-12-26
 */
@Getter
@Builder
public class ResultDataTable implements Serializable {

    private static final long serialVersionUID = 7328568359346752947L;

    /**
     * 总条数
     */
    private int total;
    /**
     * 列表
     */
    private List<?> rows;

}
