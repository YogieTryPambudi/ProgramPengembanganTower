package com.assosiatedicoding.programpengembangantowerproviderkabsukoharjo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView bgapp, clover,male,people;
    LinearLayout textsplash, texthome, menus,menu_about;
    Animation frombottom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        frombottom = AnimationUtils.loadAnimation(this, R.anim.frombottom);


        textsplash = (LinearLayout) findViewById(R.id.textsplash);
        texthome = (LinearLayout) findViewById(R.id.texthome);
        menus = (LinearLayout) findViewById(R.id.menus);
        menu_about = (LinearLayout)findViewById(R.id.menu_about);
        male = (ImageView)findViewById(R.id.male);
        people = (ImageView)findViewById(R.id.people);
        male.setOnClickListener(this);
        people.setOnClickListener(this);
        menu_about.setOnClickListener(this);

        bgapp.animate().translationY(-1900).setDuration(1000).setStartDelay(1000);
        clover.animate().alpha(0).setDuration(1000).setStartDelay(1000);
        textsplash.animate().translationY(140).alpha(0).setDuration(1000).setStartDelay(1000);

        texthome.startAnimation(frombottom);
        menus.startAnimation(frombottom);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.male:
                Intent moveIntent = new Intent(MainActivity.this,LoginActivity.class);
                startActivity(moveIntent);
                Toast.makeText(this,"Admin Dipilih",Toast.LENGTH_SHORT).show();
                break;
        }
        switch (v.getId()){
            case R.id.people:
                Intent moveintent = new Intent(MainActivity.this,ImagesActivity.class);
                startActivity(moveintent);
                Toast.makeText(this,"Umum Dipilih",Toast.LENGTH_SHORT).show();
        }
        switch (v.getId()){
            case R.id.menu_about:
                Intent moveintent = new Intent(MainActivity.this,detailMenuAbout.class);
                startActivity(moveintent);
                Toast.makeText(this,"Menu About Dipilih",Toast.LENGTH_SHORT).show();
        }
    }
}
