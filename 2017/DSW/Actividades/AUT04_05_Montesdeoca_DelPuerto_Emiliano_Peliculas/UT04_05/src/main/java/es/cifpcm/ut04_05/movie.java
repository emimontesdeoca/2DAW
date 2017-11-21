/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cifpcm.ut04_05;

/**
 *
 * @author emont
 */
public class movie {

    private Integer IdMovie;
    private Integer IdCategory;
    private String Title;

    public movie() {
    }

    public movie(Integer IdMovie, Integer IdCategory, String Title) {
        this.IdMovie = IdMovie;
        this.IdCategory = IdCategory;
        this.Title = Title;
    }

    public Integer getIdMovie() {
        return IdMovie;
    }

    public void setIdMovie(Integer IdMovie) {
        this.IdMovie = IdMovie;
    }

    public Integer getIdCategory() {
        return IdCategory;
    }

    public void setIdCategory(Integer IdCategory) {
        this.IdCategory = IdCategory;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }
}
