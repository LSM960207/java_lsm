package kr.green.maranix.dao;

import kr.green.maranix.vo.OrderDetailVO;
import kr.green.maranix.vo.OrdersVO;

public interface OrdersDAO {

	OrdersVO selectOrders(OrdersVO orNum);
	
	OrderDetailVO selectOrderDetail(OrderDetailVO odNum);
	
	public void insertOrders(OrdersVO oVO);

	public void insertOrderDetail(OrderDetailVO odVO);
}
