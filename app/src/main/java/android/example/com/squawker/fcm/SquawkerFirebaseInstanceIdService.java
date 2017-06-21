package android.example.com.squawker.fcm;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

/**
 * Created by prof.BOLA on 6/20/2017.
 */

public class SquawkerFirebaseInstanceIdService extends FirebaseInstanceIdService {
    
    public static final String LOG_TAG = SquawkerFirebaseInstanceIdService.class.getSimpleName();

    @Override
    public void onTokenRefresh() {
        String refreshToken = FirebaseInstanceId.getInstance().getToken();
        Log.d(LOG_TAG, "Refreshed token: " + refreshToken);
        
        sendRegistrationToServer(refreshToken);
    }

    private void sendRegistrationToServer(String refreshToken) {
    }
}
