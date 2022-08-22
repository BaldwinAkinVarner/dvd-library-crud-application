/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sg.dvdlibrary.ui;

import com.sg.dvdlibrary.dto.DVD;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author crouton
 */
public class DVDLibraryView {
    
    private UserIO io;
    public DVDLibraryView(UserIO io){
        this.io = io;
    }

    public int printMenuAndGetSelection() {
        io.print("Main Menu");
        io.print("1. See all DVDs");
        io.print("2. Add a DVD");
        io.print("3. Remove a DVD");
        io.print("4. Edit a DVD");
        io.print("5. Search for a DVD");
        io.print("6. See DVD Info");
        io.print("7. Exit");

        return io.readInt("Please select from the above choices.", 1, 7);
    }
    
    public DVD getNewDVDInfo(){
        String title = io.readString("Please enter the DVD Title");
        String releaseYear = io.readString("Please enter the DVD Release Year");
        String releaseDate = io.readString("What date (YYYY-MM-dd) the movie released?");
        String mpaaRating = io.readString("What is the movie's rating?");
        String director = io.readString("Who is the director?");
        String studio = io.readString("What studio produced it?");
        String userNote = io.readString("Provide any notes you have about the movie.");
        DVD currentDVD = new DVD(title, releaseDate, mpaaRating, director, studio, userNote);
        currentDVD.setTitle(title, releaseYear);
        currentDVD.setReleaseDate(releaseDate);
        currentDVD.setMpaaRating(mpaaRating);
        currentDVD.setDirector(director);
        currentDVD.setStudio(studio);
        currentDVD.setUserNote(userNote);
        return currentDVD;
    }
    
    public void displayCreateDVDBanner(){
        io.print("== Create DVD ==");
    }
    
    public void displayCreateSuccessBanner(){
        io.readString("DVD Successfully created. Please hit enter to continue.");
    }
    
    public void displayDVDList(List<DVD> library){
        int itNum = 1;
        for (DVD currentDVD : library){
            String DVDInfo = String.format(itNum + ".%s | released on %s | Rated: %s | Directed by: %s | Studio: %s | Notes: %s",
                    currentDVD.getTitle(),
                    currentDVD.getReleaseDate(),
                    currentDVD.getMpaaRating(),
                    currentDVD.getDirector(),
                    currentDVD.getStudio(),
                    currentDVD.getUserNote());
            io.print(DVDInfo);
            itNum += 1;
        }
        io.readString("Please hit enter to continue");
    }
    
    public void displayDisplayAllBanner(){
        io.print("=== Display All Students ===");
    }
    
    public String getDVDChoice(){
        String title = io.readString("Please enter the DVD name");
        String releaseYear = io.readString("Please enter the year the DVD was released"); 
        String fullTitle = String.format("%s (%s)",title, releaseYear);
        return fullTitle;
    }
    
    public void displayDVD(DVD currentDVD){
        if (currentDVD != null) {
            String DVDInfo = String.format("%s : released on %s | Rated: %s | Directed by: %s | Studio: %s | Notes: %s",
                    currentDVD.getTitle(),
                    currentDVD.getReleaseDate(),
                    currentDVD.getMpaaRating(),
                    currentDVD.getDirector(),
                    currentDVD.getStudio(),
                    currentDVD.getUserNote());
            io.print(DVDInfo);
        } else {
            io.print("No DVD Found");
        }
        io.readString("Please hit enter to continue");
    }
    
    public void displayDisplayDVDBanner(){
        io.print("=== Display DVD ===");
    }
    
    public void displayRemoveResult(DVD dvdToRemove){
        if (dvdToRemove != null){
            io.print("DVD successfully removed");
        } else {
            io.print("No such DVD");
        }
        io.readString("Please hit enter to continue");
    }
    
    public void displayRemoveDVDBanner(){
        io.print("=== Remove DVD ===");
    }
    
    public ArrayList<String> getEditChoice(){
        // 1 means editing title, 2 means editing release date, 3 means editing rating, 4 means editing director, 5 means editing studio, 6 means editing usernote
        Integer choice = io.readInt("What would you like to update? (Press 1 for Title, 2 for Release Date, 3 for Rating, 4 for Director, 5 for Studio, or 6 for UserNote");
        ArrayList<String> choicesArr = new ArrayList<>();
        switch (choice) {
            case 1:
                String title = io.readString("Please enter the updated DVD Title");
                String releaseYear = io.readString("Please enter the DVD Release Year");
                String finalTitle = String.format("%s (%s)",title, releaseYear);
                choicesArr.add(finalTitle);
                choicesArr.add("1");
                break;
            case 2:
                String releaseDate = io.readString("Please enter the updated release date (YYYY-DD-MM)");
                choicesArr.add(releaseDate);
                choicesArr.add("2");
                break;
            case 3:
                String rating = io.readString("Please enter the updated rating");
                choicesArr.add(rating);
                choicesArr.add("3");
                break;
            case 4:
                String director = io.readString("Please enter the updated director");
                choicesArr.add(director);
                choicesArr.add("4");
                break;
            case 5:
                String studio = io.readString("Please enter the updated studio");
                choicesArr.add(studio);
                choicesArr.add("5");
                break;
            case 6:
                String userNote = io.readString("Please enter the updated note");
                choicesArr.add(userNote);
                choicesArr.add("6");
                break;
        }
        return choicesArr;
    }
    
    public void displayEditSuccessBanner(){
        io.print("DVD successfully updated");
    }
    
    public ArrayList<String> getSearchResults(ArrayList<DVD> listOfDVDs){
        ArrayList<String> listOfMatches = new ArrayList<>();
        String userChoice = io.readString("What DVD would you like to search for?").toLowerCase();
        for (DVD currentDVD : listOfDVDs){
            String nameOfDVD = currentDVD.getTitle();
            String lowerCaseName = nameOfDVD.toLowerCase();
            if (lowerCaseName.contains(userChoice)){
                listOfMatches.add(nameOfDVD);
            }
        }
        return listOfMatches;
    }
    
    public void displaySearchFailure() {
        io.readString("No DVD found :/ sorry. Please hit enter to continue");
    }
    
    public void displaySearchBanner() {
        io.print("=== Searching....... ===");
    }
    
    public String getSearchResultChoice(ArrayList<String> listOfDVDs) {
        Integer listLength = listOfDVDs.size();
        Integer enumerator = 1;
        for (String currentDVDName : listOfDVDs){
            io.print(enumerator + ". " + currentDVDName);
            enumerator += 1;
        }
        Integer userChoice = io.readInt("Please choose which DVD you would like to view", 1, listLength);
        return listOfDVDs.get(userChoice - 1);
    }
    
    public void displayExitBanner(){
        io.print("Good Bye!");
    }
    
    public void displayUnknownCommandBanner(){
        io.print("Unknown Command :/");
    }
    
    public void displayErrorMessage(String errorMsg){
        io.print("=== ERROR ===");
        io.print(errorMsg);
    }
}
