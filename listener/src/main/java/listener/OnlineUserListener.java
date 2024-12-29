package listener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class OnlineUserListener implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        // 会话创建，在线人数加1
        ServletContext context = se.getSession().getServletContext();
        Integer onlineCount = (Integer) context.getAttribute("onlineCount");
        if (onlineCount == null) {
            onlineCount = 1;
        } else {
            onlineCount++;
        }
        context.setAttribute("onlineCount", onlineCount);
        System.out.println("用户上线，当前在线人数：" + onlineCount);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        // 会话销毁，在线人数减1
        ServletContext context = se.getSession().getServletContext();
        Integer onlineCount = (Integer) context.getAttribute("onlineCount");
        if (onlineCount == null || onlineCount <= 0) {
            onlineCount = 0;
        } else {
            onlineCount--;
        }
        context.setAttribute("onlineCount", onlineCount);
        System.out.println("用户下线，当前在线人数：" + onlineCount);
    }
}