package com.moa.model.service;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moa.model.ProjectDto;
import com.moa.model.mapper.ProjectMapper;

@Service
public class ProjectServiceImpl implements ProjectService {
	@Autowired
	private SqlSession sqlSession;

	@Override
	public void create(ProjectDto project) throws Exception {
		sqlSession.getMapper(ProjectMapper.class).create(project);
	}

	@Override
	public ProjectDto projectInfo(String id) throws Exception {
		return sqlSession.getMapper(ProjectMapper.class).projectInfo(id);
	}

	@Override
	public void waiting(Map<String, Object> param) throws Exception {
		sqlSession.getMapper(ProjectMapper.class).waiting(param);
	}

	@Override
	public void permission(Map<String, Object> param) throws Exception {
		sqlSession.getMapper(ProjectMapper.class).watingDelete(param);
		sqlSession.getMapper(ProjectMapper.class).projectAppend(param);

	}

	@Override
	public void denial(Map<String, Object> param) throws Exception {
		sqlSession.getMapper(ProjectMapper.class).denial(param);
		
	}

}