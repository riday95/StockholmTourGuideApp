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
public class FoodFragment extends Fragment {

    public FoodFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.location_list, container, false);

        final ArrayList<Place> places = new ArrayList<Place>();

        places.add(new Place(R.string.fd_wienercafeet_title, R.string.fd_wienercafeet_des, R.string.fd_wienercafeet_add, R.string.fd_wienercafeet_tel, R.string.fd_wienercafeet_web, R.drawable.fd_wienercafeet));
        places.add(new Place(R.string.fd_greasyspoon_title, R.string.fd_greasyspoon_des, R.string.fd_greasyspoon_add, R.string.fd_greasyspoon_tel, R.string.fd_greasyspoon_web, R.drawable.fd_greasyspoon));
        places.add(new Place(R.string.fd_k25_title, R.string.fd_k25_des, R.string.fd_k25_add, R.string.fd_k25_tel, R.string.fd_k25_web, R.drawable.fd_k25));
        places.add(new Place(R.string.fd_stockholmsglasshus_title, R.string.fd_stockholmsglasshus_des, R.string.fd_stockholmsglasshus_add, R.string.fd_stockholmsglasshus_tel, R.string.fd_stockholmsglasshus_web, R.drawable.fd_stockholmsglasshus));
        places.add(new Place(R.string.fd_boqueria_title, R.string.fd_boqueria_des, R.string.fd_boqueria_add, R.string.fd_boqueria_tel, R.string.fd_boqueria_web, R.drawable.fd_boqueria));
        places.add(new Place(R.string.fd_bunmeatbun_title, R.string.fd_bunmeatbun_des, R.string.fd_boqueria_add, R.string.fd_boqueria_tel, R.string.fd_boqueria_web, R.drawable.fd_bunmeatbun));
        places.add(new Place(R.string.fd_surfers_title, R.string.fd_surfers_des, R.string.fd_surfers_add, R.string.fd_boqueria_tel, R.string.fd_boqueria_web, R.drawable.fd_surfers));
        places.add(new Place(R.string.fd_operakallaren_title, R.string.fd_operakallaren_des, R.string.fd_operakallaren_add, R.string.fd_operakallaren_tel, R.string.fd_operakallaren_web, R.drawable.fd_operakallaren));
        places.add(new Place(R.string.fd_gondolen_title, R.string.fd_gondolen_des, R.string.fd_gondolen_add, R.string.fd_gondolen_tel, R.string.fd_gondolen_web, R.drawable.fd_gondolen));
        places.add(new Place(R.string.fd_ilcaffe_title, R.string.fd_ilcaffe_des, R.string.fd_ilcaffe_add, R.string.fd_ilcaffe_tel, R.string.fd_ilcaffe_web, R.drawable.fd_ilcaffe));

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