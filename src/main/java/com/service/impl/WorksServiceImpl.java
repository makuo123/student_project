package com.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dao.WorksDAO;
import com.entity.Works;
import com.service.WorksService;

@Service("worksService")
public class WorksServiceImpl implements WorksService {
	@Autowired
	private WorksDAO worksDAO;
	@Override // 继承接口的新增 返回值0(失败),1(成功)
	public int insertWorks(Works works) {
		return this.worksDAO.insertWorks(works);
	}

	@Override // 继承接口的更新 返回值0(失败),1(成功)
	public int updateWorks(Works works) {
		return this.worksDAO.updateWorks(works);
	}

	@Override // 继承接口的删除 返回值0(失败),1(成功)
	public int deleteWorks(String worksid) {
		return this.worksDAO.deleteWorks(worksid);
	}

	@Override // 继承接口的查询全部
	public List<Works> getAllWorks() {
		return this.worksDAO.getAllWorks();
	}

	@Override // 继承接口的按条件精确查询
	public List<Works> getWorksByCond(Works works) {
		return this.worksDAO.getWorksByCond(works);
	}

	@Override // 继承接口的按条件模糊查询
	public List<Works> getWorksByLike(Works works) {
		return this.worksDAO.getWorksByLike(works);
	}

	@Override // 继承接口的按主键查询 返回Entity实例
	public Works getWorksById(String worksid) {
		return this.worksDAO.getWorksById(worksid);
	}

}

