package com.tahirietrit.socialapp.model;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.tahirietrit.socialapp.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ListAdapter extends BaseAdapter {
    Context ctx;
    LayoutInflater infalter;
    ArrayList<Posts> posts;
    Intent intent;
    private Date dateThen= null;
    private Date dateNow = java.util.Calendar.getInstance().getTime();
    private String llojiKohes = "";

    public static final String USERNAME_MESSAGE = "username_text";
    public static final String AGOTIME_MESSAGE = "lastname_text";
    //public static final String TEL_MESSAGE = "tel_text";
    //public static final String IMAGEINTR_MESSAGE = "imageIntR_text";

    public void setPosts(ArrayList<Posts> posts) {
        this.posts = posts;
    }

    public void setIntent(Intent intent) {
        this.intent = intent;
    }

    public ListAdapter(Context ctx, LayoutInflater inflater) {
        this.ctx = ctx;
        this.infalter = inflater;
    }

    @Override
    public int getCount() {
        return posts.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = infalter.inflate(R.layout.list_item, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.username.setText(posts.get(position).getUsername());
        holder.pershkrimi.setText(posts.get(position).getPershkrimi());
        String dataString  = posts.get(position).getCreatedDate();

        try {
            dateThen = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(dataString);
            int koha = Diferenca();
            holder.agoTime.setText("Posted about " + koha + " " + llojiKohes + " ago.");
        } catch (ParseException e) {
            System.out.println("GABIMET NDODHIN, shpeshhere NA LODHIN");
            e.printStackTrace();
        }

        loadImageFromUrl(posts.get(position).getPhotoUrl(),holder);




        holder.listItemLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra(USERNAME_MESSAGE, posts.get(position).getUsername());
                intent.putExtra(AGOTIME_MESSAGE, posts.get(position).getCreatedDate());
                ctx.startActivity(intent);
            }
        });

        return convertView;
    }
    private void loadImageFromUrl(String url, ViewHolder holder) {
        Picasso.with(ctx).load(url).placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .into(holder.fotojaEPostuarImageView, new com.squareup.picasso.Callback() {
                    @Override
                    public void onSuccess() {
                        System.out.println("FUNKSIONOII");
                    }

                    @Override
                    public void onError() {
                        System.out.println("NUK FUNKSIONOII");
                    }
                });

        Picasso.with(ctx).load(url).placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .into(holder.profiliImageView, new com.squareup.picasso.Callback() {
                    @Override
                    public void onSuccess() {
                        System.out.println("FUNKSIONOII");
                    }

                    @Override
                    public void onError() {
                        System.out.println("NUK FUNKSIONOII");
                    }
                });

    }


    class ViewHolder {
        ImageView profiliImageView;
        TextView username;
        TextView agoTime;
        ImageView fotojaEPostuarImageView;
        TextView pershkrimi;
        LinearLayout listItemLinearLayout;

        public ViewHolder(View view) {
            profiliImageView = view.findViewById(R.id.profili_ImageView);
            username = view.findViewById(R.id.username_TextView);
            agoTime = view.findViewById(R.id.ago_TextView);
            fotojaEPostuarImageView = view.findViewById(R.id.fotoja_e_Postuar);
            pershkrimi = view.findViewById(R.id.pershkrimi_TextView);
            listItemLinearLayout = view.findViewById(R.id.list_item_LinearLayout);
        }
    }
    private long DiferencaNeSekonda()
    {
        long diferencaNeMilisekonda = dateNow.getTime() - dateThen.getTime();
        long sekondat = (long) (diferencaNeMilisekonda/1000);
        return sekondat;
    }
    private long DiferencaNeMinuta()
    {
        long minutat = (long) (DiferencaNeSekonda()/60);
        return minutat;
    }
    private long DiferencaNeOre()
    {
        long oret = (long) (DiferencaNeMinuta()/60);
        return oret;
    }
    private int DiferencaNeDite()
    {
        int ditet = (int) (DiferencaNeOre()/24);
        return ditet;
    }
    private int DiferencaNeJave()
    {
        int javet = (int) (DiferencaNeDite()/7);
        return javet;
    }
    private int DiferencaNeMuaj()
    {
        int muajt = (int) (DiferencaNeDite()/30);
        return muajt;
    }
    private int DiferencaNeVite()
    {
        int vitet = (int) (DiferencaNeMuaj()/12);
        return vitet;
    }

    private int Diferenca()
    {
        int koha = 0;
        if(DiferencaNeSekonda()<60)
        {
            koha = (int) DiferencaNeSekonda();
            if(koha==1) {
                llojiKohes = "second";
            }
            else {
                llojiKohes = "seconds";
            }
        }
        else if(DiferencaNeMinuta()<60)
        {
            koha = (int) DiferencaNeMinuta();
            if(koha==1) {
                llojiKohes = "minute";
            }
            else {
                llojiKohes = "minutes";
            }
        }
        else if(DiferencaNeOre()<24)
        {
            koha = (int) DiferencaNeOre();
            if(koha==1) {
                llojiKohes = "hour";
            }
            else {
                llojiKohes = "hours";
            }
        }
        else if(DiferencaNeDite()<7)
        {
            koha = DiferencaNeDite();
            if(koha==1) {
                llojiKohes = "day";
            }
            else {
                llojiKohes = "days";
            }
        }
        else if(DiferencaNeDite()<30)
        {
            koha = DiferencaNeJave();
            if(koha==1) {
                llojiKohes = "week";
            }
            else {
                llojiKohes = "weeks";
            }
        }
        else if(DiferencaNeMuaj()<12)
        {
            koha = DiferencaNeMuaj();
            if(koha==1) {
                llojiKohes = "month";
            }
            else {
                llojiKohes = "months";
            }
        }
        else
        {
            koha = DiferencaNeVite();
            if(koha==1) {
                llojiKohes = "year";
            }
            else {
                llojiKohes = "years";
            }
        }
        return koha;
    }
}