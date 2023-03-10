package com.thecrackertechnology.andrax;

import android.annotation.SuppressLint;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.thecrackertechnology.dragonterminal.bridge.Bridge;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

import static android.app.Activity.RESULT_OK;

public class RadareFragment extends Fragment implements View.OnClickListener{


    Button btnselect;
    Button btnradareit;
    RadioButton httpradio;
    RadioButton terminalradio;
    EditText editfiletore;
    EditText editbindto;
    String interfacere2;

    static int buttonChecked;

    public RadareFragment() {

        /**
         *
         * Help me, i'm dying...
         *
         **/

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.fragment_radare, container, false);

        btnselect = rootView.findViewById(R.id.buttonselect);
        btnradareit = rootView.findViewById(R.id.buttonreit);

        httpradio = rootView.findViewById(R.id.radioButtonHttp);
        terminalradio = rootView.findViewById(R.id.radioButtonTerminal);

        terminalradio.setChecked(true);

        editfiletore = rootView.findViewById(R.id.editTextfiletore);
        editbindto = rootView.findViewById(R.id.editTextBIND);

        btnselect.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("*/*");
                startActivityForResult(intent, 7);

            }
        });

        btnradareit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                if(httpradio.isChecked()){
                    interfacere2 = "http";
                } else {
                    interfacere2 = "terminal";
                }

                String filetore = editfiletore.getText().toString();
                String bindaddr = editbindto.getText().toString();

                if(interfacere2.equals("http")){

                    run_hack_cmd("radare2 -e http.bind=" + bindaddr + " -e http.root=/data/data/com.thecrackertechnology.andrax/ANDRAX/radare2/share/radare2/3.0.0-git/www/ -c=h " + filetore);



                } else {


                    run_hack_cmd("radare2 " + filetore);


                }

            }
        });











        return rootView;



    }



    public void onClick(View v) {

    }


    /**
     * Called when leaving the activity
     */
    @Override
    public void onPause() {

        super.onPause();
    }

    /**
     * Called when returning to the activity
     */
    @Override
    public void onResume() {

        super.onResume();

    }

    /**
     * Called before the activity is destroyed
     */
    @Override
    public void onDestroy() {

        super.onDestroy();
    }



    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {


        switch (requestCode) {
            case 7:
                if (resultCode == RESULT_OK) {
                    String PathHolder = data.getData().toString();
                    Uri uri = data.getData();


                    String mypath = null;
                    try {
                        mypath = getFilePath(getActivity(), uri);
                    } catch (URISyntaxException e) {
                        e.printStackTrace();
                    }

                    Toast.makeText(getActivity(), mypath, Toast.LENGTH_LONG).show();

                    editfiletore.setText(mypath);
                }
                break;
        }
    }




    @SuppressLint("NewApi")
    public static String getFilePath(Context context, Uri uri) throws URISyntaxException {
        String selection = null;
        String[] selectionArgs = null;

        if (Build.VERSION.SDK_INT >= 19 && DocumentsContract.isDocumentUri(context.getApplicationContext(), uri)) {
            if (isExternalStorageDocument(uri)) {
                final String docId = DocumentsContract.getDocumentId(uri);
                final String[] split = docId.split(":");
                return Environment.getExternalStorageDirectory() + "/" + split[1];
            } else if (isDownloadsDocument(uri)) {
                final String id = DocumentsContract.getDocumentId(uri);
                uri = ContentUris.withAppendedId(
                        Uri.parse("content://downloads/public_downloads"), Long.valueOf(id));
            } else if (isMediaDocument(uri)) {
                final String docId = DocumentsContract.getDocumentId(uri);
                final String[] split = docId.split(":");
                final String type = split[0];
                if ("image".equals(type)) {
                    uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                } else if ("video".equals(type)) {
                    uri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                } else if ("audio".equals(type)) {
                    uri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
                }
                selection = "_id=?";
                selectionArgs = new String[]{
                        split[1]
                };
            }
        }
        if ("content".equalsIgnoreCase(uri.getScheme())) {
            String[] projection = {
                    MediaStore.Images.Media.DATA
            };
            Cursor cursor = null;
            try {
                cursor = context.getContentResolver()
                        .query(uri, projection, selection, selectionArgs, null);
                int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
                if (cursor.moveToFirst()) {
                    return cursor.getString(column_index);
                }
            } catch (Exception e) {
            }
        } else if ("file".equalsIgnoreCase(uri.getScheme())) {
            return uri.getPath();
        }
        return null;
    }

    public static boolean isExternalStorageDocument(Uri uri) {
        return "com.android.externalstorage.documents".equals(uri.getAuthority());
    }

    public static boolean isDownloadsDocument(Uri uri) {
        return "com.android.providers.downloads.documents".equals(uri.getAuthority());
    }

    public static boolean isMediaDocument(Uri uri) {
        return "com.android.providers.media.documents".equals(uri.getAuthority());
    }

    public void run_hack_cmd(String cmd) {

        Intent intent = Bridge.createExecuteIntent(cmd);
        startActivity(intent);

    }

}
