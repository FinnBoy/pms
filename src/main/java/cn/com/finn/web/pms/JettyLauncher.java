package cn.com.finn.web.pms;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

/**
 * 
 * @author Finn Zhao
 * @version 2017年4月16日
 */
public class JettyLauncher {

    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {

        Server server = new Server(8080);

        WebAppContext webAppContext = new WebAppContext();

        String resource = "./src/main/webapp";

        webAppContext.setDescriptor(resource + "/WEB-INF/web.xml");

        webAppContext.setResourceBase(resource);

        webAppContext.setClassLoader(Thread.currentThread().getContextClassLoader());

        webAppContext.setContextPath("/pms");

        webAppContext.setParentLoaderPriority(true);

        server.setHandler(webAppContext);

        server.start();

        server.join();
    }

}
