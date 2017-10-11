package com.example.kored.myactionbar;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

/**
 * Created by kored on 11.10.2017.
 */

public class myAdapter extends RecyclerView.Adapter<myAdapter.myViewHolder> {

  ArrayList<Manzara> mManzara;
  Context c;
  myAdapter(Context c, ArrayList<Manzara> data){
    mManzara=data;
    this.c = c;
  }
  @Override
  public myViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View v = LayoutInflater.from(c).inflate(R.layout.list_item,parent,false);
    return new myViewHolder(v);
  }

  @Override
  public void onBindViewHolder(myViewHolder holder, int position) {
    Manzara manzara = mManzara.get(position);
    holder.setData(manzara , position);
  }

  @Override
  public int getItemCount() {
    return mManzara.size();
  }

  public void sil(int position){
    mManzara.remove(position);
    notifyItemRemoved(position);
    notifyItemRangeChanged(position,mManzara.size());
  }
  public void copy(int position){
    Manzara copyManzere = new Manzara();
    copyManzere = mManzara.get(position);
    mManzara.add(position+1,copyManzere);
    notifyItemInserted(position+1);
    notifyItemRangeChanged(position+1,mManzara.size());

  }

  class myViewHolder extends RecyclerView.ViewHolder implements OnClickListener {
    TextView txtmanzaraadi,txtmanzaraaciklama;
    ImageView imgmanzara,imgkopyala,imgsil;
    int position;
    public myViewHolder(View itemView) {
      super(itemView);
      txtmanzaraadi = itemView.findViewById(R.id.textView);
      txtmanzaraaciklama = itemView.findViewById(R.id.textView1);
      imgmanzara = itemView.findViewById(R.id.img1);
      imgkopyala = itemView.findViewById(R.id.imgcopy);
      imgsil = itemView.findViewById(R.id.imgsil);
      imgkopyala.setOnClickListener(this);
      imgsil.setOnClickListener(this);
    }

    public void setData(Manzara m , int position) {
      this.position=position;
      txtmanzaraaciklama.setText(m.getTanim());
      txtmanzaraadi.setText(m.getBaslik());
      imgmanzara.setImageResource(m.getImageId());
      imgsil.setImageResource(R.drawable.ic_delete);
      imgkopyala.setImageResource(R.drawable.ic_make_copy);
    }

    @Override
    public void onClick(View view) {
      switch (view.getId()){
        case R.id.imgsil: sil(position);

          break;
        case R.id.imgcopy:
          copy(position);
          break;
      }
    }
  }

}
