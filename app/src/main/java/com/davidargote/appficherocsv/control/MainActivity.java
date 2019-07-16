package com.davidargote.appficherocsv.control;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.davidargote.appficherocsv.R;
import com.davidargote.appficherocsv.model.Datos;
import com.davidargote.appficherocsv.model.ManagerHelper;
import com.opencsv.CSVReader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.CharBuffer;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button btnCargar;
    private ListView listView;

    private File file;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        referenciar();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N){
            if(checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){
                ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 111);
            }
        }


        listar();
    }

    private void listar() {

        ManagerHelper managerHelper = new ManagerHelper(MainActivity.this);

        ArrayAdapter<Datos> adapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, managerHelper.listDatas());

        listView.setAdapter(adapter);

    }

    private void referenciar() {

        btnCargar = findViewById(R.id.btnCargar);
        listView = findViewById(R.id.lvLista);

        btnCargar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                importFile();
            }
        });

    }

    private void importFile() {

        ManagerHelper managerHelper = new ManagerHelper(MainActivity.this);

        File exportDir = new File(Environment.getExternalStorageDirectory(), "/Download");

        file = new File(exportDir, "datos.csv");

        try {

            CSVReader reader = new CSVReader(new FileReader(file));
            List<String[]> list = new ArrayList<>();
            String[] nextLine;

            while ((nextLine = reader.readNext()) != null){

                list.add(nextLine);

            }

            for (int i=0; i < list.size(); i++) {

                Datos datos = new Datos();

                String[] param = list.get(i);

                datos.setName(param[0]);
                datos.setState(param[1]);
                datos.setStateAbbrv(param[2]);

                long insert = managerHelper.insertDatas(datos);

                if (insert > 0) {
                    Toast.makeText(this, "Se registro", Toast.LENGTH_SHORT).show();
                } else {

                    Toast.makeText(this, "No inserto", Toast.LENGTH_SHORT).show();

                }
            }

            listar();

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
