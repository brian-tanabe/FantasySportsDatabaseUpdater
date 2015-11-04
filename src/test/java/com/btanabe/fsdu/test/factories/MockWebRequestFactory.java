package com.btanabe.fsdu.test.factories;

import com.btanabe.fsdu.web.WebRequest;
import org.mockito.Mockito;
import org.springframework.beans.factory.FactoryBean;

import java.util.Map;

import static org.mockito.Mockito.when;

/**
 * Created by Brian on 11/3/15.
 */
public class MockWebRequestFactory implements FactoryBean<WebRequest> {
    private Map<String, String> urlToPageHtmlMap;

    @Override
    public WebRequest getObject() throws Exception {
        WebRequest mockWebRequest = Mockito.mock(WebRequest.class);
        for (String url : urlToPageHtmlMap.keySet()) {
            when(mockWebRequest.downloadWebPageSource(url)).thenReturn(urlToPageHtmlMap.get(url));
        }

        return mockWebRequest;
    }

    @Override
    public Class<?> getObjectType() {
        return WebRequest.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }

    public void setUrlToPageHtmlMap(Map<String, String> urlToPageHtmlMap) {
        this.urlToPageHtmlMap = urlToPageHtmlMap;
    }
}
