package com.xt01.service;


import com.xt01.entity.Identity;
import org.apache.poi.ss.usermodel.Workbook;

import javax.servlet.ServletOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public interface ExcelService {


    List<Identity> getBankListByExcel(InputStream in, String fileName) throws IOException,Exception;

    Workbook getWorkbook(InputStream inStr, String fileName) throws Exception;

    void export(ServletOutputStream out) throws Exception;

    void TodayExport(ServletOutputStream out, Date today) throws Exception;

    void DateExport(ServletOutputStream out, Date start,Date end) throws Exception;

    void MtExport(ServletOutputStream out) throws Exception;

    void MtTodayExport(ServletOutputStream out, Date today) throws Exception;

    void MtDateExport(ServletOutputStream out, Date start, Date end) throws Exception;

    void IdentityExport(ServletOutputStream out) throws Exception;
}