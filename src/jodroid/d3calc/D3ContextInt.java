package jodroid.d3calc;

import java.util.Date;

public interface D3ContextInt {
	int getColor(String color, int defaultColor);
	String date2text(Date date);
	String [] getStringArray(int idStringArray);
	String getString(int idString);
}
