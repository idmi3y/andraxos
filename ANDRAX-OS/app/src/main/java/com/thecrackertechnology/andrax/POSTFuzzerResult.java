package com.thecrackertechnology.andrax;

import android.app.ProgressDialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import static java.security.AccessController.getContext;

public class POSTFuzzerResult extends AppCompatActivity {

    TextView textresult;
    TextView textresult02;
    TextView hackedmatch;
    EditText editmatch;
    String site;
    String posthack;
    String pattern;
    String cookie;
    String useragent;
    String bufferlinelist = "";

    /**
     *
     * Help me, i'm dying...
     *
     **/

    String textprogress = "";

    ProgressDialog dialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_postfuzzer_result);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        dialog = ProgressDialog.show(POSTFuzzerResult.this, null,"Hacking... This can take a long time.");
        dialog.setCancelable(false);


        Bundle extras = getIntent().getExtras();
        if(extras !=null){
            site = extras.getString("SITE");
            posthack = extras.getString("POSTHACK");
            pattern = extras.getString("PATTERN");
            cookie = extras.getString("COOKIE");
            useragent = extras.getString("USERAGENT");
        } else {

        }


        textresult02 = (TextView) findViewById(R.id.textpostresult02);
        hackedmatch = (TextView) findViewById(R.id.textviewhackedpost);

        editmatch = (EditText) findViewById(R.id.editTextpostoutputbytes);

        Button btngetout = (Button) findViewById(R.id.buttonpostmatch);






        btngetout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

               String match = editmatch.getText().toString();

                try {



                    Process process = Runtime.getRuntime().exec("su -c cat /data/data/com.thecrackertechnology.andrax/ANDRAX/postfuzzer/output | grep POST | grep -v " + match);



                    BufferedReader reader = new BufferedReader(
                            new InputStreamReader(process.getInputStream()));
                    int read;

                    char[] buffer = new char[8000];
                    StringBuffer output = new StringBuffer();
                    while ((read = reader.read(buffer)) > 0) {
                        output.append(buffer, 0, read );

                        hackedmatch.append("HACKED!\n\n " + output.toString() + "\n");

                    }
                    reader.close();






                    process.waitFor();




                } catch (IOException e) {
                    throw new RuntimeException(e);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }


            }
        });


        hackall task = new hackall();
        task.execute();



    }


    private class hackall extends AsyncTask<Void, Void, String> {

        @Override
        protected String doInBackground(Void... params) {
            String counter = "";

            ArrayList<String> listlines = new ArrayList<String>();
            try {

                Process process = Runtime.getRuntime().exec("su -c /data/data/com.thecrackertechnology.andrax/ANDRAX/bin/postfuzzer " + "/data/data/com.thecrackertechnology.andrax/ANDRAX/postfuzzer/'*.txt' " + "\"" + site + "\"" + " " + "\"" + posthack + "\"" + " " + "\"" + pattern + "\"" + " " + "\"" + cookie + "\"" + " " + "\"" + useragent + "\"" + " | grep POST | tee /data/data/com.thecrackertechnology.andrax/ANDRAX/postfuzzer/output");

                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(process.getInputStream()));



                while ((bufferlinelist = reader.readLine()) != null) {




                    listlines.add(bufferlinelist);
                }

                if((bufferlinelist = reader.readLine()) == null){



                }


                reader.close();







                process.waitFor();




            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }



            return listlines.toString();
        }


        protected void onPostExecute(String result) {
            String outtext;
            String outtext02;

            outtext = result.substring(1);
            outtext02 = outtext.substring(0, outtext.length()-1);


                textresult02.append(outtext02.replace(",", " \n"));



            dialog.dismiss();

        }


    }





}
