package com.sabrine.panne;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.sabrine.panne.Adapter.ReponseAdapter;
import com.sabrine.panne.Api.ApiRequest;
import com.sabrine.panne.Api.RetrofitService;
import com.sabrine.panne.model.DataModel;
import com.sabrine.panne.model.ResponseDataModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListReponse extends AppCompatActivity {
    private RecyclerView RecycleLayout;
    private RecyclerView.LayoutManager RecycleManager;
    private RecyclerView.Adapter reponseAdapter;
    String idClient;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_reponse);

        RecycleLayout = findViewById(R.id.recyclerview);

        Bundle data = getIntent().getExtras();

        if (data != null) {
            idClient = data.getString("idClient");
        }

        ApiRequest api = RetrofitService.getClient().create(ApiRequest.class);
        Call<ResponseDataModel> getReponse=api.getResponse(idClient);
        getReponse.enqueue(new Callback<ResponseDataModel>() {
            @Override
            public void onResponse(Call<ResponseDataModel> call, Response<ResponseDataModel> response) {
                String code = response.body().getCode();
                List<DataModel> item = response.body().getResult();
                if (code.equals("1")) {
                    RecycleManager = new LinearLayoutManager(ListReponse.this, LinearLayoutManager.VERTICAL, false);

                    RecycleLayout.setLayoutManager(RecycleManager);

                    reponseAdapter = new ReponseAdapter(item, ListReponse.this,idClient);

                    RecycleLayout.setAdapter(reponseAdapter);
                }
            }

            @Override
            public void onFailure(Call<ResponseDataModel> call, Throwable t) {
                Toast.makeText(ListReponse.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
