package com.xt01.service.impl;

import com.xt01.dao.ApplyDao;
import com.xt01.dao.MaintainDao;
import com.xt01.entity.Apply;
import com.xt01.entity.Identity;
import com.xt01.entity.Maintain;
import com.xt01.service.ExcelService;
import com.xt01.utils.StringUtil;

import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletOutputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExcelServiceImpl implements ExcelService {

    @Autowired
    private ApplyDao applyDao;

    @Autowired
    private MaintainDao maintainDao;

    private final static String excel2003L =".xls";    //2003- 版本的excel
    private final static String excel2007U =".xlsx";   //2007+ 版本的excel


    /**
     * 描述：获取IO流中的数据，组装成List<List<Object>>对象
     * @param in,fileName
     * @return
     * @throws IOException
     */
    @Override
    public List<Identity> getBankListByExcel(InputStream in, String fileName) throws IOException,Exception {
        System.out.println("getBankListByExcel");
        Workbook work = this.getWorkbook(in,fileName);
        if(null == work){
            System.out.println("Excel工作薄为空！");
//            throw new Exception("创建Excel工作薄为空！");
        }
        Sheet sheet = null;
        Row row = null;

        List<Identity> list = new ArrayList();
        System.out.println("======="+work.getNumberOfSheets());
        for (int i = 0; i < work.getNumberOfSheets(); i++) {

            sheet = work.getSheetAt(i);
            if(sheet==null){continue;}
            for (int j = sheet.getFirstRowNum()+1; j < sheet.getLastRowNum()+1; j++) {
                row = sheet.getRow(j);
                Identity identity = new Identity();

                long uid;
                if (row.getCell(0)!=null){
                    uid = Math.round(row.getCell(0).getNumericCellValue());
                }else {uid = 0;}
                identity.setUid(uid);

                System.out.println("---------" + uid);


                String username;
                if (row.getCell(1)!=null){
                    username = row.getCell(1).getStringCellValue();
                }else {username ="";}
                identity.setUsername(username);

                System.out.println("---------" + username);

                String over;
                if (row.getCell(2)!=null){
//                    over = new SimpleDateFormat("yyyy-MM-dd").format(row.getCell(2).getDateCellValue());
                    over = row.getCell(2).getStringCellValue();

                }else {over ="";}
                identity.setOver(over);

                System.out.println("---------" + over);

                String sex;
                if (row.getCell(3)!=null){
                    sex = row.getCell(3).getStringCellValue();
                }else{sex = "";}
                identity.setSex(sex);

                System.out.println("---------" + sex);

                String email;
                if (row.getCell(4)!=null){
                    email = row.getCell(4).getStringCellValue();
                }else {email = "";}
                identity.setEmail(email);

                System.out.println( "---------" + email);

                String iden;
                if (row.getCell(5)!=null){
                        iden = row.getCell(5).getStringCellValue();
                }else {iden = "";}
                identity.setIdentity(iden);

                System.out.println( "---------" + iden);

                long callnum;
                if (row.getCell(6)!=null){
                    callnum = Math.round(row.getCell(6).getNumericCellValue());
                }else {callnum = 0;}
                identity.setCallnum(callnum);

                System.out.println( "---------" + callnum);

                String address;
                if (row.getCell(7)!=null){
                    address = row.getCell(7).getStringCellValue();
                }else {address = "";}
                identity.setAddress(address);

                System.out.println( "---------" + address);

                System.out.println("====" +identity.toString());
                list.add(identity);
            }
        }
        for (Identity id:list){
        System.out.println(id);
        }
        return list;
    }

    /**
     * 描述：对表格中数值进行格式化
     * @param cell
     * @return
     */
    public Object getCellValue(Cell cell){
        Object value = null;
        DecimalFormat df = new DecimalFormat("0");  //格式化number String字符
        SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd");  //日期格式化
        DecimalFormat df2 = new DecimalFormat("0.00");  //格式化数字

        switch (cell.getCellType()) {
            case Cell.CELL_TYPE_STRING:
                value = cell.getRichStringCellValue().getString();
                break;
            case Cell.CELL_TYPE_NUMERIC:
                if("General".equals(cell.getCellStyle().getDataFormatString())){
                    value = df.format(cell.getNumericCellValue());
                }else if("m/d/yy".equals(cell.getCellStyle().getDataFormatString())){
                    value = sdf.format(cell.getDateCellValue());
                }else{
                    value = df2.format(cell.getNumericCellValue());
                }
                break;
            case Cell.CELL_TYPE_BOOLEAN:
                value = cell.getBooleanCellValue();
                break;
            case Cell.CELL_TYPE_BLANK:
                value = "";
                break;
            default:
                break;
        }
        return value;
    }

    /**
     * 描述：根据文件后缀，自适应上传文件的版本
     * @param inStr,fileName
     * @return
     * @throws Exception
     */
    public Workbook getWorkbook(InputStream inStr, String fileName) throws Exception{
        Workbook wb = null;
        String fileType = fileName.substring(fileName.lastIndexOf("."));
        if(excel2003L.equals(fileType)){
            wb = new HSSFWorkbook(inStr);  //2003-
        }else if(excel2007U.equals(fileType)){
            wb = new XSSFWorkbook(inStr);  //2007+
        }else{
            throw new Exception("解析的文件格式有误！");
        }
        return wb;
    }


    @Override
    public void export(ServletOutputStream out) throws Exception {
        try{
            // 创建一个workbook，对应一个Excel文件
            HSSFWorkbook workbook = new HSSFWorkbook();
            // 写入实体数据
            List<Apply> l = applyDao.queryAll();
            ApplyFormatWriter(workbook,l);
            // 将文件输出到客户端浏览器
            try {
                workbook.write(out);
                out.flush();
                out.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }catch(Exception e){
            e.printStackTrace();
            throw new Exception("导出信息失败！");
        }
    }

    @Override
    public void TodayExport(ServletOutputStream out,Date today) throws Exception {
        try{
            // 创建一个workbook，对应一个Excel文件
            HSSFWorkbook workbook = new HSSFWorkbook();
            // 写入实体数据
            List<Apply> l = applyDao.queryByToday(today);
            ApplyFormatWriter(workbook,l);
            // 将文件输出到客户端浏览器
            try {
                workbook.write(out);
                out.flush();
                out.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }catch(Exception e){
            e.printStackTrace();
            throw new Exception("导出信息失败！");
        }
    }

    @Override
    public void DateExport(ServletOutputStream out, Date start, Date end) throws Exception {
        try{
            // 创建一个workbook，对应一个Excel文件
            HSSFWorkbook workbook = new HSSFWorkbook();
            // 写入实体数据
            List<Apply> l = applyDao.queryByDate(start,end);
            ApplyFormatWriter(workbook,l);
            // 将文件输出到客户端浏览器
            try {
                workbook.write(out);
                out.flush();
                out.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }catch(Exception e){
            e.printStackTrace();
            throw new Exception("导出信息失败！");
        }
    }


    @Override
    public void MtExport(ServletOutputStream out) throws Exception {
        try{
            // 创建一个workbook，对应一个Excel文件
            HSSFWorkbook workbook = new HSSFWorkbook();
            // 写入实体数据
            List<Maintain> list = maintainDao.queryAll();
            MaintainFormatWriter(workbook,list);
            // 将文件输出到客户端浏览器
            try {
                workbook.write(out);
                out.flush();
                out.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }catch(Exception e){
            e.printStackTrace();
            throw new Exception("导出信息失败！");
        }
    }

    @Override
    public void MtTodayExport(ServletOutputStream out,Date today) throws Exception {
        try{
            // 创建一个workbook，对应一个Excel文件
            HSSFWorkbook workbook = new HSSFWorkbook();
            // 写入实体数据
            List<Maintain> list = maintainDao.queryByToday(today);

            MaintainFormatWriter(workbook,list);
            // 将文件输出到客户端浏览器
            try {
                workbook.write(out);
                out.flush();
                out.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }catch(Exception e){
            e.printStackTrace();
            throw new Exception("导出信息失败！");
        }
    }

    @Override
    public void MtDateExport(ServletOutputStream out, Date start, Date end) throws Exception {
        try{
            // 创建一个workbook，对应一个Excel文件
            HSSFWorkbook workbook = new HSSFWorkbook();
            // 写入实体数据
            List<Maintain> l = maintainDao.queryByDate(start,end);
            MaintainFormatWriter(workbook,l);
            // 将文件输出到客户端浏览器
            try {
                workbook.write(out);
                out.flush();
                out.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }catch(Exception e){
            e.printStackTrace();
            throw new Exception("导出信息失败！");
        }
    }



    @Override
    public void IdentityExport(ServletOutputStream out) throws Exception {
        try{
            // 创建一个workbook，对应一个Excel文件
            HSSFWorkbook workbook = new HSSFWorkbook();
            // 写入实体数据
            List<Identity> list = applyDao.IdentityqueryAll();

            IdentityFormatWriter(workbook,list);
            // 将文件输出到客户端浏览器
            try {
                workbook.write(out);
                out.flush();
                out.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }catch(Exception e){
            e.printStackTrace();
            throw new Exception("导出信息失败！");
        }
    }








    void ApplyFormatWriter(HSSFWorkbook workbook,List<Apply> list) throws ParseException {
        // 在workbook中添加一个sheet,对应Excel文件中的sheet
        HSSFSheet hssfSheet = workbook.createSheet("sheet1");

        // 在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
        HSSFRow hssfRow = hssfSheet.createRow(0);

        // 创建单元格，并设置值表头 设置表头居中
        HSSFCellStyle hssfCellStyle = workbook.createCellStyle();

        //居中样式
        hssfCellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        String[] titles = {"序号","用户姓名","性别","用户号","移动电话","用户组","地址","业务类型","办理时长","自动预销户时间","证件号码","编码","密码","申请时间","余额缴费金额","待扣款缴费金额"};

        HSSFCell hssfCell = null;
        for (int i = 0; i < titles.length; i++) {
            hssfCell = hssfRow.createCell(i);//列索引从0开始
            hssfCell.setCellValue(titles[i]);//列名1
            hssfCell.setCellStyle(hssfCellStyle);//列居中显示
        }

        if(list != null && !list.isEmpty()){
            for (int i = 0; i < list.size(); i++) {
                hssfRow = hssfSheet.createRow(i+1);
                Apply apply= list.get(i);

                // 第六步，创建单元格，并设置值
                long rid = 0;
                if(apply.getRid() != 0){
                    rid = i+1;
                }
                hssfRow.createCell(0).setCellValue(rid);

                String username = "";
                if(apply.getUsername() != null){
                    username = apply.getUsername();
                }
                hssfRow.createCell(1).setCellValue(username);

                String sex = "";
                if(apply.getSex() != null){
                    sex = apply.getSex();
                }
                hssfRow.createCell(2).setCellValue(sex);

                long uid = 0;
                if(apply.getUid() != 0){
                    uid = apply.getUid();
                }
                hssfRow.createCell(3).setCellValue(uid);

                long callnum = 0;
                if(apply.getCallnum() != 0){
                    callnum = apply.getCallnum();
                }
                hssfRow.createCell(4).setCellValue(callnum);

                String usergroup = "";
                if(apply.getUsergroup() != null){
                    usergroup = apply.getUsergroup();
                }
                hssfRow.createCell(5).setCellValue(usergroup);

                String address = "";
                if(apply.getAddress() != null){
                    address = apply.getAddress();
                }
                hssfRow.createCell(6).setCellValue(address);

                String businesstype = "";
                if(apply.getBusinesstype() != null){
                    businesstype = StringUtil.Toture(apply.getBusinesstype());
                }
                hssfRow.createCell(7).setCellValue(businesstype);

                String forlong = "";
                if(apply.getForlong() != 0){
                    forlong = StringUtil.FLtoInfo(apply.getForlong());
                }
                hssfRow.createCell(8).setCellValue(forlong);

                String over = "";
                if(apply.getForlong() != 0 && apply.getApplytime() != null ){
                    over = StringUtil.TC(apply.getApplytime(),apply.getForlong());
                }
                hssfRow.createCell(9).setCellValue(over);


                String identity = "";
                if(apply.getIdentity() != null){
                    identity = apply.getIdentity();
                }
                hssfRow.createCell(10).setCellValue(identity);

                int acode = 0;
                hssfRow.createCell(11).setCellValue(acode);


                String password = "";
                if(apply.getPassword() != null){
                    password = apply.getPassword();
                }
                hssfRow.createCell(12).setCellValue(password);


                String applytime = "";
                if(apply.getApplytime() != null){
                    applytime = new SimpleDateFormat("yyyy-MM-dd hh:mm").format(apply.getApplytime());
                }
                hssfRow.createCell(13).setCellValue(applytime);

                hssfRow.createCell(14).setCellValue(0);

                double pay = 0;
                if(apply.getPay() != 0){
                    pay = apply.getPay();
                }
                hssfRow.createCell(15).setCellValue(pay);


            }
        }
    }


    void MaintainFormatWriter(HSSFWorkbook workbook,List<Maintain> list) {
        // 在workbook中添加一个sheet,对应Excel文件中的sheet
        HSSFSheet hssfSheet = workbook.createSheet("sheet1");

        // 在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
        HSSFRow hssfRow = hssfSheet.createRow(0);

        // 创建单元格，并设置值表头 设置表头居中
        HSSFCellStyle hssfCellStyle = workbook.createCellStyle();

        //居中样式
        hssfCellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);


        String[] titles = {"序号","用户名","校园网账号","联系电话","校区","宿舍地址","内容","报修时间"};

        HSSFCell hssfCell = null;
        for (int i = 0; i < titles.length; i++) {
            hssfCell = hssfRow.createCell(i);//列索引从0开始
            hssfCell.setCellValue(titles[i]);//列名1
            hssfCell.setCellStyle(hssfCellStyle);//列居中显示
        }

        if(list != null && !list.isEmpty()){
            for (int i = 0; i < list.size(); i++) {
                hssfRow = hssfSheet.createRow(i+1);
                Maintain m = list.get(i);

                // 第六步，创建单元格，并设置值
                hssfRow.createCell(0).setCellValue(i+1);

                String username = "";
                if(m.getUsername() != null){
                    username = m.getUsername();
                }
                hssfRow.createCell(1).setCellValue(username);

                String account = "";
                if(m.getAccount() != null){
                    account = m.getAccount();
                }
                hssfRow.createCell(2).setCellValue(account);

                long callnum = 0;
                if(m.getCallnum() != 0){
                    callnum = m.getCallnum();
                }
                hssfRow.createCell(3).setCellValue(callnum);

                String campus = "";
                if(m.getCampus() != null){
                    campus = m.getCampus();
                }
                hssfRow.createCell(4).setCellValue(campus);

                String address = "";
                if(m.getAddress() != null){
                    address = m.getAddress();
                }
                hssfRow.createCell(5).setCellValue(address);

                String content = "";
                if(m.getContent() != null){
                    content = m.getContent();
                }
                hssfRow.createCell(6).setCellValue(content);

                String date = "";
                if(m.getDate() != null){
                    date = m.getDate();
                }
                hssfRow.createCell(7).setCellValue(date);
            }
        }
    }


    void IdentityFormatWriter(HSSFWorkbook workbook,List<Identity> list){
        // 在workbook中添加一个sheet,对应Excel文件中的sheet
        HSSFSheet hssfSheet = workbook.createSheet("sheet1");

        // 在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
        HSSFRow hssfRow = hssfSheet.createRow(0);

        // 创建单元格，并设置值表头 设置表头居中
        HSSFCellStyle hssfCellStyle = workbook.createCellStyle();

        //居中样式
        hssfCellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);

        String[] titles = {"用户名","用户姓名","自动预销户时间","性别","邮箱地址","证件号码","移动电话","地址"};

        HSSFCell hssfCell = null;
        for (int i = 0; i < titles.length; i++) {
            hssfCell = hssfRow.createCell(i);//列索引从0开始
            hssfCell.setCellValue(titles[i]);//列名1
            hssfCell.setCellStyle(hssfCellStyle);//列居中显示
        }
        if(list != null && !list.isEmpty()){
            for (int i = 0; i < list.size(); i++) {
                hssfRow = hssfSheet.createRow(i+1);
                Identity iden = list.get(i);

                Long uid = 0L;
                if (iden.getUid() !=0 ){
                    uid = iden.getUid();
                }
                hssfRow.createCell(0).setCellValue(uid);

                String username = "";
                if(iden.getUsername() != null){
                    username = iden.getUsername();
                }
                hssfRow.createCell(1).setCellValue(username);

                String over = "";
                if(iden.getOver() != null){
                    over = iden.getOver();
                }
                hssfRow.createCell(2).setCellValue(over);

                String sex = "";
                if(iden.getSex() != null){
                    sex = iden.getSex();
                }
                hssfRow.createCell(3).setCellValue(sex);

                String email = "";
                if(iden.getEmail() != null){
                    email = iden.getEmail();
                }
                hssfRow.createCell(4).setCellValue(email);

                String identi = "";
                if(iden.getIdentity() != null){
                    identi = iden.getIdentity();
                }
                hssfRow.createCell(5).setCellValue(identi);

                long callnum = 0;
                if(iden.getCallnum() != 0){
                    callnum = iden.getCallnum();
                }
                hssfRow.createCell(6).setCellValue(callnum);

                String address = "";
                if(iden.getAddress() != null){
                    address = iden.getAddress();
                }
                hssfRow.createCell(7).setCellValue(address);
            }
        }
    }
}