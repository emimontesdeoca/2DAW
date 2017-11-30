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
public class category {

    private Integer IdCategory;
    private String Description;

    public category() {
    }

    public category(Integer IdCategory, String Description) {
        this.IdCategory = IdCategory;
        this.Description = Description;
    }

    public Integer getIdCategory() {
        return IdCategory;
    }

    public void setIdCategory(Integer IdCategory) {
        this.IdCategory = IdCategory;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

}
