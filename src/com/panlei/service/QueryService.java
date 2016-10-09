package com.panlei.service;

import java.util.List;
import java.util.Random;

import com.panlei.bean.Command;
import com.panlei.bean.CommandContent;
import com.panlei.bean.Message;
import com.panlei.dao.CommandDao;
import com.panlei.dao.MessageDao;
import com.panlei.util.Iconst;

/**
 * 查询相关的业务功能
 */
public class QueryService {
	/**
	 * 通过指令查询自动回复的内容
	 * @param command 指令
	 * @return 自动回复的内容
	 */
	public String queryByCommand(String command) {
		CommandDao commandDao = new CommandDao();
		List<Command> commandList;
		//如果指令是帮助的话，就输出指令名称以及描述信息
		if(Iconst.HELP_COMMAND.equals(command)) {
			commandList = commandDao.queryCommandList(null, null);			//去数据库查询
			StringBuilder result = new StringBuilder();
			for(int i = 0; i < commandList.size(); i++) {
				if(i != 0) {
					result.append("<br/>");
				}
				result.append("回复[" + commandList.get(i).getName() + "]可以查看" + commandList.get(i).getDescription());
			}
			return result.toString();
		}
		//否则的话么就随机输出一条指令内容
		commandList = commandDao.queryCommandList(command, null);	//查询结果是对应Command实体
		if(commandList.size() > 0) {
			//获取查询结果Command集中的内容结果集
			List<CommandContent> contentList = commandList.get(0).getContentList();
			//生成随机数包括0，不包括commandList.size()
			int i = new Random().nextInt(contentList.size());
			return contentList.get(i).getContent();
		}
		return Iconst.NO_MATCHING_CONTENT;
	}
}
