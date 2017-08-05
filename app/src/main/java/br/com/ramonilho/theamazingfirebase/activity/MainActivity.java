package br.com.ramonilho.theamazingfirebase.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.messaging.FirebaseMessaging;

import br.com.ramonilho.theamazingfirebase.R;

import static com.google.android.gms.internal.zzs.TAG;

public class MainActivity extends AppCompatActivity {

    private FirebaseAnalytics mFirebaseAnalytics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Prints device token
        String token = FirebaseInstanceId.getInstance().getToken();
        Log.d(TAG, "Refreshed token: "+token);

        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);

        // Subscribe to Firebase topic
        FirebaseMessaging.getInstance().subscribeToTopic("mob");
    }

    public void clickMe(View v) {
        Bundle params = new Bundle();
        params.putString("NAME", "Ramon");
        mFirebaseAnalytics.logEvent("clickMe", params);
    }

    public void crashApp(View v) {
        mFirebaseAnalytics.logEvent("crashApp", null);
//        int i = 1 / 0;
    }

}
