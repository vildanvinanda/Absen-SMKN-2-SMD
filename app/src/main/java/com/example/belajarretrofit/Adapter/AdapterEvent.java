//package com.example.belajarretrofit.Adapter;
//
//import android.content.Context;
//import android.view.LayoutInflater;
//import android.view.ViewGroup;
//
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.example.belajarretrofit.Holder.HolderEvent;
//import com.example.belajarretrofit.Model.Event;
//import com.example.belajarretrofit.Model.jadwal.ModelJadwal;
//import com.example.belajarretrofit.R;
//
//import org.jetbrains.annotations.NotNull;
//
//import java.util.List;
//
//public class AdapterEvent extends RecyclerView.Adapter<HolderEvent> {
//
//    Context context;
//    List<ModelJadwal> modelEvent;
//
//    public AdapterEvent(Context context, List<ModelJadwal> modelEvent) {
//        this.context = context;
//        this.modelEvent = modelEvent;
//
//    }
//
//    @NotNull
//    @Override
//    public HolderEvent onCreateViewHolder( @NotNull ViewGroup parent, int viewType) {
//        return new HolderEvent(LayoutInflater.from(context).inflate(R.layout.item_jadwal, parent,false));
//    }
//
//    @Override
//    public void onBindViewHolder(@NotNull HolderEvent holder, int position) {
//
//        holder.txtjdl.setText(modelEvent.get(position).getDataJadwal().getJudul());
//        holder.txtjam.setText(modelEvent.get(position).getDataJadwal().getJam());
//        holder.txttempat.setText(modelEvent.get(position).getDataJadwal().getTempat());
//
////        holder.itemView.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View v) {
////                Intent intent = new Intent(context, DetailPiala.class);
////                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
////                context.startActivity(intent);
////            }
////        });
//    }
//
//    @Override
//    public int getItemCount() {
//        return modelEvent.size();
//    }
//
//    public interface ItemClickListener {
//
//    }
//}


package com.example.belajarretrofit.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.example.belajarretrofit.Holder.HolderEvent;
import com.example.belajarretrofit.Model.Event;
import com.example.belajarretrofit.Model.jadwal.JadwalModel;
import com.example.belajarretrofit.Model.jadwal.ModelJadwal;
import com.example.belajarretrofit.R;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class AdapterEvent extends RecyclerView.Adapter<HolderEvent> {

    Context context;
    List<JadwalModel> modelEvent;

    public AdapterEvent(Context context, List<JadwalModel> modelEvent) {
        this.context = context;
        this.modelEvent = modelEvent;

    }

    @NotNull
    @Override
    public HolderEvent onCreateViewHolder( @NotNull ViewGroup parent, int viewType) {
        return new HolderEvent(LayoutInflater.from(context).inflate(R.layout.item_jadwal, parent,false));
    }

    @Override
    public void onBindViewHolder(@NotNull HolderEvent holder, int position) {

        JadwalModel model = modelEvent.get(position);
        holder.txtjdl.setText(model.getJudul());
        holder.txtjam.setText(model.getJam());
        holder.txttempat.setText(model.getTempat());

//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(context, DetailPiala.class);
//                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                context.startActivity(intent);
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return modelEvent.size();
    }

    public void modelEvent(List<JadwalModel> filterList) {
    }

    public interface ItemClickListener {

    }
}
