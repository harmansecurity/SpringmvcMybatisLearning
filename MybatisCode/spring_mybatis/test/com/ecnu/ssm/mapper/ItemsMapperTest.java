package com.ecnu.ssm.mapper;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ecnu.ssm.po.Items;
import com.ecnu.ssm.po.ItemsExample;

public class ItemsMapperTest {
	private ApplicationContext applicationContext;
	
	private ItemsMapper itemsMapper;
	//��setUp��������õ�spring����
	@Before
	public void setUp() throws Exception{
		applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
		itemsMapper = (ItemsMapper) applicationContext.getBean("itemsMapper");
	}
	@Test
	public void testDeleteByPrimaryKey() {
		fail("Not yet implemented");
	}

	//����
	@Test
	public void testInsert() {
		//���� items����
		Items items = new Items();
		items.setName("�ֻ�");
		items.setPrice(999f);
		items.setCreatetime(new Date());
		itemsMapper.insert(items);
	}
	//�Զ���������ѯ
	@Test
	public void testSelectByExample() {
		ItemsExample itemsExample = new ItemsExample();
		//ͨ��criteria�����ѯ����
		ItemsExample.Criteria criteria = itemsExample.createCriteria();
		criteria.andNameEqualTo("�ʼǱ�");
		//���ܷ��ض�����¼
		List<Items> list = itemsMapper.selectByExample(itemsExample);

		System.out.println(list);
	}

	//����������ѯ
	@Test
	public void testSelectByPrimaryKey() {
		Items items = itemsMapper.selectByPrimaryKey(1);
		System.out.println(items);
	}
	
	//��������
	@Test
	public void testUpdateByPrimaryKey() {
		//�������ֶν��и��£���Ҫ�Ȳ�ѯ�����ٸ���
		Items items = itemsMapper.selectByPrimaryKey(1);

		items.setName("�ֻ�");

		itemsMapper.updateByPrimaryKey(items);
		//��������ֶβ���Ϊ�Ÿ��£�������������ʹ�ô˷���������Ҫ�Ȳ�ѯ�ٸ���
		//itemsMapper.updateByPrimaryKeySelective(record);
	}

}
