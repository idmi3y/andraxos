package com.thecrackertechnology.andrax;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.Window;

import com.thecrackertechnology.dragonterminal.bridge.Bridge;

import me.ibrahimsn.particle.ParticleView;

public class Dco_Packet_Crafting extends Activity {

    ParticleView particleView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        super.onCreate(savedInstanceState);



        setContentView(R.layout.dco_packet_crafting);

        particleView = findViewById(R.id.particleView_dco_packet);

        CardView cardviewhping = findViewById(R.id.card_view_hping3);
        CardView cardviewnping = findViewById(R.id.card_view_nping);
        CardView cardviewscapy = findViewById(R.id.card_view_scapy);
        CardView cardviewhexinject = findViewById(R.id.card_view_hexinject);
        CardView cardviewncat = findViewById(R.id.card_view_ncat);
        CardView cardviewfragmentation6 = findViewById(R.id.card_view_fragmentation6);
        CardView cardViewnemesis = findViewById(R.id.card_view_nemesis);


        cardviewhping.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                run_hack_cmd("hping3 --help");

            }
        });

        cardviewnping.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                run_hack_cmd("nping");

            }
        });

        cardviewscapy.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                run_hack_cmd("scapy");

            }
        });

        cardviewhexinject.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                run_hack_cmd("hexinject -h");

            }
        });

        /**
         *
         * Help me, i'm dying...
         *
         **/

        cardviewncat.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                run_hack_cmd("ncat -h");

            }
        });


        cardviewfragmentation6.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                run_hack_cmd("fragmentation6");

            }
        });

        cardViewnemesis.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                run_hack_cmd("nemesis");

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
