package com.babar.web.common;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * @author babar
 * @since 8/9/17.
 */
public class ControllerUtils {

    public static String redirect(String redirectUrl) {
        return "redirect:" + redirectUrl;
    }

    public static String redirectToDashboard() {
        return "redirect:" + Forwards.DASHBOARD_URL;
    }

    public static String redirectWithMessage(RedirectAttributes redirectAttributes, String message, String redirectUrl) {
        redirectAttributes.addFlashAttribute("FLASH_MESSAGE", message);

        return "redirect:" + redirectUrl;
    }

    public static String redirectToCommon(RedirectAttributes redirectAttributes, String message, String showUrl) {
        redirectAttributes.addFlashAttribute("doneBean", new DoneBean(message, showUrl));

        return "redirect:" + Forwards.COMMON_DONE;
    }
}
