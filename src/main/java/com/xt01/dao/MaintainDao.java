package com.xt01.dao;


import com.xt01.entity.Maintain;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSessionException;

import java.util.Date;
import java.util.List;

public interface MaintainDao {

    int Add(@Param("username") String username,
                    @Param("account") String account,
                    @Param("callnum") long callnum,
                    @Param("campus") String campus,
                    @Param("address") String address,
                    @Param("content") String content,
                    @Param("date") String date);

    List<Maintain> queryAll();

    List<Maintain> queryByToday(@Param("today") Date today) throws Exception;

    List<Maintain> queryByDate(@Param("start") Date start, @Param("end") Date end) throws Exception;

//    /**
//     *   分页查询所有
//     * @param startpage
//     * @param pagecount
//     * @return
//     */
//    List<Maintain> queryAllMaintainByPage(@Param("startpage") int startpage,
//                                          @Param("pagecount") int pagecount);
//
//    /**
//     *   分页查询今日报修
//     * @param startpage
//     * @param pagecount
//     * @param date
//     * @return
//     * @throws Exception
//     */
//    List<Maintain> queryTodayByPage(@Param("startpage") int startpage,
//                                       @Param("pagecount") int pagecount,
//                                       @Param("today") Date date) throws Exception;

    /**
     * 分页查询所有
     * @param page
     * @param count
     * @return
     */
    List<Maintain> queryByPage(@Param("page") int page,
                               @Param("count") int count) throws SqlSessionException;

    int queryCount() throws SqlSessionException;




    /**
     * 分页查询今日报修
     * @param page
     * @param count
     * @param today
     * @return
     */
    List<Maintain> queryToByPage(@Param("page") int page,
                                 @Param("count") int count,
                                 @Param("today") Date today) throws SqlSessionException;

    int queryToCount(@Param("today") Date today) throws SqlSessionException;
}
