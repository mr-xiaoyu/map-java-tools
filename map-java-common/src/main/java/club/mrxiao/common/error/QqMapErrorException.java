package club.mrxiao.common.error;

/**
 *  @author <a href="https://github.com/mr-xiaoyu">xiaoyu</a>
 *  @since 2024-08-13
 */
public class QqMapErrorException extends Exception {

    private static final long serialVersionUID = 6493501001039551507L;

    private final QqMapError qqMapError;

    public QqMapErrorException(QqMapError qqMapError) {
        super(qqMapError.toString());
        this.qqMapError = qqMapError;
    }

    public QqMapErrorException(QqMapError qqMapError, Throwable cause) {
        super(qqMapError.toString(), cause);
        this.qqMapError = qqMapError;
    }

    public QqMapError getError() {
        return this.qqMapError;
    }
}
