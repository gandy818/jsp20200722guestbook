package com.guest.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import com.guest.dao.MessageDao;
import com.guest.jdbc.ConnectionProvider;
import com.guest.jdbc.JdbcUtil;
import com.guest.model.Message;

public class GetMessageListService {
	private static GetMessageListService instance = new GetMessageListService();
	
	public static GetMessageListService getInstance() {
		return instance;
	
	}
	
	private GetMessageListService() {}
	
	
	public MessageListView getMessageList(int pageNumber) {
		Connection conn = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			MessageDao messageDao = MessageDao.getInstance();
			
			List<Message> messageList =  messageDao.selectList(conn);
			
			return new MessageListView(messageList);
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(conn);
		}
		return null;
	}
}
