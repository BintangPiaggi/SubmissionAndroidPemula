package com.bangkumist.bintang.submissionpemula;

import android.content.Intent;
import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    String[] titleData;
    String[] overviewData;
    TypedArray photoData;
    Adapter adapter;
    RecyclerView rc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rc = findViewById(R.id.rcClubs);
        adapter = new Adapter(this);
        rc.setHasFixedSize(true);
        rc.setAdapter(adapter);
        rc.setLayoutManager(new GridLayoutManager(this, 2));

        prepare();
        addItem();

        adapter.setOnItemClickListener(new Adapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Items mItems = new Items();
                mItems.setImage(photoData.getResourceId(position, -1));
                mItems.setTitle(titleData[position]);
                mItems.setInfo(overviewData[position]);
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("data", mItems);
                startActivity(intent);
            }
        });
    }
    public void prepare (){
        titleData = getResources().getStringArray(R.array.club_name);
        overviewData = getResources().getStringArray(R.array.league_info);
        photoData = getResources().obtainTypedArray(R.array.club_image);
    }
    private void addItem() {
        ArrayList<Items> mItems = new ArrayList<>();

        for (int i = 0; i < titleData.length; i++) {
            Items club = new Items();
            club.setImage(photoData.getResourceId(i, -1));
            club.setTitle(titleData[i]);
            club.setInfo(overviewData[i]);
            mItems.add(club);
        }

        adapter.setMovieItems(mItems);
    }
}

