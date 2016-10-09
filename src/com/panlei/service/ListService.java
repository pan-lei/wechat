package com.panlei.service;

import java.util.List;

import com.panlei.bean.Message;
import com.panlei.dao.MessageDao;

/**
 * 
 * @author Perry
 * 列表相关的业务功能
 */
public class ListService {
	public List<Message> queryMessage(String command, String description) {
		MessageDao messageDao = new MessageDao();
		return messageDao.queryMessageList(command, description);
	}
}
