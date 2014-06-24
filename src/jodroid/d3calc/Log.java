package jodroid.d3calc;


/**
 * Simple log implementation.
 * TODO: delegation to provide a platform independent Log.
 * @author JRD
 */
public class Log {
	private static ILog log;
	public static void setLog(ILog lg) {
		log = lg;
	}

	public static void v(String tag, String message) {
		log.v(tag, message);
	}
	
	public static void d(String tag, String message) {
		log.d(tag, message);
	}
	
	public static void i(String tag, String message) {
		log.i(tag, message);
	}
	
	public static void w(String tag, String message) {
		log.w(tag, message);
	}
	
	public static void e(String tag, String message) {
		log.e(tag, message);
	}

	public static void wtf(String tag, String message) {
		log.wtf(tag, message);
	}
	
	public static void println(int priority, String tag, String msg) {
		log.println(priority, tag, msg);
	}
}
