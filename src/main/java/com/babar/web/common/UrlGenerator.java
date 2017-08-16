package com.babar.web.common;

import com.babar.utils.StringUtils;
import org.springframework.util.CollectionUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/**
 * @author babar
 * @since 8/9/17.
 */
public class UrlGenerator {

    private Url url;

    private Map<String, String> paramNameValueMap;

    public UrlGenerator(Url url) {
        this.url = url;
    }

    public Url getUrl() {
        return url;
    }

    public void setUrl(Url url) {
        this.url = url;
    }

    public UrlGenerator addParam(String paramName, String paramValue) {
        if (CollectionUtils.isEmpty(paramNameValueMap)) {
            paramNameValueMap = new HashMap<>();
        }

        paramNameValueMap.put(paramName, paramValue);

        return this;
    }

    public String getRawUrl() {
        String baseUrl = url.getUrl();

        String parameterString = "";
        boolean firstIteration = true;

        for (Map.Entry<String, String> entry : paramNameValueMap.entrySet()) {

            try {
                parameterString += firstIteration ? "?" : "&";
                parameterString += entry.getKey() + "=" + URLEncoder.encode(entry.getValue(), "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }

            firstIteration = false;
        }

        return baseUrl + parameterString;
    }
}
