package pe.edu.upc.alex;

import android.app.Application;

import com.androidnetworking.AndroidNetworking;

/**
 * Created by Usuario on 2/10/2017.
 */

public class AlexApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        AndroidNetworking.initialize(getApplicationContext());
    }
}
