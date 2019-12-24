package com.thecrackertechnology.andrax;

import android.app.DownloadManager;
import android.app.WallpaperManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.thecrackertechnology.dragonterminal.bridge.Bridge;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class DnstoolFragment extends Fragment  implements View.OnClickListener{

    public String interfacessl;
    public String domainssl;
    public String hostssl;

    EditText editTextinterface;
    EditText editTextdomain;
    EditText editTexthost;


    public DnstoolFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.fragment_dnstool, container, false);

        Button btncrackssl = (Button) rootView.findViewById(R.id.btnsslcracker);

        editTextinterface = (EditText) rootView.findViewById(R.id.editinterface);
        editTextdomain = (EditText) rootView.findViewById(R.id.editdomain);
        editTexthost = (EditText) rootView.findViewById(R.id.edithost);



        btncrackssl.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                interfacessl = editTextinterface.getText().toString();
                domainssl = editTextdomain.getText().toString();
                hostssl = editTexthost.getText().toString();

                run_hack_cmd("sslcracker " + "-i " + interfacessl + " " + "-dns " + domainssl + " " + "-ip " + hostssl);



            }
        });

        return rootView;



    }



    public void onClick(View v) {

        /**
         *
         * Help me, i'm dying...
         *
         **/

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

    public void run_hack_cmd(String cmd) {

        Intent intent = Bridge.createExecuteIntent(cmd);
        startActivity(intent);

    }

}
