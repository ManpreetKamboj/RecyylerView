package com.example.recyylerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.vholdr>{

    List<DemoModel> MyListData;
    LisenDo llisenDo;

    public MyAdapter(LisenDo li) {
        MyListData= new ArrayList<>();
        this.llisenDo =li;

    }


    @Override
    public vholdr onCreateViewHolder( ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.mylisttt,parent,false);
        return new vholdr(v);


    }

    @Override
    public void onBindViewHolder( MyAdapter.vholdr holder, int position) {

        holder.t1.setText(MyListData.get(position).getS1());
        holder.t2.setText(MyListData.get(position).getS2());
        holder.t3.setText(MyListData.get(position).getS3());
        holder.t4.setText(MyListData.get(position).getS4());
        holder.t5.setText(MyListData.get(position).getS5());
        holder.t6.setText(MyListData.get(position).getS6());
        holder.t7.setText(MyListData.get(position).getS7());
        holder.t8.setText(MyListData.get(position).getS8());

       // holder.img.setImageBitmap(MyListData.get(position).getBmp());

    }

    @Override
    public int getItemCount() {

        return MyListData.size();


    }

    public void setData(List<DemoModel> values) {
        this.MyListData.clear();
        this.MyListData.addAll(values);
        notifyDataSetChanged();
    }

    public class vholdr extends RecyclerView.ViewHolder{

        TextView t1;
        TextView t2;
        TextView t3;
        TextView t4;
        TextView t5;
        TextView t6;
        TextView t7;
        TextView t8;

        ImageView img;


        public vholdr( View itemView) {
            super(itemView);

            t1 = itemView.findViewById(R.id.textView4);
            t2 = itemView.findViewById(R.id.textView14);
            t3 = itemView.findViewById(R.id.textView12);
            t4 = itemView.findViewById(R.id.textView15);
            t5 = itemView.findViewById(R.id.textView16);
            t6 = itemView.findViewById(R.id.textView18);
            t7 = itemView.findViewById(R.id.textView17);
            t8 = itemView.findViewById(R.id.textView19);
           // img = itemView.findViewById(R.id.imageView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    llisenDo.iamdo(getAdapterPosition());
                }
            });


        }
    }


}
