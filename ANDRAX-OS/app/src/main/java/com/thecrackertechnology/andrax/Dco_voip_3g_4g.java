package com.thecrackertechnology.andrax;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.Window;

import com.thecrackertechnology.dragonterminal.bridge.Bridge;

import me.ibrahimsn.particle.ParticleView;

public class Dco_voip_3g_4g extends Activity {

    ParticleView particleView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        super.onCreate(savedInstanceState);


        setContentView(R.layout.dco_voip_3g_4g);

        particleView = findViewById(R.id.particleView_dco_voip);

        CardView cardviewsipsak = findViewById(R.id.card_view_sipsak);
        CardView cardviewenumiax = findViewById(R.id.card_view_enumiax);
        CardView cardviewvsaudit = findViewById(R.id.card_view_vsaudit);
        CardView cardviewiaxflood = findViewById(R.id.card_view_iaxflood);
        CardView cardviewinviteflood = findViewById(R.id.card_view_inviteflood);
        CardView cardviewrtpflood = findViewById(R.id.card_view_rtpflood);
        CardView cardviewrtpbreak = findViewById(R.id.card_view_rtpbreak);
        CardView cardviewrtpinsertsound = findViewById(R.id.card_view_rtpinsertsound);
        CardView cardviewrtpmixsound = findViewById(R.id.card_view_rtpmixsound);



        cardviewenumiax.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                run_hack_cmd("enumiax");

            }
        });

        cardviewsipsak.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                run_hack_cmd("sipsak");

            }
        });

        cardviewvsaudit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                run_hack_cmd("vsaudit");

            }
        });

        cardviewiaxflood.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                run_hack_cmd("iaxflood");

            }
        });

        cardviewinviteflood.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                run_hack_cmd("inviteflood");

            }
        });

        cardviewrtpflood.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                run_hack_cmd("rtpflood");

            }
        });

        cardviewrtpbreak.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                run_hack_cmd("rtpbreak");

            }
        });

        cardviewrtpinsertsound.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                run_hack_cmd("rtpinsertsound");

            }
        });

        cardviewrtpmixsound.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                run_hack_cmd("rtpmixsound");

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
