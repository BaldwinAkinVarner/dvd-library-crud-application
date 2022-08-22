/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sg.dvdlibrary.dto;

/**
 *
 * @author crouton
 */
public class DVD {
    private String title;
    private String releaseDate;
    private String mpaaRating;
    private String director;
    private String studio;
    private String userNote;
    
    public DVD(String title, String releaseDate, String mpaaRating, String director, String studio, String userNote){
        this.title = title;
        this.releaseDate = releaseDate;
        this.mpaaRating = mpaaRating;
        this.director = director;
        this.studio = studio;
        this.userNote = userNote;
    }
    
    public void setTitle(String title, String releaseYear){
        this.title = String.format("%s (%s)",title, releaseYear);
    }
    
    public void setTitle(String title){
        this.title = title;
    }
    
    public void setReleaseDate(String releaseDate){
        this.releaseDate = releaseDate;
    }
    
    public void setMpaaRating(String mpaaRating){
        this.mpaaRating = mpaaRating;
    }
    
    public void setDirector(String director){
        this.director = director;
    }
    
    public void setStudio(String studio){
        this.studio = studio;
    }
    
    public void setUserNote(String userNote){
        this.userNote = userNote;
    }
    
    public String getTitle(){
        return this.title;
    }
    
    public String getReleaseDate(){
        return this.releaseDate;
    }
    
    public String getMpaaRating(){
        return this.mpaaRating;
    }
    
    public String getDirector(){
        return this.director;
    }
    
    public String getStudio(){
        return this.studio;
    }
    
    public String getUserNote(){
        return this.userNote;
    }
}
