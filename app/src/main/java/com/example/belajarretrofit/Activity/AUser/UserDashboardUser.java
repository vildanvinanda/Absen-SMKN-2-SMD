package com.example.belajarretrofit.Activity.AUser;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.belajarretrofit.Fragment.Dashboard;
import com.example.belajarretrofit.Fragment.DashboardAdmin;
import com.example.belajarretrofit.Fragment.DashboardSU;
import com.example.belajarretrofit.Fragment.Jadwal;
import com.example.belajarretrofit.Fragment.Profile;
import com.example.belajarretrofit.Fragment.Riwayat;
import com.example.belajarretrofit.Activity.Login;
import com.example.belajarretrofit.R;
import com.example.belajarretrofit.SessionManager;
import com.example.belajarretrofit.databinding.ActivityDashboardUserBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import org.jetbrains.annotations.NotNull;

public class UserDashboardUser extends AppCompatActivity implements NavigationBarView.OnItemSelectedListener {

    private Dashboard dashboard = new Dashboard();
    private DashboardSU dashboard1 = new DashboardSU();
    private DashboardAdmin dashboard2 = new DashboardAdmin();
    private Riwayat riwayat = new Riwayat();
    private Jadwal jadwal = new Jadwal();
    private Profile profile = new Profile();
    private BottomNavigationView bottomNav;

    //supaya tidak login lagi maka kita akan cek sesinya
    SessionManager sessionManager;
    String nama, type_user;
    private ActivityDashboardUserBinding binding;

    String teks;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDashboardUserBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.bottomNav.setOnItemSelectedListener(this);

        //ini adalah sebuah objek sesi
        //kita tambahkan kondisi
        sessionManager = new SessionManager(UserDashboardUser.this);
        //kita ccek
        //kita gunakan !
        if (sessionManager.isLogin() == false){
            //kita membuat sebuah method
            moveToLogin();
        }


        //letakan data yang ada di hasmap ke textview
        nama = sessionManager.getUserDetail().get(SessionManager.NAMA);
        type_user = sessionManager.getUserDetail().get(SessionManager.TYPE_USER);


        if (type_user.equals("user")) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, dashboard).commit();
            binding.bottomNav.setVisibility(View.VISIBLE);
        } else if (type_user.equals("super user")){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, dashboard1).commit();
            binding.bottomNav.setVisibility(View.VISIBLE);
        } else if (type_user.equals("admin")){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, dashboard2).commit();
            binding.bottomNav.setVisibility(View.GONE);
        }

        Intent intent = getIntent();
        if (intent != null) {
            String data = intent.getStringExtra("key"); // Mendapatkan data berdasarkan kunci
            // Lakukan sesuatu dengan data jika diperlukan
            // Tampilkan Fragment yang sesuai berdasarkan data atau ID Fragment
            if ("user".equals(data)) {
                int selectedItem = R.id.miProfil;
                binding.bottomNav.setSelectedItemId(selectedItem);
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragmentContainer, profile) // Gantilah YourFragment dengan nama Fragment Anda
                        .commit();
            }
        }

    }

    private void moveToLogin() {
        //berikan fungsi
        Intent intent = new Intent(UserDashboardUser.this, Login.class);
        //gunakan setFlags untuk data data yang di dalam mann activity
        //menggunakan Flag_Activity_No_History berguna suaya data yang ada di maiin activity ini gk adak lagi
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_HISTORY);
        startActivity(intent);
        finish();
    }

    @Override
    public boolean onNavigationItemSelected(@NotNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.miDashboard:
                if (type_user.equals("user")) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, dashboard).commit();
                } else if (type_user.equals("super user")){
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, dashboard1).commit();
                } else if (type_user.equals("admin")){

                }
                return true;
            case R.id.miJadwal:
                if (type_user.equals("user")) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, jadwal).commit();
                } else if (type_user.equals("super user")){
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, jadwal).commit();
                } else if (type_user.equals("admin")){

                }
                return true;
            case R.id.miRiwayat:
                if (type_user.equals("user")) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, riwayat).commit();

                } else if (type_user.equals("super user")){
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, riwayat).commit();
                } else if (type_user.equals("admin")){

                }
                return true;

            case R.id.miProfil:
                if (type_user.equals("user")) {
//                    getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, profile).commit();
                    Bundle bundle = new Bundle();
                    bundle.putString("TEXT", type_user);
                    profile.setArguments(bundle);

                    getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, profile).commit();


                } else if (type_user.equals("super user")){
                    Bundle bundle = new Bundle();
                    bundle.putString("TEXT", type_user);
                    profile.setArguments(bundle);

                    getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, profile).commit();

                } else if (type_user.equals("admin")){

                }
                return true;
        }
        return false;
    }

}
