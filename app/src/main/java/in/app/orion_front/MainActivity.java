package in.app.orion_front;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import in.app.orion_front.api.goapi;
import in.app.orion_front.model.Signinresponse;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;
public class MainActivity extends ActionBarActivity {
    Button loginfacebook,logingoole;
    public static final String MyPREFERENCES = "MyPrefs" ;
    String api_url;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        api_url=getResources().getString(R.string.api_url);
        loginfacebook= (Button) findViewById(R.id.loginfacebook);
        logingoole= (Button) findViewById(R.id.logingoogle);
        loginfacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goapi goapi = new RestAdapter.Builder().setEndpoint(api_url).build().
                        create(in.app.orion_front.api.goapi.class);
                goapi.loginfacebook(new Callback<Signinresponse>() {
                    @Override
                    public void success(Signinresponse signinresponse, Response response) {
                        Log.i("Name" , signinresponse.name);
                    }
                    @Override
                    public void failure(RetrofitError error) {
                        Log.i("Error" ,error.getMessage() +"");
                    }
                });
            }
        });
        logingoole.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
    }
}
