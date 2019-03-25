package com.sabrine.panne;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.sabrine.panne.Adapter.DepanneurAdapter;
import com.sabrine.panne.Adapter.MsgAdapter;
import com.sabrine.panne.Api.ApiRequest;
import com.sabrine.panne.Api.RetrofitService;
import com.sabrine.panne.model.DataModel;
import com.sabrine.panne.model.ResponseDataModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListMsg extends AppCompatActivity {
    private RecyclerView RecycleLayout;
    private RecyclerView.LayoutManager RecycleManager;
    private RecyclerView.Adapter msgAdapter;
    String idDepanneur;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_msg);
        RecycleLayout = findViewById(R.id.recyclerview);
        Bundle data = getIntent().getExtras();

        if (data != null) {
            idDepanneur= data.getString("idDepanneur");

        }
        ApiRequest api = RetrofitService.getClient().create(ApiRequest.class);
        Call<ResponseDataModel> getMessages=api.getMessages(idDepanneur);
        getMessages.enqueue(new Callback<ResponseDataModel>() {
            @Override
            public void onResponse(Call<ResponseDataModel> call, Response<ResponseDataModel> response) {
                String code = response.body().getCode();
                List<DataModel> item = response.body().getResult();
                if (code.equals("1")) {
                    RecycleManager = new LinearLayoutManager(ListMsg.this, LinearLayoutManager.VERTICAL, false);

                    RecycleLayout.setLayoutManager(RecycleManager);

                    msgAdapter = new MsgAdapter(item, ListMsg.this);

                    RecycleLayout.setAdapter(msgAdapter);
                }
            }

            @Override
            public void onFailure(Call<ResponseDataModel> call, Throwable t) {

            }
        });

    }
}
