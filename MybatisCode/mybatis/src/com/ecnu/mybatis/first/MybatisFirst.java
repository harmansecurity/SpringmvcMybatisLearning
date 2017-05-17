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
 * ���ų���
 * @author LiangHui
 *
 */
public class MybatisFirst {
	//����id��ѯ�û���Ϣ���õ�һ����¼���
	@Test
	public void findUserByIdTest() throws IOException{
		
		//mybatis�����ļ�  ����Ƿ���sqlmap�ļ������Ǿ���"sqlmap/SqlMapConfig.xml"
		String resource = "SqlMapConfig.xml";
		//�õ������ļ���
		InputStream inputstream = Resources.getResourceAsStream(resource);
		//�����Ự����,����mybatis�������ļ���Ϣ
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputstream);
		//ͨ�������õ�SQLSession�Ự
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//ͨ��SqlSession�������ݿ�
		//��һ��������ӳ���ļ���statement��id,����=namespace+"."+statement��id
		//�ڶ���������ָ����ӳ���ļ�����ƥ���parameterType���͵Ĳ���
		//sqlSession.selectOne�������ӳ���ļ�����ƥ���resultType���͵Ķ���
		User user = sqlSession.selectOne("test.findUserById", 1);
		System.out.println(user);
		
		//�ͷ���Դ
		sqlSession.close();
	}
	
	//�����û�����ģ����ѯ�û��б�
	@Test
	public void findUserByNameTest() throws IOException{
		//mybatis�����ļ�  ����Ƿ���sqlmap�ļ������Ǿ���"sqlmap/SqlMapConfig.xml"
		String resource = "SqlMapConfig.xml";
		//�õ������ļ���
		InputStream inputstream = Resources.getResourceAsStream(resource);
		//�����Ự����,����mybatis�������ļ���Ϣ
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputstream);
		//ͨ�������õ�SQLSession�Ự
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		//list�е�user��ӳ���ļ���resultType��ָ������һ��
		List<User> list = sqlSession.selectList("test.findUserByName", "С��");
		System.out.println(list);
		sqlSession.close();
	}
	
	//����û���Ϣ
	@Test
	public void insertUserTest() throws IOException{
		//mybatis�����ļ�  ����Ƿ���sqlmap�ļ������Ǿ���"sqlmap/SqlMapConfig.xml"
		String resource = "SqlMapConfig.xml";
		//�õ������ļ���
		InputStream inputstream = Resources.getResourceAsStream(resource);
		//�����Ự����,����mybatis�������ļ���Ϣ
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputstream);
		//ͨ�������õ�SQLSession�Ự
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//�����û�����
		User user = new User();
		user.setUsername("С�һ�");
		user.setBirthday(new Date());
		user.setSex("��");
		user.setAddress("����֣��");
		//list�е�user��ӳ���ļ���resultType��ָ������һ��
		sqlSession.insert("test.insertUser", user);	
		//�ύ����
		sqlSession.commit();
		//��ȡ�û���������:mysql����������ִ��insert�ύ֮ǰ�Զ�����һ������������ͨ��MySQL������ȡ��
		//�ղ����¼������������LAST_INSERT_ID(),����insert֮�����
		//�������������أ�ʹ��MySQL��uuid()����������������Ҫ�޸ı��е�id�ֶ�����Ϊstring���������ó�35λ��
		//ִ��˼·��1.��ͨ��uuid()��ѯ�����������������뵽sql����� 2.ִ��uuid()���˳�������insert���֮ǰִ��
		System.out.println(user.getId());
		sqlSession.close();
	}
	
	//���idɾ���û���Ϣ
	@Test
	public void deleteUserTest() throws IOException{
		//mybatis�����ļ�  ����Ƿ���sqlmap�ļ������Ǿ���"sqlmap/SqlMapConfig.xml"
		String resource = "SqlMapConfig.xml";
		//�õ������ļ���
		InputStream inputstream = Resources.getResourceAsStream(resource);
		//�����Ự����,����mybatis�������ļ���Ϣ
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputstream);
		//ͨ�������õ�SQLSession�Ự
		SqlSession sqlSession = sqlSessionFactory.openSession();

		//���ݴ���IDɾ���û�
		sqlSession.delete("test.deleteUser", 35);	
		//�ύ����
		sqlSession.commit();
		//�رջỰ
		sqlSession.close();
	}
	
	//���idɾ���û���Ϣ
	@Test
	public void updateUserTest() throws IOException{
		//mybatis�����ļ�  ����Ƿ���sqlmap�ļ������Ǿ���"sqlmap/SqlMapConfig.xml"
		String resource = "SqlMapConfig.xml";
		//�õ������ļ���
		InputStream inputstream = Resources.getResourceAsStream(resource);
		//�����Ự����,����mybatis�������ļ���Ϣ
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputstream);
		//ͨ�������õ�SQLSession�Ự
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//�����û�����
		User user = new User();
		user.setId(35);
		user.setUsername("xxxx");
		user.setBirthday(new Date());
		user.setSex("��");
		user.setAddress("����֣��");
		sqlSession.update("test.updateUser", user);	
		//�ύ����
		sqlSession.commit();
		//�رջỰ
		sqlSession.close();
	}
}
