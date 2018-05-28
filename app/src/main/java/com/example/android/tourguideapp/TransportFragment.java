package com.example.android.tourguideapp;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class TransportFragment extends Fragment {

    public TransportFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.location_list, container, false);

        final ArrayList<Place> places = new ArrayList<Place>();

        places.add(new Place(R.string.tp_sl_title, R.string.tp_sl_des,R.string.tp_sl_add,R.string.tp_sl_tel,R.string.tp_sl_web, R.drawable.tp_sl));
        places.add(new Place(R.string.tp_hoponhopoff_title, R.string.tp_hoponhopoff_des,R.string.tp_hoponhopoff_add,R.string.tp_hoponhopoff_tel,R.string.tp_hoponhopoff_web, R.drawable.tp_hoponhopoff));
        places.add(new Place(R.string.tp_oceanbus_title, R.string.tp_oceanbus_des,R.string.tp_oceanbus__add,R.string.tp_oceanbus__tel,R.string.tp_oceanbus__web, R.drawable.tp_oceanbus));

        // Create an {@link WordAdapter}, whose data source is a list of {@link Word}s. The
        // adapter knows how to create list items for each item in the list.
        PlaceAdapter adapter = new PlaceAdapter(getActivity(), places);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // word_list.xml layout file.
        ListView listView = (ListView) rootView.findViewById(R.id.location_list);

        // Make the {@link ListView} use the {@link WordAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Word} in the list.
        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), PlaceActivity.class);
                intent.putExtra("PLACES", places.get(position));
                startActivity(intent);
            }
        });

        return rootView;
    }
}