package com.jhonnatan.ajedrez;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Arrays;

public class tablero extends AppCompatActivity {
    //Declaración de variables
    String numCaso,fAlfil,cAlfil,fTorre,cTorre;
    Button[] buttonArray=new Button[64];
    TextView txtBlancas,txtNegras;
    LinearLayout overbox;
    int[] casillasBlancas= {0,2,4,6,9,11,13,15,16,18,20,22,25,27,29,31,32,34,36,38,41,43,45,47,48,50,52,54,57,59,61,63};
    int auxCasillaAlfil=0,auxCasillaTorre=0;
    int[] posiblesAlfil = new int[20];
    int[] posiblesTorre = new int[20];
    int[][] matriz = {{0,1,2,3,4,5,6,7},{8,9,10,11,12,13,14,15},{16,17,18,19,20,21,22,23},{24,25,26,27,28,29,30,31},
            {32,33,34,35,36,37,38,39},{40,41,42,43,44,45,46,47},{48,49,50,51,52,53,54,55},{56,57,58,59,60,61,62,63}};
    int posA,posT,FA,FT,CA,CT,auxTurno=0;
    String auxCerrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tablero);

        //capturamos datos del activity anterior
        numCaso = getIntent().getStringExtra("CASO");
        fAlfil = getIntent().getStringExtra("FILAALFIL");
        cAlfil = getIntent().getStringExtra("COLUMNAALFIL");
        fTorre = getIntent().getStringExtra("FILATORRE");
        cTorre = getIntent().getStringExtra("COLUMNATORRE");

        //Declaración de instancias
        buttonArray[0] = (Button)findViewById(R.id.btn11);
        buttonArray[1] = (Button)findViewById(R.id.btn12);
        buttonArray[2] = (Button)findViewById(R.id.btn13);
        buttonArray[3] = (Button)findViewById(R.id.btn14);
        buttonArray[4] = (Button)findViewById(R.id.btn15);
        buttonArray[5] = (Button)findViewById(R.id.btn16);
        buttonArray[6] = (Button)findViewById(R.id.btn17);
        buttonArray[7] = (Button)findViewById(R.id.btn18);
        buttonArray[8] = (Button)findViewById(R.id.btn21);
        buttonArray[9] = (Button)findViewById(R.id.btn22);
        buttonArray[10] = (Button)findViewById(R.id.btn23);
        buttonArray[11] = (Button)findViewById(R.id.btn24);
        buttonArray[12] = (Button)findViewById(R.id.btn25);
        buttonArray[13] = (Button)findViewById(R.id.btn26);
        buttonArray[14] = (Button)findViewById(R.id.btn27);
        buttonArray[15] = (Button)findViewById(R.id.btn28);
        buttonArray[16] = (Button)findViewById(R.id.btn31);
        buttonArray[17] = (Button)findViewById(R.id.btn32);
        buttonArray[18] = (Button)findViewById(R.id.btn33);
        buttonArray[19] = (Button)findViewById(R.id.btn34);
        buttonArray[20] = (Button)findViewById(R.id.btn35);
        buttonArray[21] = (Button)findViewById(R.id.btn36);
        buttonArray[22] = (Button)findViewById(R.id.btn37);
        buttonArray[23] = (Button)findViewById(R.id.btn38);
        buttonArray[24] = (Button)findViewById(R.id.btn41);
        buttonArray[25] = (Button)findViewById(R.id.btn42);
        buttonArray[26] = (Button)findViewById(R.id.btn43);
        buttonArray[27] = (Button)findViewById(R.id.btn44);
        buttonArray[28] = (Button)findViewById(R.id.btn45);
        buttonArray[29] = (Button)findViewById(R.id.btn46);
        buttonArray[30] = (Button)findViewById(R.id.btn47);
        buttonArray[31] = (Button)findViewById(R.id.btn48);
        buttonArray[32] = (Button)findViewById(R.id.btn51);
        buttonArray[33] = (Button)findViewById(R.id.btn52);
        buttonArray[34] = (Button)findViewById(R.id.btn53);
        buttonArray[35] = (Button)findViewById(R.id.btn54);
        buttonArray[36] = (Button)findViewById(R.id.btn55);
        buttonArray[37] = (Button)findViewById(R.id.btn56);
        buttonArray[38] = (Button)findViewById(R.id.btn57);
        buttonArray[39] = (Button)findViewById(R.id.btn58);
        buttonArray[40] = (Button)findViewById(R.id.btn61);
        buttonArray[41]= (Button)findViewById(R.id.btn62);
        buttonArray[42] = (Button)findViewById(R.id.btn63);
        buttonArray[43] = (Button)findViewById(R.id.btn64);
        buttonArray[44] = (Button)findViewById(R.id.btn65);
        buttonArray[45] = (Button)findViewById(R.id.btn66);
        buttonArray[46] = (Button)findViewById(R.id.btn67);
        buttonArray[47] = (Button)findViewById(R.id.btn68);
        buttonArray[48]= (Button)findViewById(R.id.btn71);
        buttonArray[49] = (Button)findViewById(R.id.btn72);
        buttonArray[50] = (Button)findViewById(R.id.btn73);
        buttonArray[51] = (Button)findViewById(R.id.btn74);
        buttonArray[52] = (Button)findViewById(R.id.btn75);
        buttonArray[53]= (Button)findViewById(R.id.btn76);
        buttonArray[54] = (Button)findViewById(R.id.btn77);
        buttonArray[55] = (Button)findViewById(R.id.btn78);
        buttonArray[56] = (Button)findViewById(R.id.btn81);
        buttonArray[57] = (Button)findViewById(R.id.btn82);
        buttonArray[58] = (Button)findViewById(R.id.btn83);
        buttonArray[59] = (Button)findViewById(R.id.btn84);
        buttonArray[60] = (Button)findViewById(R.id.btn85);
        buttonArray[61] = (Button)findViewById(R.id.btn86);
        buttonArray[62] = (Button)findViewById(R.id.btn87);
        buttonArray[63] = (Button)findViewById(R.id.btn88);

        txtBlancas= (TextView)findViewById(R.id.textView4);
        txtNegras= (TextView)findViewById(R.id.textView3);

        overbox = (LinearLayout)findViewById(R.id.OverBox);

        //Inicializamos el vector de posiciones a -1
        inicializar();

        //convertimos el valor de la posición del alfil en Numeros
        FA= Integer.parseInt(fAlfil);
        CA= Integer.parseInt(cAlfil);
        //convertimos el valor de la posición de la torre en Numeros
        FT= Integer.parseInt(fTorre);
        CT= Integer.parseInt(cTorre);
        //Calculamos el valor de la matriz segun la posicion de la ficha
        posA=matriz[FA][CA];
        posT=matriz[FT][CT];
        //Condiciones iniciales
        condicionesIniciales();

        //Definimos la funcion cuando se da clic en cualquier boton de la pantalla
        for (int x=0;x<buttonArray.length;x++){
            final int finalX = x;
            buttonArray[x].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Comportamiento cuando estamos en el primer caso
                    switch (numCaso) {
                        case "1": {
                            int aaaa = 0;
                            //Comparamos si el usuario da clic en los posibles del Alfil
                            for (int i : posiblesAlfil) {
                                if (i == finalX) {
                                    aaaa = 1;
                                    break;
                                }
                            }
                            //Validamos si esta en la posibilidades
                            if (aaaa == 1) {
                                if (finalX == posT) {
                                    //Mostramos mensaje de que Captura el alfil
                                    auxCerrar = "1";
                                    mostrarMensaje(getResources().getString(R.string.msj10), getResources().getString(R.string.msj11));
                                } else {
                                    //Mostramos mensaje de que No ha capturado
                                    auxCerrar = "0";
                                    mostrarMensaje(getResources().getString(R.string.msj13), getResources().getString(R.string.msj12));
                                }
                            }
                            break;
                        }
                        case "2": {
                            //Comportamiento cuando estamos en el segundo caso
                            int aaaa = 0;
                            //Comparamos si el usuario da clic en los posibles del Alfil
                            for (int i : posiblesTorre) {
                                if (i == finalX) {
                                    aaaa = 1;
                                    break;
                                }
                            }
                            //Validamos si esta en la posibilidades
                            if (aaaa == 1) {
                                if (finalX == posA) {
                                    //Mostramos mensaje de que Captura La Torre
                                    auxCerrar = "1";
                                    mostrarMensaje(getResources().getString(R.string.msj10), getResources().getString(R.string.msj14));
                                } else {
                                    //Mostramos mensaje de que No ha capturado
                                    auxCerrar = "0";
                                    mostrarMensaje(getResources().getString(R.string.msj13), getResources().getString(R.string.msj15));
                                }
                            }
                            break;
                        }
                        case "3":
                            if (auxTurno == 0) {
                                int aaaa = 0;
                                //Comparamos si el usuario da clic en los posibles del Alfil
                                for (int i : posiblesAlfil) {
                                    if (i == finalX) {
                                        aaaa = 1;
                                        break;
                                    }
                                }
                                //Validamos si esta en la posibilidades
                                if (aaaa == 1) {
                                    if (finalX == posT) {
                                        //Mostramos mensaje de que Captura el alfil
                                        auxCerrar = "1";
                                        mostrarMensaje(getResources().getString(R.string.msj10), getResources().getString(R.string.msj11));
                                    } else {
                                        //desplazamos el alfil
                                        auxTurno = 1;
                                        barrarposicionAlfil(posA);
                                        posA = finalX;
                                        FA = calcularFila(posA);
                                        CA = calcularColumna(posA);
                                        condicionesInicialesTercerCaso();
                                        txtBlancas.setAlpha(0);
                                        txtNegras.setAlpha(1);
                                        Arrays.fill(posiblesAlfil, -1);
                                        calcularPosicionTorre(FT, CT);
                                    }
                                }
                            } else {
                                int aaaa = 0;
                                //Comparamos si el usuario da clic en los posibles del Alfil
                                for (int i : posiblesTorre) {
                                    if (i == finalX) {
                                        aaaa = 1;
                                        break;
                                    }
                                }
                                //Validamos si esta en la posibilidades
                                if (aaaa == 1) {
                                    if (finalX == posA) {
                                        //Mostramos mensaje de que Captura La Torre
                                        auxCerrar = "1";
                                        mostrarMensaje(getResources().getString(R.string.msj10), getResources().getString(R.string.msj14));
                                    } else {
                                        //Desplazamos la torre
                                        auxTurno = 0;
                                        borrarposicionTorre(posT);
                                        posT = finalX;
                                        FT = calcularFila(posT);
                                        CT = calcularColumna(posT);
                                        condicionesInicialesTercerCaso();
                                        txtBlancas.setAlpha(1);
                                        txtNegras.setAlpha(0);
                                        for (int x = 0; x < posiblesAlfil.length; x++) {
                                            posiblesTorre[x] = -1;
                                        }
                                        calcularPosicionAlfil(FA, CA);
                                    }
                                }
                            }
                            break;
                        default:
                            throw new IllegalStateException("Unexpected value: " + numCaso);
                    }
                }
            });
        }
    }

    //Esta funcion nos permite borrar la posicion de la torre
    private void borrarposicionTorre(int posT) {
        for (int i : posiblesTorre) {
            if (i != -1) {
                int aa = 0;
                //Verificamos si esta en celda blanca o negra
                for (int casillasBlanca : casillasBlancas) {
                    if (i == casillasBlanca) {
                        aa = 1;
                        break;
                    }
                }
                if (aa == 0) {
                    buttonArray[i].setBackgroundResource(R.drawable.cuadro_negro_inicial);
                } else {
                    buttonArray[i].setBackgroundResource(R.drawable.cuadro_blanco_inicial);
                }
            }
        }
        int aa=0;
        //Verificamos si esta en celda blanca o negra
        for (int casillasBlanca : casillasBlancas) {
            if (posT == casillasBlanca) {
                aa = 1;
                break;
            }
        }

        //Dependiendo el color de la posicion de la celda se muestra la ficha
        if(aa==0) {
            buttonArray[posT].setBackgroundResource(R.drawable.cuadro_negro_inicial);
        }else {
            buttonArray[posT].setBackgroundResource(R.drawable.cuadro_blanco_inicial);
        }
        buttonArray[posT].setPadding(11,0,0,0);
        buttonArray[posT].setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);




    }

    //metodo para calcular filas
    private int calcularFila(int posA) {
        int aux=0;
        for (int x=0; x < matriz.length; x++) {
            for (int y=0; y < matriz[x].length; y++) {
                if (matriz[x][y] == posA) {
                    aux = x;
                    break;
                }
            }
        }
        return aux;
    }

    //metodo para calcular columnas
    private int calcularColumna(int posA) {
        int aux=0;
        for (int[] ints : matriz) {
            for (int y = 0; y < ints.length; y++) {
                if (ints[y] == posA) {
                    aux = y;
                }
            }
        }
        return aux;
    }

    //Funcion que nos permite borrar las posiciones del alfil
    private void barrarposicionAlfil(int posA) {
        for (int i : posiblesAlfil) {
            if (i != -1) {
                buttonArray[i].setBackgroundResource(R.drawable.cuadro_blanco_inicial);
            }
        }
        //Quitamos del tablero la posicion anterior
        buttonArray[posA].setBackgroundResource(R.drawable.cuadro_blanco_inicial);
        buttonArray[posA].setPadding(11,0,0,0);
        buttonArray[posA].setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);

    }

    //Funcion para mostrar un dialogo
    private void mostrarMensaje(String titulo, String msg) {
        overbox.setAlpha(0);
        AlertDialog dialog = new AlertDialog.Builder(this,R.style.CustomDialogTheme)
                .setTitle(titulo)
                .setMessage(Html.fromHtml(msg))
                .setPositiveButton("Cerrar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if(auxCerrar.equals("1")){
                            //enviamos al activity de iniciar sesión
                            Intent intent = new Intent(tablero.this, configuracion.class);
                            startActivity(intent);
                            overridePendingTransition(R.anim.fadein,R.anim.fadeout);
                            finish();
                        }
                    }
                })
                .setCancelable(false)
                .show();

        String font_path = "font/HelveticaLTStdBold.otf";
        Typeface TF = Typeface.createFromAsset(getAssets(), font_path);

        Button positive_button = dialog.getButton(DialogInterface.BUTTON_POSITIVE);
        positive_button.setBackgroundResource(R.drawable.botoncerrar);
        positive_button.setHeight(5);
        positive_button.setPadding(40,0,40,0);
        positive_button.setTypeface(TF);

    }

    //Funcion nos permite inicializar con -1 el vector de posiciones del alfil
    private void inicializar() {
        for (int x=0;x<posiblesAlfil.length;x++){
            posiblesAlfil[x]=-1;
            posiblesTorre[x]=-1;
        }
    }

    //Esta funcion nos permite ubicar las fichas segun su posición
    private void condicionesIniciales() {
        overbox.setAlpha(0);
        //Determinamos si la posición del alfil da en casilla blanca o negra
        for (int casillasBlanca : casillasBlancas) {
            if (posA == casillasBlanca) {
                auxCasillaAlfil = 1;
                break;
            }
        }
        //Determinamos si la posición de la torre da en casilla blanca o negra
        for (int casillasBlanca : casillasBlancas) {
            if (posT == casillasBlanca) {
                auxCasillaTorre = 1;
                break;
            }
        }
        //Dependiendo el color de la posicion de la celda se muestra la ficha
        if(auxCasillaAlfil==0){
            buttonArray[posA].setBackgroundResource(R.drawable.cuadro_negro_actual);
            buttonArray[posA].setPadding(11,0,0,0);
            buttonArray[posA].setCompoundDrawablesWithIntrinsicBounds(R.mipmap.ic_alfil, 0, 0, 0);
        }else{
            buttonArray[posA].setBackgroundResource(R.drawable.cuadro_blanco_actual);
            buttonArray[posA].setPadding(11,0,0,0);
            buttonArray[posA].setCompoundDrawablesWithIntrinsicBounds(R.mipmap.ic_alfil, 0, 0, 0);
        }
        //Dependiendo el color de la posicion de la celda se muestra la ficha
        if(auxCasillaTorre==0){
            buttonArray[posT].setBackgroundResource(R.drawable.cuadro_negro_actual);
            buttonArray[posT].setPadding(15,0,0,0);
            buttonArray[posT].setCompoundDrawablesWithIntrinsicBounds(R.mipmap.ic_torre, 0, 0, 0);
        }else{
            buttonArray[posT].setBackgroundResource(R.drawable.cuadro_blanco_actual);
            buttonArray[posT].setPadding(15,0,0,0);
            buttonArray[posT].setCompoundDrawablesWithIntrinsicBounds(R.mipmap.ic_torre, 0, 0, 0);
        }

        //Verificamos el caso para determinar que jugador tiene su turno
        if (numCaso.equals("1") || numCaso.equals("3")) {
            calcularPosicionAlfil(FA, CA);
            txtBlancas.setAlpha(1);
            txtNegras.setAlpha(0);
        } else {
            calcularPosicionTorre(FT,CT);
            txtNegras.setAlpha(1);
            txtBlancas.setAlpha(0);
        }



    }

    private void condicionesInicialesTercerCaso() {
        //Determinamos si la posición del alfil da en casilla blanca o negra
        for (int casillasBlanca : casillasBlancas) {
            if (posA == casillasBlanca) {
                auxCasillaAlfil = 1;
                break;
            }
        }
        //Determinamos si la posición de la torre da en casilla blanca o negra
        for (int casillasBlanca : casillasBlancas) {
            if (posT == casillasBlanca) {
                auxCasillaTorre = 1;
                break;
            }
        }
        //Dependiendo el color de la posicion de la celda se muestra la ficha
        if(auxCasillaAlfil==0){
            buttonArray[posA].setBackgroundResource(R.drawable.cuadro_negro_actual);
            buttonArray[posA].setPadding(11,0,0,0);
            buttonArray[posA].setCompoundDrawablesWithIntrinsicBounds(R.mipmap.ic_alfil, 0, 0, 0);
        }else{
            buttonArray[posA].setBackgroundResource(R.drawable.cuadro_blanco_actual);
            buttonArray[posA].setPadding(11,0,0,0);
            buttonArray[posA].setCompoundDrawablesWithIntrinsicBounds(R.mipmap.ic_alfil, 0, 0, 0);
        }
        //Dependiendo el color de la posicion de la celda se muestra la ficha
        if(auxCasillaTorre==0){
            buttonArray[posT].setBackgroundResource(R.drawable.cuadro_negro_actual);
            buttonArray[posT].setPadding(15,0,0,0);
            buttonArray[posT].setCompoundDrawablesWithIntrinsicBounds(R.mipmap.ic_torre, 0, 0, 0);
        }else{
            buttonArray[posT].setBackgroundResource(R.drawable.cuadro_blanco_actual);
            buttonArray[posT].setPadding(15,0,0,0);
            buttonArray[posT].setCompoundDrawablesWithIntrinsicBounds(R.mipmap.ic_torre, 0, 0, 0);
        }
    }

    //Función que nos permite calcular las posiciones de la Torre
    private void calcularPosicionTorre(int ft, int ct) {
        int al=0;
        int auxFA=ft;
        int auxCA=ct;
        //Calculamos las posibles casillas donde puede moverse
        for (int x=0;x<20;x++) {
            if(al==0) {
                auxFA=auxFA+1;
                //Validamos que no se salga de los rangos de la matriz
                if(auxFA<=7){
                    posiblesTorre[x]=matriz[auxFA][auxCA];
                } else {
                    al=1;
                    auxFA=ft;
                    auxCA=ct;
                    x--;
                }
            } else if(al==1) {
                auxCA=auxCA-1;
                //Validamos que no se salga de los rangos de la matriz
                if(auxCA>=0){
                    posiblesTorre[x]=matriz[auxFA][auxCA];
                } else {
                    al=2;
                    auxFA=ft;
                    auxCA=ct;
                    x--;
                }
            } else if(al==2) {
                auxFA=auxFA-1;
                //Validamos que no se salga de los rangos de la matriz
                if(auxFA>=0){
                    posiblesTorre[x]=matriz[auxFA][auxCA];
                } else {
                    al=3;
                    auxFA=ft;
                    auxCA=ct;
                    x--;
                }
            } else if(al==3) {
                auxCA=auxCA+1;
                //Validamos que no se salga de los rangos de la matriz
                if(auxCA<=7){
                    posiblesTorre[x]=matriz[auxFA][auxCA];
                } else {
                    al=4;
                    auxFA=ft;
                    auxCA=ct;
                    x--;
                }
            }
        }

        for (int i : posiblesTorre) {
            if (i != -1) {
                //recorremos el vector de casillas blancas para saber si lo es o no
                int aaaCasilla = 0;
                //Determinamos si la posición del alfil da en casilla blanca o negra
                for (int casillasBlanca : casillasBlancas) {
                    if (i == casillasBlanca) {
                        aaaCasilla = 1;
                        break;
                    }
                }
                //Verificamos el condicional
                if (aaaCasilla == 0) {
                    buttonArray[i].setBackgroundResource(R.drawable.cuadro_negro_posible);
                } else {
                    buttonArray[i].setBackgroundResource(R.drawable.cuadro_blanco_posible);
                }
            }
        }
    }

    //Funcion que nos permite calcular las posiciones del alfil
    private void calcularPosicionAlfil(int fa, int ca) {
        int al=0;
        int auxFA=fa;
        int auxCA=ca;
        //Calculamos las posibles casillas donde puede moverse
        for (int x=0;x<20;x++) {
            if(al==0) {
                auxFA=auxFA+1;
                auxCA=auxCA+1;
                //Validamos que no se salga de los rangos de la matriz
                if(auxFA<=7 && auxCA<=7){
                    posiblesAlfil[x]=matriz[auxFA][auxCA];
                } else {
                    al=1;
                    auxFA=fa;
                    auxCA=ca;
                    x--;
                }
            } else if(al==1) {
                auxFA=auxFA+1;
                auxCA=auxCA-1;
                //Validamos que no se salga de los rangos de la matriz
                if(auxFA<=7 && auxCA>=0){
                    posiblesAlfil[x]=matriz[auxFA][auxCA];
                } else {
                    al=2;
                    auxFA=fa;
                    auxCA=ca;
                    x--;
                }
            } else if(al==2) {
                auxFA=auxFA-1;
                auxCA=auxCA-1;
                //Validamos que no se salga de los rangos de la matriz
                if(auxFA>=0 && auxCA>=0){
                    posiblesAlfil[x]=matriz[auxFA][auxCA];
                } else {
                    al=3;
                    auxFA=fa;
                    auxCA=ca;
                    x--;
                }
            } else if(al==3) {
                auxFA=auxFA-1;
                auxCA=auxCA+1;
                //Validamos que no se salga de los rangos de la matriz
                if(auxFA>=0 && auxCA<=7){
                    posiblesAlfil[x]=matriz[auxFA][auxCA];
                } else {
                    al=4;
                    auxFA=fa;
                    auxCA=ca;
                    x--;
                }
            }
        }

        for (int i : posiblesAlfil) {
            if (i != -1) {
                //recorremos el vector de casillas blancas para saber si lo es o no
                int aaaCasilla = 0;
                //Determinamos si la posición del alfil da en casilla blanca o negra
                for (int casillasBlanca : casillasBlancas) {
                    if (i == casillasBlanca) {
                        aaaCasilla = 1;
                        break;
                    }
                }
                //Verificamos el condicional
                if (aaaCasilla == 0) {
                    buttonArray[i].setBackgroundResource(R.drawable.cuadro_negro_posible);
                } else {
                    buttonArray[i].setBackgroundResource(R.drawable.cuadro_blanco_posible);
                }
            }
        }
    }

    //Configuración del boton de atras
    @Override public void onBackPressed() {
        Intent intent = new Intent(tablero.this, configuracion.class);
        startActivity(intent);
        overridePendingTransition(R.anim.fadein,R.anim.fadeout);
        finish();
    }

}