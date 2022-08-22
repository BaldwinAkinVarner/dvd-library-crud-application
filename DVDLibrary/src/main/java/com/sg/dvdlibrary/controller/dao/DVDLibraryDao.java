/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.sg.dvdlibrary.controller.dao;

import com.sg.dvdlibrary.dto.DVD;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author crouton
 */
public interface DVDLibraryDao {
    DVD addDVD(String title, DVD DVD) throws DVDLibraryDaoException;
    ArrayList<DVD> getAllDVDs() throws DVDLibraryDaoException;
    DVD getDVD(String title) throws DVDLibraryDaoException;
    DVD removeDVD(String title) throws DVDLibraryDaoException;
}
