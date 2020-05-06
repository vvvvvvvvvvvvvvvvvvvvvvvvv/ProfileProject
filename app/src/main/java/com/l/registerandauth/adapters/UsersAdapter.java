package com.l.registerandauth.adapters;

import android.content.Context;

import android.content.Intent;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.l.registerandauth.R;
import com.l.registerandauth.activities.ChatActivity;
import com.l.registerandauth.models.User;



import java.util.List;

import javax.xml.transform.Result;

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.UsersViewHolder> {

    private Context mCtx;
    private List<User> userList;

    public UsersAdapter(Context mCtx, List<User> userList) {
        this.mCtx = mCtx;
        this.userList = userList;
    }

    @NonNull
    @Override
    public UsersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mCtx).inflate(R.layout.recyclerview_users, parent, false);
        return new UsersViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UsersViewHolder holder, int position) {
        User user = userList.get(position);

        holder.textViewName.setText(user.getName());
        holder.textViewEmail.setText(user.getEmail());
        holder.textViewSchool.setText(user.getSchool());
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    class UsersViewHolder extends RecyclerView.ViewHolder {

        TextView textViewName, textViewEmail, textViewSchool;

        public UsersViewHolder(View itemView) {
            super(itemView);

            textViewName = itemView.findViewById(R.id.textViewName);
            textViewEmail = itemView.findViewById(R.id.textViewEmail);
            textViewSchool = itemView.findViewById(R.id.textViewSchool);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    int postion = getAdapterPosition();

                    if (postion != RecyclerView.NO_POSITION) {

                        User result = userList.get(postion);
                        Intent intent = new Intent(mCtx,
                                ChatActivity.class);
                        intent.putExtra("userData", result);
                        mCtx.startActivity(intent);


                    }

                }
            });
        }
    }
}
