package jodroid.d3calc;

public interface ILog {
	void v(String tag, String message);
	void d(String tag, String message);
	void i(String tag, String message);
	void w(String tag, String message);
	void e(String tag, String message);
	void wtf(String tag, String message);
	void println(int priority, String tag, String msg);
}
