package com.mirea.kt.homework4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText ed1, ed2, ed3;
    private DBManager dbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.dbManager = new DBManager(new MyAppSQLiteHelper(this, "my_database.db", null, 1));
        ed1 = findViewById(R.id.etModel);
        ed2 = findViewById(R.id.etNumber);
        ed3 = findViewById(R.id.etAge);
        Button btAdd = findViewById(R.id.btAdd);
        Button btNext = findViewById(R.id.btNext);
        btAdd.setOnClickListener(this);
        btNext.setOnClickListener(this);
        Toast.makeText(this, R.string.INFO, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onClick(View v){
        if (v.getId()==R.id.btAdd){
            if (this.dbManager!=null){
                String model = ed1.getText().toString();
                String number = ed2.getText().toString();
                String age = ed3.getText().toString();
                if (!model.isEmpty() && !number.isEmpty() && !age.isEmpty()){
                    boolean res = dbManager.saveCarToDatabase(new Car(model, number, Integer.parseInt(age)));
                    if (res){
                        Toast.makeText(this, R.string.insert_success, Toast.LENGTH_LONG).show();
                        Log.i("car_app", "Запись успешно создана");
                    }else{
                        Toast.makeText(this, R.string.insert_error, Toast.LENGTH_LONG).show();
                        Log.d("car_app", "Ошибка при добавлении");
                    }
                }else{
                    Toast.makeText(this, R.string.incorrect_value, Toast.LENGTH_LONG).show();
                    Log.d("car_app", "Значение некорректно");
                }
            }
        }else if (v.getId()==R.id.btNext){
            Intent intent = new Intent(this, CarActivity.class);
            ArrayList<Car> cars = dbManager.loadAllCarsFromDatabase();
            Bundle b = new Bundle();
            b.putSerializable("CARS", (Serializable) cars);
            intent.putExtra("BUNDLE", b);
            startActivity(intent);
            Log.i("car_app", "Отображение списка");
        }
    }
}