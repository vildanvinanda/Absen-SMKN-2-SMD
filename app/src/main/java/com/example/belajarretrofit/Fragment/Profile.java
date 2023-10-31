package com.example.belajarretrofit.Fragment;

import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.bumptech.glide.Glide;
import com.example.belajarretrofit.Adapter.AdapterEkUser;
import com.example.belajarretrofit.Model.User.ModelUser;
import com.example.belajarretrofit.Presenter.UserEksPresenter;
import com.example.belajarretrofit.ProfilSetting;
import com.example.belajarretrofit.SessionManager;
import com.example.belajarretrofit.View.UserEksView;
import com.example.belajarretrofit.databinding.FragmentProfileBinding;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

import static android.app.Activity.RESULT_OK;

public class Profile extends Fragment implements UserEksView {

//    TextView txt_user, txt_nis, txt_email, txt_kls, txt_nomor, txt_jk, txt_alamat, txtuid;
//    ImageView ppuser,settingbtn;
//    FloatingActionButton float_editpp;

    AdapterEkUser adapterEkUser;
    UserEksPresenter presenter;
    private FragmentProfileBinding binding;
    private SessionManager sessionManager;
    ProgressDialog dialog;

    private static final int REQUEST_IMAGE_CAPTURE = 2;
    private static final int PICK_IMAGE_REQUEST = 1;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentProfileBinding.inflate(inflater, container, false);
        View view = binding.getRoot();


        sessionManager = new SessionManager(getActivity());
        String nama = sessionManager.getUserDetail().get(SessionManager.NAMA);
        String uid = sessionManager.getUserDetail().get(SessionManager.UID);
        String nis = sessionManager.getUserDetail().get(SessionManager.NIS);
        String kls = sessionManager.getUserDetail().get(SessionManager.KELAS);
        String email = sessionManager.getUserDetail().get(SessionManager.EMAIL);
        String nohp = sessionManager.getUserDetail().get(SessionManager.NO_HP);
        String alamat = sessionManager.getUserDetail().get(SessionManager.ALAMAT);
        String type = sessionManager.getUserDetail().get(SessionManager.TYPE_USER);
        String imguser = sessionManager.getUserDetail().get(SessionManager.IMG_USER);

        binding.txtUser.setText(nama);
        binding.txtEmail.setText(email);
        binding.addKls.setText(kls);
        binding.addNis.setText(nis);
        binding.addAlamat.setText(alamat);
        binding.addNohp.setText(nohp);
        Glide.with(requireContext()).load(imguser).centerCrop().into(binding.ppuser);
//        String status = jdldatadiri2.getText().toString();

        dialog = new ProgressDialog(getContext());
        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        dialog.setMessage("Tolong tunggu.....");
        dialog.setCancelable(false);
        dialog.setTitle("Dalam proses pendaftaran");
        dialog.setCanceledOnTouchOutside(false);



        binding.floatEditpp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                // Mengambil gambar dari kamera
//                Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//                startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
//
//                // Mengambil gambar dari galeri
//                Intent pickPhoto = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
//                startActivityForResult(pickPhoto, REQUEST_IMAGE_PICK);

//                Intent intent = new Intent();
//                intent.setType("image/*");
//                intent.setAction(Intent.ACTION_GET_CONTENT);
//                startActivityForResult(Intent.createChooser(intent,"open gallery"),REQUEST_IMAGE_PICK);

                openGalery();

            }
        });

        presenter = new UserEksPresenter(this);
        presenter.onGetEkskul(uid);
        binding.btnSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ProfilSetting.class);
                intent.putExtra("STATUS", type);
                startActivity(intent);
//                presenter.getImage(uid);
            }
        });
//        presenter.onGetEkskul2(uid);


        return view;
    }

    private void openGalery() {
//        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
//        startActivityForResult(intent, PICK_IMAGE_REQUEST);
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, PICK_IMAGE_REQUEST);

//        if (ContextCompat.checkSelfPermission(getContext(),
//                Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
//            Intent intent = new Intent();
//            intent.setType("image/*");
//            intent.setAction(Intent.ACTION_GET_CONTENT);
//            startActivityForResult(intent, 10);
//        } else {
//            ActivityCompat.requestPermissions(getActivity(),
//                    new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},1);
//        }

    }



//    @Override
//    public void onSuccessImg(List<ModelGetUser> img) {
//        Glide.with(this).load(img).into(binding.ppuser);
//    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        sessionManager = new SessionManager(getActivity());
        String uid = sessionManager.getUserDetail().get(SessionManager.UID);

        if (resultCode == RESULT_OK)
        {
            if(requestCode == PICK_IMAGE_REQUEST)
            {
                if (data != null) {
                    Uri selectedImageUri = data.getData();
                    // Konversi URI gambar ke base64
                    String imageBase64 = getBase64FromUri(selectedImageUri);
                        uploadImage(selectedImageUri,uid);
//                    presenter.updatePP(imageBase64, uid);

                }
            } else if (requestCode == REQUEST_IMAGE_CAPTURE) {
                if (data != null) {
                    Uri capturedImageUri = data.getData();
//                    uploadImage(capturedImageUri, uid);
                }
            }
        }


    }

    private String getBase64FromUri(Uri selectedImageUri) {
        try {
            InputStream inputStream = getContext().getContentResolver().openInputStream(selectedImageUri);
            byte[] bytes = new byte[inputStream.available()];
            inputStream.read(bytes);
            inputStream.close();
            return Base64.encodeToString(bytes, Base64.DEFAULT);
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

    private void uploadImage(Uri imageBase64, String uid) {
        File file = new File(getRealPathFromURI(imageBase64));
        RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), file);
        MultipartBody.Part body = MultipartBody.Part.createFormData("img_user", file.getName(), requestFile);
        RequestBody userId = RequestBody.create(MediaType.parse("text/plain"), uid);

        String uid_user = sessionManager.getUserDetail().get(SessionManager.UID);

        presenter.updatePP(body,userId, uid_user);
    }

    private String getRealPathFromURI(Uri contentUri) {
        String[] projection = {MediaStore.Images.Media.DATA};
        ContentResolver contentResolver = getContext().getContentResolver();
        Cursor cursor = contentResolver.query(contentUri, projection, null, null, null);

        if (cursor == null) return null;

        int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
        cursor.moveToFirst();
        String path = cursor.getString(column_index);
        cursor.close();
        return path;
    }
//    @Override
//    public void getEKskul(String kolom1, String kolom2, String uid) {
////        if (kolom1.isEmpty()){
////            binding.recAddStatus.setVisibility(View.GONE);
////        } else if (kolom1 != null){
////            binding.recAddStatus.setVisibility(View.VISIBLE);
////
////        }
//        String kata_kunci = kolom1;
////        binding.recAddStatus.setText(kolom1);
////        presenter.onGetStatus(kata_kunci,uid);
//    }
//
//    @Override
//    public void getStatusEk1(String statusEk) {
////        binding.recAddStatus.setText(statusEk);
//        Toast.makeText(getActivity(), "Massage ->" + statusEk, Toast.LENGTH_SHORT).show();
//    }
//
//    @Override
//    public void onErrorStatus(String localizedMessage) {
//        Toast.makeText(getActivity(), localizedMessage, Toast.LENGTH_SHORT).show();
//    }
//
//    @Override
//    public void Test(String message) {
//        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
//    }


    @Override
    public void onSuccess(List<ModelUser> kolom1) {
        adapterEkUser = new AdapterEkUser(getContext(),kolom1);
//        binding.status.setText((CharSequence) kolom1);
        LinearLayoutManager layoutManager
                = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        binding.recEskul.setLayoutManager(layoutManager);
        binding.recEskul.setAdapter(adapterEkUser);
    }

    @Override
    public void onError(String localizedMessage) {

    }

    @Override
    public void onResponsePP(String responseBody, String uid) {
        Toast.makeText(getActivity(), responseBody, Toast.LENGTH_LONG).show();
//        String uid = sessionManager.getUserDetail().get(SessionManager.UID);

//        presenter.loadImageFromServer(uid);
//        sessionManager = new SessionManager(getActivity());
//        sessionManager.updateImgUserData(body);
    }

    @Override
    public void onErrorPP(String localizedMessage) {
        Toast.makeText(getActivity(), localizedMessage, Toast.LENGTH_LONG).show();
    }

    @Override
    public void doneProgressUpdatePP() {
        dialog.dismiss();
    }

    @Override
    public void onProgressUpdatePP() {
        dialog.show();
    }

    @Override
    public void onSuccessImg(String imageUrl, SessionManager sessionManager) {
        sessionManager = new SessionManager(getActivity());
//
//        //data akan disimpa di LoginData
//        //data yang telah diambil kita simpan di session
        sessionManager.updateImageUserData(imageUrl);
////        String imgUrl = sessionManager.getUserDetail().get(SessionManager.IMG_USER);
        String sesiimg = sessionManager.getUserDetail().get(SessionManager.IMG_USER);
        Glide.with(this).load(sesiimg).centerCrop().into(binding.ppuser);
//        Toast.makeText(getActivity(), "TOLONGG", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void Failure(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }

}