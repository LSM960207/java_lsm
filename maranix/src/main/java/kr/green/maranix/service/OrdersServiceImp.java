package kr.green.maranix.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kr.green.maranix.dao.OrdersDAO;
import kr.green.maranix.vo.OrderDetailVO;
import kr.green.maranix.vo.OrdersVO;

@Service
public class OrdersServiceImp implements OrdersService {

	@Autowired
	OrdersDAO ordersDao;
	
	@Override
	public OrdersVO selectOrders(OrdersVO orNum) {
		return ordersDao.selectOrders(orNum);
	}

	@Override
	public OrderDetailVO selectOrderDetail(OrderDetailVO odNum) {
		return ordersDao.selectOrderDetail(odNum);
	}
	
	@Override
	public void insertOrders(OrdersVO oVO) {
		ordersDao.insertOrders(oVO);
	}
	
	@Override
	public void insertOrderDetail(OrderDetailVO odVO) {
		 ordersDao.insertOrderDetail(odVO);
	}	
}
