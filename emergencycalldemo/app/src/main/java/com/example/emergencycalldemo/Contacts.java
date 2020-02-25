package com.example.emergencycalldemo;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Contacts extends Fragment {

    Button submit;
    SQLiteconn db;

     String n;
     String m;
     String p;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_add_contacts,null);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //db=new SQLiteconn(view.getContext());
        db=new SQLiteconn(view.getContext().getApplicationContext());

        final EditText name=view.findViewById(R.id.name);
        final EditText mobile=view.findViewById(R.id.phone);
        final EditText priority=view.findViewById(R.id.priority);




        submit=view.findViewById(R.id.addc);

        submit.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        /*if(n.trim().length()==0 || m.trim().length()==0 || p.trim().length()==0){
                            Toast.makeText(getContext().getApplicationContext(),"Please fill all details",Toast.LENGTH_LONG).show();
                        }
                        else {*/
                        n=name.getText().toString();
                        m=mobile.getText().toString();
                        p=priority.getText().toString();
                            Log.d("flow checking","kk");
                        Log.e("before call", "onClick: "+n+" "+m+" "+p);
                            boolean flag = db.insert(""+n, ""+m, ""+p);
                            String msg;
                            if (flag) {
                                msg = "Contact Added";
                            } else {
                                msg = "Record insertion failed";
                            }
                            Toast.makeText(getContext().getApplicationContext(), msg, Toast.LENGTH_LONG).show();
                            name.setText("");
                            mobile.setText("");
                            priority.setText("");
                            name.requestFocus();
                        }
                    //
                    // }
                }
        );
    }
}
