package com.platform.movies.persistence.mapper;

import com.platform.movies.domain.Genre;
import org.mapstruct.Named;

public class GenreMapper {

    @Named("stringToGenre")
    public static Genre stringToGenre(String genre){

        if(genre==null) return null;

        return switch (genre.toUpperCase()){
            case "ACCION" -> Genre.ACTION;
            case "COMEDIA" -> Genre.COMEDY;
            case "DRAMA" -> Genre.DRAMA;
            case "TERROR" -> Genre.HORROR;
            case "ANIMADA" -> Genre.ANIMATED;
            case "CIENCIA_FICCION" -> Genre.SCI_FI;
            case "FANTASIA" -> Genre.FANTASY;
            default -> null;
        };
    }

    @Named("genreToString")
    public static String genreToString(Genre genre){

        if(genre==null) return null;

        return switch (genre){
            case ACTION -> "ACCION";
            case COMEDY -> "COMEDIA";
            case DRAMA -> "DRAMA";
            case ANIMATED -> "ANIMADA";
            case HORROR -> "TERROR";
            case SCI_FI -> "CIENCIA_FICCION";
            case FANTASY -> "FANTASIA";
            default -> null;
        };
    }
}
