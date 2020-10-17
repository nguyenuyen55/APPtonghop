package com.example.myapp;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.security.acl.LastOwnerException;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link listviewFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class listviewFragment extends Fragment {
    ListView listView;
    ImageView bn1,bn2;
    String mTitle[] = {"House 1", "House 2", "Home 3", "Home 4", "Home 5"};
    String mDescription[] = {"House 1 , 19 Ông Ích Khiêm ", "House 2, 02 Thanh Sơn ", "House 3, 48 Cao Thắng ", "House , Nhà của Uyên^^ ", "House 5 , 05 Nguyễn Văn Trỗi"};
    int images[] = {R.drawable.home1, R.drawable.home2, R.drawable.home3, R.drawable.hom4, R.drawable.home5};
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public listviewFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment listviewFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static listviewFragment newInstance(String param1, String param2) {
        listviewFragment fragment = new listviewFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.ds_main, container, false);
        // Inflate the layout for this fragment

        bn1=(ImageView) rootView.findViewById(R.id.di_den_profile) ;
        // Inflate the layout for this fragment
        bn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProfileFragment fragment = new ProfileFragment();
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fram_layout,fragment);
                fragmentTransaction.commit();
            }
        });

        listView =rootView.findViewById(R.id.lv33);
        // now create an adapter class

        listviewFragment.MyAdapter adapter = new listviewFragment.MyAdapter(getActivity(), mTitle, mDescription, images);
        listView.setAdapter(adapter);

        return rootView;

    }
    class MyAdapter extends ArrayAdapter<String> {

        Context context;
        String rTitle[];
        String rDescription[];
        int rImgs[];

        MyAdapter (Context c, String title[], String description[], int imgs[]) {
            super(c, R.layout.row, R.id.textview1, title);
            this.context = c;
            this.rTitle = title;
            this.rDescription = description;
            this.rImgs = imgs;

        }


        @Override
        public View getView(int position,  View convertView,  ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.row, parent, false);
            ImageView images = row.findViewById(R.id.image);
            TextView myTitle = row.findViewById(R.id.textview1);
            TextView myDescription = row.findViewById(R.id.textview2);

            // now set our resources on views
            images.setImageResource(rImgs[position]);
            myTitle.setText(rTitle[position]);
            myDescription.setText(rDescription[position]);




            return row;
        }
    }
}