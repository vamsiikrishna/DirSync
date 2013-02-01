package vamsii;

/**
 * Created with IntelliJ IDEA.
 * User: vamsi
 * Date: 1/2/13
 * Time: 5:44 PM
 * To change this template use File | Settings | File Templates.
 */
import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class DirSync {
    public static void main(String args[]) throws Exception {

        CamelContext context = new DefaultCamelContext();

        // add our route to the CamelContext
        context.addRoutes(new RouteBuilder() {
            public void configure() {
                from("file:data/inbox?noop=true").to("file:data/outbox");
            }
        });

        // start the route and let it do its work
        context.start();
        Thread.sleep(100000000);

        // stop the CamelContext
        context.stop();
    }
}
