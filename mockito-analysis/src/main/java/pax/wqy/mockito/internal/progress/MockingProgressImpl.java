package pax.wqy.mockito.internal.progress;

import pax.wqy.mockito.invocation.Location;
import pax.wqy.mockito.invocation.LocationImpl;

/**
 * Created by qingyun.wang on 14/03/2018.
 */

public class MockingProgressImpl implements MockingProgress {
    private Location stubbingInProgress;

    @Override
    public void stubbingStarted() {
        validateState();
        stubbingInProgress = new LocationImpl();
    }

    @Override
    public void validateState() {

    }
}