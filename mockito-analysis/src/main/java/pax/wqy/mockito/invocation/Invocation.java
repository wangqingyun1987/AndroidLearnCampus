package pax.wqy.mockito.invocation;

/**
 * Created by qingyun.wang on 14/03/2018.
 */

public interface Invocation extends InvocationOnMock, DescribedInvocation {
    /**
     * whether the invocation has already been verified
     * */
    boolean isVerified();

    /**
     * the sequence number of the invocation, used to determine the invocation order.
     * */
    int getSequenceNumber();

    /**
     * location in code for this invocation
     * */
    Location getLocation();

    /**
     * get unprocessed arguments whereas @getArguments returned processed arguments (varags expanded etc.)
     * */
    Object[] getRawArguments();

    Class<?> getRawReturnType();

    /**
     * mark this invocation as verified
     * */
    void marjVerified();
}