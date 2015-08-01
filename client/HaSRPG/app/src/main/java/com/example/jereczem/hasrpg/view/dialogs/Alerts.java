package com.example.jereczem.hasrpg.view.dialogs;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;

import com.example.jereczem.hasrpg.R;

/**
 * Created by jereczem on 03.07.15.
 */
public class Alerts {
    public static AlertDialog otherError(Activity activity, String error_alert_message) {
        String error_alert_title =
                activity.getResources().getString(R.string.error_alert_title);
        return DialogGenerator.generateSimpleOKAlert(activity, error_alert_title, error_alert_message);
    }

    public static AlertDialog databaseError(Activity activity) {
        String db_error_title =
                activity.getResources().getString(R.string.db_error_title);
        String db_error_message=
                activity.getResources().getString(R.string.db_error_message);
        return DialogGenerator.generateSimpleOKAlert(activity, db_error_title, db_error_message);
    }

    protected static class DialogGenerator {
        public static AlertDialog generateSimpleOKAlert(Activity activity, String title, String message){
            AlertDialog.Builder builder = new AlertDialog.Builder(activity);
            // Add the buttons
            builder.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    // User clicked OK button
                }
            });
            AlertDialog alertDialog = builder.create();
            alertDialog.setTitle(title);
            alertDialog.setMessage(message);
            return alertDialog;
        }
    }
}

