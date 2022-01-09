/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.collections;


import helpers.Loader;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import lapr.project.gpsd.model.ZipCode;


/**
 *
 * @author Beatriz Ribeiro
 */
public class ZipCodeCollection {
    private static ZipCodeCollection _instance = null;
    private List<ZipCode> allZipCodes;

    private ZipCodeCollection() {
        this.allZipCodes = new ArrayList<>();
        Init();
    }
    
    public static ZipCodeCollection getInstance() {
        if (_instance == null) {
            _instance = new ZipCodeCollection();
        }
        
        return _instance;
    }
    
    private void Init() {
        try {
            this.allZipCodes = Loader.readZipCodes();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public List<ZipCode> getAllZipCodes() {
        return allZipCodes;
    }
    
}
