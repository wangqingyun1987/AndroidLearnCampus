package pax.wqy.mockito.internal.progress;

/**
 * Created by qingyun.wang on 14/03/2018.
 */

public interface MockingProgress {
    void stubbingStarted();

    void validateState();
}