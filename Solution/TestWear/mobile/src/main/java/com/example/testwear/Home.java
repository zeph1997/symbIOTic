package com.example.testwear;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.wearable.CapabilityClient;
import com.google.android.gms.wearable.CapabilityInfo;
import com.google.android.gms.wearable.MessageClient;
import com.google.android.gms.wearable.MessageEvent;
import com.google.android.gms.wearable.Node;
import com.google.android.gms.wearable.Wearable;
import com.google.android.gms.wearable.WearableListenerService;

import java.util.ArrayList;
import java.util.Set;

public class Home extends AppCompatActivity {

    Set nodes;
    ArrayList<Team> teamArrayList = new ArrayList<>();
    TeamAdapter teamAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView lv = (ListView) findViewById(R.id.lv);

        teamArrayList.clear();
        Team currTeam = new Team("Alpha","Dante Liew","4");
        teamArrayList.add(currTeam);

        teamAdapter = new TeamAdapter(getApplicationContext(),teamArrayList);
        teamAdapter.notifyDataSetChanged();
        lv.setAdapter(teamAdapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent nextPage = new Intent(getApplicationContext(),Members.class);
                startActivity(nextPage);
            }
        });

        Task<CapabilityInfo> capabilityInfoTask = Wearable.getCapabilityClient(getApplicationContext())
                .getCapability("watch", CapabilityClient.FILTER_REACHABLE);

        capabilityInfoTask.addOnCompleteListener(new OnCompleteListener<CapabilityInfo>() {
            @Override
            public void onComplete(Task<CapabilityInfo> task) {

                if (task.isSuccessful()) {
                    CapabilityInfo capabilityInfo = task.getResult();
                    nodes = capabilityInfo.getNodes();
                } else {
                    Log.d("D:", "Capability request failed to return any results.");
                }

            }
        });

        Wearable.getMessageClient(getApplicationContext()).addListener(new MessageClient.OnMessageReceivedListener() {
            @Override
            public void onMessageReceived(@NonNull MessageEvent messageEvent) {
                switch(messageEvent.getPath()){
                    case "/sendMessage":

                        break;
                    default:
                        break;
                }
            }
        });
    }

}
