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

import org.w3c.dom.Text;

public class PlayerAdapter extends ArrayAdapter<Players>{

    Context mContext;
    int mLayoutResourceId;
    Players mData[] = null;

    public PlayerAdapter(Context mContext, int mLayoutResourceId, Players[] mData) {
        super(mContext, mLayoutResourceId , mData);
        this.mContext = mContext;
        this.mLayoutResourceId = mLayoutResourceId;
        this.mData = mData;
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
        LayoutInflater inflator = LayoutInflater.from(mContext);
        row = inflator.inflate(mLayoutResourceId , parent , false);

        ImageView mImage =  row.findViewById(R.id.mImage);
        TextView medium =  row.findViewById(R.id.mediumText);
        TextView small =  row.findViewById(R.id.smallText);

        //get data
        Players players = mData[position];



        //fill the cell
        medium.setText(players.playerName);
        small.setText(players.iplTeam);

        int resId = mContext.getResources().getIdentifier(players.mNameOfImage,"drawable",mContext.getPackageName());
        mImage.setImageResource(resId);

        return row;

    }


}
