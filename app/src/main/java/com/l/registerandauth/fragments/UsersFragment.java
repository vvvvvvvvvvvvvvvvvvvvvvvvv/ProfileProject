package com.l.registerandauth.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.l.registerandauth.R;
import com.l.registerandauth.activities.MainActivity;
import com.l.registerandauth.activities.ProfileActivity;
import com.l.registerandauth.adapters.UsersAdapter;
import com.l.registerandauth.models.User;
import com.l.registerandauth.models.UsersResponse;
import com.l.registerandauth.service.RetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UsersFragment extends Fragment  {

    private RecyclerView recyclerView;
    UsersAdapter usersAdapter;
    private List<User> userList;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.users_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        Call<UsersResponse> call = RetrofitClient.getInstance().getApi().getUser();
        call.enqueue(new Callback<UsersResponse>() {
            @Override
            public void onResponse(Call<UsersResponse> call, Response<UsersResponse> response) {
                userList =  response.body().getUsers();
                usersAdapter = new UsersAdapter(getActivity(), userList);
                recyclerView.setAdapter(usersAdapter);


            }

            @Override
            public void onFailure(Call<UsersResponse> call, Throwable t) {

            }
        });


    }
}
