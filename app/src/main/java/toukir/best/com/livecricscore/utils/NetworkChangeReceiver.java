package toukir.best.com.livecricscore.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AlertDialog;
import android.util.Log;

import toukir.best.com.livecricscore.newupdate.HomeActivity;

/**
 * Created by toukir on 6/10/17.
 */

public class NetworkChangeReceiver extends BroadcastReceiver {

    boolean isConnected = false;

    @Override
    public void onReceive(final Context context, final Intent intent) {

        Log.v("LOG_TAG", "Receieved notification about network status");
        isNetworkAvailable(context);

    }


    public boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivity = (ConnectivityManager)
                context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivity != null) {
            NetworkInfo[] info = connectivity.getAllNetworkInfo();
            if (info != null) {
                for (int i = 0; i < info.length; i++) {
                    if (info[i].getState() == NetworkInfo.State.CONNECTED) {
                        if(!isConnected){
                            Log.v("LOG_TAG", "Now you are connected to Internet!");
                            isConnected = true;
                            //do your processing here ---
                            //if you need to post any data to the server or get status
                            //update from the server
                        }
                        return true;
                    }
                }
            }
        }
        isConnected = false;
        //showConnectionDialog(context);
        return false;
    }

    public void showConnectionDialog(final Context mContext){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(mContext);
        alertDialogBuilder.setMessage("Please Check Your Internet Connection");
        alertDialogBuilder.setPositiveButton("Cancel",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                        new HomeActivity().finish();
                    }
                });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

}
