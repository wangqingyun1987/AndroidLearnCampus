package pax.wqy.mockito.invocation;

import java.lang.reflect.Method;

/**
 * An invocation on a mock
 */

public interface InvocationOnMock {
    /**
     * returns the mock object
     * */
    Object getMock();

    /**
     * returns the method
     * */
    Method getMethod();

    /**
     * returns arguments passed to the method
     * */
    Object[] getArguments();

    /**
     * returns casted argument at given index
     * */
    <T> T getArgument(int index);

    /**
     * calls real method
     * */
    Object callRealMethod() throws Throwable;
}