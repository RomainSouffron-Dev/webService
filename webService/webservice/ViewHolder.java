package com.a3wa.webservice.webservice;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ViewHolder {

    private TextView txtTitre;
    private ImageView imgView;

    public ViewHolder(View convertView){
        this.txtTitre = convertView.findViewById(R.id.txtTitre);
        this.imgView = convertView.findViewById(R.id.imgView);
    }

    public TextView getTxtTitre() {
        return txtTitre;
    }

    public void setTxtTitre(TextView txtTitre) {
        this.txtTitre = txtTitre;
    }

    public ImageView getImgView() {
        return imgView;
    }
}
