/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sg.dvdlibrary.controller.dao;

import com.sg.dvdlibrary.dto.DVD;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author crouton
 */
public class DVDLibraryDaoFileImpl implements DVDLibraryDao{
    
    private Map<String, DVD> library = new HashMap<>();
    public static final String LIBRARY_FILE = "library.txt";
    public static final String DELIMITER = "::";
    
    @Override
    public DVD addDVD(String title, DVD DVD) throws DVDLibraryDaoException{
        loadLibrary();
        DVD currentDVD = library.put(title, DVD);
        writeLibrary();
        return currentDVD;
    }

    @Override
    public ArrayList<DVD> getAllDVDs() throws DVDLibraryDaoException{
        loadLibrary();
        return new ArrayList<DVD>(library.values());
    }

    @Override
    public DVD getDVD(String title) throws DVDLibraryDaoException{
        loadLibrary();
        return library.get(title);
    }

    @Override
    public DVD removeDVD(String title) throws DVDLibraryDaoException{
        loadLibrary();
        DVD removedDVD = library.remove(title);
        writeLibrary();
        return removedDVD;
    }
    
    private DVD unmarshallDVD(String textOfDVD){
        String[] dvdTokens = textOfDVD.split(DELIMITER);
        String title = dvdTokens[0];
        String releaseDate = dvdTokens[1];
        String mpaaRating = dvdTokens[2];
        String director = dvdTokens[3];
        String studio = dvdTokens[4];
        String userNote = dvdTokens[5];
        DVD dvdFromFile = new DVD(title, releaseDate, mpaaRating, director, studio, userNote);
        return dvdFromFile;
    }
    
    private void loadLibrary() throws DVDLibraryDaoException {
        Scanner scanner;
        
        try {
            // Create Scanner for reading the file
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(LIBRARY_FILE)));
        } catch (FileNotFoundException e) {
            throw new DVDLibraryDaoException(
                    "-_- Could not load roster data into memory.", e);
        }
        
        String currentLine;
        DVD currentDVD;
        
        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            currentDVD = unmarshallDVD(currentLine);
            library.put(currentDVD.getTitle(), currentDVD);
        }
        scanner.close();
    }
    
    private String marshallDVD(DVD aDVD){
        
        String dvdAsText = aDVD.getTitle() + DELIMITER;
        dvdAsText += aDVD.getReleaseDate() + DELIMITER;
        dvdAsText += aDVD.getMpaaRating() + DELIMITER;
        dvdAsText += aDVD.getDirector() + DELIMITER;
        dvdAsText += aDVD.getStudio() + DELIMITER;
        dvdAsText += aDVD.getUserNote() + DELIMITER;
        
        return dvdAsText;
    }
    
    private void writeLibrary() throws DVDLibraryDaoException{
        
        PrintWriter out;
        
        try {
            out = new PrintWriter(new FileWriter(LIBRARY_FILE));
        } catch (IOException e) {
            throw new DVDLibraryDaoException(
                    "Could not save student data.", e);
        }
        
        String dvdAsText;
        ArrayList<DVD> listOfDVDs = this.getAllDVDs();
        for (DVD currentDVD : listOfDVDs){
            dvdAsText = marshallDVD(currentDVD);
            out.println(dvdAsText);
            out.flush();
        }
        
        out.close();
    }
}
