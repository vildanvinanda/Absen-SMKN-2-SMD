package com.example.belajarretrofit.Activity.Admin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import com.example.belajarretrofit.Activity.ASuperUser.TambahJadwal;
import com.example.belajarretrofit.Adapter.AdaperCalendar;
import com.example.belajarretrofit.Adapter.AdapterEvent;
import com.example.belajarretrofit.CalendarUtils;
import com.example.belajarretrofit.Model.jadwal.JadwalModel;
import com.example.belajarretrofit.Model.jadwal.ModelJadwal;
import com.example.belajarretrofit.Presenter.JadwalPresenter;
import com.example.belajarretrofit.SessionManager;
import com.example.belajarretrofit.View.JadwalView;
import com.example.belajarretrofit.databinding.ActivityJadwalAdminBinding;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static com.example.belajarretrofit.CalendarUtils.daysInWeekArray;
import static com.example.belajarretrofit.CalendarUtils.monthYearFromDate;

public class JadwalAdmin extends AppCompatActivity implements JadwalView, AdaperCalendar.OnItemListener {

    private ActivityJadwalAdminBinding binding;
    ProgressDialog dialog;
    JadwalPresenter presenter;
    AdapterEvent adapterEvent;
    List<ModelJadwal> modelJadwals;
    JadwalModel jadwal3;
    private JadwalModel[] jadwalModels;
    SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityJadwalAdminBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        CalendarUtils.selectedDate = LocalDate.now();
        sessionManager = new SessionManager(this);
        String type = sessionManager.getUserDetail().get(SessionManager.TYPE_USER);

        if(type.equals("user")){
            binding.btnTambahAcara.setVisibility(View.GONE);
        }else {
            binding.btnTambahAcara.setVisibility(View.VISIBLE);
        }


        setWeekView();
        binding.bulanLalu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CalendarUtils.selectedDate = CalendarUtils.selectedDate.minusWeeks(1);
                setWeekView();
            }
        });
        binding.bulanDepan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CalendarUtils.selectedDate = CalendarUtils.selectedDate.plusWeeks(1);
                setWeekView();
            }
        });

        binding.btnTambahAcara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                startActivity(new Intent(getActivity(), TambahJadwal.class));
                Intent intent = new Intent(JadwalAdmin.this, TambahJadwal.class);
                startActivity(intent);
            }
        });


        binding.jdlJadwal.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // Panggil metode untuk melakukan filter data berdasarkan inputan
                presenter.getData(charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });

        dialog = new ProgressDialog(getApplicationContext());
        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        dialog.setMessage("Tolong tunggu.....");
        dialog.setCancelable(false);
        dialog.setTitle("Dalam proses pendaftaran");
        dialog.setCanceledOnTouchOutside(false);

        presenter = new JadwalPresenter(this);
//        presenter.getData();
        String test = binding.jdlJadwal.getText().toString();
        presenter.getData(test);
    }


    private void setWeekView()
    {
        binding.namabln.setText(monthYearFromDate(CalendarUtils.selectedDate));
        ArrayList<LocalDate> days = daysInWeekArray(CalendarUtils.selectedDate);

        AdaperCalendar calendarAdapter = new AdaperCalendar(days, this);
//        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getContext(), 7);
//        CalendarAdapter calendarAdapter = new CalendarAdapter(days, this);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(), 7);
        binding.calendarRecyclerView.setLayoutManager(layoutManager);
        binding.calendarRecyclerView.setAdapter(calendarAdapter);


        String test = CalendarUtils.selectedDate.toString();
        binding.jdlJadwal.setText(test);

//        setEventAdpater();

    }

    private void setEventAdpater(List<JadwalModel> item) {

        adapterEvent = new AdapterEvent(getApplicationContext(),item);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        binding.recAcara.setLayoutManager(layoutManager);
        binding.recAcara.setAdapter(adapterEvent);

//        ArrayList<ModelJadwal> dailyEvents = DataJadwal.eventsForDate(CalendarUtils.selectedDate);
//        AdapterEvent event = new AdapterEvent(getContext(),dailyEvents);
//        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
//        binding.recAcara.setLayoutManager(layoutManager);
//        binding.recAcara.setAdapter(event);


        //ini baru
//        ArrayList<ModelJadwal> dailyEvents = ModelJadwal.eventsForDate(CalendarUtils.selectedDate);


//        AdapterEvent event = new AdapterEvent(getActivity(),dailyEvents);
//        event.notifyDataSetChanged();
////        LinearLayoutManager layoutManager
////                = new LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false);
//        binding.recAcara.setLayoutManager(new LinearLayoutManager(getContext()));
//        binding.recAcara.setAdapter(event);

    }



    @Override
    public void onSelectedDate(LocalDate date, ArrayList<LocalDate> days, int position) {
        date = days.get(position);
        if (date.equals(CalendarUtils.selectedDate)){
            String test = String.valueOf(CalendarUtils.selectedDate);
            binding.jdlJadwal.setText(test);
            setWeekView();
        }
    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public void onItemClick(int position, LocalDate date) {
        CalendarUtils.selectedDate = date;
        String test = String.valueOf(CalendarUtils.selectedDate);
        binding.jdlJadwal.setText(test);
        setWeekView();
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void onSuccsess(String message) {

    }

    @Override
    public void onFailure(String message) {

    }

    @Override
    public void onError(String localizedMessage) {

    }

    @Override
    public void onGetResult(List<JadwalModel> items) {
        setEventAdpater(items);
    }

    @Override
    public void onResume()
    {
        super.onResume();
//        setEventAdpater();
    }
}