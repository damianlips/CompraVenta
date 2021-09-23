package com.example.compraventa;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    EditText titulo;
    EditText descripcion;
    EditText correo;
    EditText precio;
    ArrayAdapter<CharSequence> adapter;
    EditText categoriaET;
    Switch ofrecerDescuentoSwitch;
    SeekBar descuentoSB;
    TextView progresoLbl;
    CheckBox retiroCB;
    EditText direccionRetiro;
    CheckBox terminos;
    Button publicar;
    Button cambiar_categoria;
    LinearLayout descuentoLayout;
    Categoria categoria;
    private static final int CODIGO_BUSCAR_CATEGORIA = 123;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        titulo = findViewById(R.id.tituloPublicacion);
        descripcion = findViewById(R.id.descripcion);
        correo = findViewById(R.id.correo);
        precio = findViewById(R.id.precio);
        ofrecerDescuentoSwitch = findViewById(R.id.switch_descuento);
        progresoLbl = findViewById(R.id.progreso_seek_lbl);
        retiroCB = findViewById(R.id.retiro_checkBox);
        direccionRetiro = findViewById(R.id.direccion_retiro);
        terminos = findViewById(R.id.terminos_checkBox);
        publicar = findViewById(R.id.publicar_button);
        descuentoSB = findViewById(R.id.seekBar_descuento);
        descuentoLayout = findViewById(R.id.descuento_layout);
        cambiar_categoria = findViewById(R.id.button_cambiar_categoria);
        categoriaET = findViewById(R.id.categoria_seleccionada);
        progresoLbl.setText(String.valueOf(descuentoSB.getProgress()));
        ofrecerDescuentoSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                /*
                if(b) descuentoLayout.setVisibility(View.VISIBLE);
                    else descuentoLayout.setVisibility(View.GONE);

                 */
                descuentoLayout.setVisibility(b? View.VISIBLE:View.GONE);
            }
        });
        descuentoLayout.setVisibility(View.GONE);
        retiroCB.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b) direccionRetiro.setVisibility(View.VISIBLE);
                else direccionRetiro.setVisibility(View.GONE);
            }
        });
        direccionRetiro.setVisibility(View.GONE);
        descuentoSB.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                progresoLbl.setText(String.valueOf(i));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        publicar.setEnabled(false);
        terminos.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b) publicar.setEnabled(true);
                else publicar.setEnabled(false);
            }
        });

        cambiar_categoria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CategoriasRecycler.class);
                startActivityForResult(intent,CODIGO_BUSCAR_CATEGORIA);

            }
        });

        publicar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int errores=0;
                if(titulo.getText().toString().equals("")) {
                    errores++;
                    Toast.makeText(MainActivity.this,R.string.error_titulo_vacio,Toast.LENGTH_SHORT).show();
                }
                else if(!Pattern.matches("[\\w\\s,\\.;:]+",titulo.getText().toString())){
                    errores++;
                    Toast.makeText(MainActivity.this,R.string.error_titulo_formato,Toast.LENGTH_LONG).show();
                }
                if(!Pattern.matches("[\\w\\s,\\.;:]*+",descripcion.getText().toString())){
                    errores++;
                    Toast.makeText(MainActivity.this,R.string.error_descripcion_formato,Toast.LENGTH_LONG).show();
                }

                if(!Pattern.matches("(\\S+@\\S{3,})?",correo.getText().toString())){
                    errores++;
                    Toast.makeText(MainActivity.this,R.string.error_correo_formato,Toast.LENGTH_LONG).show();
                }

                if(precio.getText().toString().equals("")) {
                    errores++;
                    Toast.makeText(MainActivity.this,R.string.error_precio_vacio,Toast.LENGTH_SHORT).show();
                }
                else if(Double.valueOf(precio.getText().toString())<=0){
                    errores++;
                    Toast.makeText(MainActivity.this,R.string.error_precio,Toast.LENGTH_LONG).show();
                }
                if(categoriaET.getText().equals(R.string.ninguna_categoria_seleccionada)){
                    errores++;
                    Toast.makeText(MainActivity.this,R.string.error_categoria_vacia,Toast.LENGTH_LONG).show();
                }

                if(ofrecerDescuentoSwitch.isChecked()){
                    if(descuentoSB.getProgress()==0){
                        errores++;
                        Toast.makeText(MainActivity.this,R.string.error_descuento,Toast.LENGTH_LONG).show();
                    }
                }

                if(retiroCB.isChecked()){
                    if(direccionRetiro.getText().toString().equals("")) {
                        errores++;
                        Toast.makeText(MainActivity.this,R.string.error_direccion_vacio,Toast.LENGTH_SHORT).show();
                    }
                    else if(!Pattern.matches("[\\w\\s,\\.;:]+",direccionRetiro.getText().toString())){
                        errores++;
                        Toast.makeText(MainActivity.this,R.string.error_direccion_formato,Toast.LENGTH_LONG).show();
                    }
                }
                if(errores==0) Toast.makeText(MainActivity.this,R.string.exito,Toast.LENGTH_LONG).show();


            }
        });


    }

    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if( resultCode == Activity.RESULT_OK){
            if(requestCode==CODIGO_BUSCAR_CATEGORIA){
                String nombreCategoria = data.getExtras().getString("nombre");
                String idCategoria = data.getExtras().getString("id");
                String colorCategoria = data.getExtras().getString("color");
                categoria = new Categoria(nombreCategoria,idCategoria,colorCategoria);
                categoriaET.setText(categoria.nombre);
                //categoriaET.setBackgroundColor(categoria.color);
            }
        }
    }


    }