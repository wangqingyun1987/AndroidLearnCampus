package pax.wqy.mockito.invocation;

/**
 * Mockito handler of an invocation on a mock, this is the core part of the API, the heart of mockito.
 * */
public interface MockHandler {
    /**
     * The default implementation provided by Mockito handles invocations by recording
     * method calls on mocks for further verification, captures the stubbing information when mock is stubbed,
     * returns the stubbed values for invocations that have been stubbed, and much more.
     * */
    Object handle(Invocation invocation) throws Throwable;
}