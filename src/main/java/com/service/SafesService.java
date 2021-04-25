package com.service;
import java.util.List;
import org.springframework.stereotype.Service;
import com.entity.Safes;
@Service("safesService")
public interface SafesService {
	// 插入数据 调用safesDAO里的insertSafes配置
	public int insertSafes(Safes safes);

	// 更新数据 调用safesDAO里的updateSafes配置
	public int updateSafes(Safes safes);

	// 删除数据 调用safesDAO里的deleteSafes配置
	public int deleteSafes(String safesid);

	// 查询全部数据 调用safesDAO里的getAllSafes配置
	public List<Safes> getAllSafes();

	// 按照Safes类里面的字段名称精确查询 调用safesDAO里的getSafesByCond配置
	public List<Safes> getSafesByCond(Safes safes);

	// 按照Safes类里面的字段名称模糊查询 调用safesDAO里的getSafesByLike配置
	public List<Safes> getSafesByLike(Safes safes);

	// 按主键查询表返回单一的Safes实例 调用safesDAO里的getSafesById配置
	public Safes getSafesById(String safesid);

}

