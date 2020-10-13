package com.a3wa.webservice.webservice;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.squareup.picasso.Picasso;

import java.util.List;

public class Adapter extends ArrayAdapter<Model>{


        public Adapter(Context context, List<Model> categorie){
            super(context,0,categorie);
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

            if(convertView == null) {
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.template,parent,false);
            }

            ViewHolder viewHolder = (ViewHolder) convertView.getTag();

            if(viewHolder == null){
                viewHolder = new ViewHolder(convertView);
                convertView.setTag(viewHolder);
            }

            Model model = getItem(position);

            viewHolder.getTxtTitre().setText(model.getTitre());
            Picasso.get().load(model.getPhoto()).into(viewHolder.getImgView());


            return convertView;
        }
}


