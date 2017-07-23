package com.babar.common;

import org.springframework.web.bind.support.DefaultSessionAttributeStore;
import org.springframework.web.context.request.WebRequest;

/**
 * @author babar
 * @since 7/20/17.
 */
public class CommonSessionAttributeStore extends DefaultSessionAttributeStore{

    @Override
    protected String getAttributeNameInSession(WebRequest request, String attributeName) {
        return attributeName + "-bbr";
    }
}
