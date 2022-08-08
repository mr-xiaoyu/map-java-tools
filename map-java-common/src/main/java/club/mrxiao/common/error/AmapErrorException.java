package club.mrxiao.common.error;

/**
 *  @author <a href="https://github.com/mr-xiaoyu">xiaoyu</a>
 *  @since 2022-08-08
 */
public class AmapErrorException extends Exception {

    private static final long serialVersionUID = 1166926691581981805L;

    private AmapError amapError;

    public AmapErrorException(AmapError amapError) {
        super(amapError.toString());
        this.amapError = amapError;
    }

    public AmapErrorException(AmapError amapError, Throwable cause) {
        super(amapError.toString(), cause);
        this.amapError = amapError;
    }

    public AmapError getError() {
        return this.amapError;
    }
}
