package com.panlei.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.panlei.bean.Message;
import com.panlei.util.DB;

/**
 * 
 * @author Perry
 * 跟Message表相关的操作
 */
public class MessageDao {
	/**
	 * 根据查询条件查询消息列表
	 */
	public List<Message> queryMessageList(String command, String description){
		DB db= new DB();
		List<Message> messageList = new ArrayList<Message>();
		SqlSession sqlSession = null;
		try {
			//获得sqlSession
			sqlSession = db.getSqlSession();
			//通过SqlSession执行SQL语句,语句需要在配置文件中配置,根据ID来对应
			//注意动态传参的应用,第二个参数是动态参数,但只能有一个，所以可以直接传递实例对象过去
			Message message = new Message();
			message.setCommand(command);
			message.setDescription(description);
			messageList = sqlSession.selectList("Message.queryMessageList", message);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
		return messageList;
	}
	/**
	 * 
	 * @param id
	 * 单条删除
	 */
	public static void deleteOne(int id) {
		DB db= new DB();
		SqlSession sqlSession = null;
		try {
			//获得sqlSession
			sqlSession = db.getSqlSession();
			//通过SqlSession执行SQL语句,语句需要在配置文件中配置,根据ID来对应
			//注意动态传参的应用,第二个参数是动态参数,但只能有一个，所以可以直接传递实例对象过去
			sqlSession.delete("Message.deleteOne", id);
			//Mybatis不默认提交，需手动提交
			sqlSession.commit();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
	}
	//批量删除
	public static void deleteBatch(List<Integer> ids) {
		DB db= new DB();
		SqlSession sqlSession = null;
		try {
			//获得sqlSession
			sqlSession = db.getSqlSession();
			//通过SqlSession执行SQL语句,语句需要在配置文件中配置,根据ID来对应
			//注意动态传参的应用,第二个参数是动态参数,但只能有一个，所以可以直接传递实例对象过去
			sqlSession.delete("Message.deleteBatch", ids);
			//Mybatis不默认提交，需手动提交
			sqlSession.commit();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
	}
	public static void main(String[] args) {
		MessageDao messageDao = new MessageDao();
		messageDao.queryMessageList("", "");
	}
	/**
	 * 根据查询条件查询消息列表
	 */
//	public List<Message> queryMessageList(String command, String description) {
//		List<Message> messageList = new ArrayList<Message>();
//		try {
//			Connection conn = DB.getConn();
//			//检索条件不固定，使用StringBuilder，最后面加上where 1=1，表示可能有检索条件，也可能没有
//			StringBuilder sql = new StringBuilder("select ID,COMMAND,DESCRIPTION,CONTENT from MESSAGE where 1=1");
//			//判断检索条件，第一次进来是空，进来后不输入内容，点击提交的话是空字符串，所以要判断两次
//			List<String> paramList = new ArrayList<String>();
//			if(command!=null && !"".equals(command.trim())) {
//				//注意空格的问题
//				sql.append(" and COMMAND=?");
//				paramList.add(command);
//			}
//			if(description!=null && !"".equals(description.trim())) {
//				//注意空格的问题,模糊查询,注意？两边有空格
//				sql.append(" and DESCRIPTION like '%' ? '%'");
//				paramList.add(description);
//			}
//			PreparedStatement statement = DB.prepare(conn, sql.toString());
//			for (int i=0; i<paramList.size(); i++) {
//				statement.setString(i+1, paramList.get(i));
//			}
//			ResultSet rs = statement.executeQuery();
//			
//			while(rs.next()) {
//				Message message = new Message();
//				message.setId(rs.getString("ID"));
//				message.setCommand(rs.getString("COMMAND"));
//				message.setDescription(rs.getString("DESCRIPTION"));
//				message.setContent(rs.getString("CONTENT"));
//				messageList.add(message);
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return messageList;
//	}
}
