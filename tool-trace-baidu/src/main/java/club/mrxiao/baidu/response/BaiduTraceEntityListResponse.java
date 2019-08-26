package club.mrxiao.baidu.response;

import club.mrxiao.baidu.domain.BaiduTraceEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 终端对象列表
 * @author xiaoyu
 *
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class BaiduTraceEntityListResponse extends BaiduTraceBaseResponse{

    /**
     * 结果总条数
     */
    private Integer total;

    /**
     * 结果条数
     */
    private Integer size;

    /**
     *entity详细信息列表
     */
    private List<BaiduTraceEntity> entities;
}
