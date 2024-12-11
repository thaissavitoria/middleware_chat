/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pacote;

import java.io.BufferedReader;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

/**
 *
 * @author admlab
 */
public class RmiWebImpl extends UnicastRemoteObject implements RmiWebInterface{
    public RmiWebImpl()throws RemoteException{
        super();       
    }
    
    @Override
    public boolean gravaMsg(String msg)throws RemoteException{
       boolean ok=false;
      try{
            File arquivo= new File("C:\\Dados\\arquivo.txt");
            FileWriter escritor = new FileWriter(arquivo,true);
            
            escritor.write(msg);
            escritor.close();
            ok=true;
       }
       catch(Exception e){
           e.printStackTrace();
           ok=false;
       }
      
      return ok;
    };
    
    @Override
    public String recuperaMsg()throws RemoteException{
        String sRet="";
        try{
            File arquivo = new File("C:\\Dados\\arquivo.txt");
            FileReader leitor = new FileReader(arquivo);
            BufferedReader buffer = new BufferedReader(leitor);

            while(buffer.ready()){
                sRet+=buffer.readLine();
            }

            leitor.close();
        }
        catch(Exception e){
            sRet = "Mensagens indisponíveis - ERRO NO REPOSITÓRIO";
            e.printStackTrace();
        }
        
        return sRet;
    };
}

