package com.example.belajarretrofit.APIService;

import com.example.belajarretrofit.Model.DafEkskul.ModelDafEkskul;
import com.example.belajarretrofit.Model.DafEkskul.ModelDaftarEks;
import com.example.belajarretrofit.Model.DafEkskul.ResponseDelete;
import com.example.belajarretrofit.Model.EkUser.ModelEksStatus;
import com.example.belajarretrofit.Model.Ekskul.ModelCreateEkskul;
import com.example.belajarretrofit.Model.Ekskul.ModelEkskul;
import com.example.belajarretrofit.Model.Ekskul.ModelGetEkskul;
import com.example.belajarretrofit.Model.Ekskul.ModelUserKolom;
import com.example.belajarretrofit.Model.Galeri.ModelGaleri;
import com.example.belajarretrofit.Model.Galeri.ModelTambahGaleri;
import com.example.belajarretrofit.Model.ModelAbsen.ModelAbsenUser;
import com.example.belajarretrofit.Model.ModelAbsen.ModelGetAbsen;
import com.example.belajarretrofit.Model.ModelGetStatusUserEk;
import com.example.belajarretrofit.Model.PermintaanBergabung.ModelReq;
import com.example.belajarretrofit.Model.PermintaanBergabung.SendUkskulToUser;
import com.example.belajarretrofit.Model.PermintaanBergabung.SendUserEkskulModelResponse;
import com.example.belajarretrofit.Model.Piala.ModelPiala;
import com.example.belajarretrofit.Model.Piala.ModelTambahPiala;
import com.example.belajarretrofit.Model.ProfilSetting.ModelFAQResponse;
import com.example.belajarretrofit.Model.ProfilSetting.UpdateProfilResponse;
import com.example.belajarretrofit.Model.UpdateEkskul.ModelUpdateEks;
import com.example.belajarretrofit.Model.User.ModelPP;
import com.example.belajarretrofit.Model.User.ModelUser;
import com.example.belajarretrofit.Model.User.ModelUserPlusJML;
import com.example.belajarretrofit.Model.jadwal.JadwalModel;
import com.example.belajarretrofit.Model.jadwal.ModelJadwal;
import com.example.belajarretrofit.Model.login.ModelLogin;
import com.example.belajarretrofit.Model.register.ModelRegister;
import com.example.belajarretrofit.Model.riwayat.ModelRiwayat;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;

public interface ApiInterface {

    //retrofit
    //karena disni bersifat form jadi menggunakan @FormUrlEncode
    @FormUrlEncoded
    //karena disini  kita menggunakan metode Post maka menggunakan @Post
    @POST("login.php")
    //ini membuat retrofit dengan Call retrofit 2 dan Login disini merupakan Model Login dan respons itu custom
    Call<ModelLogin> loginResponse(
            //karena kita menggunakan Field jadi kirta pakai @FIELD
            @Field("email") String email,
            @Field("password") String password
    );


    @FormUrlEncoded
    @POST("regis.php")
    Call<ModelRegister> registerResponse(
            @Field("uid") String uid,
            @Field("nis") String nis,
            @Field("email") String email,
            @Field("password") String password,
            @Field("nama") String nama,
            @Field("kelas") String kelas,
            @Field("no_hp") String no_hp,
            @Field("jk") String jk,
            @Field("alamat") String alamat,
            @Field("type_user") String type_user,
            @Field("img_user") String img_user
    );

//    @FormUrlEncoded
//    @POST("updateEksSU.php")
//    Call<ModelUpdateEks> updateResponse(
//            @Field("id_ekskul") String uid,
//            @Field("nama") String nama,
//            @Field("deskripsi") String deskripsi,
//            @Field("img") String img
//    );

    @Multipart
    @POST("updateEksSU.php")
    Call<ModelUpdateEks> updateResponse(
            @Part("id_ekskul") RequestBody id_ekskul,
            @Part("nama") RequestBody nama,
            @Part("deskripsi") RequestBody deskripsi,
            @Part MultipartBody.Part img
    );





    @Multipart
    @POST("sendGaleri.php")
    Call<ModelTambahGaleri> sendDataGaleri(
            @Part("id_galeri") String id_galeri,
            @Part("judul") RequestBody judul,
            @Part("des") RequestBody des,
            @Part("tgl") RequestBody tgl,
            @Part MultipartBody.Part img
    );


    @Multipart
    @POST("CreateEkskul.php")
    Call<ModelCreateEkskul> createEkskul(
            @Part("id_ekskul") String id_ekskul,
            @Part("nama") RequestBody nama,
            @Part("deskripsi") RequestBody deskripsi,
            @Part MultipartBody.Part img
    );

    @FormUrlEncoded
    @POST("createTabel.php")
    Call<ModelCreateEkskul> sendTabelEkskul(
            @Field("namaE") String namaE,
            @Field("namaDE") String namaDE
    );

    @FormUrlEncoded
    @POST("getStatusUser.php")
    Call<List<ModelGetStatusUserEk>> getStatusUserEk(
            @Field("namaE") String namaE,
            @Field("uid") String uid
    );

//    @Multipart
//    @POST("getFIlterDafEkskul.php")
//    Call<List<ModelReq>> getFilterDafEks(
//            @Part("namaE") String namaE,
//            @Part("keyword") String keyword
//    );

    @GET("getFIlterDafEkskul.php")
    Call<List<ModelReq>> getFilterDafEks(
            @Query("keyword") String keyword,
            @Query("namaE") String namaE
    );

    @GET("getFilterUser.php")
    Call<List<ModelUserPlusJML>> getFilterAllUSer(
            @Query("keyword") String keyword
    );

    @FormUrlEncoded
    @POST("getEkstrakulikuler.php")
    Call<List<ModelGetEkskul>> getListEkskul(
            @Field("nama") String nama
    );

    @GET("getDataUserWithStatus.php")
    Call<List<ModelGetEkskul>> getListStatusEksUser(
            @Query("nama") String nama,
            @Query("status") String status
    );

//    @GET("updateStatusUserEkskul.php")
//    Call<List<ModelGetEkskul>> getListStatusEksUser(
//            @Query("nama") String nama,
//            @Query("status") String status
//    );

    @Multipart
    @POST("sendPiala.php")
    Call<ModelTambahPiala> sendDataPiala(
            @Part("id_piala") String id_piala,
            @Part("judul") RequestBody judul,
            @Part("des") RequestBody des,
            @Part("tgl") RequestBody tgl,
            @Part MultipartBody.Part img
    );

    @FormUrlEncoded
    @POST("tambahJadwal.php")
    Call<ModelJadwal> jadwalResponse(
            @Field("id") String id,
            @Field("judul") String judul,
            @Field("jam") String jam,
            @Field("tempat") String tempat,
            @Field("hari") String hari,
            @Field("nama_ekskul") String nama_ekskul,
            @Field("tgl") LocalDate tgl,
            @Field("waktu") LocalTime waktu
    );

    @FormUrlEncoded
    @POST("deleteDafUser.php")
    Call<ResponseDelete> deleteDafResponse(
            @Field("nama") String nama,
            @Field("id_daf_ek") String id_daf_ek
    );

    @FormUrlEncoded
    @POST("deleteUser.php")
    Call<ResponseDelete> deleteUser(
            @Field("uid") String uid
    );

    @FormUrlEncoded
    @POST("deleteUserInEkskul.php")
    Call<ResponseDelete> deleteUserInEkskul(
            @Field("namaE") String namaE,
            @Field("uid") String uid
    );


    @FormUrlEncoded
    @POST("updateStatusUser.php")
    Call<ResponseDelete> updateStatusUser(
            @Field("uid") String uid,
            @Field("type_user") String type_user
    );


    @FormUrlEncoded
    @POST("updateStatusUserEkskul.php")
    Call<ResponseDelete> updateStatusUserEkskul(
            @Field("namaE") String namaE,
            @Field("uid") String uid,
            @Field("status") String status
    );


    @FormUrlEncoded
    @POST("sendRiwayat.php")
    Call<ModelRiwayat> riwayatResponse(
            @Field("id") String id,
            @Field("uid") String uid,
            @Field("judul") String judul,
            @Field("tgl") LocalDate tgl
    );

    @FormUrlEncoded
    @POST("SpesifikStatus.php")
    Call<ModelEksStatus> spesificEksResponese(
            @Field("nama") String nama,
            @Field("uid") String uid
    );

    @FormUrlEncoded
    @POST("update_pass_user.php")
    Call<UpdateProfilResponse> UbahPassResponse(
            @Field("uid") String uid,
            @Field("oldPass") String oldPass,
            @Field("newPass") String newPass
    );

    @FormUrlEncoded
    @POST("updateEkstraKulikuler.php")
    Call<SendUkskulToUser> sendEkskulToColumnResponse(
            @Field("uid") String uid,
            @Field("ekskul") String ekskul
    );

    @FormUrlEncoded
    @POST("update_nama_user.php")
    Call<UpdateProfilResponse> UbahNamaResponse(
            @Field("uid") String uid,
            @Field("nama") String nama
    );

    @FormUrlEncoded
    @POST("update_alamat_user.php")
    Call<UpdateProfilResponse> UbahAlamatResponse(
            @Field("uid") String uid,
            @Field("alamat") String alamat
    );

    @FormUrlEncoded
    @POST("update_kelas_user.php")
    Call<UpdateProfilResponse> UbahKelasResponse(
            @Field("uid") String uid,
            @Field("kelas") String kelas
    );

    @FormUrlEncoded
    @POST("update_jk_user.php")
    Call<UpdateProfilResponse> UbahJKResponse(
            @Field("uid") String uid,
            @Field("jk") String jk
    );

    @FormUrlEncoded
    @POST("update_nohp_user.php")
    Call<UpdateProfilResponse> UbahNoHPResponse(
            @Field("uid") String uid,
            @Field("no_hp") String no_hp
    );


    @FormUrlEncoded
    @POST("getDafEKskul.php")
    Call<List<ModelReq>> getDataDafEKskul(
            @Field("nama") String nama
    );


    @FormUrlEncoded
    @POST("deleteDafUser.php")
    Call<ModelReq> deleteUser(
            @Field("nama") String nama,
            @Field("id_daf_ek") String id_daf_ek
        );

    @FormUrlEncoded
    @POST("sendUserDafEkskul.php")
    Call<SendUserEkskulModelResponse> sendUserToEkskul(
            @Field("ekskul") String ekskul,
            @Field("id_ek") String id_ek,
            @Field("uid") String uid,
            @Field("nama_user") String nama_user,
            @Field("nis") String nis,
            @Field("jk") String jk,
            @Field("kelas") String kelas,
            @Field("alamat") String alamat,
            @Field("nohp") String nohp,
            @Field("img_user") String img_user
    );

    //karena dia berupa img maka menggunkan multipart
//    @Multipart
//    @POST("update_pp_user.php")
//    Call<UpdateProfilResponse> UbahPPUserResponse(
//            @Field("uid") String uid,
//            @Part MultipartBody.Part image
//    );

//Dapet
    @Multipart
    @POST("update_pp_user.php")
    Call<UpdateProfilResponse> uploadImage(
            @Part MultipartBody.Part img_user,
            @Part("uid") RequestBody uid
    );

//    @FormUrlEncoded
//    @POST("update_pp_user.php")
//    Call<UpdateProfilResponse> uploadImage(
////            @Part("uid") RequestBody uid,
////            @Part("img_user\"; filename=\"image.jpg\" ") RequestBody image
//            @Field("uid") String uid,
//            @Field("img_user") String imageBase64
//    );

    @GET("getImg.php?uid=")
    Call<ModelPP> getImage(
            @Query("uid") String uid
    );


    @FormUrlEncoded
    @POST("sendDafEkskul.php")
    Call<ModelDafEkskul> ekskuDaflResponse(
            @Field("id_daf_ek") String id_daf_ek,
            @Field("uid") String uid,
            @Field("nama") String nama,
            @Field("nis") String nis,
            @Field("jk") String jk,
            @Field("kls") String kls,
            @Field("alamat") String alamat,
            @Field("alasan") String alasan,
            @Field("ekskul") String ekskul,
            @Field("nohp") String nohp
    );

    @FormUrlEncoded
    @POST("addAbsen.php")
    Call<ModelAbsenUser> addAbsenResponse(
            @Field("id") String id,
            @Field("namaE") String namaE,
            @Field("tgl") String tgl,
            @Field("uid") String uid,
            @Field("nama") String nama,
            @Field("nis") String nis,
            @Field("kelas") String kelas
    );

    @FormUrlEncoded
    @POST("getAbsen.php")
    Call<List<ModelGetAbsen>> getAbsenResponse(
            @Field("namaE") String namaE
    );

    @GET("getJadwal.php?tgl=")
    Call<List<JadwalModel>> getJadwal(
            @Query("tgl") String tgl
    );

    @GET("getFilterEkskul.php?keyword=")
    Call<List<ModelEkskul>> getFilterEkskul(
            @Query("keyword") CharSequence keyword
    );

    @GET("getRiwayat.php?uid=")
    Call<List<ModelRiwayat>> getRiwayat(
            @Query("uid") String uid
    );

    @GET("getUserEks.php?uid=")
    Call<List<ModelUser>> getEkUser(
            @Query("uid") String uid
    );

    @GET("getAllUser.php")
    Call<List<ModelUserPlusJML>> getAllEkUser(

    );

    @GET("getUserEks.php?uid=")
    Call<ModelUser> getUserStatus(
            @Query("uid") String uid
    );

    @GET("getUserStatus2.php?uid=")
    Call<ModelUserKolom> getUserStatus2(
            @Query("uid") String uid
    );

    @GET("getUserEks.php?uid=")
    Call<ModelLogin> getUser(
            @Query("uid") String uid
    );

    @GET("getFaq.php")
    Call<List<ModelFAQResponse>> getfaq(
    );

//    @GET("getUser.php?uid=")
//    Call<ModelEkUser> getEkUser2(
//            @Query("uid") String uid
//    );
//
//    @FormUrlEncoded
//    @POST("getEkskulUser.php")
//    Call<ModelStatusEkUser> getEkStatus1(
//            @Field("kata_kunci") String kata_kunci,
//            @Field("uid") String uid
//    );

//    @FormUrlEncoded
//    @POST("getEkskulUser2.php")
//    Call<ModelStatusEkUser> getEkStatus2(
//            @Field("kata_kunci") String kata_kunci,
//            @Field("uid") String uid
//    );

    @GET("getEkskul.php")
    Call<List<ModelEkskul>> getEkskul(
    );

    @GET("getGaleri.php")
    Call<List<ModelGaleri>> getGaleri(
    );

    @GET("getPiala.php")
    Call<List<ModelPiala>> getPiala(
    );

}
