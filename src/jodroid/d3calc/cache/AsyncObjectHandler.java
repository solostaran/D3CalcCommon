package jodroid.d3calc.cache;

/**
 * Interface for asynchronous operations.<br/>
 * Generally used for http requests.
 * @author JRD
 * @param <T>
 */
public interface AsyncObjectHandler<T> {
	void onSuccess(T obj);
	void onFailure(String code, String reason);
}
