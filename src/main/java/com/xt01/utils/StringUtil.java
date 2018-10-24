package com.xt01.utils;

import com.xt01.entity.Apply;
import com.xt01.result.Setting.BTResult;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {

    public static String FLtoInfo(int fl) {
        String FlInfo;
        if (fl == 3000) FlInfo = "一个月";
        else if (fl == 3050) FlInfo = "一个季度";
        else if (fl == 3001) FlInfo = "一个学期";
        else if(fl == 3002) FlInfo = "一个学年";
        else FlInfo = "";
        return FlInfo;
    }

    public static int FLtoInfo(String info) {
        int Fl;
        if (info.equals("一个月")) Fl = 3000;
        else if (info.equals("一个季度")) Fl = 3050;
        else if (info.equals("一个学期")) Fl = 3001;
        else if(info.equals("一个学年")) Fl = 3002;
        else Fl = 0;
        return Fl;
    }

    public static String TC(Date to,int forlong) throws ParseException {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        String tdy;
        c.setTime(to);
        if (forlong == 3000){
            c.add(Calendar.MONTH,1);
            Date td = c.getTime();
            tdy = df.format(td);
        }else if (forlong == 3050){
            c.add(Calendar.MONTH,3);
            Date td = c.getTime();
            tdy = df.format(td);
        }else if (forlong == 3001){
            c.add(Calendar.MONTH,5);
            Date td = c.getTime();
            tdy = df.format(td);
        }else if (forlong == 3002){
            c.add(Calendar.YEAR,1);
            Date td = c.getTime();
            tdy = df.format(td);
        }else {
            tdy = "";
        }
        return tdy;
    }

    public static String turn(int power){
        if (power==40001) return "超级管理员";
        else if (power==40002) return "普通管理员";
        else return "";
    }

    public static Date Date2(String a) throws ParseException {
        DateFormat w =  new SimpleDateFormat("yyyy-MM-dd hh:mm");
        int y = Integer.valueOf(a.substring(0, 4));
        int M = Integer.valueOf(a.substring(5, 7));
        int d = Integer.valueOf(a.substring(8, 10));
        int h = Integer.valueOf(a.substring(11, 13));
        int m = Integer.valueOf(a.substring(14, 16));
        String time = (y +"-"+ M +"-"+ d+ " "+ h +":"+m);
        Date date = w.parse(time);
        return date;
    }

//    public static List<Apply> ArToA(List<Apply> l) {
//        List<Apply> la = new ArrayList();
//        for (int i = 0; i < l.size(); i++) {
//            Apply a = new Apply((i + 1),
//                    l.get(i).getUsername(),
//                    l.get(i).getSex(),
//                    l.get(i).getUid(),
//                    l.get(i).getCallnum(),
//                    l.get(i).getUsergroup(),
//                    l.get(i).getAddress(),
//                    StringUtil.Toture(l.get(i).getBusinesstype()),
//                    StringUtil.FLtoInfo(l.get(i).getForlong()),
//                    l.get(i).getIdentity(),
//                    l.get(i).getPassword(),
//                    new SimpleDateFormat("yyyy-MM-dd hh:mm").format(l.get(i).getApplytime()));
//            la.add(i, a);
//        }
//        return la;
//    }

    public static List<BTResult> BTFalseToTure(List<BTResult> l) {
        List<BTResult> la = new ArrayList();
        for (int i = 0; i < l.size(); i++) {
            BTResult bt = new BTResult(
                    l.get(i).getI(),
                    StringUtil.Toture(l.get(i).getBst()),
                    l.get(i).getMprice(),
                    l.get(i).getQprice(),
                    l.get(i).getSprice(),
                    l.get(i).getYprice(),
                    l.get(i).getRemark()
                    );
            la.add(i, bt);
        }
        return la;
    }

    public static List<BTResult> BTTureToFalse(List<BTResult> l) {
        List<BTResult> la = new ArrayList();
        for (int i = 0; i < l.size(); i++) {
            BTResult bt = new BTResult(
                    l.get(i).getI(),
                    StringUtil.Tofalse(l.get(i).getBst()),
                    l.get(i).getMprice(),
                    l.get(i).getQprice(),
                    l.get(i).getSprice(),
                    l.get(i).getYprice(),
                    l.get(i).getRemark()
            );
            la.add(i, bt);
        }
        return la;
    }


//    mybatis防注入  "+","%"
    public static String Toture(String s) {
        String str = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.substring(i, i + 1).equals("z")){
                if (s.substring(i+1, i + 4).equals("xcp")){
                    str += "%";
                    i +=3;
                }else {
                    str += s.substring(i, i + 1);
                }

            }else if (s.substring(i, i + 1).equals("v")){
                if (s.substring(i+1, i + 4).equals("bnl")){
                    str += "+";
                    i +=3;
                }else {
                    str += s.substring(i, i + 1);
                }
            }else {
                str += s.substring(i, i + 1);
            }
        }
        return str;
    }

    public static String Tofalse(String s) {
        String str = "";
        String st;
        for (int i = 0; i < s.length(); i++) {
            st = s.substring(i, i + 1);
            switch (st) {
                case "%":
                    str += "zxcp";
                    break;
                case "+":
                    str += "vbnl";
                    break;
                default:
                    str += st;
                    break;

            }
        }
        return str;
    }

    /**
     * 数值类型前面补零（共13位）
     * @param num
     * @return
     */
    public static String supplementZeroGenerateThirteen(int num){
        String str = String.format("%013d", num);

        return str;
    }

    /**
     * 数值类型前面补零（共16位）
     * @param num
     * @return
     */
    public static String supplementZeroGenerateSixteen(int num){
        String str = String.format("%016d", num);

        return str;
    }
    /**
     * 数值类型前面补零（共3位）
     * @param num
     * @return
     */
    public static String supplementZeroGenerateThree(int num){
        String str = String.format("%03d", num);

        return str;
    }

    /**
     * 判断字符串是不是double型
     * @param str
     * @return
     */
    public static boolean isNumeric(String str){
        Pattern pattern = Pattern.compile("[0-9]+[.]{0,1}[0-9]*[dD]{0,1}");
        Matcher isNum = pattern.matcher(str);
        if( !isNum.matches() ){
            return false;
        }
        return true;
    }

    public static String trim(String str, boolean nullFlag){
        String tempStr = null;

        if (str != null)
        {
            tempStr = str.trim();
        }

        if (nullFlag)
        {
            if ("".equals(tempStr) || "null".equals(tempStr))
            {
                tempStr = null;
            }
        }
        else
        {
            if (tempStr == null)
            {
                tempStr = "";
            }
        }

        return tempStr;
    }
    public static String replace(String strSource, String strFrom, String strTo) {
        if(strSource==null){
            return null;
        }
        int i = 0;
        if ((i = strSource.indexOf(strFrom, i)) >= 0) {
            char[] cSrc = strSource.toCharArray();
            char[] cTo = strTo.toCharArray();
            int len = strFrom.length();
            StringBuffer buf = new StringBuffer(cSrc.length);
            buf.append(cSrc, 0, i).append(cTo);
            i += len;
            int j = i;
            while ((i = strSource.indexOf(strFrom, i)) > 0) {
                buf.append(cSrc, j, i - j).append(cTo);
                i += len;
                j = i;
            }
            buf.append(cSrc, j, cSrc.length - j);
            return buf.toString();
        }
        return strSource;
    }


    public static String deal(String str) {
        str = replace(str, "\\", "\\\\");
        str = replace(str, "'", "\\'");
        str = replace(str, "\r", "\\r");
        str = replace(str, "\n", "\\n");
        str = replace(str, "\"", "\\\"");
        return str;
    }

    public static String GetMapToXML(Map<String,String> param){
        StringBuffer sb = new StringBuffer();
        sb.append("<xml>");
        for (Map.Entry<String,String> entry : param.entrySet()) {
            sb.append("<"+ entry.getKey() +">");
            sb.append(entry.getValue());
            sb.append("</"+ entry.getKey() +">");
        }
        sb.append("</xml>");
        return sb.toString();
    }
}
