package com.genericrest.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author fernando
 */
public class TomcatSupportListener implements ServletContextListener, ServletRequestListener, HttpSessionListener {

    private static final Logger LOG = LoggerFactory.getLogger(TomcatSupportListener.class);
    private static final String WELD_LISTENER_CLASS = "org.jboss.weld.environment.servlet.Listener";

    private ServletContextListener scListener;
    private ServletRequestListener srListener;
    private HttpSessionListener hsListener;

    public TomcatSupportListener() {
        try {
            Class<?> listenerClass = Class.forName(WELD_LISTENER_CLASS, false, Thread.currentThread().getContextClassLoader());
            Object listener = listenerClass.newInstance();
            scListener = (ServletContextListener) listener;
            srListener = (ServletRequestListener) listener;
            hsListener = (HttpSessionListener) listener;
            LOG.info("The TomcatSupportListener has been configured with a " + WELD_LISTENER_CLASS);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            LOG.error("Not using the TomcatSupportListener as the weld listener(" + WELD_LISTENER_CLASS + ") is not defined on the classpath");
            throw new RuntimeException(e);
        } 
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        if (scListener != null) {
            scListener.contextInitialized(sce);
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        if (scListener != null) {
            scListener.contextDestroyed(sce);
        }
    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        if (srListener != null) {
            srListener.requestDestroyed(sre);
        }
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        if (srListener != null) {
            srListener.requestInitialized(sre);
        }
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        if (hsListener != null) {
            hsListener.sessionCreated(se);
        }
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        if (hsListener != null) {
            hsListener.sessionDestroyed(se);
        }
    }

}
