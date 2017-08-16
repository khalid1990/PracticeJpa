package com.babar.web.common;

import java.net.URL;
import java.util.Map;

/**
 * @author babar
 * @since 8/9/17.
 */
public class DoneBean {

    private static final long serialVersionUID = 1L;

    private String message;

    private String showUrl;

    public DoneBean() {
    }

    public DoneBean(String message, String showUrl) {
        this.message = message;
        this.showUrl = showUrl;
    }

    public DoneBean(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getShowUrl() {
        return showUrl;
    }

    public void setShowUrl(String showUrl) {
        this.showUrl = showUrl;
    }
}
