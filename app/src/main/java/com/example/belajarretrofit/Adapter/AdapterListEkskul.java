package com.example.belajarretrofit.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.belajarretrofit.Activity.DetailGaleri;
import com.example.belajarretrofit.Holder.HolderUser;
import com.example.belajarretrofit.Model.Ekskul.ModelEkskul;
import com.example.belajarretrofit.Model.Ekskul.ModelGetEkskul;
import com.example.belajarretrofit.Model.Piala.ModelPiala;
import com.example.belajarretrofit.Model.UserEkskul.ModelUserEks;
import com.example.belajarretrofit.R;
import com.example.belajarretrofit.View.itemClick.RecyclerViewItemClickForAdapterListEkskul;
import com.example.belajarretrofit.View.itemClick.RecyclerViewItemClickListener;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class AdapterListEkskul extends RecyclerView.Adapter<AdapterListEkskul.HolderUser> {

    Context context;
    List<ModelGetEkskul> modelUserEks;
    private RecyclerViewItemClickForAdapterListEkskul mListener;

    public AdapterListEkskul(Context context, List<ModelGetEkskul> modelUserEks ,RecyclerViewItemClickForAdapterListEkskul listener) {
        this.context = context;
        this.modelUserEks = modelUserEks;
        this.mListener = listener;
    }

    @NotNull
    @Override
    public HolderUser onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        return new HolderUser(LayoutInflater.from(context).inflate(R.layout.item_user, parent, false));
    }

    @Override
    public void onBindViewHolder(@NotNull AdapterListEkskul.HolderUser holder, int position) {
        ModelGetEkskul model = modelUserEks.get(position);

        Glide.with(holder.addimguser)
                .load(model.getImg_user())
                .centerCrop()
                .into(holder.addimguser);

        holder.eddnama.setText(model.getNama_user());
        holder.eddkls.setText(model.getKelas());
        holder.eddnis.setText(model.getNis());
    }

//    @Override
//    public void onBindViewHolder(@NotNull HolderUser holder, int position) {
//        ModelGetEkskul model = modelUserEks.get(position);
//
//        Glide.with(holder.addimguser)
//                .load(model.getImg_user())
//                .centerCrop()
//                .into(holder.addimguser);
//
//        holder.eddnama.setText(model.getNama_user());
//        holder.eddkls.setText(model.getKelas());
//        holder.eddnis.setText(model.getNis());
//
////        holder.itemView.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View v) {
////
////            }
////        });
//
////        holder.itemView.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View v) {
////                //BELUM DI SET
////
////                Intent intent = new Intent(context, DetailGaleri.class);
////                intent.putExtra(EXTRA_IMG, model.getImg());
////                intent.putExtra(EXTRA_JUDUL, model.getJudul());
////                intent.putExtra(EXTRA_TGL, model.getTgl());
////                intent.putExtra(EXTRA_DES, model.getDes());
////                intent.putExtra(EXTRA_ID, model.getId_piala());
////                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
////                context.startActivity(intent);
////            }
////        });
//
//    }

    @Override
    public int getItemCount() {
        return modelUserEks.size();
    }

    public class HolderUser extends RecyclerView.ViewHolder {
        public TextView eddnama, eddkls, eddnis;
        public ImageView addimguser;
        public HolderUser(@NotNull View itemView) {
            super(itemView);
            addimguser = (ImageView) itemView.findViewById(R.id.addimguser);
            eddnama = (TextView) itemView.findViewById(R.id.eddnama);
            eddnis = (TextView) itemView.findViewById(R.id.eddnis);
            eddkls = (TextView) itemView.findViewById(R.id.eddkls);

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
                        mListener.onItemClick(position, modelUserEks);

                    }
                }
            });
        }
    }
}
