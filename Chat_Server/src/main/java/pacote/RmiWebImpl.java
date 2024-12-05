/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pacote;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author admlab
 */
public class RmiWebImpl extends UnicastRemoteObject implements RmiWebInterface{
    public RmiWebImpl()throws RemoteException{
        super();       
    }
}
