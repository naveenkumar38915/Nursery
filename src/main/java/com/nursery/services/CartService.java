package com.nursery.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nursery.models.Cart;
import com.nursery.models.UpdateCartDTO;
import com.nursery.repos.CartRepository;

@Service
public class CartService {
	
	@Autowired private CartRepository dao;

	public void addToCart(Cart cart) {
		// TODO Auto-generated method stub
		dao.save(cart);
	}

	public List<Cart> findByUser(int id) {
		// TODO Auto-generated method stub
		return dao.findByUserid(id);
	}

	public void deleteFromCart(int cartid) {
		// TODO Auto-generated method stub
		dao.deleteById(cartid);
	}
	
	public void updateQty(UpdateCartDTO dto) {
		Cart cc=dao.findById(dto.getId()).get();
		cc.setQty(dto.getQty());
		dao.save(cc);
	}

	public boolean checkItemInCart(int prodid,int userid) {
		// TODO Auto-generated method stub
		return dao.findItemInCart(prodid,userid).isPresent();
	}

	public void emptyCart(int userid) {
		// TODO Auto-generated method stub
		dao.emptyCart(userid);
	}
	
	

}
