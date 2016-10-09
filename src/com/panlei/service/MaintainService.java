package com.panlei.service;

import java.util.ArrayList;
import java.util.List;

import com.panlei.dao.MessageDao;

/**
 * @author Perry
 * ά����ص�ҵ����,
 * servlet�㲢����ǰ��ҳ�洫���������ݽ��в�����������service��
 */
public class MaintainService {
	/**
	 * ����ɾ��
	 * @param id
	 */
	public void deleteOne(String id) {
		if(id!=null && !"".equals(id.trim())) {
			MessageDao messageDao = new MessageDao();
			messageDao.deleteOne(Integer.parseInt(id));
		}
	}
	/**
	 * ����ɾ��
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
