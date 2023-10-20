package com.heroesvillanos.dominio;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.File;

public class Archivo {

    private final String nombreArchivo;
    public Archivo(String nombreArchivo){
        this.nombreArchivo = nombreArchivo;
    }

    public File crearFile(TipoArchivo tipo) {
        ClassLoader classloader = this.getClass().getClassLoader();
        URL recurso = classloader.getResource("archivos" + File.separator + this.nombreArchivo + "." + tipo.getSufijo());
        if (recurso != null){
            return  new File(recurso.getPath());
        }
        else{
            throw new RuntimeException();
        }
    }

    public enum TipoArchivo{
        ENTRADA("in"),
        SALIDA("out");

        final String sufijo;

        TipoArchivo(String sufijo){
            this.sufijo = sufijo;
        }

        public String getSufijo(){
            return this.sufijo;
        }
    }


}
