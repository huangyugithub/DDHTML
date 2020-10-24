package com.baizhi.mybatisutil;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


public class MybatisUtil {
	private static SqlSessionFactory ssf;
	//创建线程绑定对象
	private static ThreadLocal<SqlSession> tl = new ThreadLocal<SqlSession>();
	
	static{
		try{
			//加载mybatis框架运行参数  Resources读取框架配置信息
			InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
			//创建SqlSessionFactory对象  工厂对象
			ssf = new SqlSessionFactoryBuilder().build(is);
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException("MybatisUtil 工具类读取配置文件出现异常");
		}
	}
	//获取SqlSession对象
	public static SqlSession openSession(){
		SqlSession ss = tl.get();
		if(ss == null){
			ss = ssf.openSession();
			tl.set(ss);
		}
		return ss;
	}
	//关闭连接资源
	public static void close(){
		SqlSession ss = openSession();
		ss.close();
		//将连接从线程绑定对象中移除
		tl.remove();
	}
	//获取接口实现类对象
	public static Object getMapper(Class cl){
		SqlSession ss = openSession();
		return ss.getMapper(cl);
	}
	//提交事务
	public static void commit(){
		openSession().commit();
		close();
	}
	//回滚事务
	public static void rollback(){
		openSession().rollback();
		close();
	}

}
