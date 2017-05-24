package com.example.mm.crunchtime;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//    }



    static final String ACTION_SCAN = "com.google.zxing.client.android.SCAN";
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;


    @Override

    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);




        //set the main content layout of the Activity

        setContentView(R.layout.activity_main);

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();

    }


    //product barcode mode

//    public void scanBar(View v) {
//
//        try {
//
//            //start the scanning activity from the com.google.zxing.client.android.SCAN intent
//
//            Intent intent = new Intent(ACTION_SCAN);
//
//            intent.putExtra("SCAN_MODE", "PRODUCT_MODE");
//
//            startActivityForResult(intent, 0);
//
//        } catch (ActivityNotFoundException anfe) {
//
//            //on catch, show the download dialog
//
//            showDialog(MainActivity.this, "No Scanner Found", "Download a scanner code activity?", "Yes", "No").show();
//
//        }
//
//    }


    //product qr code mode

    public void scanQR(View v) {

        try {

            //start the scanning activity from the com.google.zxing.client.android.SCAN intent
            Intent intent = new Intent(ACTION_SCAN);
            intent.putExtra("SCAN_MODE", "QR_CODE_MODE");

            startActivityForResult(intent, 0);

        } catch (ActivityNotFoundException anfe) {

            //on catch, show the download dialog

            showDialog(MainActivity.this, "No Scanner Found", "Download a scanner code activity?", "Yes", "No").show();

        }

    }

    //alert dialog for downloadDialog
    private static AlertDialog showDialog(final Activity act, CharSequence title, CharSequence message, CharSequence buttonYes, CharSequence buttonNo) {

        AlertDialog.Builder downloadDialog = new AlertDialog.Builder(act);
        downloadDialog.setTitle(title);
        downloadDialog.setMessage(message);
        downloadDialog.setPositiveButton(buttonYes, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                Uri uri = Uri.parse("market://search?q=pname:" + "com.google.zxing.client.android");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                try {
                    act.startActivity(intent);
                } catch (ActivityNotFoundException anfe) {

                }
            }
        });
        downloadDialog.setNegativeButton(buttonNo, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        return downloadDialog.show();
    }


    //on ActivityResult method
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if (requestCode == 0) {
            if (resultCode == RESULT_OK) {
                //get the extras that are returned from the intent
                String contents = intent.getStringExtra("SCAN_RESULT");
                String format = intent.getStringExtra("SCAN_RESULT_FORMAT");
                String[][] tab = new String[9][3];
                tab[0][0] = "2016200600";
                tab[0][1] = "Mourad";
                tab[0][2] = "MAMASSI";

                tab[1][0] = "2016200644";
                tab[1][1] = "Youssef";
                tab[1][2] = "DANINE";

                tab[2][0] = "2012250801";
                tab[2][1] = "Nicolas";
                tab[2][2] = "VAUTRIN";


                tab[3][0] = "2015200579";
                tab[3][1] = "Nicolas";
                tab[3][2] = "DECROIX";
//                tab[0] = "2016200644";
//                tab[0] = "2016200600";
//                tab[0] = "2016200600";
//                tab[0] = "2016200600";
//                tab[0] = "2016200600";

                Toast toast = null;

                for (int i = 0; i < 9; i++) {
                    if (contents.equals(tab[i][0])) {
                        toast = Toast.makeText(this, tab[i][1] + " " + tab[i][2], Toast.LENGTH_LONG);
//                    toast.show();
                    }
                }
//                if(contents.equals("2016200600")){
//                     toast = Toast.makeText(this, "Mourad MAMASSI", Toast.LENGTH_LONG);
////                    toast.show();
//                }else if(contents.equals("2016200644")){
//                     toast = Toast.makeText(this, "Youssef DANINE", Toast.LENGTH_LONG);
//
//                }

                toast.show();
//                Toast toast = Toast.makeText(this, "Content:" + contents + " Format:" + format, Toast.LENGTH_LONG);
//                toast.show();

                Intent intent2 = new Intent(this, Main2Activity.class);
                Bundle bundle = new Bundle();

//Add your data to bundle
                bundle.putString("codeqr", contents);
                intent2.putExtras(bundle);
                startActivity(intent2);

            }
        }
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Main Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }
}
