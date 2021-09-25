package com.example.blockid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.DocumentsContract;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import net.gotev.uploadservice.MultipartUploadRequest;
import net.gotev.uploadservice.ServerResponse;
import net.gotev.uploadservice.UploadInfo;
import net.gotev.uploadservice.UploadStatusDelegate;
import java.io.File;
import java.util.ArrayList;

public class Home extends AppCompatActivity {
    private ArrayList<String> names;
    public static final String ID = ":C";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Intent intent = getIntent();
        String userName = "Hola! "+intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        ImageButton add_button = (ImageButton) findViewById(R.id.add_button);
        TextView nameUser= (TextView) findViewById(R.id.Name_user);
        ListView list_files = (ListView) findViewById(R.id.list_item);
        names = new ArrayList<String>();

        names.add("curp.pdf");
        names.add("Acta_nacimiento.pdf");
        names.add("ine.pdf");
        names.add("Licencia.pdf");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, names);
        list_files.setAdapter(adapter);

        list_files.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
    Toast.makeText(Home.this, "Has pulsado: "+ names.get(position), Toast.LENGTH_LONG).show();
        Intent intent2 = new Intent(Home.this, qr_view.class);
        intent2.putExtra(ID, names.get(position));
        startActivity(intent2);
     }
    });


        nameUser.setText(userName);

        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar ok = Snackbar.make(v , "AGREGAR", 3000);
                ok.show();

                openFile();

            }
        });
    }

    private void openFile() {
        Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        intent.setType("application/pdf");
        startActivityForResult(intent, 2);
    }
}