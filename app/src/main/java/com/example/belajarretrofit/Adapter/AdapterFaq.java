package com.example.belajarretrofit.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.belajarretrofit.Holder.HolderEvent;
import com.example.belajarretrofit.Holder.HolderFAQ;
import com.example.belajarretrofit.Model.ProfilSetting.ModelFAQResponse;
import com.example.belajarretrofit.R;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class AdapterFaq extends RecyclerView.Adapter<HolderFAQ> {

    Context context;
    List<ModelFAQResponse> modelFAQList;

    public AdapterFaq(Context context, List<ModelFAQResponse> modelFAQList) {
        this.context = context;
        this.modelFAQList = modelFAQList;
    }

    @NotNull
    @Override
    public HolderFAQ onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        return new HolderFAQ(LayoutInflater.from(context).inflate(R.layout.item_faq, parent, false));
    }

    @Override
    public void onBindViewHolder(@NotNull HolderFAQ holder, int position) {
        ModelFAQResponse modelFAQ = modelFAQList.get(position);

        holder.pertanyaan.setText(modelFAQ.getPertanyaan());
        holder.jawaban.setText(modelFAQ.getJawaban());
        holder.pertanyaan.setText(modelFAQ.getPertanyaan());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(holder.jawabanbg.getVisibility() == View.GONE){
                    holder.jawabanbg.setVisibility(View.VISIBLE);
                    holder.rowrightfaq.animate().rotation(holder.rowrightfaq.getRotation()+90).start();
                }
                else{
                    holder.jawabanbg.setVisibility(View.GONE);
                    holder.rowrightfaq.animate().rotation(holder.rowrightfaq.getRotation()-90).start();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return modelFAQList.size();
    }
    public void clear() {
        int size = modelFAQList.size();
        modelFAQList.clear();
        notifyItemRangeRemoved(0, size);
    }
}

