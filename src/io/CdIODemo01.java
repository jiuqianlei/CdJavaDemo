package io;

import java.io.File;
import java.io.FilenameFilter;

/**
 * 
 * @author cd
 * 
 *         2014-3-4
 * 
 *         IODemo之 文件过滤
 * 
 */
public class CdIODemo01 {

    public static void main(String[] args) {
	String path = "/home/bobby/音乐";
	String rule = ".mp3";
	String[] list;
	try {
	    File file = new File(path);
	    list = file.list(new FileFilter(rule));
	    if (list != null && list.length != 0) {
		for (String str : list) {
		    System.out.println(str);
		}
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	}

    }

}

class FileFilter implements FilenameFilter {

    String strRule;

    // 实例化时传入过滤字符串
    public FileFilter(String strRule) {
	this.strRule = strRule;
    }

    public boolean accept(File dir, String name) {
	// Strip path information:
	String f = new File(name).getName();
	// 过滤规则
	return f.endsWith(strRule);
	// return f.indexOf(strRule) != -1;
    }
}
