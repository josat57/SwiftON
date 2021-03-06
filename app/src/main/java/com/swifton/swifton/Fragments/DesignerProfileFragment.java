package com.swifton.swifton.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.swifton.swifton.Adpaters.DesignerprofileAdapter;
import com.swifton.swifton.DesignersProfileActivity;
import com.swifton.swifton.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Objects;


/**
 * A simple {@link Fragment} subclass.
 */
public class DesignerProfileFragment extends Fragment {
    FloatingActionButton editFab;
    TextView id, username, password, firstname, lastname,email, designerid, address,phone,position,deviceids, created_at, updated_at;

    RecyclerView recyclerView;
    DesignerprofileAdapter adapter;
    RequestQueue req;

    String DesignersURL = "http:192.168.43.53/swiftonbe/app/get_designers.php";

    public DesignerProfileFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_designer_profile, container, false);

        editFab = view.findViewById(R.id.editProfileFAB);
        id = view.findViewById(R.id.dsnid);
        username = view.findViewById(R.id.dsnusername);
        designerid = view.findViewById(R.id.designerID);
        firstname = view.findViewById(R.id.dsnfirstname);
        lastname = view.findViewById(R.id.dsnlastname);
        email = view.findViewById(R.id.dsnemail);
        password = view.findViewById(R.id.dsnpassword);
        address = view.findViewById(R.id.dsnaddress);
        phone = view.findViewById(R.id.dsnphone);
        position = view.findViewById(R.id.dsnposition);
        deviceids = view.findViewById(R.id.dsndeviceid);
        created_at = view.findViewById(R.id.dsncreated);
        updated_at = view.findViewById(R.id.dsnupdated);

        loadTopDesigners();

        editFab.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent editprofileIntent = new Intent(getActivity(), DesignersProfileActivity.class);
                startActivity(editprofileIntent);
                Objects.requireNonNull(getActivity()).overridePendingTransition(R.anim.fade_out, R.anim.fade_in);
            }
        });
        return view;
    }

    //Load the Top DesignersProfileHolder data
    private void loadTopDesigners(){

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, DesignersURL, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject designerObject) {
                try {
                        //get Jsonobjects

                        int mid = designerObject.getInt("id");
                        String musername = designerObject.getString("username");
                        String mdesignerid = designerObject.getString("designerid");
                        String mfirstname = designerObject.getString("firstname");
                        String mlastname = designerObject.getString("lastname");
                        String memail = designerObject.getString("email");
                        String mpassword = designerObject.getString("dpassword");
                        String maddress = designerObject.getString("daddress");
                        String mphoneno  = designerObject.getString("phoneno");
                        String mdposition = designerObject.getString("dposition");
                        String mdeviceids = designerObject.getString("deviceids");
                        String mcreated_at = designerObject.getString("created_at");
                        String mupdated_at = designerObject.getString("updated_at");
                        Toast.makeText(getActivity(), "Hey "+ musername, Toast.LENGTH_LONG).show();
//                                DesignersProfile designersProfile =  new DesignersProfile(mid, musername, mdesignerid, mfirstname, mlastname, memail, mpassword, maddress, mphoneno, mdposition, mdeviceids, mcreated_at, mupdated_at);
//                                mdesignersProfile.add(designersProfile);

                        id.setText(mid);
                        username.setText(musername);
                        password.setText(mpassword);
                        firstname.setText(mfirstname);
                        lastname.setText(mlastname);
                        email.setText(memail);
                        designerid.setText(mdesignerid);
                        address.setText(maddress);
                        phone.setText(mphoneno);
                        position.setText(mdposition);
                        deviceids.setText(mdeviceids);
                        created_at.setText(mcreated_at);
                        updated_at.setText(mupdated_at);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getActivity(), error.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

        Volley.newRequestQueue(getActivity()).add(jsonObjectRequest);
    }

}