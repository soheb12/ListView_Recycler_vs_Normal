package com.example.venkatpinnamani.mylistview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class PlayerAdapterRecycler extends ArrayAdapter<Players>{

    Context mContext;
    int mLayoutResourceId;
    Players mData[];

    public PlayerAdapterRecycler(@NonNull Context context, int resource, Players[] data) {
        super(context, resource , data);
        this.mContext = context;
        this.mLayoutResourceId = resource;
        this.mData = data;
    }

    @Nullable
    @Override
    public Players getItem(int position) {
        return super.getItem(position);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View row = convertView;

        PlayerHolder holder = null;

        if(row == null)
        {
            //inflate the view
            LayoutInflater inflater = LayoutInflater.from(mContext);
            row = inflater.inflate(mLayoutResourceId,parent,false);

            holder = new PlayerHolder();

            holder.medium = row.findViewById(R.id.mediumText);
            holder.small = row.findViewById(R.id.smallText);
            holder.imageView = row.findViewById(R.id.mImage);

            row.setTag(holder);
        }else{
            holder = (PlayerHolder) row.getTag();
        }

        Players players = mData[position];

        //setup and reuse
        holder.imageView.setOnClickListener(popUpListener);
        Integer rowPos = position;
        holder.imageView.setTag(rowPos);

        holder.medium.setText(players.playerName);
        holder.small.setText(players.iplTeam);

        int resId = mContext.getResources().getIdentifier(players.mNameOfImage,"drawable",mContext.getPackageName());
        holder.imageView.setImageResource(resId);

        return row;

    }

    View.OnClickListener popUpListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Integer viewPos = (Integer) v.getTag();
            Players players = mData[viewPos];
            Toast.makeText(getContext() , "My Jersy Number Is : " + players.jerseyNumber , Toast.LENGTH_SHORT).show();

        }
    };

    private static class PlayerHolder
    {
        TextView small;
        TextView medium;
        ImageView imageView;
    }
}
