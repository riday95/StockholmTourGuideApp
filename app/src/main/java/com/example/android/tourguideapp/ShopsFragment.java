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
public class ShopsFragment extends Fragment {

    public ShopsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.location_list, container, false);

        final ArrayList<Place> places = new ArrayList<Place>();

        places.add(new Place(R.string.sp_mallofscandinavia_title, R.string.sp_mallofscandinavia_des, R.string.sp_mallofscandinavia_add, R.string.sp_mallofscandinavia_tel, R.string.sp_mallofscandinavia_web, R.drawable.sp_mallofscandinavia));
        places.add(new Place(R.string.sp_moodstockholm_title, R.string.sp_moodstockholm_des, R.string.sp_moodstockholm_add, R.string.sp_moodstockholm_tel, R.string.sp_moodstockholm_web, R.drawable.sp_moodstockholm));
        places.add(new Place(R.string.sp_nk_title, R.string.sp_nk_des, R.string.sp_nk_add, R.string.sp_nk_tel, R.string.sp_nk_web, R.drawable.sp_nk));
        places.add(new Place(R.string.sp_gallerian_title, R.string.sp_gallerian_des, R.string.sp_gallerian_add, R.string.sp_gallerian_tel, R.string.sp_gallerian_web, R.drawable.sp_gallerian));
        places.add(new Place(R.string.sp_sturegallerian_title, R.string.sp_sturegallerian_des, R.string.sp_sturegallerian_add, R.string.sp_sturegallerian_tel, R.string.sp_sturegallerian_web, R.drawable.sp_sturegallerian));
        places.add(new Place(R.string.sp_ahlenscity_title, R.string.sp_ahlenscity_des, R.string.sp_ahlenscity_add, R.string.sp_ahlenscity_tel, R.string.sp_ahlenscity_web, R.drawable.sp_ahlenscity));
        places.add(new Place(R.string.sp_hm_title, R.string.sp_hm_des, R.string.sp_hm_add, R.string.sp_hm_tel, R.string.sp_hm_web, R.drawable.sp_hm));
        places.add(new Place(R.string.sp_sciencefictionbokhandeln_title, R.string.sp_sciencefictionbokhandeln_des, R.string.sp_sciencefictionbokhandeln_add, R.string.sp_sciencefictionbokhandeln_tel, R.string.sp_sciencefictionbokhandeln_web, R.drawable.sp_sciencefictionbokhandeln));
        places.add(new Place(R.string.sp_farmersmarket_title, R.string.sp_farmersmarket_des, R.string.sp_farmersmarket_add, R.string.sp_farmersmarket_tel, R.string.sp_farmersmarket_web, R.drawable.sp_farmersmarket));
        places.add(new Place(R.string.sp_soundpollution_title, R.string.sp_soundpollution_des, R.string.sp_soundpollution_add, R.string.sp_soundpollution_tel, R.string.sp_soundpollution_web, R.drawable.sp_soundpollution));

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