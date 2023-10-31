package com.example.belajarretrofit.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.belajarretrofit.Model.PermintaanBergabung.ModelReq;
import com.example.belajarretrofit.R;
import com.example.belajarretrofit.View.itemClick.RecyclerViewItemClickListener;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class AdapterReqBasket extends RecyclerView.Adapter<AdapterReqBasket.MyViewHolder> {

    private RecyclerViewItemClickListener mListener;
    Context context;
    List<ModelReq> modelQeqBaskets;

//    public static final String EXTRA_ID= "id_daf_ek";
//    public static final String EXTRA_NAMA = "nama";
//    public static final String EXTRA_NIS = "nis";
//    public static final String EXTRA_IMG = "img";
//    public static final String EXTRA_ALAMAT = "alamat";
//    public static final String EXTRA_ALASAN = "alasan";
//    public static final String EXTRA_KLS = "kelas";
//    public static final String EXTRA_JK = "jk";
//    public static final String EXTRA_NOHP= "nohp";

    public AdapterReqBasket(Context context, List<ModelReq> modelQeqBaskets,RecyclerViewItemClickListener listener) {
        this.context = context;
        this.modelQeqBaskets = modelQeqBaskets;
        this.mListener = listener;
    }


    public void setOnItemClickListener (RecyclerViewItemClickListener listener){
        mListener = listener;
    }

    @NotNull
    @Override
    public AdapterReqBasket.MyViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        return new AdapterReqBasket.MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_permintaan,parent,false));
    }

    @Override
    public void onBindViewHolder(@NotNull AdapterReqBasket.MyViewHolder holder, int position) {
        ModelReq model = modelQeqBaskets.get(position);
//        Intent intent = new Intent(context, PermintaanBergabung.class);
//        intent.putExtra(EXTRA_JML, model.getJml());
//        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//        context.startActivity(intent);


        Glide.with(holder.img).load(model.getImg_user()).centerCrop().into(holder.img);
        holder.addnama.setText(model.getNama());
        holder.addnis.setText(model.getNis());
        holder.addkls.setText(model.getKls());
    }

    @Override
    public int getItemCount() {
        return modelQeqBaskets.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView addnama,addnis, addkls;
        public ImageView img;
        public MyViewHolder(@NotNull View itemView) {
            super(itemView);

            addnama = (TextView) itemView.findViewById(R.id.addnama);
            addnis = (TextView) itemView.findViewById(R.id.addnis);
            addkls = (TextView) itemView.findViewById(R.id.addkls);
            img = (ImageView) itemView.findViewById(R.id.img);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
//                    if (mListener != null) {
//                        int position = getAdapterPosition();
//                        if (position != RecyclerView.NO_POSITION) {
//                            ModelReq item = modelQeqBaskets.get(position);
//                            // Buka aktivitas detail dengan data item
//                            Intent intent = new Intent(view.getContext(), DetailUser.class);
////                            intent.putExtra("item_id", item.getId());
//                            view.getContext().startActivity(intent);
//
////                            String alamat = modelQeqBaskets.get(position).getAlamat(); // Ganti ini sesuai dengan cara mengambil data dari model Anda
////                            String nama = modelQeqBaskets.get(position).getNama();
////                            String nis = modelQeqBaskets.get(position).getNis();
////                            String nohp = modelQeqBaskets.get(position).getNohp();
////                            String alasan = modelQeqBaskets.get(position).getAlasan();
////                            String kls = modelQeqBaskets.get(position).getKls();
////                            String id = modelQeqBaskets.get(position).getId_ek();
////                            String img = modelQeqBaskets.get(position).getImg_user();
////                            String jk = modelQeqBaskets.get(position).getJk();
//                            mListener.onItemClick(position);
//                        }
//                    }
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {

                        // Buka aktivitas detail dengan data item
//                        Intent intent = new Intent(context, DetailUser.class);
//
//                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                        context.startActivity(intent);
                        mListener.onItemClick(position, modelQeqBaskets);
                    }
                }
            });

        }
    }

//    @NotNull
//    @Override
//    public HolderBergabung onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
//        return new HolderBergabung(LayoutInflater.from(context).inflate(R.layout.item_permintaan,parent,false));
//    }
//
//    @Override
//    public void onBindViewHolder(@NotNull HolderBergabung holder, int position) {
//        ModelReq model = modelQeqBaskets.get(position);
////        Intent intent = new Intent(context, PermintaanBergabung.class);
////        intent.putExtra(EXTRA_JML, model.getJml());
////        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
////        context.startActivity(intent);
//
//
//        Glide.with(holder.img).load(model.getImg_user()).centerCrop().into(holder.img);
//        holder.addnama.setText(model.getNama());
//        holder.addnis.setText(model.getNis());
//        holder.addkls.setText(model.getKls());
//
//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(context, DetailUser.class);
//                intent.putExtra(EXTRA_ID, model.getId_ek());
//                intent.putExtra(EXTRA_NAMA, model.getNama());
//                intent.putExtra(EXTRA_IMG, model.getImg_user());
//                intent.putExtra(EXTRA_NIS, model.getNis());
//                intent.putExtra(EXTRA_ALAMAT, model.getAlamat());
//                intent.putExtra(EXTRA_ALASAN, model.getAlasan());
//                intent.putExtra(EXTRA_KLS, model.getKls());
//                intent.putExtra(EXTRA_JK, model.getJk());
//                intent.putExtra(EXTRA_NOHP, model.getNohp());
//                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                context.startActivity(intent);
//
//            }
//        });
//    }
//
//    @Override
//    public int getItemCount() {
//        return modelQeqBaskets.size();
//    }
}
