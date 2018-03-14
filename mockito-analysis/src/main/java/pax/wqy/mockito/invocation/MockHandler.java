package pax.wqy.mockito.invocation;

/**
 * Mockito handler of an invocation on a mock, this is the core part of the API, the heart of mockito.
 *
 * Mockito actually use bytebuddy (http://bytebuddy.net/) to create a class for mocked type, and mockito
 *      will then insert a MockHandler instance into the created class, so all method-calls will be redirected
 *      to MockHandler, this is essential as how mockito works
 * */
public interface MockHandler {
    /**
     * The default implementation provided by Mockito handles invocations by recording
     * method calls on mocks for further verification, captures the stubbing information when mock is stubbed,
     * returns the stubbed values for invocations that have been stubbed, and much more.
     * */
    Object handle(Invocation invocation) throws Throwable;
}