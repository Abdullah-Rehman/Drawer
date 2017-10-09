package com.abdullah_rehman.drawer;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;


public class RequestsListFragment extends Fragment {

    ListView List_no;
    ArrayList<RequestModel> requestList;
    RequestAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_requests_list, container, false);
        requestList = new ArrayList<>();

        for(int i=0; i<15; i++){
            RequestModel requestModel = new RequestModel();
            requestModel.setBloodGroup("A+ve");
            requestModel.setDate("Day "+i+1);
            requestModel.setCity("Faisalabad");
            requestList.add(requestModel);
        }

        adapter = new RequestAdapter(getActivity().getApplicationContext(), R.layout.single_row, requestList);

        List_no=(ListView) view.findViewById(R.id.List_no);

        List_no.setAdapter(adapter);
        return view;
    }


}
