package club.mrxiao.common.error;

/**
 *  @author <a href="https://github.com/mr-xiaoyu">xiaoyu</a>
 *  @since 2019-12-26
 */
public class BaiduMapErrorException extends Exception {

    private static final long serialVersionUID = 4055391380144098272L;

    private BaiduMapError baiduMapError;

    public BaiduMapErrorException(BaiduMapError baiduMapError) {
        super(baiduMapError.toString());
        this.baiduMapError = baiduMapError;
    }

    public BaiduMapErrorException(BaiduMapError baiduMapError, Throwable cause) {
        super(baiduMapError.toString(), cause);
        this.baiduMapError = baiduMapError;
    }

    public BaiduMapError getError() {
        return this.baiduMapError;
    }
}
