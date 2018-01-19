package com.zyj.service.inter;

import java.util.List;

import com.zyj.domain.Message;
import com.zyj.domain.Users;

public interface MessageServiceInter extends BaseInterface{

	public List<Message> showMessage(Users user);
}
