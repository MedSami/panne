package com.sabrine.panne;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.sabrine.panne.Adapter.DepanneurAdapter;
import com.sabrine.panne.Api.ApiRequest;
import com.sabrine.panne.Api.RetrofitService;
import com.sabrine.panne.model.DataModel;
import com.sabrine.panne.model.ResponseDataModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListDepanneur extends AppCompatActivity {
    private RecyclerView RecycleLayout;
    private RecyclerView.LayoutManager RecycleManager;
    private RecyclerView.Adapter depanneurAdapter;
    String idClient;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_depanneur);
        RecycleLayout = findViewById(R.id.recyclerview);
        ApiRequest api = RetrofitService.getClient().create(ApiRequest.class);
        Call<ResponseDataModel> getDepanneurs=api.getDepanneurs();

        getDepanneurs.enqueue(new Callback<ResponseDataModel>() {
            @Override
            public void onResponse(Call<ResponseDataModel> call, Response<ResponseDataModel> response) {
                String code = response.body().getCode();
                List<DataModel> item = response.body().getResult();
                if (code.equals("1")) {
                    RecycleManager = new LinearLayoutManager(ListDepanneur.this, LinearLayoutManager.VERTICAL, false);

                    RecycleLayout.setLayoutManager(RecycleManager);

                    depanneurAdapter = new DepanneurAdapter(item, ListDepanneur.this);

                    RecycleLayout.setAdapter(depanneurAdapter);
                }
            }

            @Override
            public void onFailure(Call<ResponseDataModel> call, Throwable t) {
                Toast.makeText(ListDepanneur.this, "Problem Connexion", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
