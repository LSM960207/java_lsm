package kr.green.maranix.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kr.green.maranix.dao.OrderDAO;
import kr.green.maranix.vo.OrderDetailVO;
import kr.green.maranix.vo.OrderVO;
import kr.green.maranix.vo.ProductVO;

@Service
public class OrderServiceImp implements OrderService {

	@Autowired
	OrderDAO orderDao;
	
	@Override
	public OrderVO selectOrder(OrderVO orNum) {
		return orderDao.selectOrder(orNum);
	}

	@Override
	public OrderDetailVO selectOrderDetail(OrderDetailVO odNum) {
		return orderDao.selectOrderDetail(odNum);
	}
	
	@Override
	public OrderVO insertOrder(OrderVO oVO) {
		return orderDao.insertOrder(oVO);
	}
	
	@Override
	public OrderDetailVO insertOrderDetail(OrderDetailVO odVO) {
		return orderDao.insertOrderDetail(odVO);
	}	
}
