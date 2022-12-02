package hu.gyaposz.tutorial.simplistic.contexthierarchy.application.service;

import hu.gyaposz.tutorial.simplistic.contexthierarchy.web.util.ViewBean;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CommonServiceTest {

    private static final String AVAILABLE_RESPONSE = "response";
    private static final String MISSING_RESPONSE = "10";
    @Mock
    ViewBean viewBean;

    @Test
    public void shouldReturnInputValueIfViewBeanIsMissing() {
        // This test case lies. The input value is also returned if content is null (or you do not mock it).
        CommonService commonService = new CommonService(null);
        assertEquals(MISSING_RESPONSE, commonService.convert(10L));
    }

    @Test
    public void shouldReturnResponseIfViewBeanIsAvailable() {
        when(viewBean.getContent()).thenReturn(AVAILABLE_RESPONSE);
        CommonService commonService = new CommonService(viewBean);
        assertEquals(AVAILABLE_RESPONSE, commonService.convert(10L));
    }
}