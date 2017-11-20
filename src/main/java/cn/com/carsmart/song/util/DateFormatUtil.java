package cn.com.carsmart.song.util;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author songchengjun
 *
 */
public class DateFormatUtil {
	
	private static Logger LOGGER = LoggerFactory.getLogger(DateFormatUtil.class);
	
	private static ThreadLocal<SimpleDateFormat> threadLocal = new ThreadLocal<SimpleDateFormat>(){

		@Override
		protected SimpleDateFormat initialValue() {
			return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		}
	};
	
	private static ThreadLocal<SimpleDateFormat> strThreadLocal = new ThreadLocal<SimpleDateFormat>(){

		@Override
		protected SimpleDateFormat initialValue() {
			return new SimpleDateFormat("yyyyMMddHHmmss");
		}
	};
	
	private static ThreadLocal<SimpleDateFormat> milliThreadLocal = new ThreadLocal<SimpleDateFormat>(){

		@Override
		protected SimpleDateFormat initialValue() {
			return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		}
	};
	
	public static Date parse(String dateStr) throws ParseException {
        return threadLocal.get().parse(dateStr);
    }

    public static String format(Date date) {
        return threadLocal.get().format(date);
    }
    
    public static Date strParse(String dateStr) throws ParseException {
        return strThreadLocal.get().parse(dateStr);
    }

    public static String strFormat(Date date) {
        return strThreadLocal.get().format(date);
    }
    
    public static Date milliParse(String dateStr) throws ParseException {
        return milliThreadLocal.get().parse(dateStr);
    }

    public static String milliFormat(Date date) {
        return milliThreadLocal.get().format(date);
    }
    
    /** 解析时间字符串*/
	public static Date extractDateStr(String dateStr){
		Date time = new Date();
		if (StringUtils.isBlank(dateStr)) {
			return time;
		}
		
		try {
			if (dateStr.contains("-") || dateStr.contains(":")) {
				time = DateFormatUtil.parse(dateStr);
			} else {
				time = DateFormatUtil.strParse(dateStr);
			} 
		} catch (ParseException e) {
			e.printStackTrace();
			LOGGER.error("时间解析出错！");
		}
		
		return time;
	}
    
}
