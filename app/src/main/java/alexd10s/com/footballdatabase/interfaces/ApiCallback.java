package alexd10s.com.footballdatabase.interfaces;

/**
 * Created by alex on 13/08/2017.
 */

public interface ApiCallback {
    void OnSuccess(String result);
    void OnFailure(String message);
}
