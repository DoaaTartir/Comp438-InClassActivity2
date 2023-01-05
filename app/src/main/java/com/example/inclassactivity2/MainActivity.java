package com.example.inclassactivity2;

import static java.lang.Integer.valueOf;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
private EditText name;
private EditText salary;
private Spinner spn;
private Button btn;
private ListView lst;
ArrayList<Employee> employee=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupViews();
        spnMethod();
        btnMethod();

    }

    private void spnMethod() {
        String [] spnInfo = new String[2];
        spnInfo[0]= new String("Full time");
        spnInfo[1]=new String("Part Time");
        ArrayAdapter<String>spnAdapter=new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_item,spnInfo);
        spn.setAdapter(spnAdapter);
    }

    private void btnMethod() {
    btn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            employee.add(new Employee(name.getText().toString(), Integer.valueOf(salary.getText().toString())));
            String details=employee.toString();
            ArrayAdapter<Employee> adapter=new ArrayAdapter<Employee>(MainActivity.this, android.R.layout.simple_list_item_1,employee);
            lst.setAdapter(adapter);
        }
    });


    }

    private void setupViews() {
        name=findViewById(R.id.name);
        salary=findViewById(R.id.salary);
        spn=findViewById(R.id.spn);
        btn=findViewById(R.id.btn);
        lst=findViewById(R.id.lst);
    }
}