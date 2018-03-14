package pax.wqy.mockito.invocation;

/**
 * Created by qingyun.wang on 14/03/2018.
 */

public interface DescribedInvocation {
    /**
     * descibe invocation in human friendly way
     * */
    String toString();

    /**
     * the location in the code where this invocation actually happened
     * */
    Location getLocation();
}