package com.zy.helia;

import android.content.Context;
import android.content.Intent;
<<<<<<< HEAD
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
=======
>>>>>>> 87093b909797f1ff279ac9d861a62a049b3ff1f2
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


import com.zy.helia.Activities.EventDetail;
import java.util.ArrayList;


public class EventFragmentAdapter extends RecyclerView.Adapter<EventFragmentAdapter.ViewHolder> {

    private static Context context;
    private int totalCount;
    private ArrayList<String> EventName;
<<<<<<< HEAD

    private Button button;

=======
>>>>>>> 87093b909797f1ff279ac9d861a62a049b3ff1f2

    private Button button;

<<<<<<< HEAD


    public EventFragmentAdapter(Context context, ArrayList<String> EventName) {

        this.context = context;
=======
    // two parameter for this class - context and an ArrayList containing the EventName to be in the recyclerView
    public EventFragmentAdapter(Context context, ArrayList<String> EventName) {
        this.context = context;
        // get the number of EventName when the class is constructed
>>>>>>> 87093b909797f1ff279ac9d861a62a049b3ff1f2
        this.totalCount = EventName.size();
        this.EventName = EventName;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public Button button;
        // each data item is just a string in this case
        public ViewHolder(final View v) {
            super(v);
            button = v.findViewById(R.id.button);
        }
    }


    @Override
    public EventFragmentAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_event_adapter, parent, false);
        ViewHolder vh = new ViewHolder(v);



        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull final EventFragmentAdapter.ViewHolder holder, final int position) {
<<<<<<< HEAD

        Toast.makeText(context,"WuZiang",Toast.LENGTH_LONG).show();
        Toast.makeText(context, "onBindViewHolder", Toast.LENGTH_SHORT).show();

        try {
            DatabaseHelp db = new DatabaseHelp(context);
            eventds = db.viewPendingEvents();
            if(eventds==null)
                Toast.makeText(context,"Null",Toast.LENGTH_LONG).show();
        }
        catch (Exception e){
            Toast.makeText(context,"Error",Toast.LENGTH_LONG).show();
        }
        while (eventds.moveToNext())
        {
            int eventIndex = eventds.getColumnIndex("Event_Name");
            String eventName = eventds.getString(eventIndex);
            Toast.makeText(context,eventName,Toast.LENGTH_LONG).show();
            EventName.add(eventName);
        }
        button.setText(EventName.get(position));



        holder.button.setText(EventName.get(position));

=======
        holder.button.setText(EventName.get(position));

>>>>>>> 87093b909797f1ff279ac9d861a62a049b3ff1f2
        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // pass information to another activity started by click the button
                Intent startNewActivity = new Intent(context,EventDetail.class);

                startNewActivity.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startNewActivity.putExtra("EventName", EventName.get(position));

                context.startActivity(startNewActivity);

            }
        });




    }

    @Override
    // the getItemCount should return the size of the ArrayList
    public int getItemCount() {
        return totalCount;
    }
}