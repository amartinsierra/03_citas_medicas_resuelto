package graficos.curso.ejercicios.a03_citas_medicas_resuelto;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class CitasActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_citas);
        TextView tvConfirmacion=this.findViewById(R.id.tvConfirmacion);
        Intent in=this.getIntent();
        tvConfirmacion.setText(in.getStringExtra("nombre")+"\n"+
        in.getStringExtra("fecha")+"\n"+
        in.getStringExtra("hora")+"\n"+
        in.getStringExtra("tipo"));
    }
}
