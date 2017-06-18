package Controlador;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author live yedgerik
 */
public class FileManager 
{
    // Variables Globables ---------------------------------------------
    private File controlador;
    private String ruta;
    private FileInputStream fileInput;
    private BufferedInputStream bufferedInput;
    private FileOutputStream fileOutput;
    private BufferedOutputStream bufferedOutput;
    private byte[] bytes;
    private String file;
    /**
     * Constructor -----------------------------------------------------
     * @param pArchivo 
     * @param ss1 
     */
    public FileManager(String pArchivo) 
    {
        // Inicializo el nombre del album
        file = pArchivo;
        // Inicializo variables globales
        this.bytes = null;
    }
    /**
     * 
     * @return 
     */
    public byte[] leerArchivo() throws IOException 
    {
        //
        try {
            fileInput = new FileInputStream(file);
        } catch (FileNotFoundException e1) {
            return null;
        } catch (RuntimeException e2) {
            JOptionPane.showMessageDialog(null,"¡No hay Album a guardar!","ERROR",2);
        }
        //
        bufferedInput = new BufferedInputStream(fileInput);
        int largo = bufferedInput.available();
        try {
            bytes = new byte[largo];
            bufferedInput.read(bytes);
        } catch (Exception e) {
            bytes = new byte[0];
            return bytes;
        } finally {
            try {
                bufferedInput.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return bytes;
    }
    public byte[] leerArchivo(int offset, int len) throws IOException 
    {
        //
        try {
            fileInput = new FileInputStream(file);
        } catch (FileNotFoundException e1) {
            return null;
        } catch (RuntimeException e2) {
            JOptionPane.showMessageDialog(null,"¡No hay Album a guardar!","ERROR",2);
        }
        //
        bufferedInput = new BufferedInputStream(fileInput);
        try {
            bytes = new byte[len];
            bufferedInput.read(bytes, offset, len);
        } catch (Exception e) {
            bytes = new byte[0];
            return bytes;
        } finally {
            try {
                bufferedInput.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return bytes;
    }
    /**
     * 
     * @param pBytes 
     * @param bo 
     * @return  
     * @throws java.io.IOException 
     */
    public int escribirArchivo(byte[] pBytes, boolean bo) throws IOException 
    {
        //
        bytes = pBytes;
        int total= 0;
        
        try {
            fileOutput = new FileOutputStream(file, bo);
            fileInput = new FileInputStream(file);
            total = fileInput.available();
            fileInput.close();
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }
        //
        bufferedOutput = new BufferedOutputStream(fileOutput);
        
        try {
            bufferedOutput.write(bytes);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedOutput.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return total;
    }

}
