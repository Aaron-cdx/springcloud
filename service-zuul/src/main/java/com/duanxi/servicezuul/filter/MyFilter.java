package com.duanxi.servicezuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author caoduanxi
 * @Date 2019/12/23 16:43
 * <p>
 * zuul服务器路由的过滤以及安全验证
 */
@Component
public class MyFilter extends ZuulFilter {
    private static final Logger log = LoggerFactory.getLogger(MyFilter.class);
    @Override
    public String filterType() {
        return "pre....";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true; // 表明需要过滤，默认为false
    }

    @Override
    public Object run(){
        // 获取当前的上下文环境
        RequestContext currentContext = RequestContext.getCurrentContext();
        // 获取请求
        HttpServletRequest request = currentContext.getRequest();
        log.info(String.format("%s >>> %s",request.getMethod(),request.getRequestURL().toString()));
        // 是否携带令牌
        String token = request.getParameter("token");
        if(token == null){
            log.info("token is empty!");
            // 意思就是不发送给路由器进行处理
            currentContext.setSendZuulResponse(false);
            // 设置响应的状态码为401
            currentContext.setResponseStatusCode(401);
            try {
                // 将本次请求的token is empty响应给写回去，通过F12可以看到response处的响应结果为token is empty
                // 前端拿到这个可以知道需要加上token，带上token即可
                currentContext.getResponse().getWriter().write("token is empty!");
            } catch (IOException e) {
                return null;
            }
        }
        log.info("ok");
        return null;
    }
}
