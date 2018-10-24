package com.xt01.dao;

import com.xt01.entity.Apply;
import com.xt01.entity.Identity;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSessionException;

import java.util.Date;
import java.util.List;

public interface ApplyDao {


    /**
     *  添加申请
     * @param username
     * @param sex
     * @param uid
     * @param callnum
     * @param usergroup
     * @param address
     * @param businesstype
     * @param forlong
     * @param applytime
     * @param pay
     * @throws Exception
     */
    public int Add(@Param("username") String username,
                   @Param("sex") String sex,
                   @Param("uid") long uid,
                   @Param("callnum") long callnum,
                   @Param("usergroup") String usergroup,
                   @Param("address") String address,
                   @Param("businesstype") String businesstype,
                   @Param("forlong") int forlong,
                   @Param("identity") String identity,
                   @Param("acode") int acode,
                   @Param("password") String password,
                   @Param("applytime") Date applytime,
                   @Param("pay") double pay) throws Exception;

    List<Apply> queryAll() throws Exception;

    List<Apply> queryByUN(@Param("username") String username) throws Exception;



    List<Apply> queryByToday(@Param("today") Date today) throws Exception;

    List<Apply> queryByDate(@Param("start") Date start, @Param("end") Date end) throws Exception;



    /**
     * 分页查询所有
     * @param page
     * @param count
     * @return
     */
    List<Apply> queryByPage(@Param("page") int page, @Param("count") int count) throws SqlSessionException;

    int queryCount() throws SqlSessionException;

    /**
     * 分页查询今日报修
     * @param page
     * @param count
     * @param today
     * @return
     */
    List<Apply> queryToByPage(@Param("page") int page, @Param("count") int count, @Param("today") Date today) throws SqlSessionException;

    int queryToCount(@Param("today") Date today) throws SqlSessionException;






    /**
     *   查询是否已申请
     * @param uid
     * @return
     */
    public int CheckUIdHadApplyExist(long uid);

    /**
     *   查询是否存在在信息库
     * @param uid
     * @return
     */
    public int CheckUIdExist(long uid);

    /**
     *   检测是否合法
     * @param uid
     * @return
     */
    public String DoCheckGetIdentity(long uid);

    public int InsertIdentityExcel(@Param("uid") long uid,
                                   @Param("username") String username,
                                   @Param("over") String over,
                                   @Param("sex") String sex,
                                   @Param("email") String email,
                                   @Param("identity") String identity,
                                   @Param("callnum") long callnum,
                                   @Param("address") String address);

    List<Identity> IdentityqueryAll() throws Exception;

    int IdClear() throws Exception;
}
