package com.example.testwear;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class TeamAdapter extends ArrayAdapter<Team> {

    private Context mContext;
    private ArrayList<Team> teamArrayList = new ArrayList<>();

    public TeamAdapter(@NonNull Context context, ArrayList<Team> teams){
        super(context, R.layout.home_listitem_layout,teams);
        mContext = context;
        teamArrayList = teams;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        View listitem = convertView;
        listitem = LayoutInflater.from(mContext).inflate(R.layout.home_listitem_layout,parent,false);

        Team currentTeam = teamArrayList.get(position);

        TextView teamName = (TextView) listitem.findViewById(R.id.teamName);
        TextView teamLeader = (TextView) listitem.findViewById(R.id.teamLeader);
        TextView memberCount = (TextView) listitem.findViewById(R.id.memberCount);

        teamName.setText(currentTeam.getTeamName());
        teamLeader.setText(currentTeam.getTeamLeader());
        memberCount.setText(currentTeam.getNoMembers());

        return listitem;
    }
}
