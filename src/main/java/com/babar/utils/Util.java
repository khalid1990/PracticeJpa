package com.babar.utils;

import com.babar.web.common.Forwards;
import com.babar.web.common.UrlGenerator;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author babar
 * @since 3/26/17.
 */
public class Util {

    public static boolean isAnyNull (Object... objects) {
        for (Object object : objects) {
            if (object == null) {
                return true;
            }
        }

        return false;
    }

    public static String getBackLink() {
        HttpServletRequest request = getRequest();

        String backLink = ServletRequestUtils.getStringParameter(request, "backLink", null);
        backLink = StringUtils.isEmpty(backLink) ? Forwards.DASHBOARD_URL : backLink;

        return backLink;
    }

    public static String getCurrentUrl() {
        HttpServletRequest request = getRequest();
        return request.getServletPath() + request.getPathInfo() +
                (StringUtils.isEmpty(request.getQueryString()) ? "" : "?" + request.getQueryString());
    }

    private static HttpServletRequest getRequest() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    }
}
