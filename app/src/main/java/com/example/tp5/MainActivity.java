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
    String tab[]={"Pomme","Pastèque","un abricot","une pêche"," la poire","la mangue","un ananas","le kiwi","la figue","la framboise","la myrtille"};
    String tab1[]={"Cultivée dès le Néolithique, la pomme est aujourd'hui le fruit le plus consommé par les Français."
    ,"Apparue sous le soleil d’Afrique, la pastèque est aujourd’hui très appréciée tout l’été sur les étals français. Très rafraîchissante, sa chair peu sucrée est gorgée d’eau et de vitamines.",
    "Apparu il y a 5 000 ans, l’abricot est aujourd’hui un fruit apprécié de tous en été. Les variétés se sont développées au fil des années, multipliant les textures et les saveurs. ",
    "La pêche-nectarine est le 7e fruit le plus consommé en France. Originaire d’Asie, elle est présente sur nos étals depuis le XVe siècle.",
    "Arrivée en France au XVIe siècle, la poire s’est rapidement imposée dans tout le pays. ",
    "Délicieusement parfumée, juteuse et tendre, la mangue est un fruit charnu. Sa chair, d’un beau jaune-orangé, a un délicat goût sucré.",
    "Fruit exotique, l’ananas a longtemps été considéré comme un bien rare et précieux.",
    "Dégusté depuis 2 000 ans en Chine, le kiwi séduit aujourd’hui le monde entier. En France, il est cultivé dans trois régions, dont l’une détient même un Label Rouge ! ",
    "La figue est un festival de couleurs et de saveurs ! Blanche, noire, rouge, violette ou bicolore, elle reste avant tout un fruit gourmand et gorgé de soleil.",
    "Sensuelle et charnue, la framboise possède une saveur parfumée et suave. Elle se déguste nature ou cuisinée, mais reste fragile.",
    "Petite baie gourmande, la myrtille vous séduira par sa jolie teinte bleu-noir et son goût parfumé, légèrement sucré et acidulé."};

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