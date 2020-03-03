package com.assosiatedicoding.programpengembangantowerproviderkabsukoharjo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {
    ImageView fotoTower;
    TextView namaTower;
    TextView keteranganTower;

    private void initializeWidget() {

        fotoTower = (ImageView) findViewById(R.id.fotoTower);
        namaTower = (TextView) findViewById(R.id.namaTower);
        keteranganTower = (TextView) findViewById(R.id.keteranganTower);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        initializeWidget();
        Intent i = this.getIntent();
        String name = i.getExtras().getString("NAMA_KEY");
        String description = i.getExtras().getString("DESKRIPSI_KEY");
        String imageURL = i.getExtras().getString("IMAGE_KEY");
        namaTower.setText(name);
        keteranganTower.setText(description);
        Picasso.with(this)
                .load(imageURL)
                .placeholder(R.drawable.imagepreview)
                .fit()
                .centerCrop()
                .into(fotoTower);
    }
}