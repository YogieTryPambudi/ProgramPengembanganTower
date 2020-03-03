package com.assosiatedicoding.programpengembangantowerproviderkabsukoharjo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

public class detailMenuAbout extends AppCompatActivity {
    ImageView foto_ogie;
    TextView namayogie;
    TextView keterangan_email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_menu_about);
        foto_ogie = (ImageView)findViewById(R.id.foto_ogie);

    }
}
