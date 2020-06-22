package com.karanjah.myvolley;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.PicassoProvider;

import java.util.List;

public class DevelopersAdapter extends RecyclerView.Adapter<DevelopersAdapter.ViewHolder> {
//developerlist declaration
    private List<DeveloperList> developerList;

    private Context mContext;

    public static final String KEY_NAME="name";
    public static final String KEY_IMAGE="image";
    public static final String KEY_URL="url";

    public DevelopersAdapter(List<DeveloperList> developerList, Context mContext) {
        this.developerList = developerList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public DevelopersAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       return new
               ViewHolder((LayoutInflater.from(parent.getContext()).inflate(R.layout.developer_list,parent,false)));
    }

    @Override
    public void onBindViewHolder(@NonNull DevelopersAdapter.ViewHolder holder, final int position) {
final  DeveloperList currentDeveloper=developerList.get(position);

holder.login.setText(currentDeveloper.getLogin());
holder.html_url.setText(currentDeveloper.getHtml_url());

        Picasso.get()
                .load(currentDeveloper.getAvatar_url())
                .into(holder.avatar_url);

        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DeveloperList developerList1=developerList.get(position);

                Intent skipIntent=new Intent(view.getContext(),ProfileActivity.class);
                skipIntent.putExtra(KEY_NAME,developerList1.getLogin());
                skipIntent.putExtra(KEY_URL,developerList1.getHtml_url());
                skipIntent.putExtra(KEY_IMAGE,developerList1.getAvatar_url());
                view.getContext().startActivity(skipIntent);
            }
        });



    }

    @Override
    public int getItemCount() {
        return developerList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        //View objects Defined
        public TextView login;
        public ImageView avatar_url;
        public TextView html_url;
        public LinearLayout linearLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            login=itemView.findViewById(R.id.username);
            avatar_url=itemView.findViewById(R.id.imageView);
            html_url=itemView.findViewById(R.id.html_url);
            linearLayout=itemView.findViewById(R.id.linearLayout);
        }
    }
}
