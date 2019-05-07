package graficos.curso.ejercicios.a03_citas_medicas_resuelto;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TimePicker;

public class MainActivity extends Activity {

    String hora="",fecha="",tipo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void hora(View v){
        TimePickerDialog tpd=new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int i, int i1) {
                        hora=i+":"+i1;
                    }
                },
                10,
                20,
                true);
        tpd.show();
    }
    public void fecha(View v){
        DatePickerDialog dpd=new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        fecha=i2+"/"+(i1+1)+"/"+i;
                    }
                },
                2017,
                4,
                30);
        dpd.show();
    }
    public void citar(View v){
        Intent in=new Intent(this,CitasActivity.class);
        EditText edtNombre=this.findViewById(R.id.edtNombre);
        //comprobar el tipo de consulta
        RadioGroup rgTipo=this.findViewById(R.id.rgTipo);
        switch(rgTipo.getCheckedRadioButtonId()){
            case R.id.rbGeneral:
                tipo="Consulta general";
                break;
            case R.id.rbPediatria:
                tipo="Consulta pediatría";
                break;
        }
        //guardamos datos en el Intent
        in.putExtra("nombre","nombre: "+edtNombre.getText().toString());
        in.putExtra("hora","La hora: "+hora);
        in.putExtra("fecha","La fecha: "+fecha);
        in.putExtra("tipo","El tipo: "+tipo);
        this.startActivity(in);

    }
}
