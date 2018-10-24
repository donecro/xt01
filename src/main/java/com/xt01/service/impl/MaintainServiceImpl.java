package com.xt01.service.impl;

import com.xt01.dao.MaintainDao;
import com.xt01.entity.Maintain;
import com.xt01.service.MaintainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class MaintainServiceImpl implements MaintainService {

    @Autowired
    private MaintainDao maintainDao;


    @Override
    public int submitMaintain(Maintain m) {
        return maintainDao.Add(
                m.getUsername(),
                m.getAccount(),
                m.getCallnum(),
                m.getCampus(),
                m.getAddress(),
                m.getContent(),
                m.getDate());
    }

    @Override
    public List<Maintain> getList(){
        List<Maintain> l = maintainDao.queryAll();
        List<Maintain> la = new ArrayList();
        for (int i =0 ;i<l.size();i++){
            Maintain m = new Maintain(
                    i+1,
                    l.get(i).getUsername(),
                    l.get(i).getAccount(),
                    l.get(i).getCallnum(),
                    l.get(i).getCampus(),
                    l.get(i).getAddress(),
                    l.get(i).getContent(),
                    l.get(i).getDate());
            la.add(i,m);
        }
        return la;
    }

    @Override
    public List<Maintain> queryByPage(int page, int count) { return maintainDao.queryByPage(page,count); }

    @Override
    public int queryCount() { return maintainDao.queryCount(); }

    @Override
    public List<Maintain> queryToByPage(int page, int count, Date today) { return maintainDao.queryToByPage(page,count,today); }

    @Override
    public int queryToCount(Date today) { return maintainDao.queryToCount(today); }
}
