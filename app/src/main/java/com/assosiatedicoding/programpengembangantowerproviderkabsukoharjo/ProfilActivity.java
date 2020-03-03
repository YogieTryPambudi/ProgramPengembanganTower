package com.assosiatedicoding.programpengembangantowerproviderkabsukoharjo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ProfilActivity extends AppCompatActivity implements View.OnClickListener{

    //firebase auth object
    private FirebaseAuth firebaseAuth;

    //view objects
    private Button btnLogout;
    private LinearLayout Data,Sea;
    private TextView baca;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);

        //initializing firebase authentication object
        firebaseAuth = FirebaseAuth.getInstance();

        //if the user is not logged in
        //that means current user will return null
        if(firebaseAuth.getCurrentUser() == null){
            //closing this activity
            finish();
            //starting login activity
            startActivity(new Intent(this, LoginActivity.class));
        }

        //getting current user
        FirebaseUser user = firebaseAuth.getCurrentUser();

        //initializing views
        btnLogout = (Button) findViewById(R.id.btn_logout);
        Data = (LinearLayout) findViewById(R.id.Data);
        Sea = (LinearLayout) findViewById(R.id.Sea);
        baca = (TextView)findViewById(R.id.baca);


        //adding listener to button
        btnLogout.setOnClickListener(this);
        Data.setOnClickListener(this);
        Sea.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        //if logout is pressed
        if(view == btnLogout){
            //logging out the user
            firebaseAuth.signOut();
            //closing activity
            finish();
            //starting login activity
            startActivity(new Intent(this, LoginActivity.class));
        }
        switch (view.getId()){
            case R.id.Data:
                Intent moveIntent = new Intent(ProfilActivity.this,FirebaseTambah.class);
                startActivity(moveIntent);
                Toast.makeText(this,"Tambah Data Dipilih", Toast.LENGTH_SHORT).show();
                break;
        }
        switch (view.getId()){
            case R.id.Sea:
                openImagesActivity();
        }
    }
    private void openImagesActivity(){
        Intent intent = new Intent(this,ImagesActivity.class);
        startActivity(intent);
        Toast.makeText(this,"Lihat Data Dipilih",Toast.LENGTH_SHORT).show();
    }
}
