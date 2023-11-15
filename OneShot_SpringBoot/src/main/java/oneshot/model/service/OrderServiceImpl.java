package oneshot.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import oneshot.model.dao.OrderDao;
import oneshot.model.dto.Order;
import oneshot.model.dto.OrderDetail;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Transactional
    @Override
    public int regist(Order order) {
        return orderDao.registOrder(order);
    }

    @Override
    public int urlCheck(String url) {
        return orderDao.urlCheck(url);
    }

    @Transactional
    @Override
    public int addOrderDetail(OrderDetail orderDetail) {
        return orderDao.addOrderDetail(orderDetail);
    }

}
