package com.example.kored.myactionbar;

import android.os.Build.VERSION;
import android.os.Build.VERSION_CODES;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.Toolbar.OnMenuItemClickListener;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements OnClickListener,
    OnMenuItemClickListener {



  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    MenuInflater menuInflater = getMenuInflater();
    menuInflater.inflate(R.menu.mymenu,menu);
    return true;
  }

  RecyclerView recyclerView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    Toolbar tb = (Toolbar) findViewById(R.id.tb1);
    tb.setTitle("title");
    tb.setSubtitle("subtitle");
    tb.setNavigationIcon(R.mipmap.ic_launcher);
    tb.setNavigationOnClickListener(this);
    tb.inflateMenu(R.menu.mymenu);
    tb.setOnMenuItemClickListener(this);

    recyclerView = (RecyclerView) findViewById(R.id.mainrec);
    myAdapter myAdapter = new myAdapter(getApplicationContext(),Manzara.getData());
    recyclerView.setAdapter(myAdapter);
    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
    linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
    recyclerView.setLayoutManager(linearLayoutManager);
    if(VERSION.SDK_INT >= VERSION_CODES.LOLLIPOP){

      //Kullanıcının Apisi 21 ve üzeri ise çalışacak kod
    }
    else{
      //Kullanıcının Apisi 21'den düşük ise ise çalışacak kod
    }
  }


  @Override
  public void onClick(View view) {
    Toast.makeText(this, "Tıklandı", Toast.LENGTH_SHORT).show();
  }

  @Override
  public boolean onMenuItemClick(MenuItem item) {
    switch (item.getItemId()){
      case R.id.id1:
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        break;
      case R.id.id2:
        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(this);
        linearLayoutManager2.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager2);
        break;
      case R.id.id3:
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,3);
        gridLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(gridLayoutManager);
        break;
      case R.id.id4:
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.HORIZONTAL);
        staggeredGridLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);
        break;
      case R.id.id5:
        StaggeredGridLayoutManager staggeredGridLayoutManager1 = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        staggeredGridLayoutManager1.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(staggeredGridLayoutManager1);
        break;
    }
    return false;
  }
}
