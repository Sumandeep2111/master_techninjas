package com.example.project_techninjas_android;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterNote extends RecyclerView.Adapter<AdapterNote.ViewHolder> {
    LayoutInflater inflater;
    List<Note> notes;

    AdapterNote(Context context,List<Note> notes){
        this.inflater = LayoutInflater.from(context);
        this.notes = notes;
    }

    @NonNull
    @Override
    public AdapterNote.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.custom_listview,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterNote.ViewHolder holder, int position) {
        String title = notes.get(position).getTitle();
        String date = notes.get(position).getDate();
        String time = notes.get(position).getTime();
       // int id = notes.get(position).getId();
        holder.notetitle.setText(title);
        holder.date.setText(date);
        holder.time.setText(time);

    }

    @Override
    public int getItemCount() {

        return notes.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView notetitle,date,time;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            notetitle = itemView.findViewById(R.id.ntitle);
            date = itemView.findViewById(R.id.ndate);
            time = itemView.findViewById(R.id.ntime);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(),DetailsNote.class);
                    intent.putExtra("ID",notes.get(getAdapterPosition()).getId());
                    v.getContext().startActivity(intent);
                  //  Toast.makeText(v.getContext(),"Item clicked",Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
