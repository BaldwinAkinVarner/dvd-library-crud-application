/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sg.dvdlibrary.controller;

import com.sg.dvdlibrary.controller.dao.DVDLibraryDao;
import com.sg.dvdlibrary.controller.dao.DVDLibraryDaoException;
import com.sg.dvdlibrary.controller.dao.DVDLibraryDaoFileImpl;
import com.sg.dvdlibrary.dto.DVD;
import com.sg.dvdlibrary.ui.DVDLibraryView;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/**
 *
 * @author crouton
 */
public class DVDLibraryController {
    
    private DVDLibraryView view;
    private DVDLibraryDao dao;
    
    public DVDLibraryController(DVDLibraryDao dao, DVDLibraryView view){
        this.dao = dao;
        this.view = view;
    }
    
    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;
        try{
            while (keepGoing) {

                menuSelection = getMenuSelection();

                switch (menuSelection) {
                    case 1:
                        listDVDs();
                        break;
                    case 2:
                        createDVD();
                        break;
                    case 3:
                        removeDVD();
                        break;
                    case 4:
                        editDVD();
                        break;
                    case 5:
                        searchForDVD();
                        break;
                    case 6:
                        viewDVD();
                        break;
                    case 7:
                        exitMessage();
                        keepGoing = false;
                        break;
                    default:
                        unknownCommand();
                }

            } //End of While
        } catch(DVDLibraryDaoException e) {
            view.displayErrorMessage(e.getMessage());
        }
    }
    
    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }
    
    private void createDVD() throws DVDLibraryDaoException{
        view.displayCreateDVDBanner();
        DVD newDVD = view.getNewDVDInfo();
        dao.addDVD(newDVD.getTitle(), newDVD);
        view.displayCreateSuccessBanner(); 
    }
    
    private void listDVDs()throws DVDLibraryDaoException{
        view.displayDisplayAllBanner();
        List<DVD> listOfDVDs = dao.getAllDVDs();
        view.displayDVDList(listOfDVDs);
    }
    
    private void viewDVD()throws DVDLibraryDaoException{
        view.displayDisplayDVDBanner();
        String title = view.getDVDChoice();
        DVD currentDVD = dao.getDVD(title);
        view.displayDVD(currentDVD);
    }
    
    private void removeDVD()throws DVDLibraryDaoException{
        view.displayRemoveDVDBanner();
        String title = view.getDVDChoice();
        DVD removedDVD = dao.removeDVD(title);
        view.displayRemoveResult(removedDVD);
    }
    
    private void editDVD()throws DVDLibraryDaoException{
        String title = view.getDVDChoice();
        DVD editedDVD = dao.removeDVD(title);
        // 1 means editing title, 2 means editing release date, 3 means editing rating, 4 means editing director, 5 means editing studio, 6 means editing usernote
        ArrayList<String> choicesArr = view.getEditChoice();
        switch (choicesArr.get(1)) {
            case "1":
                editedDVD.setTitle(choicesArr.get(0));
                break;
            case "2":
                editedDVD.setReleaseDate(choicesArr.get(0));
                break;
            case "3":
                editedDVD.setMpaaRating(choicesArr.get(0));
                break;
            case "4":
                editedDVD.setDirector(choicesArr.get(0));
                break;
            case "5":
                editedDVD.setStudio(choicesArr.get(0));
                break;
            case "6":
                editedDVD.setUserNote(choicesArr.get(0));
                break;
        }
        dao.addDVD(editedDVD.getTitle(), editedDVD);
        view.displayDVD(editedDVD);
        view.displayEditSuccessBanner();
    }
    
    public void searchForDVD()throws DVDLibraryDaoException{
        view.displaySearchBanner();
        ArrayList<DVD> listOfDVDs = dao.getAllDVDs();
        ArrayList<String> listOfMatches = view.getSearchResults(listOfDVDs);
        if (!listOfMatches.isEmpty()){
            String resultName = view.getSearchResultChoice(listOfMatches);
            DVD currentDVD = dao.getDVD(resultName);
            view.displayDVD(currentDVD);
        } else {
            view.displaySearchFailure();
        }
    }
    
    public void unknownCommand(){
        view.displayUnknownCommandBanner();
    }
    
    public void exitMessage(){
        view.displayExitBanner();
    }
}
