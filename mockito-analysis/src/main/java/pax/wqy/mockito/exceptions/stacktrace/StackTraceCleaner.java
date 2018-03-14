package pax.wqy.mockito.exceptions.stacktrace;

/**
 * Created by qingyun.wang on 14/03/2018.
 */

public interface StackTraceCleaner {
    /**
     * decides whether an stack trace element should be included in cleaned stack trace
     * */
    boolean isIn(StackTraceElement candidate);
}