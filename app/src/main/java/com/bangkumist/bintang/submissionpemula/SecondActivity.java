package com.bangkumist.bintang.submissionpemula;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    TextView tvTitleDetial, tvInfoDetail;
    ImageView imgDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Items clubItems = getIntent().getParcelableExtra("data");

        tvTitleDetial = findViewById(R.id.titleDetail);
        String text =  clubItems.getTitle();
        tvTitleDetial.setText(text);


        tvInfoDetail = findViewById(R.id.infoDetail);
        String text2 = clubItems.getInfo();
        tvInfoDetail.setText(text2);


        int Image = clubItems.getImage();
        imgDetail = findViewById(R.id.imgDetail);
        imgDetail.setImageResource(Image);
    }
}
