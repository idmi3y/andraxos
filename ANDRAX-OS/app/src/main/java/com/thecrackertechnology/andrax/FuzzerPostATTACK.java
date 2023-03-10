package com.thecrackertechnology.andrax;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FuzzerPostATTACK extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    WebView webcodeview;
    String website;
    EditText postpageattack;
    EditText postattack;
    EditText patternattack;
    EditText cookie;
    Spinner useragent;
    String spinneritem;
    String postpagetohack;
    String posttohack;
    String patterntohack;
    String cookietohack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fuzzer_post_attack);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Bundle extras = getIntent().getExtras();
        if(extras !=null){
            website = extras.getString("HOSTKEYtwo");
        } else {
            //website = "http://www.google.com";
        }

        webcodeview = (WebView) findViewById(R.id.webviewcodeattack);

        postpageattack = (EditText) findViewById(R.id.editTextpostpage);
        postattack = (EditText) findViewById(R.id.editTextpostattack);
        patternattack = (EditText) findViewById(R.id.editTextpatternattack);
        cookie = (EditText) findViewById(R.id.editTextcookieattack);
        useragent = (Spinner) findViewById(R.id.spinneruseragentattack);

        Button btnattack = (Button) findViewById(R.id.buttonattackit);



        
        useragent.setOnItemSelectedListener(this);


        List<String> attackuseragents = new ArrayList<String>();
        attackuseragents.add("Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/47.0.2526.73 Safari/537.36");
        attackuseragents.add("Opera/9.80 (Windows NT 6.0) Presto/2.12.388 Version/12.14");
        attackuseragents.add("Mozilla/5.0 (Windows NT 6.3; rv:36.0) Gecko/20100101 Firefox/55.3");
        attackuseragents.add("Mozilla/5.0 (Windows; U; Windows NT 6.1; en-US) AppleWebKit/533.20.25 (KHTML, like Gecko) Version/5.0.4 Safari/533.20.27");
        attackuseragents.add("Mozilla/5.0 (Windows NT 10.0; Trident/7.0; rv:11.0) like Gecko");
        attackuseragents.add("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/42.0.2311.135 Safari/537.36 Edge/12.10240");
        attackuseragents.add("Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/41.0.2227.0 Safari/537.36");
        attackuseragents.add("Opera/9.80 (X11; Linux i686; Ubuntu/14.10) Presto/2.12.388 Version/12.16");
        attackuseragents.add("Mozilla/5.0 (X11; Linux i586; rv:53.0.2) Gecko/20100101 Firefox/53.0.2");
        attackuseragents.add("Mozilla/5.0 (X11; U; Linux x86_64; en-us) AppleWebKit/531.2+ (KHTML, like Gecko) Version/5.0 Safari/531.2");
        attackuseragents.add("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_10_1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/41.0.2227.1 Safari/537.36");
        attackuseragents.add("Opera/9.80 (Macintosh; Intel Mac OS X 10.6.8; U; fr) Presto/2.9.168 Version/11.52");
        attackuseragents.add("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_10; rv:33.0) Gecko/20100101 Firefox/33.0");
        attackuseragents.add("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_1) AppleWebKit/601.2.7 (KHTML, like Gecko) Version/9.0.1 Safari/601.2.7");
        attackuseragents.add("Mozilla/5.0 (iPhone; CPU iPhone OS 9_2 like Mac OS X) AppleWebKit/601.1 (KHTML, like Gecko) CriOS/47.0.2526.70 Mobile/13C71 Safari/601.1.46");
        attackuseragents.add("Mozilla/5.0 (Linux; U; Android 4.4.4; Nexus 5 Build/KTU84P) AppleWebkit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30");
        attackuseragents.add("Mozilla/5.0 (Linux; U; Android 5.1.1; Nexus 5 Build/KTU84P) AppleWebkit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30");
        attackuseragents.add("Mozilla/5.0 (Linux; U; Android 6.0.0; Nexus 5 Build/KTU84P) AppleWebkit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30");
        attackuseragents.add("Mozilla/5.0 (Linux; U; Android 7.0.0; Nexus 5 Build/KTU84P) AppleWebkit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30");
        attackuseragents.add("Mozilla/5.0 (Linux; U; Android 8.0.0; Nexus 5 Build/KTU84P) AppleWebkit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30");
        attackuseragents.add("Mozilla/5.0 (compatible; MSIE 9.0; Windows Phone OS 7.5; Trident/5.0; IEMobile/9.0)");
        attackuseragents.add("Nokia5250/10.0.011 (SymbianOS/9.4; U; Series60/5.0 Mozilla/5.0; Profile/MIDP-2.1 Configuration/CLDC-1.1 ) AppleWebKit/525 (KHTML, like Gecko) Safari/525 3gpp-gba");



        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, attackuseragents);


        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        /**
         *
         * Help me, i'm dying...
         *
         **/

        useragent.setAdapter(dataAdapter);


        btnattack.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                fuzzerposthack();

            }
        });




        webcodeview.getSettings().setJavaScriptEnabled(true);
        webcodeview.getSettings().setAllowContentAccess(true);
        webcodeview.setVerticalScrollBarEnabled(true);
        webcodeview.setHorizontalScrollBarEnabled(true);
        webcodeview.canGoBack();

        webcodeview.setWebChromeClient(new WebChromeClient());



        try {

            Process process = Runtime.getRuntime().exec("su -c cat /data/data/com.thecrackertechnology.andrax/ANDRAX/output | sed 's/^.*POST/POST/' | tail -n+5 | head -n-4 | sed '/Accept:/d'");



            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(process.getInputStream()));
            int read;
            char[] buffer = new char[8000];
            StringBuffer output = new StringBuffer();
            while ((read = reader.read(buffer)) > 0) {
                output.append(buffer, 0, read );
            }
            reader.close();


            process.waitFor();



                /*Codeview.with(getApplicationContext())
                        .withCode(output.toString())
                        .setStyle(Settings.WithStyle.XT256)
                        .setLang(Settings.Lang.JAVASCRIPT)
                        .into(webcodeview); */

            String myHtmlString = "<html><head>" +
                    "<link rel=\"stylesheet\" href=file:///android_asset/xt256.css>" +
                    "<script src=file:///android_asset/highlight.pack.js></script>" +
                    "<script>hljs.initHighlightingOnLoad();</script>" +
                    "</head><body>" +
                    "<pre><code class=\"http\">" + output.toString() + "</code></pre>" +
                    "</body></html>";
            webcodeview.loadDataWithBaseURL(null, myHtmlString, "text/html", "UTF-8", null);


        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }



    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        String item = parent.getItemAtPosition(position).toString();

        spinneritem = item;


        Toast.makeText(parent.getContext(), "Useragent: " + item, Toast.LENGTH_SHORT).show();


    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


    public void fuzzerposthack() {

        postpagetohack = postpageattack.getText().toString();
        posttohack = postattack.getText().toString();
        patterntohack = patternattack.getText().toString();
        cookietohack = cookie.getText().toString();

        Intent intent = new Intent(FuzzerPostATTACK.this, POSTFuzzerResult.class);
        intent.putExtra("SITE", website + "/" + postpagetohack);
        intent.putExtra("POSTHACK", posttohack);
        intent.putExtra("PATTERN", patterntohack);
        intent.putExtra("COOKIE", cookietohack);
        intent.putExtra("USERAGENT", spinneritem);
        startActivity(intent);

    }
}
