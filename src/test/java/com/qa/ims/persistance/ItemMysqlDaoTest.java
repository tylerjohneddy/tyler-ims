//package com.qa.ims.persistance;
//
//import static org.junit.Assert.assertEquals;
//import static org.mockito.Mockito.when;
//import java.math.BigDecimal;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.List;
//
//import org.apache.log4j.Logger;
//import org.junit.Before;
//import org.junit.BeforeClass;
//import org.junit.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.MockitoAnnotations;
//import org.mockito.Spy;
//
//
//import com.qa.persistence.dao.ItemDaoMysql;
//import com.qa.persistence.domain.Item;
//
//public class ItemMysqlDaoTest {
//	public static final Logger logger = Logger.getLogger(ItemMysqlDaoTest.class);
//	private Item item;
//	private Item item2;
//	@Mock
//	private Item mockOrder;
//	
//	@Mock
//	private Statement mockStatment;
//	
//	@Mock
//	private ResultSet mockResultSet;
//	
//	@Mock
//	private Connection mockConnection;
//	@Spy
//	@InjectMocks
//	private ItemDaoMysql itemDaoMock;
//	
//	@Before
//	public void setUpItem() throws SQLException {
//		MockitoAnnotations.initMocks(this);
//		when(mockConnection.createStatement()).thenReturn(mockStatment);
//		
//		
//
//		
//		
//
//		
//	}
//
//}
