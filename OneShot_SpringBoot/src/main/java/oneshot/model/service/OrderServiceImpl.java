package oneshot.model.service;

import oneshot.model.dao.OrderDao;
import oneshot.model.dto.Order;
import oneshot.model.dto.User;
import oneshot.util.RandomCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;

    @Transactional
    @Override
    public int createOrder(User user, String orderUrl) {
        int userId = user.getUserId();
        Order order = new Order(userId, orderUrl);
        return orderDao.insert(order);
    }

    @Override
    public String createOrderCode() {
        while (true) {
            String randomCode = RandomCode.get();
            if (orderDao.countByOrderCode(randomCode) == 0) {
                return randomCode;
            }
        }
    }

    @Override
    public Order getOrder(String orderCode) {
        return orderDao.selectByOrderCode(orderCode);
    }

    @Override
    public int deleteOrder(int orderId) {
        return orderDao.delete(orderId);
    }

}
