package kr.green.maranix.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kr.green.maranix.dao.OrderDAO;

@Service
public class OrderServiceImp implements OrderService {

	@Autowired
	OrderDAO orderDao;
	
	
}
