/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.kappadev.medplus.ui.printer;

import javax.print.PrintService;

/**
 *
 * @author Tomasz
 */
public class PrinterSelectionRunnable implements Runnable{

    private PrinterSelection printerSelection;
    private PrintService[] printerServices;
    
    @Override
    public void run() {
        if(getPrinterServices()!= null){
            
           printerSelection = new PrinterSelection();
           printerSelection.setVisible(true);
           
        }
        
    }

    /**
     * @return the printerServices
     */
    public PrintService[] getPrinterServices() {
        return printerServices;
    }

    /**
     * @param printerServices the printerServices to set
     */
    public void setPrinterServices(PrintService[] printerServices) {
        this.printerServices = printerServices;
    }
    
}
