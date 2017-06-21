package android.example.com.squawker.fcm;

import android.content.ContentValues;
import android.example.com.squawker.provider.SquawkContract;
import android.example.com.squawker.provider.SquawkProvider;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.util.Map;

/**
 * Created by prof.BOLA on 6/21/2017.
 */

public class SquawkerMessagingService extends FirebaseMessagingService {

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        Map<String, String> data = remoteMessage.getData();
        String author = data.get(SquawkContract.COLUMN_AUTHOR);
        String authorKey = data.get(SquawkContract.COLUMN_AUTHOR_KEY);
        String message = data.get(SquawkContract.COLUMN_MESSAGE);
        String date = data.get(SquawkContract.COLUMN_DATE);

        ContentValues cv = new ContentValues();
        cv.put(SquawkContract.COLUMN_AUTHOR, author);
        cv.put(SquawkContract.COLUMN_MESSAGE, message);
        cv.put(SquawkContract.COLUMN_AUTHOR_KEY, authorKey);
        cv.put(SquawkContract.COLUMN_DATE, date);

        getContentResolver().insert(SquawkProvider.SquawkMessages.CONTENT_URI,
                cv);
    }
}
