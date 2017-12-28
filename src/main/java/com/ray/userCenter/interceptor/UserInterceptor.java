package com.ray.userCenter.interceptor;

/**
 * Created by Administrator on 2017/12/10 0010.
 */

import com.ray.userCenter.entity.UserInfoEntity;
import com.ray.userCenter.util.GetUrlParam;
import com.ray.userCenter.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * 登陆拦截器
 *
 * @author   lm
 */
public class UserInterceptor implements HandlerInterceptor {
    @Autowired
    private ApplicationContext context;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        /** ==模拟登录代码begin==*/
/*        String userId = "";
        Map<String,String> m = GetUrlParam.URLRequest(url);
        String logincode = m.get("logincode");
        String account = m.get("account");
        if(logincode!=null && !"".equals(logincode)){
            if("0".equals(logincode)){//直接登录
                //userId = WXQYHUtil.getUserId(code,appName);
            }
            if("1".equals(logincode)){//模拟登录
                //userId = m.get("account");
                userId=account;
            }
        }*/
        /** ==模拟登录代码end==*/

        String token = request.getHeader("um-token");
        //redis 拿token
        RedisUtil redisUtil = new RedisUtil();
        Object infoEntity = redisUtil.getObject(token);
        return true;
/*        if(userId!=null && !"".equals(userId)){ //已经获取到关注者openid
            logger.debug("userId : " + userId);
            return true;
        }else{
            //根据登陆的微信获取token
            String url = request.getRequestURL().toString();
            if (request.getQueryString() != null){
                url+= "?"+request.getQueryString();
            }
            String redirectUrl = WXQYHUtil.getRedirectUrl(url);
            response.sendRedirect(redirectUrl);
            return false;
    }*/
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        System.out.println(">>>MyInterceptor1>>>>>>>请求处理之后进行调用，但是在视图被渲染之前（Controller方法调用之后）");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        System.out.println(">>>MyInterceptor1>>>>>>>在整个请求结束之后被调用，也就是在DispatcherServlet 渲染了对应的视图之后执行（主要是用于进行资源清理工作）");
    }

}
