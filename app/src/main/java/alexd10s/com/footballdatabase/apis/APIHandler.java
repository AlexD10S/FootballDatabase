package alexd10s.com.footballdatabase.apis;

import android.content.Context;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkError;
import com.android.volley.NoConnectionError;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

import alexd10s.com.footballdatabase.interfaces.ApiCallback;

/**
 * Created by alex on 13/08/2017.
 */

public class APIHandler {

    private final Context currentContex;
    static APIHandler handler;
    RequestQueue queue;
    String TAG = "ApiHandler";
    String BASE_URL = "http://api.football-data.org/v1/";

    public static APIHandler GetObject(Context cntx) {
        if (handler == null)
            handler = new APIHandler(cntx);
        return handler;
    }


    private APIHandler(Context cntx) {
        this.currentContex = cntx;
        queue = Volley.newRequestQueue(cntx);
    }

    public void DoGet(String url, final String[] dataParams, final String[] data, final ApiCallback callback) {
        StringRequest stringRequest = new StringRequest(Request.Method.GET,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        callback.OnSuccess(response);

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // to find no network connection error.
                        callback.OnFailure(ParseVolleyError(error));
                    }
                }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<>();
                for (int i = 0; i < dataParams.length; i++) {
                    params.put(dataParams[i], data[i]);
                }
                return params;
            }
        };
        queue.add(stringRequest);
    }

    public void DoGetWithoutParams(String url, final ApiCallback callback) {
        /*******************************/
        /* That line is not secure. Check it and fix (See Httpstrust Manager)*/
        //HttpsTrustManager.allowAllSSL();
        StringRequest stringRequest = new StringRequest(Request.Method.GET,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        callback.OnSuccess(response);

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // to find no network connection error.
                        callback.OnFailure(ParseVolleyError(error));
                    }
                });

        queue.add(stringRequest);
    }


    private String ParseVolleyError(VolleyError volleyError) {
        String message = null;
        if (volleyError instanceof NetworkError) {
            message = "Cannot connect to Internet...Please check your connection!";
        } else if (volleyError instanceof ServerError) {
            message = "The server could not be found. Please try again after some time!!";
        } else if (volleyError instanceof AuthFailureError) {
            message = "Cannot connect to Internet...Please check your connection!";
        } else if (volleyError instanceof ParseError) {
            message = "Parsing error! Please try again after some time!!";
        } else if (volleyError instanceof NoConnectionError) {
            message = "Cannot connect to Internet...Please check your connection!";
        } else if (volleyError instanceof TimeoutError) {
            message = "Connection TimeOut! Please check your internet connection.";
        }else
            message = volleyError.getMessage();

        return message;
    }


    /****************************************************/
    // ------ Function Specific API -------------------.
    /****************************************************/

    public void GetLeagues(String year,final ApiCallback callback) {
        if (callback == null)
            return;

        // Request a string response from the provided URL.
        DoGetWithoutParams(BASE_URL + "competitions/?season="+year,
                new ApiCallback() {
            @Override
            public void OnSuccess(String responce) {
                try {
                    callback.OnSuccess(responce);
                } catch (Exception e) {
                    Log.i(TAG, e.getMessage());

                    callback.OnFailure(e.getMessage());
                }
            }

            @Override
            public void OnFailure(String responce) {
                callback.OnFailure(responce);
            }
        });
    }

    public void GetTable(String id,final ApiCallback callback) {
        if (callback == null)
            return;

        // Request a string response from the provided URL.
        DoGetWithoutParams(BASE_URL + "competitions/"+id+"/leagueTable",new ApiCallback() {
                    @Override
                    public void OnSuccess(String responce) {
                        try {
                            callback.OnSuccess(responce);
                        } catch (Exception e) {
                            Log.i(TAG, e.getMessage());

                            callback.OnFailure(e.getMessage());
                        }
                    }

                    @Override
                    public void OnFailure(String responce) {
                        callback.OnFailure(responce);
                    }
                });
    }
}
