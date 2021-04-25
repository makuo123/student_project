package com.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dao.SafesDAO;
import com.entity.Safes;
import com.service.SafesService;

@Service("safesService")
public class SafesServiceImpl implements SafesService {
	@Autowired
	private SafesDAO safesDAO;
	@Override // 继承接口的新增 返回值0(失败),1(成功)
	public int insertSafes(Safes safes) {
		return this.safesDAO.insertSafes(safes);
	}

	@Override // 继承接口的更新 返回值0(失败),1(成功)
	public int updateSafes(Safes safes) {
		return this.safesDAO.updateSafes(safes);
	}

	@Override // 继承接口的删除 返回值0(失败),1(成功)
	public int deleteSafes(String safesid) {
		return this.safesDAO.deleteSafes(safesid);
	}

	@Override // 继承接口的查询全部
	public List<Safes> getAllSafes() {
		return this.safesDAO.getAllSafes();
	}

	@Override // 继承接口的按条件精确查询
	public List<Safes> getSafesByCond(Safes safes) {
		return this.safesDAO.getSafesByCond(safes);
	}

	@Override // 继承接口的按条件模糊查询
	public List<Safes> getSafesByLike(Safes safes) {
		return this.safesDAO.getSafesByLike(safes);
	}

	@Override // 继承接口的按主键查询 返回Entity实例
	public Safes getSafesById(String safesid) {
		return this.safesDAO.getSafesById(safesid);
	}

}

