package com.thecrackertechnology.andrax;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.thecrackertechnology.dragonterminal.bridge.Bridge;

import java.util.Objects;

import me.ibrahimsn.particle.ParticleView;

public class MainFragment extends Fragment  implements View.OnClickListener{

    public MainFragment() {

    }

    ParticleView particleView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_main, container, false);


        Button btnrun = (Button) rootView.findViewById(R.id.btnrun);
        Button btntutorials = (Button) rootView.findViewById(R.id.btntutorials);
        Button btnyoutube = (Button) rootView.findViewById(R.id.btnyoutube);
        Button btncontact = (Button) rootView.findViewById(R.id.btncontact);
        Button btnmanual = (Button) rootView.findViewById(R.id.btnmanual);

        ImageView imgmain = (ImageView) rootView.findViewById(R.id.imageViewmainbanner);

        //ImageView imgtraining = (ImageView) rootView.findViewById(R.id.imageView_training_banner);

        imgmain.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                clickimagerefresh();
            }
        });

        /** imgtraining.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                clicktraining();
            }
        }); **/

            btnrun.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {

                    run_hack_cmd("andrax");


                }
            });


        btntutorials.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(), TutorialActivity.class);
                startActivity(intent);

            }
        });

        btnyoutube.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/channel/UCbjj-0WFsITWSb_Xf9WE5EQ"));
                startActivity(intent);
            }
        });

        btncontact.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String mailto = "mailto:weidsom@thecrackertechnology.com" + "?subject=" + Uri.encode("ANDRAX Contact");

                Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
                emailIntent.setData(Uri.parse(mailto));

                try {
                    startActivity(emailIntent);
                } catch (ActivityNotFoundException e) {

                }
            }
        });

        btnmanual.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://andrax.thecrackertechnology.com/documentation"));
                startActivity(intent);
            }
        });


        particleView = rootView.findViewById(R.id.particleView);

        return rootView;


        /**
         *
         * Help me, i'm dying...
         *
         **/

    }

    public void clickimagerefresh() {
        //MainFragment fragment = new MainFragment();
        //android.support.v4.app.FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        //fragmentTransaction.replace(R.id.fragment_container, fragment);
        //fragmentTransaction.commit();
    }

    public void clicktraining() {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://androidhacking.thecrackertechnology.com/"));
        startActivity(intent);
    }



    public void onClick(View v) {

    }

    /**
     * Called when leaving the activity
     */

    @Override
    public void onPause() {
        particleView.pause();
        super.onPause();

    }

    /**
     * Called when returning to the activity
     */

    @Override
    public void onResume() {
        particleView.resume();
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
