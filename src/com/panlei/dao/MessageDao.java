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
 * ��Message����صĲ���
 */
public class MessageDao {
	/**
	 * ���ݲ�ѯ������ѯ��Ϣ�б�
	 */
	public List<Message> queryMessageList(String command, String description){
		DB db= new DB();
		List<Message> messageList = new ArrayList<Message>();
		SqlSession sqlSession = null;
		try {
			//���sqlSession
			sqlSession = db.getSqlSession();
			//ͨ��SqlSessionִ��SQL���,�����Ҫ�������ļ�������,����ID����Ӧ
			//ע�⶯̬���ε�Ӧ��,�ڶ��������Ƕ�̬����,��ֻ����һ�������Կ���ֱ�Ӵ���ʵ�������ȥ
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
	 * ����ɾ��
	 */
	public static void deleteOne(int id) {
		DB db= new DB();
		SqlSession sqlSession = null;
		try {
			//���sqlSession
			sqlSession = db.getSqlSession();
			//ͨ��SqlSessionִ��SQL���,�����Ҫ�������ļ�������,����ID����Ӧ
			//ע�⶯̬���ε�Ӧ��,�ڶ��������Ƕ�̬����,��ֻ����һ�������Կ���ֱ�Ӵ���ʵ�������ȥ
			sqlSession.delete("Message.deleteOne", id);
			//Mybatis��Ĭ���ύ�����ֶ��ύ
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
	//����ɾ��
	public static void deleteBatch(List<Integer> ids) {
		DB db= new DB();
		SqlSession sqlSession = null;
		try {
			//���sqlSession
			sqlSession = db.getSqlSession();
			//ͨ��SqlSessionִ��SQL���,�����Ҫ�������ļ�������,����ID����Ӧ
			//ע�⶯̬���ε�Ӧ��,�ڶ��������Ƕ�̬����,��ֻ����һ�������Կ���ֱ�Ӵ���ʵ�������ȥ
			sqlSession.delete("Message.deleteBatch", ids);
			//Mybatis��Ĭ���ύ�����ֶ��ύ
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
	 * ���ݲ�ѯ������ѯ��Ϣ�б�
	 */
//	public List<Message> queryMessageList(String command, String description) {
//		List<Message> messageList = new ArrayList<Message>();
//		try {
//			Connection conn = DB.getConn();
//			//�����������̶���ʹ��StringBuilder����������where 1=1����ʾ�����м���������Ҳ����û��
//			StringBuilder sql = new StringBuilder("select ID,COMMAND,DESCRIPTION,CONTENT from MESSAGE where 1=1");
//			//�жϼ�����������һ�ν����ǿգ��������������ݣ�����ύ�Ļ��ǿ��ַ���������Ҫ�ж�����
//			List<String> paramList = new ArrayList<String>();
//			if(command!=null && !"".equals(command.trim())) {
//				//ע��ո������
//				sql.append(" and COMMAND=?");
//				paramList.add(command);
//			}
//			if(description!=null && !"".equals(description.trim())) {
//				//ע��ո������,ģ����ѯ,ע�⣿�����пո�
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
