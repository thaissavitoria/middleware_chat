/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pacote;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author admlab
 */
public class RmiWebInterface extends Remote{
    public boolean gravaMsg(String msg)throws RemoteException;
    
    public String recuperaMsg()throws RemoteException;

}
