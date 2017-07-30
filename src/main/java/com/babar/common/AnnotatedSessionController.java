package com.babar.common;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import java.util.Random;

/**
 * @author babar
 * @since 7/20/17.
 */
public class AnnotatedSessionController {

    private static final String COMMAND_ID = "commandId";

    @ModelAttribute
    public String createCommandId(HttpServletRequest request) {
        if ("GET".equals(request.getMethod())) {
            request.setAttribute(COMMAND_ID, getCommandId(request));
        } else if ("POST".equals(request.getMethod())) {
            String commandId = ServletRequestUtils.getStringParameter(request, COMMAND_ID, "");
            request.setAttribute(COMMAND_ID, commandId);
        }

        return null;
    }

    private String getCommandId(HttpServletRequest request) {
        String commandId = ServletRequestUtils.getStringParameter(request, COMMAND_ID, "");

        if (!StringUtils.isEmpty(commandId.trim())) {
            return commandId;
        }

        return String.valueOf(System.currentTimeMillis());
    }
}
