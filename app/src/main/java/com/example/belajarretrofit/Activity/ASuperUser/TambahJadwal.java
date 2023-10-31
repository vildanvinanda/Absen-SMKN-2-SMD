package com.example.belajarretrofit.Activity.ASuperUser;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.belajarretrofit.APIService.ApiInterface;
import com.example.belajarretrofit.CalendarUtils;
import com.example.belajarretrofit.Model.Event;
import com.example.belajarretrofit.Model.jadwal.JadwalModel;
import com.example.belajarretrofit.Model.jadwal.ModelJadwal;
import com.example.belajarretrofit.Presenter.JadwalPresenter;
import com.example.belajarretrofit.Presenter.RegisterPresenter;
import com.example.belajarretrofit.R;
import com.example.belajarretrofit.Register;
import com.example.belajarretrofit.View.JadwalView;
import com.example.belajarretrofit.databinding.ActivityTambahJadwalBinding;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class TambahJadwal extends AppCompatActivity implements JadwalView {

    private LocalTime time;
    private ActivityTambahJadwalBinding binding;
    ApiInterface apiInterface;
    JadwalPresenter jadwalPresenter;
    ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTambahJadwalBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

//            initWidgets();
            time = LocalTime.now();
//            eventDateTV.setText("Date: " + CalendarUtils.formattedDate(CalendarUtils.selectedDate));
//            eventTimeTV.setText("Time: " + CalendarUtils.formattedTime(time));

        dialog = new ProgressDialog(this);
        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        dialog.setMessage("Tolong tunggu.....");
        dialog.setCancelable(false);
        dialog.setTitle("Dalam proses input data");
        dialog.setCanceledOnTouchOutside(false);

        jadwalPresenter = new JadwalPresenter(this);

    }


    public void btn(View view) {
        switch (view.getId()){
            case R.id.btnbergabung:
                String takeJudul = binding.addkegiatan.getText().toString();
                String takeJam = binding.addjam.getText().toString();
                String takeTempat = binding.addtempat.getText().toString();
                String takeHari = binding.addhari.getText().toString();
                String takeEkskul = binding.addekskul.getText().toString();
//                String cek = addkegiata
//                String eventName = eventNameET.getText().toString();
//                Event newEvent = new Event(takeJudul,takeJam,takeTempat, takeHari, CalendarUtils.selectedDate, time);
//                Event.eventsList.add(newEvent);
                jadwalPresenter.createEvent(takeJudul,takeJam,takeTempat, takeHari,takeEkskul, CalendarUtils.selectedDate, time);
//                ModelJadwal.eventsList.add();
                finish();
                break;
            case R.id.btnback:
                finish();
                break;
        }
    }

    @Override
    public void onItemClick(int position, LocalDate date) {

    }

    @Override
    public void showProgress() {
        dialog.show();
    }

    @Override
    public void hideProgress() {
        dialog.dismiss();
    }


    @Override
    public void onSuccsess(String message) {
        Toast.makeText(TambahJadwal.this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onFailure(String message) {
        Toast.makeText(TambahJadwal.this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onError(String localizedMessage) {
        Toast.makeText(TambahJadwal.this, localizedMessage, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onGetResult(List<JadwalModel > items) {

    }


//    public void saveEventAction(View view)
//    {
//        String eventName = eventNameET.getText().toString();
//        Event newEvent = new Event(eventName, CalendarUtils.selectedDate, time);
//        Event.eventsList.add(newEvent);
//        finish();
//    }
}