package com.l.registerandauth.adapters;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.l.registerandauth.R;

class UsersViewHolder extends RecyclerView.ViewHolder {

    TextView textViewName, textViewEmail, textViewSchool;

    public UsersViewHolder(View itemView) {
        super(itemView);

        textViewName = itemView.findViewById(R.id.textViewName);
        textViewEmail = itemView.findViewById(R.id.textViewEmail);
        textViewSchool = itemView.findViewById(R.id.textViewSchool);


    }


}
