package com.ecnu.mybatis.first;



import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.ecnu.mybatis.po.User;

/**
 * 入门程序
 * @author LiangHui
 *
 */
public class MybatisFirst {
	//根据id查询用户信息，得到一条记录结果
	@Test
	public void findUserByIdTest() throws IOException{
		
		//mybatis配置文件  如果是放在sqlmap文件夹下那就是"sqlmap/SqlMapConfig.xml"
		String resource = "SqlMapConfig.xml";
		//得到配置文件流
		InputStream inputstream = Resources.getResourceAsStream(resource);
		//创建会话工厂,传入mybatis的配置文件信息
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputstream);
		//通过工厂得到SQLSession会话
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//通过SqlSession操作数据库
		//第一个参数：映射文件中statement的id,等于=namespace+"."+statement的id
		//第二个参数：指定和映射文件中所匹配的parameterType类型的参数
		//sqlSession.selectOne结果是与映射文件中所匹配的resultType类型的对象
		User user = sqlSession.selectOne("test.findUserById", 1);
		System.out.println(user);
		
		//释放资源
		sqlSession.close();
	}
	
	//根据用户名称模糊查询用户列表
	@Test
	public void findUserByNameTest() throws IOException{
		//mybatis配置文件  如果是放在sqlmap文件夹下那就是"sqlmap/SqlMapConfig.xml"
		String resource = "SqlMapConfig.xml";
		//得到配置文件流
		InputStream inputstream = Resources.getResourceAsStream(resource);
		//创建会话工厂,传入mybatis的配置文件信息
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputstream);
		//通过工厂得到SQLSession会话
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		//list中的user和映射文件中resultType所指的类型一致
		List<User> list = sqlSession.selectList("test.findUserByName", "小明");
		System.out.println(list);
		sqlSession.close();
	}
	
	//添加用户信息
	@Test
	public void insertUserTest() throws IOException{
		//mybatis配置文件  如果是放在sqlmap文件夹下那就是"sqlmap/SqlMapConfig.xml"
		String resource = "SqlMapConfig.xml";
		//得到配置文件流
		InputStream inputstream = Resources.getResourceAsStream(resource);
		//创建会话工厂,传入mybatis的配置文件信息
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputstream);
		//通过工厂得到SQLSession会话
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//插入用户对象
		User user = new User();
		user.setUsername("小灰灰");
		user.setBirthday(new Date());
		user.setSex("男");
		user.setAddress("河南郑州");
		//list中的user和映射文件中resultType所指的类型一致
		sqlSession.insert("test.insertUser", user);	
		//提交事务
		sqlSession.commit();
		//获取用户自增主键:mysql自增主键，执行insert提交之前自动生成一个自增主键，通过MySQL函数获取到
		//刚插入记录的自增主键：LAST_INSERT_ID(),是在insert之后调用
		//非自增主键返回：使用MySQL的uuid()函数生成主键，需要修改表中的id字段类型为string，长度设置成35位。
		//执行思路：1.先通过uuid()查询到主键，将主键输入到sql语句中 2.执行uuid()语句顺序相对于insert语句之前执行
		System.out.println(user.getId());
		sqlSession.close();
	}
	
	//添加id删除用户信息
	@Test
	public void deleteUserTest() throws IOException{
		//mybatis配置文件  如果是放在sqlmap文件夹下那就是"sqlmap/SqlMapConfig.xml"
		String resource = "SqlMapConfig.xml";
		//得到配置文件流
		InputStream inputstream = Resources.getResourceAsStream(resource);
		//创建会话工厂,传入mybatis的配置文件信息
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputstream);
		//通过工厂得到SQLSession会话
		SqlSession sqlSession = sqlSessionFactory.openSession();

		//根据传入ID删除用户
		sqlSession.delete("test.deleteUser", 35);	
		//提交事务
		sqlSession.commit();
		//关闭会话
		sqlSession.close();
	}
	
	//添加id删除用户信息
	@Test
	public void updateUserTest() throws IOException{
		//mybatis配置文件  如果是放在sqlmap文件夹下那就是"sqlmap/SqlMapConfig.xml"
		String resource = "SqlMapConfig.xml";
		//得到配置文件流
		InputStream inputstream = Resources.getResourceAsStream(resource);
		//创建会话工厂,传入mybatis的配置文件信息
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputstream);
		//通过工厂得到SQLSession会话
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//插入用户对象
		User user = new User();
		user.setId(35);
		user.setUsername("xxxx");
		user.setBirthday(new Date());
		user.setSex("男");
		user.setAddress("河南郑州");
		sqlSession.update("test.updateUser", user);	
		//提交事务
		sqlSession.commit();
		//关闭会话
		sqlSession.close();
	}
}
