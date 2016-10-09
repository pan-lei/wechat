package com.panlei.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.panlei.bean.Command;
import com.panlei.util.DB;

public class CommandDao {
	/**
	 * ���ݲ�ѯ������ѯָ���б�
	 */
	public List<Command> queryCommandList(String name, String description){
		DB db= new DB();
		List<Command> commandList = new ArrayList<Command>();
		SqlSession sqlSession = null;
		try {
			//���sqlSession
			sqlSession = db.getSqlSession();
			//ͨ��SqlSessionִ��SQL���,�����Ҫ�������ļ�������,����ID����Ӧ
			//ע�⶯̬���ε�Ӧ��,�ڶ��������Ƕ�̬����,��ֻ����һ�������Կ���ֱ�Ӵ���ʵ�������ȥ
			Command command = new Command();
			command.setName(name);
			command.setDescription(description);
			commandList = sqlSession.selectList("Command.queryCommandList", command);
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
		return commandList;
	}
}
