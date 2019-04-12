package com.example.karla.emergencycase;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class RegistroRequest extends StringRequest {

    private  static final String ruta = "http://karla-fragoso.000webhostapp.com/Registro.php";
    private Map<String, String> parametros;
    public RegistroRequest(String nombre, String usuario, String clave, int edad, String perfil, Response.Listener<String>listener){
        super(Method.POST, ruta, listener, null);
        parametros = new HashMap<>();
        parametros.put("nombre",nombre+"");
        parametros.put("usuario",usuario+"");
        parametros.put("clave",clave+"");
        parametros.put("edad",edad+"");
        parametros.put("perfil",perfil+"");
    }

    @Override
    protected Map<String, String> getParams()  {
        return parametros;
    }
}
