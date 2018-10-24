package com.xt01.service;

import com.xt01.entity.Maintain;

import java.util.Date;
import java.util.List;

public interface MaintainService {

    int submitMaintain(Maintain m);

    List<Maintain> getList();

//    List<Maintain> queryAllMaintainByPage(PageBean<Maintain> pagebean) throws Exception;

//    List<Maintain> queryTodayByPage(PageBean<Maintain> pagebean, Date date) throws Exception;

    List<Maintain> queryByPage(int page, int count);

    int queryCount();

    List<Maintain> queryToByPage(int page, int count, Date today);

    int queryToCount(Date today);
}
