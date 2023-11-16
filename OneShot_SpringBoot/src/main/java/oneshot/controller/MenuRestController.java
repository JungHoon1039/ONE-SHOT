package oneshot.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/menu")
@Api(tags = "메뉴 컨트롤러")
public class MenuRestController {

}