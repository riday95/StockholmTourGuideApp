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
public class SightsFragment extends Fragment {

    public SightsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.location_list, container, false);

        final ArrayList<Place> places = new ArrayList<Place>();

        places.add(new Place(R.string.sh_stadshuset_title, R.string.sh_stadshuset_des,R.string.sh_stadshuset_add,R.string.sh_stadshuset_tel,R.string.sh_stadshuset_web, R.drawable.sh_stadshuset));
        places.add(new Place(R.string.sh_rosendalsslott_title, R.string.sh_rosendalsslott_des,R.string.sh_rosendalsslott_add,R.string.sh_rosendalsslott_tel,R.string.sh_rosendalsslott_web, R.drawable.sh_rosendalsslott));
        places.add(new Place(R.string.sh_gamlastan_title, R.string.sh_gamlastan_des,R.string.sh_gamlastan_add,R.string.sh_gamlastan_tel,R.string.sh_gamlastan_web, R.drawable.sh_gamlastan));
        places.add(new Place(R.string.sh_kungligaslottet_title, R.string.sh_kungligaslottet_des,R.string.sh_kungligaslottet_add,R.string.sh_kungligaslottet_tel,R.string.sh_kungligaslottet_web, R.drawable.sh_kungligastottet));
        places.add(new Place(R.string.sh_dramaten_title, R.string.sh_dramaten_des,R.string.sh_dramaten_add,R.string.sh_dramaten_tel,R.string.sh_dramaten_web, R.drawable.sh_dramaten));
        places.add(new Place(R.string.sh_skinnarviksberget_title, R.string.sh_skinnarviksberget_des,R.string.sh_skinnarviksberget_add,R.string.sh_skinnarviksberget_tel,R.string.sh_skinnarviksberget_web, R.drawable.sh_skinnarviksberget));
        places.add(new Place(R.string.sh_globen_title, R.string.sh_globen_des,R.string.sh_globen_add,R.string.sh_globen_tel,R.string.sh_globen_web, R.drawable.sh_globen));
        places.add(new Place(R.string.sh_vasamuseet_title, R.string.sh_vasamuseet_des,R.string.sh_vasamuseet_add,R.string.sh_vasamuseet_tel,R.string.sh_vasamuseet_web, R.drawable.sh_vasamuseet));
        places.add(new Place(R.string.sh_gronalund_title, R.string.sh_gronalund_des,R.string.sh_gronalund_add,R.string.sh_gronalund_tel,R.string.sh_gronalund_web, R.drawable.sh_gronalund));
        places.add(new Place(R.string.sh_skansen_title, R.string.sh_skansen_des,R.string.sh_skansen_add,R.string.sh_skansen_tel,R.string.sh_skansen_web, R.drawable.sh_skansen));

        // adapter knows how to create list items for each item in the list.
        PlaceAdapter adapter = new PlaceAdapter(getActivity(), places);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // location_list.xml layout file.
        ListView listView = (ListView) rootView.findViewById(R.id.location_list);

        // Make the {@link ListView} use the {@link PlaceAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Place} in the list.
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