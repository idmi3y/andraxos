package com.thecrackertechnology.andrax;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.thecrackertechnology.dragonterminal.bridge.Bridge;
import com.thecrackertechnology.dragonterminal.bridge.SessionId;

import me.ibrahimsn.particle.ParticleView;

public class Dco_Information_Gathering extends Activity {

    int REQUEST_CODE_RUN = 1;
    private SessionId lastSessionId;
    ParticleView particleView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        super.onCreate(savedInstanceState);


        setContentView(R.layout.dco_information_gathering);

        particleView = findViewById(R.id.particleView_dco_info);

        CardView cardviewhping = findViewById(R.id.card_view_hping3);
        CardView cardviewnping = findViewById(R.id.card_view_nping);
        CardView cardviewbettercap = findViewById(R.id.card_view_bettercap);
        CardView cardviewwhois = findViewById(R.id.card_view_whois);
        CardView cardviewlbd = findViewById(R.id.card_view_lbd);
        CardView cardviewdig = findViewById(R.id.card_view_dig);
        CardView cardviewdnsrecon = findViewById(R.id.card_view_dnsrecon);
        CardView cardviewrecondog = findViewById(R.id.card_view_recondog);
        CardView cardviewraccoon = findViewById(R.id.card_view_raccoon);
        CardView cardviewdnscracker = findViewById(R.id.card_view_dnscracker);
        CardView cardviewsmtpuserenum = findViewById(R.id.card_view_smtpuserenum);
        CardView cardviewfirewalk = findViewById(R.id.card_view_firewalk);
        CardView cardviewbraa = findViewById(R.id.card_view_braa);
        CardView cardview0trace = findViewById(R.id.card_view_0trace);
        CardView cardviewfierce = findViewById(R.id.card_view_fierce);
        CardView cardviewautomater = findViewById(R.id.card_view_automater);
        CardView cardviewdmitry = findViewById(R.id.card_view_dmitry);
        CardView cardviewintrace = findViewById(R.id.card_view_intrace);
        CardView cardviewsshauditor = findViewById(R.id.card_view_ssh_auditor);
        CardView cardviewstheharvester = findViewById(R.id.card_view_theharvester);
        CardView cardviewgoca = findViewById(R.id.card_view_goca);
        CardView cardviewsublist3r = findViewById(R.id.card_view_sublist3r);
        CardView cardviewchameleon = findViewById(R.id.card_view_chameleon);
        CardView cardviewdnsmap = findViewById(R.id.card_view_dnsmap);
        CardView cardviewvault = findViewById(R.id.card_view_vault);
        CardView cardviewxray = findViewById(R.id.card_view_xray);
        CardView cardviewgasmask = findViewById(R.id.card_view_gasmask);
        CardView cardviewtldscanner = findViewById(R.id.card_view_tld_scanner);
        CardView cardviewamass = findViewById(R.id.card_view_amass);
        CardView cardviewnettacker = findViewById(R.id.card_view_nettacker);
        CardView cardviewonesixtyone = findViewById(R.id.card_view_onesixtyone);
        CardView cardviewarping = findViewById(R.id.card_view_arping);
        CardView cardviewdnsdict6 = findViewById(R.id.card_view_dnsdict6);
        CardView cardviewinverselookup6 = findViewById(R.id.card_view_inverselookup6);
        CardView cardviewthcping6 = findViewById(R.id.card_view_thcping6);
        CardView cardviewtrace6 = findViewById(R.id.card_view_trace6);
        CardView cardviewnetdiscover = findViewById(R.id.card_view_netdiscover);
        CardView cardviewsnmpwn = findViewById(R.id.card_view_snmpwn);


        cardviewhping.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                run_hack_cmd("hping3 --help");

            }
        });

        cardviewbettercap.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                run_hack_cmd("bettercap");

            }
        });

        cardviewnping.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                run_hack_cmd("nping");

            }
        });

        cardviewwhois.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                run_hack_cmd("whois");

            }
        });

        cardviewlbd.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                run_hack_cmd("lbd");

            }
        });

        cardviewdig.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                run_hack_cmd("dig -h");

            }
        });

        cardviewdnsrecon.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                run_hack_cmd("dnsrecon");

            }
        });

        cardviewraccoon.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                run_hack_cmd("raccoon --help");

            }
        });

        cardviewdnscracker.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                run_hack_cmd("dns-cracker");

            }
        });

        cardviewsmtpuserenum.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                run_hack_cmd("smtp-user-enum");

            }
        });

        cardviewonesixtyone.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                run_hack_cmd("onesixtyone");

            }
        });

        cardviewfirewalk.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                run_hack_cmd("firewalk");

            }
        });

        cardview0trace.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                run_hack_cmd("0trace.sh");

            }
        });

        cardviewbraa.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                run_hack_cmd("braa");

            }
        });

        cardviewfierce.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                run_hack_cmd("fierce --help");

            }
        });

        cardviewautomater.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                run_hack_cmd("automater -h");

            }
        });

        cardviewdmitry.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                run_hack_cmd("dmitry");

            }
        });

        cardviewintrace.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                run_hack_cmd("intrace");

            }
        });

        cardviewsshauditor.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                run_hack_cmd("ssh-auditor");

            }
        });

        cardviewstheharvester.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                run_hack_cmd("theharvester");

            }
        });

        cardviewgoca.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                run_hack_cmd("goca");

            }
        });

        cardviewchameleon.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                run_hack_cmd("chameleon -h");

            }
        });

        cardviewdnsmap.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                run_hack_cmd("dnsmap");

            }
        });

        cardviewvault.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                run_hack_cmd("vault");

            }
        });


        /**
         *
         * Help me, i'm dying...
         *
         **/

        cardviewxray.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                run_hack_cmd("xray");

            }
        });

        cardviewgasmask.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                run_hack_cmd("gasmask");

            }
        });

        cardviewtldscanner.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                run_hack_cmd("tld_scanner");

            }
        });

        cardviewamass.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                run_hack_cmd("amass");

            }
        });

        cardviewsublist3r.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                run_hack_cmd("sublist3r");

            }
        });

        cardviewrecondog.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                run_hack_cmd("recondog");

            }
        });

        cardviewnettacker.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                run_hack_cmd("nettacker");

            }
        });

        cardviewarping.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                run_hack_cmd("arping");

            }
        });

        cardviewdnsdict6.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                run_hack_cmd("dnsdict6");

            }
        });

        cardviewinverselookup6.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                run_hack_cmd("inverse_lookup6");

            }
        });

        cardviewthcping6.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                run_hack_cmd("thcping6");

            }
        });

        cardviewtrace6.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                run_hack_cmd("trace6");

            }
        });

        cardviewnetdiscover.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                run_hack_cmd("netdiscover");

            }
        });

        cardviewsnmpwn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                run_hack_cmd("snmpwn --help");

            }
        });


    }

    public void run_hack_cmd(String cmd) {

        Intent intent = Bridge.createExecuteIntent(cmd);
        startActivity(intent);

    }

    @Override
    public void onPause() {
        particleView.pause();
        super.onPause();
        finish();
    }

}
