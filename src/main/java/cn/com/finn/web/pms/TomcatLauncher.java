package cn.com.finn.web.pms;

import org.apache.catalina.core.AprLifecycleListener;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.core.StandardServer;
import org.apache.catalina.startup.Tomcat;

import java.io.File;

/**
 * Created by development on 2017/7/15.
 *
 * @author Finn Zhao
 */
public class TomcatLauncher {

    /**
     * @param args args
     * @throws Exception exception
     */
    public static void main(String[] args) throws Exception {

        int startupPort = 8080;
        int shutdownPort = 8081;
        String catalinaHome = "."; // catalina home

        Tomcat tomcat = new Tomcat();
        tomcat.setHostname("localhost"); // host name or ip
        tomcat.setPort(startupPort);
        tomcat.setBaseDir(catalinaHome);

        String userDir = System.getProperty("user.dir");
        System.out.println(userDir);
        // tomcat.getHost().setAppBase("."); // catalina webapps dir
        tomcat.getHost().setAppBase(userDir + File.separator + ".");

        StandardServer server = (StandardServer) tomcat.getServer();
        AprLifecycleListener listener = new AprLifecycleListener();
        server.addLifecycleListener(listener);
        // server.setPort(shutdownPort); // connect this port to shutdown tomcat

        String contextPath = "/pms";
        String docBase = "src/main/webapp";
        /*
        StandardContext context = new StandardContext();
        context.setPath(contextPath);
        context.setDocBase(docBase);
        context.addLifecycleListener(new Tomcat.DefaultWebXmlListener());

        context.addLifecycleListener(new Tomcat.FixContextListener());
        context.setSessionCookieName("t-session");

        tomcat.getHost().addChild(context);
        */

        // tomcat 's ServletRegistration.Dynamic conflict with jetty's ServletRegistration.Dynamic,
        // so comment pom.xml's dependency and JettyLauncher code when using TomcatLauncher.
        tomcat.addWebapp(contextPath, docBase);

        tomcat.start();
        tomcat.getServer().await();
    }
}
