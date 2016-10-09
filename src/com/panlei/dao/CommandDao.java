package com.panlei.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.panlei.bean.Command;
import com.panlei.util.DB;

public class CommandDao {
	/**
	 * 根据查询条件查询指令列表
	 */
	public List<Command> queryCommandList(String name, String description){
		DB db= new DB();
		List<Command> commandList = new ArrayList<Command>();
		SqlSession sqlSession = null;
		try {
			//获得sqlSession
			sqlSession = db.getSqlSession();
			//通过SqlSession执行SQL语句,语句需要在配置文件中配置,根据ID来对应
			//注意动态传参的应用,第二个参数是动态参数,但只能有一个，所以可以直接传递实例对象过去
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
