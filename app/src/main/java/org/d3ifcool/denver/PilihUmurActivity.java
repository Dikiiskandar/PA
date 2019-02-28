package org.d3ifcool.denver;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

public class PilihUmurActivity extends AppCompatActivity {
    int[] mThumbIds = {
            3, 6,
            9, 12,
            15, 18
    };

    int menu;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pilih_umur);

        Intent intent = getIntent();
        menu = intent.getIntExtra("MENU",0);

        GridView gridview = (GridView) findViewById(R.id.gridView);
        gridview.setAdapter(new ImageAdapter(this));

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (menu==1){
                    Intent intentTest = new Intent(PilihUmurActivity.this, TestActivity.class);
                    intentTest.putExtra("UMUR",mThumbIds[position]);
                    startActivity(intentTest);
                }else if (menu==2){
                    Intent intentStimulasi = new Intent(PilihUmurActivity.this, StimulasiActivity.class);
                    intentStimulasi.putExtra("UMUR",mThumbIds[position]);
                    startActivity(intentStimulasi);
                }

            }
        });
    }
}
