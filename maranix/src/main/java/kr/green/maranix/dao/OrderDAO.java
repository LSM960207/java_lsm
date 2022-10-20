package kr.green.maranix.dao;

import kr.green.maranix.vo.OrderDetailVO;
import kr.green.maranix.vo.OrderVO;

public interface OrderDAO {

	OrderVO selectOrder(OrderVO orNum);
	
	OrderDetailVO selectOrderDetail(OrderDetailVO odNum);
	
	OrderVO insertOrder(OrderVO oVO);

	OrderDetailVO insertOrderDetail(OrderDetailVO odVO);
}
