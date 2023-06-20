package com.jozzz.cow_format;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class RegexPattern {

    public static void setRegexProperties(){
        Properties properties = new Properties();

        //        String percentRegx = "([1-9]\\d?(\\.\\d*)?|100)\\s*%?";
//        String percentRegx = "\\d+(\\.\\d+)?\\s*%";
        String percentRegx = "\\d+\\.*\\d*\\s*%$";
        String numberRegx = "\\d+\\.?\\d*\\s*";
        String percentAndEngRegx = "\\d+(\\.\\d+)?\\s*%\\s*([a-zA-Z]+\\s*)+";
        String percentAndThaiRegx = "\\d+(\\.\\d+)?\\s*%\\s*([ก-๙]+\\s*)+";
        String engAndPercentRegx = "([a-zA-Z]+\\s*)+\\d+(\\.\\d+)?\\s*%";
        String thaiAndPercentRegx = "([ก-๙]+\\s*)+\\d+(\\.\\d+)?\\s*%";
        String numAndEngRegx = "\\d+\\.*\\d*\\s*([a-zA-Z]+\\s*)+";
        String numAndThaiRegx = "\\d+\\.*\\d*\\s*([ก-๙]+\\s*)+";
        String engAndNumRegx = "([a-zA-Z]+\\s*)+\\d+\\.*\\d*";
        String thaiAndNumRegx = "([ก-๙]+\\s*)+\\d+\\.*\\d*";
        String engMultiRegx = "(\\d+\\.*\\d*\\s*%\\s*[a-zA-Z]*\\s*)+";
        String thaiMultiRegx = "(\\d+\\.*\\d*\\s*%\\s*[ก-๙]*\\s*)+";
        String commaRegx = ".+\\,.+";
        String plusRegx = ".+\\+.+";
        String letterAndNumMultiRegx = "([a-zA-Zก-๙]*\\s*\\d+\\.*\\d*\\s*%\\s*\\s*)+";
        String letterRegx = "([^0-9]+\\s*)+";
        String thaiPercentEng = "([ก-๙]+\\s*)+\\d+\\.*\\d*\\s*%\\s*([a-zA-Z]+\\s*)+";

        String[] tabsName = {"Percent", "Number", "Percent & Eng", "Percent & Thai", "Eng & Percent", "Thai & Percent", "Num & Eng", "Num & Thai", "Eng & Num", "Thai & Num", "Eng Multi", "Thai Multi", "Comma", "Plus", "Letter & Num Multi", "Letter", "Thai Per Eng"};
        List<String[]> regexList = new ArrayList<>();

        regexList.add(new String[] { "Percent", "\\d+\\.*\\d*\\s*%$" });
        regexList.add(new String[] { "Number", "\\d+\\.?\\d*\\s*" });
        regexList.add(new String[] { "Percent & Eng", "\\d+(\\.\\d+)?\\s*%\\s*([a-zA-Z]+\\s*)+" });
        regexList.add(new String[] { "Percent & Thai", "\\d+(\\.\\d+)?\\s*%\\s*([ก-๙]+\\s*)+" });
        regexList.add(new String[] { "Eng & Percent", "([a-zA-Z]+\\s*)+\\d+(\\.\\d+)?\\s*%" });
        regexList.add(new String[] { "Thai & Percent", "([ก-๙]+\\s*)+\\d+(\\.\\d+)?\\s*%" });
        regexList.add(new String[] { "Num & Eng", "\\d+\\.*\\d*\\s*([a-zA-Z]+\\s*)+" });
        regexList.add(new String[] { "Num & Thai", "\\d+\\.*\\d*\\s*([ก-๙]+\\s*)+" });
        regexList.add(new String[] { "Eng & Num", "([a-zA-Z]+\\s*)+\\d+\\.*\\d*" });
        regexList.add(new String[] { "Thai & Num", "([ก-๙]+\\s*)+\\d+\\.*\\d*" });
        regexList.add(new String[] { "Eng Multi", "(\\d+\\.*\\d*\\s*%\\s*[a-zA-Z]*\\s*)+" });
        regexList.add(new String[] { "Thai Multi", "(\\d+\\.*\\d*\\s*%\\s*[ก-๙]*\\s*)+" });
        regexList.add(new String[] { "Comma", ".+\\,.+" });
        regexList.add(new String[] { "Plus", ".+\\+.+" });
        regexList.add(new String[] { "Letter & Num Multi", "([a-zA-Zก-๙]*\\s*\\d+\\.*\\d*\\s*%\\s*\\s*)+" });
        regexList.add(new String[] { "Letter", "([^0-9]+\\s*)+" });
        regexList.add(new String[] { "Thai Per Eng", "([ก-๙]+\\s*)+\\d+\\.*\\d*\\s*%\\s*([a-zA-Z]+\\s*)+" });

        for (String[] regex : regexList) {
            properties.setProperty(regex[0], regex[1]);
        }

        try {
            FileOutputStream fos = new FileOutputStream("regex.properties");
            properties.store(fos, "Regex Patterns");
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<String[]> loadRegexProperties(){
        List<String[]> regexList = new ArrayList<>();

        Properties properties = new Properties();

        try {
            FileInputStream fis = new FileInputStream("regex.properties");
            properties.load(fis);
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        regexList.add(new String[]{"Percent", properties.getProperty("Percent")});
        regexList.add(new String[]{"Number", properties.getProperty("Number")});
        regexList.add(new String[]{"Percent & Eng", properties.getProperty("Percent & Eng")});
        regexList.add(new String[]{"Percent & Thai", properties.getProperty("Percent & Thai")});
        regexList.add(new String[]{"Eng & Percent", properties.getProperty("Eng & Percent")});
        regexList.add(new String[]{"Thai & Percent", properties.getProperty("Thai & Percent")});
        regexList.add(new String[]{"Num & Eng", properties.getProperty("Num & Eng")});
        regexList.add(new String[]{"Num & Thai", properties.getProperty("Num & Thai")});
        regexList.add(new String[]{"Eng & Num", properties.getProperty("Eng & Num")});
        regexList.add(new String[]{"Thai & Num", properties.getProperty("Thai & Num")});
        regexList.add(new String[]{"Eng Multi", properties.getProperty("Eng Multi")});
        regexList.add(new String[]{"Thai Multi", properties.getProperty("Thai Multi")});
        regexList.add(new String[]{"Comma", properties.getProperty("Comma")});
        regexList.add(new String[]{"Plus", properties.getProperty("Plus")});
        regexList.add(new String[]{"Letter & Num Multi", properties.getProperty("Letter & Num Multi")});
        regexList.add(new String[]{"Letter", properties.getProperty("Letter")});
        regexList.add(new String[]{"Thai Per Eng", properties.getProperty("Thai Per Eng")});

        return regexList;
    }
}
