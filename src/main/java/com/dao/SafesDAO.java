package com.dao;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import com.entity.Safes;

@Repository("safesDAO") // Repository标签定义数据库连接的访问 Spring中直接
@Mapper
public interface SafesDAO {

	/**
* SafesDAO 接口 可以按名称直接调用safes.xml配置文件的SQL语句
 */

	// 插入数据 调用entity包safes.xml里的insertSafes配置 返回值0(失败),1(成功)
	public int insertSafes(Safes safes);

	// 更新数据 调用entity包safes.xml里的updateSafes配置 返回值0(失败),1(成功)
	public int updateSafes(Safes safes);

	// 删除数据 调用entity包safes.xml里的deleteSafes配置 返回值0(失败),1(成功)
	public int deleteSafes(String safesid);

	// 查询全部数据 调用entity包safes.xml里的getAllSafes配置 返回List类型的数据
	public List<Safes> getAllSafes();

	// 按照Safes类里面的值精确查询 调用entity包safes.xml里的getSafesByCond配置 返回List类型的数据
	public List<Safes> getSafesByCond(Safes safes);

	// 按照Safes类里面的值模糊查询 调用entity包safes.xml里的getSafesByLike配置 返回List类型的数据
	public List<Safes> getSafesByLike(Safes safes);

	// 按主键查询表返回单一的Safes实例 调用entity包safes.xml里的getSafesById配置
	public Safes getSafesById(String safesid);

}


