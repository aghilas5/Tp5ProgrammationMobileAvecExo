package com.example.tp5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements DetecteurDeClicSurRecycler{
    private RecyclerView mRecyclerView;
    private MonRecycleViewAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    CoordinatorLayout mcoordinatorLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        //mLayoutManager=new GridLayoutManager(this,2,GridLayoutManager.VERTICAL, false);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new MonRecycleViewAdapter(getDataSource());
        mRecyclerView.setAdapter(mAdapter);
        mcoordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinatorLayout);
       /* ((GridLayoutManager)mLayoutManager) .setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int arg0) {
                return (arg0 % 3) == 0 ? 2 : 1;
            }
        });*/
     //   RecyclerView.ItemDecoration itemDecoration =
             //   new DividerItemDecoration(this, R.drawable.divider);
      //  mRecyclerView.addItemDecoration(itemDecoration);

    }

    @Override
    protected void onResume() {
        super.onResume();
        mAdapter.setDetecteurDeClicSurRecycler(this);
    }
    String tab[]={"Pomme","Past??que","un abricot","une p??che"," la poire","la mangue","un ananas","le kiwi","la figue","la framboise","la myrtille"};
    String tab1[]={"Cultiv??e d??s le N??olithique, la pomme est aujourd'hui le fruit le plus consomm?? par les Fran??ais."
    ,"Apparue sous le soleil d???Afrique, la past??que est aujourd???hui tr??s appr??ci??e tout l?????t?? sur les ??tals fran??ais. Tr??s rafra??chissante, sa chair peu sucr??e est gorg??e d???eau et de vitamines.",
    "Apparu il y a 5 000 ans, l???abricot est aujourd???hui un fruit appr??ci?? de tous en ??t??. Les vari??t??s se sont d??velopp??es au fil des ann??es, multipliant les textures et les saveurs. ",
    "La p??che-nectarine est le 7e fruit le plus consomm?? en France. Originaire d???Asie, elle est pr??sente sur nos ??tals depuis le XVe si??cle.",
    "Arriv??e en France au XVIe si??cle, la poire s???est rapidement impos??e dans tout le pays. ",
    "D??licieusement parfum??e, juteuse et tendre, la mangue est un fruit charnu. Sa chair, d???un beau jaune-orang??, a un d??licat go??t sucr??.",
    "Fruit exotique, l???ananas a longtemps ??t?? consid??r?? comme un bien rare et pr??cieux.",
    "D??gust?? depuis 2 000 ans en Chine, le kiwi s??duit aujourd???hui le monde entier. En France, il est cultiv?? dans trois r??gions, dont l???une d??tient m??me un Label Rouge ! ",
    "La figue est un festival de couleurs et de saveurs ! Blanche, noire, rouge, violette ou bicolore, elle reste avant tout un fruit gourmand et gorg?? de soleil.",
    "Sensuelle et charnue, la framboise poss??de une saveur parfum??e et suave. Elle se d??guste nature ou cuisin??e, mais reste fragile.",
    "Petite baie gourmande, la myrtille vous s??duira par sa jolie teinte bleu-noir et son go??t parfum??, l??g??rement sucr?? et acidul??."};

    private ArrayList<Donnee> getDataSource() {
        ArrayList results = new ArrayList<Donnee>();
        for (int index = 0; index <tab.length; index++) {


            Donnee obj = new Donnee(tab[index],tab1[index]);
            results.add(index, obj);
        }

        return results;
    }




    @Override
    public void clicSurRecyclerItem(int position, View v) {
        Snackbar.make(mcoordinatorLayout, " Clic sur l'item " + position, Snackbar.LENGTH_LONG).show();



    }
}