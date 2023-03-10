package com.thecrackertechnology.andrax;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import java.util.Collections;
import java.util.List;

import static com.bumptech.glide.gifdecoder.GifHeaderParser.TAG;

public class AdapterTutorial extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mContext;
    //private Context mContext;
    private LayoutInflater inflater;
    List<DataTutorial> data= Collections.emptyList();
    DataTutorial current;
    int currentPos=0;



    // create constructor to innitilize context and data sent from MainActivity
    AdapterTutorial(Context context, List<DataTutorial> data){
        this.mContext=context;

        inflater=LayoutInflater.from(mContext);
        this.data=data;
    }

    // Inflate the layout when viewholder created
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=inflater.inflate(R.layout.container_tutorial, parent,false);
        final MyHolder holder=new MyHolder(view);



        return holder;
    }


    // Bind data
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        // Get current position of item in recyclerview to bind data and assign values from list
        MyHolder myHolder= (MyHolder) holder;
        final DataTutorial current=data.get(position);
        myHolder.textTutorialName.setText(current.TutorialName);
        myHolder.textTutorialdesc.setText(current.Tutorialdesc);
        myHolder.textTutorialLink = current.Tutoriallink;

        myHolder.cardtutorial.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(mContext,"Tutorial: " + current.TutorialName,Toast.LENGTH_SHORT).show();
                //Toast.makeText(context,"LINK: " + current.Tutoriallink,Toast.LENGTH_LONG).show();

                Intent intentweb = new Intent(Intent.ACTION_VIEW, Uri.parse(current.Tutoriallink));
                AdapterTutorial.this.mContext.startActivity(intentweb);


            }
        });


        // load image into imageview using glide
        Glide.with(mContext).load("https://andrax.thecrackertechnology.com/app-imgs/" + current.TutorialImage)
                .placeholder(R.drawable.andrax_banner)
                .error(R.drawable.andrax_banner)
                .into(myHolder.imgTutorialimage);



    }

    // return total item from List
    @Override
    public int getItemCount() {
        return data.size();
    }


    class MyHolder extends RecyclerView.ViewHolder{

        TextView textTutorialName;
        ImageView imgTutorialimage;
        TextView textTutorialdesc;
        String textTutorialLink;

        CardView cardtutorial;





        // create constructor to get widget reference
        public MyHolder(View itemView) {
            super(itemView);
            textTutorialName = (TextView) itemView.findViewById(R.id.tutorialnome);
            imgTutorialimage = (ImageView) itemView.findViewById(R.id.imagetutorial);
            textTutorialdesc = (TextView) itemView.findViewById(R.id.tutorialdesc);
            cardtutorial = (CardView) itemView.findViewById(R.id.card_view_tutorial);

        }



    }

}
