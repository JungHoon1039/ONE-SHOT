package oneshot.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import oneshot.model.dto.Order;
import oneshot.model.service.OrderService;

@RestController
@CrossOrigin("*")
@RequestMapping("/oneshot/order")
@Api(tags = "주문서 컨트롤러")
public class OrderRestController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/regist")
    @ApiOperation(value = "주문서 생성", notes = "새로운 주문서 정보를 생성한다")
    public ResponseEntity<?> regist(Order order, HttpSession session) {
//        User loginUser = (User) session.getAttribute("loginUser");
//        if (loginUser == null) {
//            return new ResponseEntity<Void>(HttpStatus.UNAUTHORIZED);
//        }
//        order.setUserId(loginUser.getId());
        order.setUserId(1);

        // TODO url 생성 알고리즘 설계
        order.setOrderUrl("http://localhost:8080/oneshot/orderurltest");

        // TODO totalPrice 계산 알고리즘 설계
        int totalPrice = 123123;
        order.setTotalPrice(totalPrice);

        int result = orderService.regist(order);
        if (result == 0) {
            return new ResponseEntity<Integer>(result, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Integer>(result, HttpStatus.CREATED);
    }

}