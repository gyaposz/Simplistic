package hu.gyaposz.tutorial.simplistic.contexthierarchy.web.controller;

import hu.gyaposz.tutorial.simplistic.contexthierarchy.application.service.CommonService;
import hu.gyaposz.tutorial.simplistic.contexthierarchy.web.util.ViewBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class TestController
{
    private final CommonService commonService;
    private final ViewBean viewBean;

    public TestController(final CommonService commonService, final ViewBean viewBean) {
        // Do not forget. If a single constructor is available, the arguments are autowired if they are non-ambiguous.
        this.commonService = commonService;
        this.viewBean = viewBean;
    }

    @GetMapping("/{value}")
    public String getValue(@PathVariable Long value)
    {
        return "From application context: " + commonService.convert(value)
                + "\nFrom web context: "+ viewBean.getContent();
    }
}
