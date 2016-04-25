package in.app.orion_front.api;

import in.app.orion_front.model.Signinresponse;
import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created by apple on 25/04/16.
 */
public interface goapi {

    @GET("/auth/facebook")
    void loginfacebook(Callback<Signinresponse> callback);

    @GET("/logingoogle")
    void logingoogle(Callback<Signinresponse> callback);

}
