package com.example.belajarretrofit.View.itemClick;

import com.example.belajarretrofit.Model.PermintaanBergabung.ModelReq;

import java.util.List;

public interface RecyclerViewItemClickListener {
//    void onItemClick(int position, String id, String nama, String alamat, String alasan, String jk, String kls, String nis, String img, String nohp);

    void onItemClick(int position, List<ModelReq> modelQeqBaskets);
}
