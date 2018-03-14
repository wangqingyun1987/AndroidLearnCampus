package pax.wqy.mockito.exceptions.stacktrace;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qingyun.wang on 14/03/2018.
 */

public class StackTraceFilter {
    private static StackTraceCleaner cleaner;

    public StackTraceElement[] filter(StackTraceElement[] target) {
        final List<StackTraceElement> filtered = new ArrayList<>();
        for (StackTraceElement element : target) {
            if (cleaner.isIn(element)) {
                filtered.add(element);
            }
        }
        StackTraceElement[] result = new StackTraceElement[filtered.size()];
        return filtered.toArray(result);
    }
}