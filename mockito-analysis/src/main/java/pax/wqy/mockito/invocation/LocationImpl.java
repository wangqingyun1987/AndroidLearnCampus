package pax.wqy.mockito.invocation;

import pax.wqy.mockito.exceptions.stacktrace.StackTraceFilter;

/**
 * Created by qingyun.wang on 14/03/2018.
 */

public class LocationImpl implements Location {
    private StackTraceFilter stackTraceFilter;
    private Throwable stackTraceHolder;

    @Override
    public String toString() {
        StackTraceElement[] filtered = stackTraceFilter.filter(stackTraceHolder.getStackTrace());
        if (filtered.length == 0) {
            return "-> at <<unknown line>>";
        }
        return "-> at " + filtered[0].toString();
    }
}