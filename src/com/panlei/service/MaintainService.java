package com.panlei.service;

import java.util.ArrayList;
import java.util.List;

import com.panlei.dao.MessageDao;

/**
 * @author Perry
 * 维护相关的业务功能,
 * servlet层并不对前端页面传过来的数据进行操作，而交由service层
 */
public class MaintainService {
	/**
	 * 单条删除
	 * @param id
	 */
	public void deleteOne(String id) {
		if(id!=null && !"".equals(id.trim())) {
			MessageDao messageDao = new MessageDao();
			messageDao.deleteOne(Integer.parseInt(id));
		}
	}
	/**
	 * 批量删除
	 * @param ids
	 */
	public void deleteBatch(String[] ids) {
		MessageDao messageDao = new MessageDao();
		List<Integer> idList = new ArrayList<Integer>();
		for (String id : ids) {
			idList.add(Integer.valueOf(id));
		}
		messageDao.deleteBatch(idList);
	}
}
